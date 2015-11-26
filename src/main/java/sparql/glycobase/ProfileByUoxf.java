package sparql.glycobase;

import sparql.SelectSparqlBean;
import sparql.SparqlException;


public class ProfileByUoxf extends SelectSparqlBean implements GlycanGlycobase {

    public ProfileByUoxf(String sparql) {
        super(sparql);
    }

    public ProfileByUoxf() {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan/> \n";  //need to add # glycan#
        this.select = "DISTINCT ?" + SaccharideURI + " ?" + EvidenceURI + " ?" + EvidenceType + "\n";
//        this.from = "FROM <http://137.92.56.159:443/glycobase>\n";
    }

    public String getUoxf() {
        return "\"" + getSparqlEntity().getValue(GlycanGlycobase.Uoxf) + "\"";
    }


    @Override
    public String getWhere() throws SparqlException {
        String where = "?" + SaccharideURI + " glycan:has_uoxf " + getUoxf() + " .\n"
                + "?" + SaccharideURI + " (glycan:has_lc_chromatogram_peak|glycan:has_ce_peak) ?" + PeakURI + " .\n"
                + "OPTIONAL{\n ?" + EvidenceURI + " a glycan:evidence_hplc; \n a ?" + EvidenceType + " ;\n"
                + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " .\n}\n"
                + "OPTIONAL{\n ?" + EvidenceURI + " a glycan:evidence_rpuplc; \n a ?" + EvidenceType + " ;\n"
                + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " .\n}\n"
                + "OPTIONAL{\n ?" + EvidenceURI + " a glycan:evidence_uplc; \n a ?" + EvidenceType + " ;\n"
                + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " .\n}\n"
                + "OPTIONAL{\n ?" + EvidenceURI + " a glycan:evidence_ce; \n a ?" + EvidenceType + " ;\n"
                + " glycan:has_ce_peak ?" + PeakURI + " .\n}\n";

        return where;
    }
}
