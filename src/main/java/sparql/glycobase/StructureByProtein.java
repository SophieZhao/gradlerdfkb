package sparql.glycobase;

import sparql.SelectSparql;
import sparql.SelectSparqlBean;
import sparql.SparqlException;

public class StructureByProtein extends SelectSparqlBean implements GlycanGlycobase {

    public static final String Uoxf = GlycanGlycobase.Uoxf;

    public StructureByProtein(String sparql) {
        super(sparql);
    }

    public StructureByProtein() {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan/> \n";  //need to add # glycan#
        this.select = "DISTINCT ?" + Uoxf + "\n";
    }

    public String getProtein() {
        return "\"" + getSparqlEntity().getValue(GlycanGlycobase.ProteinName) + "\"";
    }


    @Override
    public String getWhere() throws SparqlException {
        String where = "?" + ProteinURI + " glycan:has_protein_name " + getProtein() + " ;\n"
                + " glycan:has_attached_glycan ?"+ SaccharideURI + " .\n"
                + "?" + SaccharideURI + " glycan:has_uoxf ?" + Uoxf + " .\n";

        return where;
    }
}

