package sparql.glycobase;

import sparql.SparqlException;

public class StructureByReport extends GlycanSelectSparql implements GlycanGlycobase {

    public static final String ReferenceCompoundURI = "ReferenceCompoundURI";


    public StructureByReport() {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan/> \n";  //need to add # glycan#
        this.select = super.getSelect() + "\n";
    }

    public String getReportName() {
        return "\"" + getSparqlEntity().getValue(GlycanGlycobase.ReportName) + "\"";
    }


    @Override
    public String getWhere() throws SparqlException {
        String where = super.getWhere();
        where += "?" + ReferenceCompoundURI + " glycan:is_from_report " + getReportName() + " .\n";

        return where;
    }
}