package sparql.glycobase;

import sparql.SelectSparqlBean;
import sparql.SparqlException;

public class AvgHplcGu extends SelectSparqlBean implements GlycanGlycobase {

    public static final String HplcGu = "HplcGu";
    public static final String avgHp = "avgHp";

    public AvgHplcGu(String sparql) {
        super(sparql);
    }

    public AvgHplcGu() {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan/> \n";  //need to add # glycan#
        this.select = "DISTINCT ?" + SaccharideURI + " (AVG(?" + HplcGu + ") AS ?" + avgHp + ") \n";
    }

    public String getId() {
        return getSparqlEntity().getValue(GlycanGlycobase.GlycoBaseId);
    }


    @Override
    public String getWhere() throws SparqlException {
        String where = "?" + SaccharideURI + " glycan:has_glycobase_id " + getId() + " .\n"
                + "OPTIONAL{?" + SaccharideURI + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " .\n"
                + "?" + ProfileURI + " a glycan:evidence_hplc;\n"
                + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " .\n"
                + "?" + PeakURI +" glycan:has_glucose_unit ?" + HplcGu + " .}\n";
        return where;
    }

    @Override
    public String getGroupBy(){
        String group = "?SaccharideURI";
        return group;
    }
}
