package sparql.glycobase;

import sparql.SparqlException;

public class StructureBySample extends GlycanSelectSparql implements GlycanGlycobase {

    public StructureBySample() {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan/> \n";  //need to add # glycan#
        this.select = super.getSelect() + '\n';
    }

    public String getSampleName() {
        return "\"" + getSparqlEntity().getValue(GlycanGlycobase.SampleName) + "\"";
    }


    @Override
    public String getWhere() throws SparqlException {
        String where = super.getWhere();
        where += "?" + ReferenceCompoundURI + " glycan:is_from_source ?" + SourceURI + " .\n"
                + "?" + SourceURI + " glycan:from_sample "+ getSampleName() + " .\n";

        return where;
    }
}