package org.unicarbkb.rdf;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.ResourceFactory;
import com.hp.hpl.jena.shared.uuid.JenaUUID;
import com.hp.hpl.jena.vocabulary.DC;
import com.hp.hpl.jena.vocabulary.RDF;
import models.database.DefinedSites;
import models.database.Journal;
import models.database.Proteins;

import java.util.List;

/**
 * Created by matthew on 07/05/2014.
 */
public class Glycoproteins {

    /*
    Create <asp/ser/thr/>
     */
    public static void createGlycoSites(Model model) {
        Resource asp = model.createResource("asparagine");
        asp.addProperty(RDF.type, GLYCOVOCAB.aminoAcid);
        Resource thr = model.createResource("threonine");
        thr.addProperty(RDF.type, GLYCOVOCAB.aminoAcid);
        Resource ser = model.createResource("serine");
        ser.addProperty(RDF.type, GLYCOVOCAB.aminoAcid);

        model.write(System.out, "TTL");

    }

    public static Resource createProteins(Model model, Proteins protein) {

        String proteinURI = "http://www.unicarbkb.org/proteinsummary/" + protein.swissProt; //+ accession;
        Resource site = null;
        Resource p = null;
        try {
            p = model.createResource(proteinURI);
            p.addProperty(GLYCOVOCAB.hasUniprotAccession, protein.swissProt); //need to add uniprot:accession TODO
            //for each know site need to get object from ebean
            List<DefinedSites> defined = protein.proteinDefinedSites;
            for (DefinedSites d : defined) {
                //d.amino_acid_position
                //p.addProperty(GLYCOVOCAB.hasGlycosylatedAA, "23").addProperty(GLYCOVOCAB.hasGlycosylatedAA, JenaUUID.generate().asString().toString());
                p.addProperty(GLYCOVOCAB.hasGlycosylatedAA, createGlycoAA(d, model));
            }
        } catch (Exception e) {
            System.out.println("Failed: " + e);
        }
        model.write(System.out, "TTL");
        return p;
    }


    public static Resource createGlycoAA(DefinedSites d, Model model) {
        // System.out.println("starting to create journal");
        String glycoAAURI = "glycoAASite_" + JenaUUID.generate().asString();

        Resource r = null;
        try {
            //r = model.createResource(journalURI);

            r = ResourceFactory.createResource(glycoAAURI);
            if(!model.containsResource(r)) {
                r.addProperty(GLYCOVOCAB.aminoAcidType, "add");
                r.addProperty(GLYCOVOCAB.modificationType, "add");
                r.addProperty(FALDO.Location, "resource create"); //TODO
                r.addProperty(RDF.type, GLYCOVOCAB.glycosylatedAA);
            }

        } catch (Exception e) {
            System.out.println("Failed: " + e);
        }

        //model.write(System.out, "TTL");
        return r;
    }



}
