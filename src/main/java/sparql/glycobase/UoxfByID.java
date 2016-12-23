package sparql.glycobase;

import sparql.SelectSparql;
import sparql.SelectSparqlBean;
import sparql.SparqlException;


public class UoxfByID extends SelectSparqlBean implements GlycanGlycobase {

    public static final String Uoxf = "Uoxf";

    public UoxfByID(String sparql) {
        super(sparql);
    }

    public UoxfByID() {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan/> \n";  //need to add # glycan#
        this.select = "DISTINCT ?" + SaccharideURI + " ?" + Uoxf +" \n";
    }

    public String getGlycoBaseId() { return getSparqlEntity().getValue(GlycanGlycobase.GlycoBaseId); }

    @Override
    public String getWhere() throws SparqlException {
        String where = "?" + SaccharideURI + " glycan:has_glycobase_id " + getGlycoBaseId() + ";\n"
                + " glycan:has_uoxf ?" + Uoxf +" .\n";

        return where;
    }
}

