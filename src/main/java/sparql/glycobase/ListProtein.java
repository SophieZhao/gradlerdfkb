package sparql.glycobase;

import sparql.SelectSparqlBean;
import sparql.SparqlException;


public class ListProtein extends SelectSparqlBean implements GlycanGlycobase {

    public static final String Uoxf = GlycanGlycobase.Uoxf;
    public static final String ProteinURI = "ProteinURI";
    public static final String ProteinName = "ProteinName";

    public ListProtein(String sparql) {
        super(sparql);
    }

    public ListProtein() {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan/> \n";
        this.select = "DISTINCT ?" + ProteinName  + "\n";
    }

    @Override
    public String getWhere() throws SparqlException {
        String where = "?" + ProteinURI + " glycan:has_protein_name ?" + ProteinName + " ;\n"
                + " glycan:has_attached_glycan ?" + SaccharideURI + " .\n";

        return where;
    }
}


