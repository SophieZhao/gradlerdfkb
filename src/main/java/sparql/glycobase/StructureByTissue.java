package sparql.glycobase;

import sparql.SparqlException;


public class StructureByTissue extends GlycanSelectSparql implements GlycanGlycobase {

    public StructureByTissue() {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan/> \n";  //need to add # glycan#
        this.select = super.getSelect() + " ?"+ Taxon + "\n";
    }

    public String getTissueName() {
        return "\"" + getSparqlEntity().getValue(GlycanGlycobase.Tissue) + "\"";
    }


    @Override
    public String getWhere() throws SparqlException {
        String where = super.getWhere();
        where += "?" + SourceURI + " glycan:has_tissue " + getTissueName() + " ;\n"
                + " glycan:has_taxon ?" + Taxon + " .\n"
                + "?" + ReferenceCompoundURI + " glycan:is_from_source ?" + SourceURI + " .\n";

        return where;
    }
}
