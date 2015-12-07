package sparql.glycobase;

import sparql.SelectSparqlBean;
import sparql.SparqlException;


public class ListStructureOnProtein extends SelectSparqlBean implements GlycanGlycobase {

    public static final String Uoxf = GlycanGlycobase.Uoxf;
    public static final String ProteinURI = "ProteinURI";
    public static final String ProteinName = "ProteinName";

    public ListStructureOnProtein(String sparql) {
        super(sparql);
    }

    public ListStructureOnProtein() {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan/> \n";
        this.select = "DISTINCT ?" + ProteinName + " ?" + Uoxf + "\n";
//        this.from = "FROM <http://137.92.56.159:443/glycobase>\n";
    }

    @Override
    public String getWhere() throws SparqlException {
        String where = "?" + ProteinURI + " glycan:has_protein_name ?" + ProteinName + " ;\n"
                + " glycan:has_attached_glycan ?" + SaccharideURI + " .\n"
                + "?" + SaccharideURI +" glycan:has_uoxf ?" + Uoxf + " .\n";

        return where;
    }
}


