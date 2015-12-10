package sparql.glycobase;

import sparql.SelectSparqlBean;
import sparql.SparqlException;


public class ListSample extends SelectSparqlBean implements GlycanGlycobase {

    public static final String SampleName = GlycanGlycobase.SampleName;

    public ListSample(String sparql) {
        super(sparql);
    }

    public ListSample() {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan/> \n";
        this.select = "DISTINCT ?" + SampleName + "\n";
    }

    @Override
    public String getWhere() throws SparqlException {
        String where = "?" + ReferenceCompoundURI + " glycan:is_from_source ?" + SourceURI + " .\n"
                + "?" + SourceURI + " glycan:from_sample ?"+ SampleName + " .\n";

        return where;
    }
}



