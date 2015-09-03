package org.unicarbkb.rdf;

import com.avaje.ebean.Ebean;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.vocabulary.RDF;
import models.database.Reference;
import models.database.Structure;
import models.unicarbdb.core.GlycanSequence;
import models.unicarbdb.hplc.Lcmucin;
import models.unicarbdb.ms.PeakLabeled;
import models.unicarbdb.ms.PeakList;
import models.unicarbdb.ms.Scan;

import java.util.List;
import java.util.UUID;

/**
 * Created by matthew on 3/09/15.
 */
public class MassSpec {

    public static Model createLcStructureResource(Model model) {
        List<Lcmucin> lcmucin = Ebean.find(Lcmucin.class).findList();
        for(Lcmucin l : lcmucin) {
            Resource r = null;
            String sequenceURI = "http://rdf.unicarbdb.org/structure/" + l.glycanSequence.glycanSequenceId;
            r = model.createResource(sequenceURI, GLYCOVOCAB.saccharide);

            r.addProperty(GLYCOVOCAB.glycosequence, createhasSequenceCTLcmucin(model, l.glycanSequence));
            createMSResource(model, l);
        }
        return model;
    }

    public static Resource createhasSequenceCTLcmucin(Model model, GlycanSequence structure) {
        Resource r = null;
        String sequenceURI = "http://rdf.unicarbdb.org/structure/" + structure.glycanSequenceId + "/ct";
        r = model.createResource(sequenceURI);
            try {
                String glycoct = structure.sequenceCt;

                if (!glycoct.isEmpty()) {
                    r.addProperty(GLYCOVOCAB.hasSequence, glycoct);
                    r.addProperty(GLYCOVOCAB.inCarbohydrateFormat, GLYCOVOCAB.carbohydrateFormatGlycoct);
                } else {
                    System.out.println("bad structure no ct etc");
                }

            } catch (Exception e) {
                System.out.println("Failed here: " + e.getCause());
            }
        return r;
    }

    public static Resource createMSResource(Model model, Lcmucin lcmucin) {

        Resource r = null;
        try {
            String uri = "http://rdf.unicarbkb.org/massSpectrum/" + lcmucin.lcmucinId; //might change to scan
            r = model.createResource(uri, GLYCOVOCAB.massSpectrum);
            r.addLiteral(GLYCOVOCAB.hasRetentionTime, lcmucin.retentionTime);
            r.addLiteral(GLYCOVOCAB.hasMsnLevel, "2");
            //add scan number number?
            models.unicarbdb.ms.Scan scan = lcmucin.scan;

            for(PeakList peakList : scan.peakLists) {
                    for(PeakLabeled peakLabeled : peakList.peakLabeled) {
                        r.addProperty(GLYCOVOCAB.hasMsPeak, createMsPeak(model, peakLabeled));
                    }
            }


        } catch (Exception e) {
            System.out.println("Failed here: " + e.getCause());
        }
        return r;
    }

    public static Resource createMsPeak(Model model, PeakLabeled peakLabeled) {
        Resource r = null;
        try{
            String uri = "http://rdf.unicarbkb.org/massSpectrum/peakList/" + UUID.randomUUID();
            r = model.createResource(uri, GLYCOVOCAB.hasMsPeak);
            r.addLiteral(GLYCOVOCAB.hasIntensity, peakLabeled.intensityValue);
            r.addLiteral(GLYCOVOCAB.hasMz, peakLabeled.mzValue);
            r.addLiteral(GLYCOVOCAB.hasCharge, peakLabeled.chargeCount); //is this correct
            //add annotation

        } catch (Exception e) {
            System.out.println("Failed here: " + e.getCause());
        }
        return r;
    }

}
