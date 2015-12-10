package sparql.glycobase;

import sparql.SelectSparqlBean;
import sparql.SparqlException;


public class ListTaxon extends SelectSparqlBean implements GlycanGlycobase {

    public static final String SampleName = GlycanGlycobase.SampleName;

    public ListTaxon(String sparql) {
        super(sparql);
    }

    public ListTaxon() {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan/> \n";
        this.select = "DISTINCT ?" + Taxon + "\n";
    }

    @Override
    public String getWhere() throws SparqlException {
        String where = "?" + ReferenceCompoundURI + " glycan:is_from_source ?" + SourceURI + " .\n"
                + "?" + SourceURI + " glycan:has_taxon ?"+ Taxon + " .\n";

        return where;
    }
}



