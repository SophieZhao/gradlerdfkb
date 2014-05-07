package org.unicarbkb.rdf;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.ResourceFactory;
import com.hp.hpl.jena.vocabulary.DC;
import com.hp.hpl.jena.vocabulary.DCTerms;
import com.hp.hpl.jena.vocabulary.OWL;
import com.hp.hpl.jena.vocabulary.RDF;
import models.database.Journal;
import models.database.Reference;
import org.unicarbkb.rdf.Namespaces;

/**
 * Created by matthew on 07/05/2014.
 */
public class ReferenceRDF {


    public static void createPublication(Reference reference, Model model) {

        try {
            Resource r = model.createResource("http://www.unicarbkb.org/reference/" + reference.id);
            r.addProperty(RDF.type, bibo.Article);
            r.addProperty(DCTerms.issued, String.valueOf(reference.year));
            r.addProperty(DC.title, reference.title);
            r.addProperty(DC.creator, reference.authors);  //list of authors

            String[] authors = reference.authors.split(",");
            for (String a : authors) {
                r.addProperty(BIBOVOCAB.authorList, a.trim());
            }

            String[] pages = reference.pages.split(",");
            r.addProperty(BIBOVOCAB.pageEnd, String.valueOf(pages[0]));
            r.addProperty(BIBOVOCAB.pageStart, String.valueOf(pages[1]));
            r.addProperty(BIBOVOCAB.volume, reference.volume);
            r.addProperty(DCTerms.isPartOf, createJournals(reference.journal, model));

            r.addProperty(OWL.sameAs, model.createResource("http://www.ncbi.nlm.nih.gov/pubmed/" + reference.pmid)); //may need to check this

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

            r = ResourceFactory.createResource(journalURI);
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
}