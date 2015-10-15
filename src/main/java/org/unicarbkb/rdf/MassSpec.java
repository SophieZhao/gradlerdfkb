package org.unicarbkb.rdf;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer;
import models.unicarbdb.core.GlycanSequence;
import models.unicarbdb.hplc.Lcmucin;
import models.unicarbdb.ms.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;

import java.util.List;
import java.util.UUID;

/**
 * Created by matthew on 3/09/15.
 */
public class MassSpec {

    public static Model createLcStructureResource(Model model) {
        //Ebean.
        EbeanServer defserver = Ebean.getServer("db");
        System.out.println("ebean check: " + defserver.getName() );
        List<Lcmucin> lcmucin = defserver.find(Lcmucin.class).findList();
        for(Lcmucin l : lcmucin) {
            System.out.println("lcm: " + l.getLcmucinId());



            Resource r = null;
            String sequenceURI = "http://rdf.unicarbdb.org/structure/" + l.glycanSequence.glycanSequenceId;
            r = model.createResource(sequenceURI, GLYCOVOCAB.saccharide);

            r.addProperty(GLYCOVOCAB.glycosequence, createhasSequenceCTLcmucin(model, l.glycanSequence));
            createMSResource(model, l);
            createAcquisition(model, l);
        }
        return model;
    }

    /*
    we have limited data all ion trap but different manufactures so can be lesss strict for now
     */
    public static Resource createAcquisition(Model model, Lcmucin lcmucin){
        Resource r = null;
        String acquisitionURI= "http://rdf.unicarbdb.org/instrumentDetails/";
        r = model.createResource(acquisitionURI);
        Acquisition acquisition = Ebean.find(Acquisition.class, lcmucin.getAcquisitionId());
        try{
            Device device = acquisition.device;

        } catch (Exception e) {

        }
        return r;
    }

    public static Resource createhasSequenceCTLcmucin(Model model, GlycanSequence structure) {
        Resource r = null;
        String sequenceURI = "http://rdf.unicarbdb.org/structure/" + structure.glycanSequenceId + "/ct";
        r = model.createResource(sequenceURI);
            try {
                String glycoct = structure.getSequenceCt();
                if (!glycoct.isEmpty()) {
                    r.addProperty(GLYCOVOCAB.hasSequence, glycoct);
                    r.addProperty(GLYCOVOCAB.inCarbohydrateFormat, GLYCOVOCAB.carbohydrateFormatGlycoct);
                } else {
                    System.out.println("bad structure no ct etc");
                }

            } catch (Exception e) {
                System.out.println("Failed here for ct: " + e.getCause());
            }
        return r;
    }

    public static Resource createMSResource(Model model, Lcmucin lcmucin) {

        Resource r = null;
        try {
            String uri = "http://rdf.unicarbdb.org/massSpectrum/" + lcmucin.lcmucinId; //might change to scan
            r = model.createResource(uri, GLYCOVOCAB.massSpectrum);
            r.addLiteral(GLYCOVOCAB.hasRetentionTime, lcmucin.retentionTime);
            r.addLiteral(GLYCOVOCAB.hasMsnLevel, 2);
            //add scan number number?
            models.unicarbdb.ms.Scan scan = lcmucin.scan;
            List<PeakList> peakList = scan.getPeakLists();

            for(PeakList peak :peakList) {
                //System.out.println("scan: " + peak.getPeakLabeled());
                for(PeakLabeled peakLabeled : peak.getPeakLabeled()) {
                    r.addProperty(GLYCOVOCAB.hasMsPeak, createMsPeak(model, peakLabeled));
                }
            }


        } catch (Exception e) {
            System.out.println("Failed here peaks: " + e.getCause());
        }
        return r;
    }

    public static Resource createMsPeak(Model model, PeakLabeled peakLabeled) {
        Resource r = null;
        try{
            String uri = "http://rdf.unicarbdb.org/massSpectrum/peakList/" + UUID.randomUUID();
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
