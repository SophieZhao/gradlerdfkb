package sparql.glycobase;

import sparql.SelectSparqlBean;
import sparql.SparqlException;

public class AvgUplcGu extends SelectSparqlBean implements GlycanGlycobase {

    public static final String avgUp = "avgUp";

    public AvgUplcGu(String sparql) {
        super(sparql);
    }

    public AvgUplcGu() {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan/> \n";  //need to add # glycan#
        this.select = "DISTINCT ?" + SaccharideURI + " (AVG(?" + Gu + ") AS ?" + avgUp + ") \n";
    }

    public String getId() {
        return getSparqlEntity().getValue(GlycanGlycobase.GlycoBaseId);
    }
    public String getLabelType() { return "\"" + getSparqlEntity().getValue(GlycanGlycobase.LabelType) + "\"";}


    @Override
    public String getWhere() throws SparqlException {
        String where = "?" + SaccharideURI + " glycan:has_glycobase_id " + getId() + " .\n"
                + "OPTIONAL{?" + SaccharideURI + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " .\n"
                + "?" + ProfileURI + " a glycan:evidence_uplc;\n"
                + " glycan:has_label " + getLabelType() + ";\n"
                + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " .\n"
                + "?" + PeakURI +" glycan:has_glucose_unit ?" + Gu + " .}\n";
        return where;
    }

    @Override
    public String getGroupBy(){
        String group = "?SaccharideURI";
        return group;
    }
}
