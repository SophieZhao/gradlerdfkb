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
import models.database.DefinedSites;
import models.database.Stproteins;
import models.database.Structure;
import models.database.Translation;

import java.util.List;

/**
 * Created by matthew on 8/05/2014.
 */
public class StructureRDF {


    /*
    Create all stored structures
     */
    public static Model createStructureResource(Model model){
        List<Structure> structures = Ebean.find(Structure.class).findList();
        for(Structure s : structures) {
            String structureURI = "http://www.unicarbkb.org/structure/" + s.id;
            Resource r = null;
            r = model.createResource(structureURI, GLYCOVOCAB.saccharide);
            r.addProperty(GLYCOVOCAB.glycosequence, createhasSequenceCt(model, s)).addProperty(GLYCOVOCAB.glycosequence, createhasSequenceIupac(model, s) );

            createResourceEntry(model, s);

        }
    return model;
    }

    public static Resource createStructureFromDefinedSite(Model model, Long id){

        Structure structure = Ebean.find(Structure.class, id);
        String structureURI = "http://www.unicarbkb.org/structure/" + structure.getId();
        Resource r = null;
        r = model.createResource(structureURI, GLYCOVOCAB.saccharide);
        r.addProperty(GLYCOVOCAB.glycosequence, createhasSequenceCt(model, structure));
        try {
            r.addProperty(GLYCOVOCAB.glycosequence, createhasSequenceIupac(model, structure) );
        } catch (Exception e) {

        }

        return r;
    }

    public static Resource createhasSequenceCt(Model model, Structure structure) {
        Resource r = null;
        String sequenceURI = "http://www.unicarbkb.org/structure/" + structure.getId() + "/ct";
        r = model.createResource(sequenceURI);
            try {
                Translation t = Ebean.find(Translation.class, structure.id);
                //List<Translation> translation = structure.translation;
                //for(Translation t : translation) {
                if(!(t ==null)){
                    r.addProperty(GLYCOVOCAB.hasSequence, t.getCt()); //, (com.hp.hpl.jena.datatypes.RDFDatatype) XSD.xstring)
                    r.addProperty(GLYCOVOCAB.inCarbohydrateFormat, GLYCOVOCAB.carbohydrateFormatGlycoct);
                } else {
                    System.out.println("bad structure no ct etc");
                }

            } catch (Exception e){ System.out.println("Failed here: " + e + e.getCause()); }

        return r;
    }

    public static Resource createhasSequenceIupac(Model model, Structure structure) {
        Resource r = null;
        String sequenceURI = "http://www.unicarbkb.org/structure/" + structure.getId() + "/iupac";
        r = model.createResource(sequenceURI);
        try {
            List<Translation> translation = structure.translation;
            for(Translation t : translation) {
                r.addProperty(GLYCOVOCAB.hasSequence, t.getIupac()); //, (com.hp.hpl.jena.datatypes.RDFDatatype) XSD.xstring)
                r.addProperty(GLYCOVOCAB.inCarbohydrateFormat, GLYCOVOCAB.carbohydrateFormatIupac);
            }

        } catch (Exception e){ System.out.println("Failed or maybe here: " + e); }

        return r;
    }

    public static Resource createResourceEntry(Model model, Structure structure) {
        Resource r = null;
        String resourceEntryURI = "resource_entry _" + JenaUUID.generate();
        r = model.createResource(resourceEntryURI);
        try {
            r.addProperty(RDF.type, GLYCOVOCAB.resourceEntry).addProperty(GLYCOVOCAB.inGlycanDatabase, GLYCOVOCAB.inKB).addLiteral(DCTerms.identifier, structure.getId());
        } catch (Exception e){ System.out.println("Failed here createResourceEntry: " + e + e.getCause()); }

        return r;
    }

}


/*
<http://csdb.glycoscience.ru/integration/make_rdf.php?&mode=record&id_list=7466>
        a glyco:resource_entry ;
        glyco:in_glycan_database glyco:database_bcsdb ;
        dcterms:identifier "7466"^^xsd:integer .
 */