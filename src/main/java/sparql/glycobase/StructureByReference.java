package sparql.glycobase;

import sparql.SelectSparql;
import sparql.SelectSparqlBean;
import sparql.SparqlException;

public class StructureByReference extends SelectSparqlBean implements GlycanGlycobase {

    public static final String Uoxf = GlycanGlycobase.Uoxf;
    public static final String PaperURI = "PaperURI";

    public StructureByReference(String sparql) {
        super(sparql);
    }

    public StructureByReference() {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan/> \n";  //need to add # glycan#
        this.select = "DISTINCT ?" + Uoxf + "\n";
    }

    public String getPmid() {
        return "\"" + getSparqlEntity().getValue(GlycanGlycobase.PubmedId) + "\"";
    }


    @Override
    public String getWhere() throws SparqlException {
        String where = "?" + ReferenceCompoundURI + " glycan:published_in ?" + PaperURI + " ;\n"
                + " glycan:has_glycan ?"+ SaccharideURI + " .\n"
                + "?" + SaccharideURI + " glycan:has_uoxf ?" + Uoxf + " .\n"
                + "?" + PaperURI + " glycan:has_pmid " + getPmid() + " .\n";

        return where;
    }
}


