package sparql.glycobase;

import sparql.SelectSparqlBean;
import sparql.SparqlException;

public class AvgUplcGu extends SelectSparqlBean implements GlycanGlycobase {

    public static final String UplcGu = "UplcGu";
    public static final String avgUp = "avgUp";

    public AvgUplcGu(String sparql) {
        super(sparql);
    }

    public AvgUplcGu() {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan/> \n";  //need to add # glycan#
        this.select = "DISTINCT ?" + SaccharideURI + "(AVG(?" + UplcGu + ") AS ?" + avgUp + ") \n";
    }

    public String getId() {
        return getSparqlEntity().getValue(GlycanGlycobase.GlycoBaseId);
    }


    @Override
    public String getWhere() throws SparqlException {
        String where = "?" + SaccharideURI + " glycan:has_glycobase_id " + getId() + " .\n"
                + "OPTIONAL{?" + SaccharideURI + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " .\n"
                + "?" + EvidenceURI + " a glycan:evidence_uplc;\n"
                + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " .\n"
                + "?" + PeakURI +" glycan:has_glucose_unit ?" + UplcGu + " .}\n";
        return where;
    }

    @Override
    public String getGroupBy(){
        String group = "?SaccharideURI";
        return group;
    }
}
