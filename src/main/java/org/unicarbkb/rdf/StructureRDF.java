package org.unicarbkb.rdf;

import com.avaje.ebean.Ebean;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.ResourceFactory;
import com.hp.hpl.jena.shared.uuid.JenaUUID;
import com.hp.hpl.jena.vocabulary.DCTerms;
import com.hp.hpl.jena.vocabulary.OWL2;
import com.hp.hpl.jena.vocabulary.RDF;
import com.hp.hpl.jena.vocabulary.XSD;
import com.sun.xml.internal.bind.v2.TODO;
import models.database.*;

import java.util.List;

/**
 * Created by matthew on 8/05/2014.
 */
public class StructureRDF {


    /*
    Create all stored structures
     */
    public static Model createStructureResource(Model model) {
        List<Structure> structures = Ebean.find(Structure.class).findList();
        for (Structure s : structures) {

            //TODO just for testing
            if(s.id < 7420) {
                String structureURI = "http://rdf.unicarbkb.org/structure/" + s.id;
                Resource r = null;
                r = model.createResource(structureURI, GLYCOVOCAB.saccharide);

            /*
            changes to use ct parser instead of translation table
             */
                //r.addProperty(GLYCOVOCAB.glycosequence, createhasSequenceCt(model, s)).addProperty(GLYCOVOCAB.glycosequence, createhasSequenceIupac(model, s)); //.addProperty(GLYCOVOCAB.glycosequence, createhasSequenceGlyde(model, s));

                r.addProperty(GLYCOVOCAB.glycosequence, createhasSeqeuceCTIupacParser(model, s)).addProperty(GLYCOVOCAB.glycosequence, createhasSequenceIupac(model, s));

                createResourceEntry(model, s);

                //CTParser.readCT(model, s, r);
            }

        }
        return model;
    }

    public static Resource createStructureFromDefinedSite(Model model, Long id) {

        Structure structure = Ebean.find(Structure.class, id);
        String structureURI = "http://rdf.unicarbkb.org/structure/" + structure.getId();
        Resource r = null;
        r = model.createResource(structureURI, GLYCOVOCAB.saccharide);
        r.addProperty(GLYCOVOCAB.glycosequence, createhasSequenceCt(model, structure));
        try {
            r.addProperty(GLYCOVOCAB.glycosequence, createhasSequenceIupac(model, structure));
        } catch (Exception e) {
        }
        return r;
    }

    public static Resource createhasSequenceCt(Model model, Structure structure) {
        Resource r = null;
        String sequenceURI = "http://rdf.unicarbkb.org/structure/" + structure.getId() + "/ct";
        r = model.createResource(sequenceURI);
        try {
            Translation t = Ebean.find(Translation.class, structure.id);
            //List<Translation> translation = structure.translation;
            //for(Translation t : translation) {
            if (!(t.getCt() == null)) {
                r.addProperty(GLYCOVOCAB.hasSequence, t.getCt()); //, (com.hp.hpl.jena.datatypes.RDFDatatype) XSD.xstring)
                r.addProperty(GLYCOVOCAB.inCarbohydrateFormat, GLYCOVOCAB.carbohydrateFormatGlycoct);
            } else {
                System.out.println("bad structure no ct etc");
            }

        } catch (Exception e) {
            System.out.println("Failed here: " + e + e.getCause());
        }

        return r;
    }


    public static Resource createhasSeqeuceCTIupacParser(Model model, Structure structure) {
        Resource r = null;
        String sequenceURI = "http://rdf.unicarbkb.org/structure/" + structure.getId() + "/ct";
        r = model.createResource(sequenceURI);
        if (structure.id < 7420) { //TODO this is for testing only
            try {
                Structure structure1 = Ebean.find(Structure.class, structure.id);
                String glycoct = IupacReader.readIupacToCT(structure1.getGlycanst());

                if (!glycoct.isEmpty()) {
                    r.addProperty(GLYCOVOCAB.hasSequence, glycoct);
                    r.addProperty(GLYCOVOCAB.inCarbohydrateFormat, GLYCOVOCAB.carbohydrateFormatGlycoct);
                } else {
                    System.out.println("bad structure no ct etc");
                }

            } catch (Exception e) {
                System.out.println("Failed here: " + e.getCause());
            }
        }
        return r;
    }


    public static Resource createhasSequenceIupac(Model model, Structure structure) {
        Resource r = null;
        String sequenceURI = "http://rdf.unicarbkb.org/structure/" + structure.getId() + "/iupac";
        r = model.createResource(sequenceURI);
        try {
            Translation t = Ebean.find(Translation.class, structure.id);

            //List<Translation> translation = structure.translation;
            //for(Translation t : translation) {
            if (!(t.getIupac() == null)) {
                r.addProperty(GLYCOVOCAB.hasSequence, t.getIupac()); //, (com.hp.hpl.jena.datatypes.RDFDatatype) XSD.xstring)
                r.addProperty(GLYCOVOCAB.inCarbohydrateFormat, GLYCOVOCAB.carbohydrateFormatIupac);
            } else {
                System.out.println("bad structure no iupac ");
            }

        } catch (Exception e) {
            System.out.println("Failed or maybe here: " + e);
        }

        return r;
    }

    //
    public static Resource createhasSequenceGlyde(Model model, Structure structure) {
        Resource r = null;
        String sequenceURI = "http://rdf.unicarbkb.org/structure/" + structure.getId() + "/glyde";
        r = model.createResource(sequenceURI);
        try {
            Translation t = Ebean.find(Translation.class, structure.id);

            //List<Translation> translation = structure.translation;
            //for(Translation t : translation) {
            if (!(t.getCt() == null)) {
                String glycoctXML = CTParser.createGlyde(t);
                System.out.println(glycoctXML);
                r.addProperty(GLYCOVOCAB.hasSequence, glycoctXML); //, (com.hp.hpl.jena.datatypes.RDFDatatype) XSD.xstring)
                r.addProperty(GLYCOVOCAB.inCarbohydrateFormat, GLYCOVOCAB.carbohydrateFormatGlyde);
            } else {
                System.out.println("bad structure no glyde2 ");
            }

        } catch (Exception e) {
            System.out.println("Failed or maybe here: " + e);
        }

        return r;
    }

    //

    public static Resource createResourceEntry(Model model, Structure structure) {
        Resource r = null;
        String resourceEntryURI = "http://rdf.unicarbkb.org/resource_entry/" + structure.getId(); // + JenaUUID.generate(); changing to Id reduce lines by 50K
        r = model.createResource(resourceEntryURI);
        try {
            r.addProperty(RDF.type, GLYCOVOCAB.resourceEntry).addProperty(GLYCOVOCAB.inGlycanDatabase, GLYCOVOCAB.inKB).addLiteral(DCTerms.identifier, structure.getId());
        } catch (Exception e) {
            System.out.println("Failed here createResourceEntry: " + e + e.getCause());
        }

        return r;
    }

}


/*
<http://csdb.glycoscience.ru/integration/make_rdf.php?&mode=record&id_list=7466>
        a glyco:resource_entry ;
        glyco:in_glycan_database glyco:database_bcsdb ;
        dcterms:identifier "7466"^^xsd:integer .
 */