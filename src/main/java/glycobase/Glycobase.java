package glycobase;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import models.glycobase.*;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by matthew on 16/10/2015.
 */
public class Glycobase {

    private final String glycanName;
    private final int glycobaseId;
    private final String glycoCT; //note presence of comma in string
    private final String uplc;
    private final String hplc;
    private final String ce;
    private final String rpuplc;
    private final String taxonomy;
    private final String tissue;
    private final String disease;
    private final String reportTitle;
    private final String reportIds;
    private final String sampleTitle;
    private final String sampleIds;
    private final String profileTitles;
    private final String profileIds;
    private final String digestionChildren;
    private final String digestionParents;

    public Glycobase(String glycanName, int glycobaseId, String glycoCT, String uplc, String hplc, String ce, String rpuplc, String taxonomy, String tissue, String disease, String reportTitle, String reportIds, String sampleTitle, String sampleIds, String profileTitles, String profileIds, String digestionChildren, String digestionParents) {
        this.glycanName = glycanName;
        this.glycobaseId = glycobaseId;
        this.glycoCT = glycoCT;
        this.uplc = uplc;
        this.hplc = hplc;
        this.ce = ce;
        this.rpuplc = rpuplc;
        this.taxonomy = taxonomy;
        this.tissue = tissue;
        this.disease = disease;
        this.reportTitle = reportTitle;
        this.reportIds = reportIds;
        this.sampleTitle = sampleTitle;
        this.sampleIds = sampleIds;
        this.profileTitles = profileTitles;
        this.profileIds = profileIds;
        this.digestionChildren = digestionChildren;
        this.digestionParents = digestionParents;
    }

    public static List<String> readArrayLine(String data) {

        List<String> elementsInString = Splitter.on(",").splitToList(data);

        return elementsInString;
    }

