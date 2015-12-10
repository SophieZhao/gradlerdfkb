package sparql.glycobase;

import sparql.SelectSparqlBean;
import sparql.SparqlException;

public class AvgRpGu extends SelectSparqlBean implements GlycanGlycobase {

    public static final String RpGu = "RpGu";
    public static final String avgRp = "avgRp";

    public AvgRpGu(String sparql) {
        super(sparql);
    }

    public AvgRpGu() {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan/> \n";  //need to add # glycan#
        this.select = "DISTINCT ?" + SaccharideURI + "(AVG(?" + RpGu + ") AS ?" + avgRp + ") \n";
    }

    public String getId() {
        return getSparqlEntity().getValue(GlycanGlycobase.GlycoBaseId);
    }


    @Override
    public String getWhere() throws SparqlException {
        String where = "?" + SaccharideURI + " glycan:has_glycobase_id " + getId() + " .\n"
                + "OPTIONAL{?" + SaccharideURI + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " .\n"
                + "?" + EvidenceURI + " a glycan:evidence_rpuplc;\n"
                + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " .\n"
                + "?" + PeakURI +" glycan:has_arabinose_unit ?" + RpGu + " .}\n";
        return where;
    }

    @Override
    public String getGroupBy(){
        String group = "?SaccharideURI";
        return group;
    }
}
