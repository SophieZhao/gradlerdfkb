package org.unicarbkb.rdf;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.ResourceFactory;
import com.hp.hpl.jena.shared.uuid.JenaUUID;
import com.hp.hpl.jena.vocabulary.DC;
import com.hp.hpl.jena.vocabulary.RDF;
import models.database.*;
import org.unicarbkb.rdf.StructureRDF;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import static java.net.URLEncoder.encode;
import static org.unicarbkb.rdf.StructureRDF.*;


public class Glycoproteins {

    public static void createProteins(Model model, Proteins protein) {
        try {
            if (protein.swissProt != null) {
                Resource p = model.createResource("http://rdf.unicarbkb.org/proteinsummary/" + protein.getSwissProt().trim());
                p.addProperty(GLYCOVOCAB.hasUniprotAccession, "uniprot:" + protein.getSwissProt()); //UNIPROT.uniprotAccession);

                List<Stproteins> strprotein = protein.stproteins;
                for (Stproteins strp : strprotein) {
                    p.addProperty(GLYCOVOCAB.hasAttachedGlycan, createStructureEntryProtein(model, strp.structure)); //TODO check output
                }

                List<DefinedSites> defined = protein.proteinDefinedSites;
                for (DefinedSites d : defined) {
                    p.addProperty(GLYCOVOCAB.hasGlycosylatedAA, createGlycoAA(d, model));
                }
            }

            if (protein.swissProt == null && protein.name != null) {
                Resource p = model.createResource("http://rdf.unicarbkb.org/proteinsummary/" + encode(protein.getName().trim(), "UTF-8"));
                p.addProperty(GLYCOVOCAB.hasProteinName, protein.getName().trim());

                List<Stproteins> strprotein = protein.stproteins;
                for (Stproteins strp : strprotein) {
                    p.addProperty(GLYCOVOCAB.hasAttachedGlycan, createStructureEntryProtein(model, strp.structure)); //TODO check output
                }

                List<DefinedSites> defined = protein.proteinDefinedSites;
                for (DefinedSites d : defined) {
                    p.addProperty(GLYCOVOCAB.hasGlycosylatedAA, createGlycoAA(d, model));
                }
            }
        } catch (Exception e) {
            System.out.println("Failed createProteins: " + e.getCause() + " more info " + protein.getSwissProt());
        }

        //return p;
    }

    /*
    create has_glycosylated_aa using uuid
    might not be the best approach
    connected to a FALDO.Location ExactPosition
    problem need to split records with AND or AND/OR etc and then create individual records
    AND AND/OR OF ON
    IN UNIPROT BUT INGORE

    REPLACE aSNASN
     */
    public static Resource createGlycoAA(DefinedSites d, Model model) {
        Resource r = null;
        //work area

        List<StructureToSiteDefined> t = d.strSiteDefined;
        System.out.println("this is the protein: " + d.protein_name + " with am string " + d.amino_acid_position );

        for (StructureToSiteDefined z : t) {

            String amino = z.amino_acid_position;
            String[] aa = amino.split(("(?i)AND|OR|AND/OR|,|IN|ON|OF|\\&"));
            for (String aaa : aa) {
                String aaaa = aaa.toUpperCase().replaceAll("AsnAsn", "Asn").replaceAll("SerSer", "Ser").replaceAll("ThrThr", "Thr").replaceAll("\\(.+?\\)", "").replaceAll("\\-", "");
                aaaa.replaceAll("ASNASN","ASN").replaceAll("\\s+","").replaceAll("\\(MAJ", "");

                System.out.println("split amino string: " + aaa.toString().trim());

                String glycoAAURI = "http://rdf.unicarbkb.org/glycoAASite/" + d.proteins.id + "_" + aaaa.replaceAll("ASNASN","ASN").replaceAll("\\s+","").replaceAll("\\(MAJ", "").trim(); //bad + JenaUUID.generate().asString();

                try {
                    r = model.createResource(glycoAAURI);
                    r.addProperty(FALDO.Location, createFaldoLocation(aaaa.trim(), z.protein_name.trim(), model, z));
                    r.addProperty(RDF.type, GLYCOVOCAB.glycosylatedAA);

                    List<StructureToSiteDefined> sD = d.strSiteDefined;
                    for (StructureToSiteDefined s : sD) {
                        System.out.println("structure dead is " + s.structure_id);
                        r.addProperty(GLYCOVOCAB.hasAttachedGlycan, createStructureFromDefinedSite(model, s.structure_id));
                    }

                    if (z.amino_acid_position.contains("ASN")) {
                        r.addProperty(GLYCOVOCAB.aminoAcidType, model.getResource("asparagine")); //TODO CHECK
                        r.addLiteral(GLYCOVOCAB.modificationType, "N-glycosylation");
                    }
                    if (z.amino_acid_position.contains("THR")) {
                        r.addProperty(GLYCOVOCAB.aminoAcid, model.getResource("threonine")); //TODO CHECK
                        r.addLiteral(GLYCOVOCAB.modificationType, "O-glycosylation");
                    }
                    if (z.amino_acid_position.contains("SER")) {
                        r.addProperty(GLYCOVOCAB.aminoAcid, model.getResource("serine")); //TODO CHECK
                        r.addLiteral(GLYCOVOCAB.modificationType, "O-glycosylation");
                    }
                } catch (Exception e) {
                    System.out.println("Failed creating glycoAA: " + e);
                }
                //model.write(System.out, "TTL");
            }
        }
        return r;
    }

    /*
    Pass glycoprotein glycosylation site position
     */
    public static Resource createFaldoLocation(String position, String protein, Model model, StructureToSiteDefined z) throws UnsupportedEncodingException {
        String faldoURI = null;
        if(z.definedSites.proteins.swissProt != null) {
            faldoURI = "http://rdf.unicarbkb.org/position/" + z.definedSites.proteins.swissProt.trim() + "_" + position.replaceAll("\\-", "").replaceAll("ASNASN","ASN").replaceAll("\\s+","").replaceAll("\\(MAJ", "").trim(); // + JenaUUID.generate().asURI();
        }
        if(z.definedSites.proteins.swissProt == null && z.protein_name != null) {
            faldoURI = "http://rdf.unicarbkb.org/position/" + encode(z.protein_name.trim(), "UTF-8") + "_" + position.replaceAll("\\-", "").trim();
        }
        Resource r = null;
        try {
            r = model.createResource(faldoURI);
            r.addLiteral(FALDO.position, position.replaceAll("ASN-", "").replaceAll("SER-", "").replaceAll("THR-", "").replaceAll("ASNASN", ""));
        } catch (Exception e) {
            System.out.println("Failed on Faldo: " + e);
        }
        return r;
    }

    /*
  Need to handle glycans known to be attached to a glycoprotein
  But site not confirmed
  <glycoprotein> .... glycan:has_attached_glycan
   */
    public static Resource createStructureEntryProtein(Model model, Structure p) {
        Resource r = null;
        //for(Stproteins p : stprotein) {
        //System.out.println("Protein " + protein.swissProt + " " + p.id);
        String structureURI = "http://rdf.unicarbkb.org/structure/" + p.id;
        ;
        r = model.createResource(structureURI, GLYCOVOCAB.saccharide);
        r.addProperty(GLYCOVOCAB.glycosequence, createhasSequenceCt(model, p))
                //.addProperty(GLYCOVOCAB.glycosequence, createhasSequenceIupac(model, p)); //todo change ct parser testing only
                .addProperty(GLYCOVOCAB.glycosequence, createhasSeqeuceCTIupacParser(model, p));
        // }
        return r;
    }
}
