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
import models.database.StructureToSiteDefined;
import models.database.Stproteins;
import org.unicarbkb.rdf.StructureRDF;

import java.util.List;

import static org.unicarbkb.rdf.StructureRDF.*;

//import static org.unicarbkb.rdf.StructureRDF.createStructureFromDefinedSite;

/**
 * Created by matthew on 07/05/2014.
 */
public class Glycoproteins {

    public static void createProteins(Model model, Proteins protein) {
        try {
            if(protein.swissProt != null ) {
                Resource p = model.createResource("http://www.unicarbkb.org/proteinsummary/" + protein.swissProt);
                p.addProperty(GLYCOVOCAB.hasUniprotAccession, "uniprot:" + protein.swissProt); //UNIPROT.uniprotAccession);
                List<DefinedSites> defined = protein.proteinDefinedSites;
                for (DefinedSites d : defined) {
                    p.addProperty(GLYCOVOCAB.hasGlycosylatedAA, createGlycoAA(d, model));
                }
                p.addProperty(GLYCOVOCAB.hasAttachedGlycan, createStructureEntryProtein(model, protein)); //TODO check output
            }

           if (protein.swissProt == null && protein.name != null) {
                Resource p = model.createResource("http://www.unicarbkb.org/proteinsummary/" + protein.name);
                p.addProperty(GLYCOVOCAB.hasProteinName, protein.name);

               List<DefinedSites> defined = protein.proteinDefinedSites;
               for (DefinedSites d : defined) {

                   p.addProperty(GLYCOVOCAB.hasGlycosylatedAA, createGlycoAA(d, model));
               }
               p.addProperty(GLYCOVOCAB.hasAttachedGlycan, createStructureEntryProtein(model, protein)); //TODO check output
            }


        } catch (Exception e) {
            System.out.println("Failed createProteins: " + e.getCause() + " more info " + protein.swissProt);
        }
        //model.write(System.out, "TTL");
        //return p;
    }

    /*
    create has_glycosylated_aa using uuid
    might not be the best approach
    connected to a FALDO.Location ExactPosition
     */
    public static Resource createGlycoAA(DefinedSites d, Model model) {
        // System.out.println("starting to create journal");
        String glycoAAURI = "glycoAASite_" + JenaUUID.generate().asString();

        Resource r = null;
        try {

            r = model.createResource(glycoAAURI);
            r.addProperty(FALDO.Location, createFaldoLocation(d.amino_acid_position, model));
            r.addProperty(RDF.type, GLYCOVOCAB.glycosylatedAA);

            List<StructureToSiteDefined> sD = d.strSiteDefined;
            for(StructureToSiteDefined s : sD) {
                System.out.println("structure dead is " + s.structure_id);
                r.addProperty(GLYCOVOCAB.hasAttachedGlycan, createStructureFromDefinedSite(model, s.structure_id));

            }

            //if(!model.containsResource(r)) {

                if(d.amino_acid_position.contains("ASN")) {
                    r.addProperty(GLYCOVOCAB.aminoAcidType, model.getResource("asparagine")); //TODO CHECK
                    r.addLiteral(GLYCOVOCAB.modificationType, "N-glycosylation");
                }
                if(d.amino_acid_position.contains("THR")) {
                    r.addProperty(GLYCOVOCAB.aminoAcid, model.getResource("threonine") ); //TODO CHECK
                    r.addLiteral(GLYCOVOCAB.modificationType, "O-glycosylation");
                }
                if(d.amino_acid_position.contains("SER")){
                    r.addProperty(GLYCOVOCAB.aminoAcid, model.getResource("serine")); //TODO CHECK
                    r.addLiteral(GLYCOVOCAB.modificationType, "O-glycosylation");
                }


           // }

        } catch (Exception e) {
            System.out.println("Failed: " + e);
        }

        //model.write(System.out, "TTL");
        return r;

    }

    /*
    Pass glycoprotein glycosylation site position
     */
    public static Resource createFaldoLocation(String position, Model model){
        String faldoURI = "_position" + JenaUUID.generate().asURI();
        Resource r = null;
        try{
            r = model.createResource(faldoURI);
            r.addLiteral(FALDO.position, position.replaceAll("ASN-", "").replaceAll("SER-", "").replaceAll("THR-", ""));
        } catch (Exception e) {
            System.out.println("Failed: " + e);
        }
    return r;
    }

    /*
  Need to handle glycans known to be attached to a glycoprotein
  But site not confirmed
  <glycoprotein> .... glycan:has_attached_glycan
   */
    public static Resource createStructureEntryProtein(Model model, Proteins protein){
        Resource r = null;
        for(Stproteins p : protein.stproteins) {
            String structureURI = "http://www.unicarbkb.org/structure/" + p.structure.id;;
            r = model.createResource(structureURI, GLYCOVOCAB.saccharide);
            r.addProperty(GLYCOVOCAB.glycosequence, createhasSequenceCt(model, p.structure))
                    .addProperty(GLYCOVOCAB.glycosequence, createhasSequenceIupac(model, p.structure));
        }
        return r;
    }
}
