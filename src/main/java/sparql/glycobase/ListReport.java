package sparql.glycobase;

import sparql.SelectSparqlBean;
import sparql.SparqlException;


public class ListReport extends SelectSparqlBean implements GlycanGlycobase {

    public static final String ReportName = GlycanGlycobase.ReportName;

    public ListReport(String sparql) {
        super(sparql);
    }

    public ListReport() {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan/> \n";
        this.select = "DISTINCT ?" + ReportName + "\n";
    }

    @Override
    public String getWhere() throws SparqlException {
        String where = "?" + ReferenceCompoundURI + " glycan:is_from_report ?" + ReportName + " .\n";

        return where;
    }
}



