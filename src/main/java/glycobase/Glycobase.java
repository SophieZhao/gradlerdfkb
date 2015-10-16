package glycobase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
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

    public void readCSV() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("glycobase.csv").getFile());
        final List<Glycobase> glycobase;

        try (final Stream<String> lines = Files.lines(file.toPath())) {
            glycobase = lines.skip(1).map(line -> line.split("\\t")).map(line -> {
                final int id = Integer.parseInt(line[1]);
                final String name = line[0];
                final String ct = line [2];
                final String uplc = line[3];
                final String hplc = line[4];
                final String ce = line[5] ;
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

        System.out.println("check size " + glycobase.size());

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