    /*
    Read csv file and chop up
     */
    public static boolean readCSV() throws IOException {
        //ClassLoader classLoader = getClass().getClassLoader();
        File file = new File("/tmp/glycobase_spread.csv");

        EbeanServer glycobaseServer = Ebean.getServer("glycobase");

        final List<Glycobase> glycobase;

        try (final Stream<String> lines = Files.lines(file.toPath())) {
            glycobase = lines.skip(1).map(line -> line.split("\\t")).map(line -> {
                final int id = Integer.parseInt(line[1]);
                final String name = line[0];
                final String ct = line[2];
                final String uplc = line[3];
                final String hplc = line[4];
                final String ce = line[5];
                final String rpuplc = line[6];
                final String taxonomy = line[7];
                final String tissue = line[8];
                final String disease = line[9];
                final String reportTitle = line[10];
                final String reportIds = line[11];
                final String sampleTitle = line[12];
                final String sampleIds = line[13];
                final String profileTitles = line[14];
                final String profileIds = line[15];
                final String digestionChildren = line[16];
                final String digestionParents = line[17];
                return new Glycobase(name, id, ct, uplc, hplc, ce, rpuplc, taxonomy, tissue, disease, reportTitle, reportIds, sampleTitle, sampleIds, profileTitles, profileIds, digestionChildren, digestionParents);
            }).collect(Collectors.toList());
        }

        for (Glycobase glycan : glycobase) {
            System.out.println("glycobase Id: " + glycan.glycobaseId);
            Structure structure = new Structure();
            structure.setId(Long.valueOf(glycan.getGlycobaseId()));
            structure.setGlycoct(glycan.getGlycoCT());
            //glycobaseServer.save(structure);


            List<String> uplcSplit = Glycobase.readArrayLine(glycan.getUplc());

            for(String uplc : uplcSplit){
                //System.out.println("uplc string: " + uplc);
                Uplc uplc1 = new Uplc();

                if (!uplc.matches("\\[\\]")) {
                    uplc = uplc.replaceAll("\\[", "").replaceAll("\\]", "");
                    //System.out.println("uplc entry: " + uplc);
                    uplc1.setGu(Double.parseDouble(uplc));
                    uplc1.setStructure(structure);
                    //glycobaseServer.save(uplc1);
                }
            }

            List<String> hplcSplit = Glycobase.readArrayLine(glycan.getHplc());

            for(String hplc : hplcSplit){
                Hplc hplc1 = new Hplc();
                if (!hplc.matches("\\[\\]")) {
                    hplc = hplc.replaceAll("\\[", "").replaceAll("\\]", "");
                    hplc1.setGu(Double.parseDouble(hplc));
                    hplc1.setStructure(structure);
                    //glycobaseServer.save(hplc1);
                }
            }


            List<String> ceSplit = Glycobase.readArrayLine(glycan.getCe());

            for(String ce : ceSplit){
                Ce ce1 = new Ce();
                if (!ce.matches("\\[\\]")) {
                    ce = ce.replaceAll("\\[", "").replaceAll("\\]", "");
                    ce1.setGu(Double.parseDouble(ce));
                    ce1.setStructure(structure);
                    //glycobaseServer.save(ce1);
                }
            }



            List<String> rpuplcSplit = Glycobase.readArrayLine(glycan.getRpuplc());
            for(String rp : rpuplcSplit){
                Rpuplc rpuplc = new Rpuplc();
                if (!rp.matches("\\[\\]")) {
                    rp = rp.replaceAll("\\[", "").replaceAll("\\]", "");
                    rpuplc.setAu(Double.parseDouble(rp));
                    rpuplc.setStructure(structure);
                    //glycobaseServer.save(rpuplc);
                }
            }

            List<String> taxonomySplit = Glycobase.readArrayLine(glycan.getTaxonomy());

            for(String tax : taxonomySplit){
                Taxonomy taxonomy = new Taxonomy();
                if (!tax.matches("\\[\\]")) {
                    tax = tax.replaceAll("\\[", "").replaceAll("\\]", "");
                    taxonomy.setTaxonomy(tax);
                    taxonomy.setStructure(structure);
                    //glycobaseServer.save(taxonomy);
                }
            }

            List<String> tissueSplit = Glycobase.readArrayLine(glycan.getTissue());
            for(String tissue : tissueSplit){
                Tissue tissue1 = new Tissue();
                if (!tissue.matches("\\[\\]")) {
                    tissue = tissue.replaceAll("\\[", "").replaceAll("\\]", "");
                    tissue1.setTissue(tissue);
                    tissue1.setStructure(structure);
                    //glycobaseServer.save(tissue1);
                }
            }

            List<String> diseaseSplit = Glycobase.readArrayLine(glycan.getDisease());
            for(String disease : diseaseSplit){
                Disease disease1 = new Disease();
                if (!disease.matches("\\[\\]")) {
                    disease = disease.replaceAll("\\[", "").replaceAll("\\]", "");
                    disease1.setDisease(disease);
                    disease1.setStructure(structure);
                    //glycobaseServer.save(disease1);
                }
            }

            List<String> reportTitleSplit = Glycobase.readArrayLine(glycan.getReportTitle());


            for(String report : reportTitleSplit){
                System.out.println("check string: " + report);

                ReportTitle reportTitle = new ReportTitle();
                if(!report.matches("\\[\\]")) {
                    report = report.replaceAll("\\[", "").replaceAll("\\]", "");
                    reportTitle.setReportId(0);
                    reportTitle.setReportTitle(report);
                    reportTitle.setStructure(structure);
                }
            }


            List<String> reportIdsSplit = Glycobase.readArrayLine(glycan.getReportIds());

            List<String> sampleTitleSplit = Glycobase.readArrayLine(glycan.getSampleTitle());

            for(String sample : sampleTitleSplit){

                SampleTitle sampleTitle = new SampleTitle();
                if(!sample.matches("\\[\\]")) {
                    sample = sample.replaceAll("\\[", "").replaceAll("\\]", "");
                    sampleTitle.setSampleId(0);
                    sampleTitle.setSampleTitle(sample);
                    sampleTitle.setStructure(structure);
                }
            }

            List<String> sampleIdsSplit = Glycobase.readArrayLine(glycan.getSampleIds());



            List<String> profileTitlesSplit = Glycobase.readArrayLine(glycan.getProfileTitles());

            for(String profile : profileTitlesSplit){

                ProfileTitle profileTitle = new ProfileTitle();
                if(!profile.matches("\\[\\]")) {
                    profile = profile.replaceAll("\\[", "").replaceAll("\\]", "");
                    profileTitle.setProfileId(0);
                    profileTitle.setProfileTitle(profile);
                    profileTitle.setStructure(structure);
                }
            }


            List<String> profileIdsSplit = Glycobase.readArrayLine(glycan.getProfileIds());

            if (glycan.getDigestionChildren().length() > 5){

                Map<String, String> digestionChildrenSplit = DigestChildrenParent.readDigestChildren(glycan.getDigestionChildren(), structure);


            }

            if (glycan.getDigestionParents().length() > 5) {
                Map<String, String> digestionParentsSplit = DigestChildrenParent.readDigestParent(glycan.getDigestionParents(), structure);
            }


        }
        return true;
    }

    public String getGlycanName() {
        return glycanName;
    }

    public int getGlycobaseId() {
        return glycobaseId;
    }

    public String getGlycoCT() {
        return glycoCT;
    }

    public String getUplc() {
        return uplc;
    }

    public String getHplc() {
        return hplc;
    }

    public String getCe() {
        return ce;
    }

    public String getRpuplc() {
        return rpuplc;
    }

    public String getTaxonomy() {
        return taxonomy;
    }

    public String getTissue() {
        return tissue;
    }

    public String getDisease() {
        return disease;
    }

    public String getReportTitle() {
        return reportTitle;
    }

    public String getReportIds() {
        return reportIds;
    }

    public String getSampleTitle() {
        return sampleTitle;
    }

    public String getSampleIds() {
        return sampleIds;
    }

    public String getProfileTitles() {
        return profileTitles;
    }

    public String getProfileIds() {
        return profileIds;
    }

    public String getDigestionChildren() {
        return digestionChildren;
    }

    public String getDigestionParents() {
        return digestionParents;
    }
}
