package sparql.glycobase;

import sparql.SelectSparqlBean;
import sparql.SparqlException;

public class ReactionByID extends SelectSparqlBean implements GlycanGlycobase {

    public static final String ReactionURI = "ReactionURI";
    public static final String SubstrateURI = "SubstrateURI";
    public static final String ProductURI = "ProductURI";
    public static final String SubstrateUoxf = "SubstrateUoxf";
    public static final String ProductUoxf = "ProductUoxf";

    public ReactionByID(String sparql) {
        super(sparql);
    }

    public ReactionByID() {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan/> \n";  //need to add # glycan#
        this.select = "DISTINCT ?" + ReactionURI + " ?" + Enzyme + " ?" + SubstrateUoxf + " ?" + ProductUoxf + "\n";
    }

    public String getId() {return getSparqlEntity().getValue(GlycanGlycobase.GlycoBaseId);}


    @Override
    public String getWhere() throws SparqlException {
        String where = "?" + SaccharideURI + " glycan:has_glycobase_id " + getId() + " .\n"
                + "?" + SaccharideURI + " glycan:has_reaction ?" + ReactionURI + " .\n"
                + "?" + ReactionURI + " glycan:has_exglycosidase ?" + Enzyme + " ;\n"
                + " glycan:has_substrate ?" + SubstrateURI + " ;\n"
                + " glycan:has_product ?" + ProductURI + " .\n"
                + "?" + SubstrateURI + " glycan:has_uoxf ?" + SubstrateUoxf+ " .\n"
                + "?" + ProductURI + " glycan:has_uoxf ?" + ProductUoxf + " .\n";

        return where;
    }
}
