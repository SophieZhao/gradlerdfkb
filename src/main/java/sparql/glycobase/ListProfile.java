package sparql.glycobase;

import sparql.SelectSparqlBean;
import sparql.SparqlException;


public class ListProfile extends SelectSparqlBean implements GlycanGlycobase {

    public static final String Uoxf = GlycanGlycobase.Uoxf;

    public ListProfile(String sparql) {
        super(sparql);
    }

    public ListProfile() {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan/> \n";
        this.select = "DISTINCT ?" + EvidenceURI + "\n";
//        this.from = "FROM <http://137.92.56.159:443/glycobase>\n";
    }

    public String getEvidenceType() { return getSparqlEntity().getValue(GlycanGlycobase.EvidenceType);}


    @Override
    public String getWhere() throws SparqlException {
        String type = getEvidenceType();
        String where = "";
        if(type.equals("uplc")){
            where += "?" + EvidenceURI + " a glycan:evidence_uplc;\n glycan:has_lc_chromatogram_peak ?" + PeakURI + ".\n";
        }
        else if(type.equals("hplc")){
            where += "?" + EvidenceURI + " a glycan:evidence_hplc;\n glycan:has_lc_chromatogram_peak ?" + PeakURI + ".\n";
        }
        else if(type.equals("rpuplc")){
            where += "?" + EvidenceURI + " a glycan:evidence_rpuplc;\n glycan:has_lc_chromatogram_peak ?" + PeakURI + ".\n";
        }
        else if(type.equals("ce")){
            where += "?" + EvidenceURI + " a glycan:evidence_ce;\n glycan:has_ce_peak ?" + PeakURI + ".\n";
        }

        return where;
    }
}

