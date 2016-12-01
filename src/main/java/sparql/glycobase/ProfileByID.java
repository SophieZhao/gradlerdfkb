package sparql.glycobase;

import sparql.SelectSparqlBean;
import sparql.SparqlException;


public class ProfileByID extends SelectSparqlBean implements GlycanGlycobase {

    public ProfileByID(String sparql) {
        super(sparql);
    }

    public ProfileByID() {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan/> \n";  //need to add # glycan#
        this.select = "DISTINCT ?" + SaccharideURI + " ?" + ProfileURI + " ?" + EvidenceType + "\n";
    }

    public String getId() {return getSparqlEntity().getValue(GlycanGlycobase.GlycoBaseId);}

    @Override
    public String getWhere() throws SparqlException {
        String where = "?" + SaccharideURI + " glycan:has_glycobase_id " + getId() + " .\n"
                + "?" + SaccharideURI + " (glycan:has_lc_chromatogram_peak|glycan:has_ce_peak) ?" + PeakURI + " .\n"
                + "OPTIONAL{\n ?" + ProfileURI + " a glycan:evidence_hplc; \n a ?" + EvidenceType + " ;\n"
                + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " .\n}\n"
                + "OPTIONAL{\n ?" + ProfileURI + " a glycan:evidence_rpuplc; \n a ?" + EvidenceType + " ;\n"
                + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " .\n}\n"
                + "OPTIONAL{\n ?" + ProfileURI + " a glycan:evidence_uplc; \n a ?" + EvidenceType + " ;\n"
                + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " .\n}\n"
                + "OPTIONAL{\n ?" + ProfileURI + " a glycan:evidence_ce; \n a ?" + EvidenceType + " ;\n"
                + " glycan:has_ce_peak ?" + PeakURI + " .\n}\n";

        return where;
    }
}
