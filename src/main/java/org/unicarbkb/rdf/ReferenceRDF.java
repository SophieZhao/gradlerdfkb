package org.unicarbkb.rdf;

import com.avaje.ebean.Ebean;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.ResourceFactory;
import com.hp.hpl.jena.vocabulary.DC;
import com.hp.hpl.jena.vocabulary.DCTerms;
import com.hp.hpl.jena.vocabulary.OWL;
import com.hp.hpl.jena.vocabulary.RDF;
import models.database.Journal;
import models.database.Method;
import models.database.Reference;
import models.database.Refmethod;
import com.hp.hpl.jena.sparql.vocabulary.FOAF;

import java.net.URLEncoder;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by matthew on 07/05/2014.
 */
public class ReferenceRDF {


    public static Resource createPublication(Reference reference, Model model) {

        //reference = Ebean.find(Reference.class, reference.id);
        Resource r = null;
        try {
            r = model.createResource("http://rdf.unicarbkb.org/reference/" + reference.id);
            r.addProperty(RDF.type, bibo.Article);
            //          System.out.println("checking publication build " );
//System.out.print("hmm");
            r.addProperty(DCTerms.issued, String.valueOf(reference.getYear()));
            r.addProperty(DC.title, reference.getTitle());
            r.addProperty(DC.creator, reference.getAuthors());  //list of authors

            String[] authors = reference.authors.split(",");
            for (String a : authors) {
                r.addProperty(BIBOVOCAB.authorList, createAuthor(model, a.trim())); //  a.trim());
            }

            String[] pages = reference.pages.split("-");
            r.addProperty(BIBOVOCAB.pageEnd, String.valueOf(pages[0]));
            r.addProperty(BIBOVOCAB.pageStart, String.valueOf(pages[1]));
            r.addProperty(BIBOVOCAB.volume, reference.getVolume());
            r.addProperty(DCTerms.isPartOf, createJournals(reference.journal, model));
            r.addProperty(GLYCOVOCAB.hasPmid, reference.getPmid());

            r.addProperty(OWL.sameAs, model.createResource("http://www.ncbi.nlm.nih.gov/pubmed/" + reference.pmid)); //may need to check this

            List<Refmethod> refMethod = reference.refmethod;
            for (Refmethod m : refMethod) {
                Method method = Ebean.find(Method.class, m.method.getId());
                r.addProperty(GLYCOVOCAB.hasMethod, addMethod(model, method));
            }

        } catch (Exception e) {
            System.out.println("Failed where: " + e);
        }
        return r;
    }

    public static Resource createJournals(Journal journal, Model model) {
        // System.out.println("starting to create journal");
        String journalURI = "http://rdf.unicarbkb.org/journal/" + journal.getId();

        Resource r = null;
        try {
            //r = model.createResource(journalURI);

            r = model.createResource(journalURI);
            //if(!model.containsResource(r)) {
            r.addProperty(DC.title, journal.getName());
            r.addProperty(BIBOVOCAB.shortTitle, journal.getShortname());
            //journal.addProperty(DC.publisher, "publisher");
            r.addProperty(RDF.type, bibo.Journal);
            //}

        } catch (Exception e) {
            System.out.println("Failed: " + e);
        }

        //model.write(System.out, "TTL");
        return r;
    }

    /*
      <_:author_St_Michael_F>
          a dc:contributor ;
          foaf:name "St Michael F" .
       */
    public static Resource createAuthor(Model model, String author) {
        String authorURI = "http://rdf.unicarbkb.org/author/" + author.replaceAll("\\s", "_").trim();
        Resource r = null;
        try {
            r = model.createResource(authorURI);
            r.addProperty(RDF.type, DC.contributor).addLiteral(FOAF.name, author.replaceAll("\\s", "_").trim());
        } catch (Exception e) {
            System.out.println("Failed: " + e);
        }
        return r;
    }

    public static Resource addMethod(Model model, Method method) {
        String methodURI = "http://rdf.unicarbkb.org/method/" + URLEncoder.encode(method.description.toLowerCase().trim());
        Resource r = null;

        try {
            r = model.createResource(methodURI);
            r.addProperty(FOAF.name, method.description.toLowerCase().trim());
        } catch (Exception e) {
            System.out.println("Failed hasMethod: " + e);
        }
        return r;
    }
}