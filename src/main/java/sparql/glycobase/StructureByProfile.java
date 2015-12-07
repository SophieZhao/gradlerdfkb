package sparql.glycobase;

import sparql.SelectSparql;
import sparql.SelectSparqlBean;
import sparql.SparqlException;


public class StructureByProfile extends SelectSparqlBean implements GlycanGlycobase {

    public static final String Uoxf = GlycanGlycobase.Uoxf;
    public static final String PeakArea = "PeakArea";
    public StructureByProfile(String sparql) {
        super(sparql);
    }

    public StructureByProfile() {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan/> \n";  //need to add # glycan#
        this.select = "DISTINCT ?" + Uoxf + " ?" + Gu + " ?" + PeakArea + " ?"+ EvidenceType + " ?"+ SaccharideURI + "\n";
//        this.from = "FROM <http://137.92.56.159:443/glycobase>\n";
    }

    public String getProfileId() {
        return getSparqlEntity().getValue(GlycanGlycobase.ProfileId);
    }


    @Override
    public String getWhere() throws SparqlException {
        String where = "OPTIONAL{ <http://rdf.glycobase.org/hplc/" + getProfileId() +"> a glycan:evidence_hplc; \n"
                + " a ?" + EvidenceType + " ;\n"
                + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " .\n"
                + "?" + PeakURI + " glycan:has_glucose_unit ?" + Gu
                + " .\n OPTIONAL{?"+ PeakURI + " glycan:has_peak_area ?" + PeakArea + " .}\n"
                + "?" + SaccharideURI + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " ;\n"
                + " a glycan:saccharide ;\n glycan:has_uoxf ?" + Uoxf + " .}\n"

                + "OPTIONAL{ <http://rdf.glycobase.org/rpuplc/" + getProfileId() +"> a glycan:evidence_rpuplc; \n"
                + " a ?" + EvidenceType + " ;\n"
                + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " .\n"
                + "?" + PeakURI + " glycan:has_arabinose_unit ?" + Gu
                + " .\n OPTIONAL{?"+ PeakURI + " glycan:has_peak_area ?" + PeakArea + " .}\n"
                + "?" + SaccharideURI + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " ;\n"
                + " a glycan:saccharide ;\n glycan:has_uoxf ?" + Uoxf + " .}\n"

                + "OPTIONAL{ <http://rdf.glycobase.org/uplc/" + getProfileId() +"> a glycan:evidence_uplc; \n"
                + " a ?" + EvidenceType + " ;\n"
                + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " .\n"
                + "?" + PeakURI + " glycan:has_glucose_unit ?" + Gu
                + " .\n OPTIONAL{?"+ PeakURI + " glycan:has_peak_area ?" + PeakArea + " .}\n"
                + "?" + SaccharideURI + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " ;\n"
                + " a glycan:saccharide ;\n glycan:has_uoxf ?" + Uoxf + " .}\n"

                + "OPTIONAL{ <http://rdf.glycobase.org/ce/" + getProfileId() +"> a glycan:evidence_ce; \n"
                + " a ?" + EvidenceType + " ;\n"
                + " glycan:has_ce_peak ?" + PeakURI + " .\n"
                + "?" + PeakURI + " glycan:has_glucose_unit ?" + Gu
                + " .\n OPTIONAL{?"+ PeakURI + " glycan:has_peak_area ?" + PeakArea + " .}\n"
                + "?" + SaccharideURI + " glycan:has_ce_peak ?" + PeakURI + " ;\n"
                + " a glycan:saccharide ;\n glycan:has_uoxf ?" + Uoxf + " .}\n";

        return where;
    }
}