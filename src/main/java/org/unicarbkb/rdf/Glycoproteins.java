package org.unicarbkb.rdf;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.shared.uuid.JenaUUID;
import com.hp.hpl.jena.vocabulary.RDF;
import models.database.Proteins;

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

        model.write(System.out, "N3");

    }

    public static Resource createProteins(Model model, Proteins protein) {


        String proteinURI = "http://www.unicarbkb.org/proteinsummary/"; //+ accession;
        Resource site = null;
        Resource protein = null;
        try {
            protein = model.createResource(proteinURI);
            protein.addProperty(GLYCOVOCAB.hasGlycosylatedAA, "23").addProperty(GLYCOVOCAB.hasGlycosylatedAA, JenaUUID.generate().asString().toString());
        } catch (Exception e) {
            System.out.println("Failed: " + e);
        }
        model.write(System.out, "TTL");
        return protein;
    }
}
