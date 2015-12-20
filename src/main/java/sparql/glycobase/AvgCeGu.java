package sparql.glycobase;

import sparql.SelectSparqlBean;
import sparql.SparqlException;

public class AvgCeGu extends SelectSparqlBean implements GlycanGlycobase {

    public static final String CeGu = "CeGu";
    public static final String avgCe = "avgCe";

    public AvgCeGu(String sparql) {
        super(sparql);
    }

    public AvgCeGu() {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan/> \n";  //need to add # glycan#
        this.select = "DISTINCT ?" + SaccharideURI + " (AVG(?" + CeGu + ") AS ?" + avgCe + ") \n";
    }

    public String getId() {
        return getSparqlEntity().getValue(GlycanGlycobase.GlycoBaseId);
    }


    @Override
    public String getWhere() throws SparqlException {
        String where = "?" + SaccharideURI + " glycan:has_glycobase_id " + getId() + " .\n"
                + "OPTIONAL{?" + SaccharideURI + " glycan:has_ce_peak ?" + PeakURI + " .\n"
                + "?" + EvidenceURI + " a glycan:evidence_ce;\n"
                + " glycan:has_ce_peak ?" + PeakURI + " .\n"
                + "?" + PeakURI +" glycan:has_glucose_unit ?" + CeGu + " .}\n";
        return where;
    }

    @Override
    public String getGroupBy(){
        String group = "?SaccharideURI";
        return group;
    }
}
