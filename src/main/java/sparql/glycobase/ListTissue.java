package sparql.glycobase;

import sparql.SelectSparqlBean;
import sparql.SparqlException;


public class ListTissue extends SelectSparqlBean implements GlycanGlycobase {


    public ListTissue(String sparql) {
        super(sparql);
    }

    public ListTissue() {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan/> \n";
        this.select = "DISTINCT ?" + Tissue + "\n";
    }

    @Override
    public String getWhere() throws SparqlException {
        String where = "?" + ReferenceCompoundURI + " glycan:is_from_source ?" + SourceURI + " .\n"
                + "?" + SourceURI + " glycan:has_tissue ?"+ Tissue + " .\n";

        return where;
    }
}



