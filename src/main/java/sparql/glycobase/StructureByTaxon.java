package sparql.glycobase;

import sparql.SparqlException;


public class StructureByTaxon extends GlycanSelectSparql implements GlycanGlycobase {

    public StructureByTaxon() {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan/> \n";  //need to add # glycan#
        this.select = super.getSelect() + "\n";
    }

    public String getTaxonName() {
        return "\"" + getSparqlEntity().getValue(GlycanGlycobase.Taxon) + "\"";
    }


    @Override
    public String getWhere() throws SparqlException {
        String where = super.getWhere();
        where += "?" + SourceURI + " glycan:has_taxon " + getTaxonName() + " .\n"
                + "?" + ReferenceCompoundURI + " glycan:is_from_source ?" + SourceURI + " .\n";

        return where;
    }
}
