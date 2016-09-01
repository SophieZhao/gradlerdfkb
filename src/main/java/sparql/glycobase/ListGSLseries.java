package sparql.glycobase;

import sparql.SelectSparqlBean;
import sparql.SparqlException;


public class ListGSLseries extends SelectSparqlBean implements GlycanGlycobase {

    public static final String ReportName = GlycanGlycobase.ReportName;

    public ListGSLseries(String sparql) {
        super(sparql);
    }

    public ListGSLseries() {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan/> \n";
        this.select = "DISTINCT ?" + ReportName + "\n";
    }

    @Override
    public String getWhere() throws SparqlException {
        String where = "?" + ReferenceCompoundURI + " glycan:has_glycan ?" + SaccharideURI
                + ";\n glycan:is_from_report ?" + ReportName + " .\n"
                + " ?" + SaccharideURI + " a glycan:glycolipid.\n";

        return where;
    }
}



