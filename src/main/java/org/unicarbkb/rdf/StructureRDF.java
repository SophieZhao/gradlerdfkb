package org.unicarbkb.rdf;

import com.avaje.ebean.Ebean;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.ResourceFactory;
import com.hp.hpl.jena.shared.uuid.JenaUUID;
import com.hp.hpl.jena.vocabulary.OWL2;
import com.hp.hpl.jena.vocabulary.XSD;
import models.database.DefinedSites;
import models.database.Structure;
import models.database.Translation;

import java.util.List;

/**
 * Created by matthew on 8/05/2014.
 */
public class StructureRDF {



    public static Model createStructureResource(Model model){
        List<Structure> structures = Ebean.find(Structure.class).findList();
        for(Structure s : structures) {
            String structureURI = "http://www.unicarbkb.org/structure/" + s.id;
            Resource r = null;
            r = model.createResource(structureURI, GLYCOVOCAB.saccharide);
            r.addProperty(GLYCOVOCAB.glycosequence, createhasSequenceCt(model, s)).addProperty(GLYCOVOCAB.glycosequence, createhasSequenceIupac(model, s) );

        }
    return model;
    }

    public static Resource createStructureFromDefinedSite(Model model, int id){

        Structure structure = Ebean.find(Structure.class, id);
        String structureURI = "http://www.unicarbkb.org/structure/" + structure.id;
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
        String sequenceURI = "http://www.unicarbkb.org/structure/" + structure.id + "/ct";
        r = model.createResource(sequenceURI);
            try {
                Translation t = Ebean.find(Translation.class, structure.id);
                //List<Translation> translation = structure.translation;
                //for(Translation t : translation) {
                    r.addProperty(GLYCOVOCAB.hasSequence, t.ct); //, (com.hp.hpl.jena.datatypes.RDFDatatype) XSD.xstring)
                    r.addProperty(GLYCOVOCAB.inCarbohydrateFormat, GLYCOVOCAB.carbohydrateFormatGlycoct);
                //}

            } catch (Exception e){ System.out.println("Failed here: " + e + e.getCause()); }

        return r;
    }

    public static Resource createhasSequenceIupac(Model model, Structure structure) {
        Resource r = null;
        String sequenceURI = "http://www.unicarbkb.org/structure/" + structure.id + "/iupac";
        r = model.createResource(sequenceURI);
        try {
            List<Translation> translation = structure.translation;
            for(Translation t : translation) {
                r.addProperty(GLYCOVOCAB.hasSequence, t.iupac); //, (com.hp.hpl.jena.datatypes.RDFDatatype) XSD.xstring)
                r.addProperty(GLYCOVOCAB.inCarbohydrateFormat, GLYCOVOCAB.carbohydrateFormatIupac);
            }

        } catch (Exception e){ System.out.println("Failed or maybe here: " + e); }

        return r;
    }

}
