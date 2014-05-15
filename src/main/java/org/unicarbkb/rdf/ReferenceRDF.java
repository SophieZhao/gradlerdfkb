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

import java.util.List;

/**
 * Created by matthew on 07/05/2014.
 */
public class ReferenceRDF {


    public void createPublication(Reference reference, Model model) {

        try {
            Resource r = model.createResource("http://www.unicarbkb.org/reference/" + reference.id);
            r.addProperty(RDF.type, bibo.Article);
            r.addProperty(DCTerms.issued, String.valueOf(reference.year));
            r.addProperty(DC.title, reference.title);
            r.addProperty(DC.creator, reference.authors);  //list of authors

            String[] authors = reference.authors.split(",");
            for (String a : authors) {
                r.addProperty(BIBOVOCAB.authorList, createAuthor(model, a.trim())); //  a.trim());
            }

            String[] pages = reference.pages.split("-");
            r.addProperty(BIBOVOCAB.pageEnd, String.valueOf(pages[0]));
            r.addProperty(BIBOVOCAB.pageStart, String.valueOf(pages[1]));
            r.addProperty(BIBOVOCAB.volume, reference.volume);
            r.addProperty(DCTerms.isPartOf, createJournals(reference.journal, model));

            r.addProperty(OWL.sameAs, model.createResource("http://www.ncbi.nlm.nih.gov/pubmed/" + reference.pmid)); //may need to check this

            List<Refmethod> refMethod = reference.refmethod;
            for (Refmethod m : refMethod) {
                Method method = Ebean.find(Method.class, m.method.getId());
                r.addProperty(GLYCOVOCAB.hasMethod, addMethod(model, method));
            }

        } catch (Exception e) {
            System.out.println("Failed where: " + e);
        }
    }

    public static Resource createJournals(Journal journal, Model model) {
        // System.out.println("starting to create journal");
        String journalURI = "journal_" + journal.id;

        Resource r = null;
        try {
            //r = model.createResource(journalURI);

            r = model.createResource(journalURI);
            if(!model.containsResource(r)) {
                r.addProperty(DC.title, journal.name);
                r.addProperty(BIBOVOCAB.shortTitle, journal.shortname);
                //journal.addProperty(DC.publisher, "publisher");
                r.addProperty(RDF.type, bibo.Journal);
            }

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
        String authorURI= "author_" + author.replaceAll("\\s","_").trim();
        Resource r = null;
        try {
            r= model.createResource(authorURI);
            r.addProperty(RDF.type, DC.contributor).addLiteral(FOAF.name, author.replaceAll("\\s","_").trim() );
        } catch (Exception e) {
            System.out.println("Failed: " + e);
        }
        return r;
    }

    public static Resource addMethod(Model model, Method method){
        String methodURI = "method_" + method.description.toLowerCase().trim();
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