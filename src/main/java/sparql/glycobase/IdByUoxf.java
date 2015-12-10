package sparql.glycobase;

import sparql.SelectSparql;
import sparql.SelectSparqlBean;
import sparql.SparqlException;


public class IdByUoxf extends SelectSparqlBean implements GlycanGlycobase {
    public static final String Uoxf=GlycanGlycobase.Uoxf;

    public IdByUoxf(String sparql) {
        super(sparql);
    }

    public IdByUoxf() {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan/> \n";  //need to add # glycan#
        this.select = "DISTINCT ?" + GlycoBaseId + " ?" + Uoxf + "\n";
    }

    public String getUoxf() {return "\"" + getSparqlEntity().getValue(GlycanGlycobase.Uoxf) + "\"";}


    @Override
    public String getWhere() throws SparqlException {
        String where = "?" + SaccharideURI + " glycan:has_uoxf " + getUoxf() + ";\n"
                + " glycan:has_uoxf ?" + Uoxf + " ;\n"
                + " glycan:has_glycobase_id ?" + GlycoBaseId + " .\n";

        return where;
    }
}