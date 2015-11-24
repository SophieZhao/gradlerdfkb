package sparql.glycobase;

import sparql.SelectSparqlBean;
import sparql.SparqlException;

public class ReactionByUoxf extends SelectSparqlBean implements GlycanGlycobase {

    public static final String ReactionURI = "ReactionURI";
    public static final String SubstrateURI = "SubstrateURI";
    public static final String ProductURI = "ProductURI";
    public static final String SubstrateUoxf = "SubstrateUoxf";
    public static final String ProductUoxf = "ProductUoxf";

    public ReactionByUoxf(String sparql) {
        super(sparql);
    }

    public ReactionByUoxf() {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan/> \n";  //need to add # glycan#
        this.select = "DISTINCT ?" + ReactionURI + " ?" + Enzyme + " ?" + SubstrateUoxf + " ?" + ProductUoxf + "\n";
        this.from = "FROM <http://137.92.56.159:443/glycobase>\n";
    }

    public String getUoxf() {
        return "\"" + getSparqlEntity().getValue(GlycanGlycobase.Uoxf) + "\"";
    }


    @Override
    public String getWhere() throws SparqlException {
        String where = "?" + SaccharideURI + " glycan:has_uoxf " + getUoxf() + " .\n"
                + "?" + SaccharideURI + " glycan:has_reaction ?" + ReactionURI + " .\n"
                + "?" + ReactionURI + " glycan:has_exglycosidase ?" + Enzyme + " ;\n"
                + " glycan:has_substrate ?" + SubstrateURI + " ;\n"
                + " glycan:has_product ?" + ProductURI + " .\n"
                + "?" + SubstrateURI + " glycan:has_uoxf ?" + SubstrateUoxf+ " .\n"
                + "?" + ProductURI + " glycan:has_uoxf ?" + ProductUoxf + " .\n";

        return where;
    }
}
