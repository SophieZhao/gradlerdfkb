package sparql.glycobase;

import sparql.SparqlException;


public class StructureByGlycobaseID extends GlycanSelectSparql implements GlycanGlycobase {

    public StructureByGlycobaseID() {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan/> \n";  //need to add # glycan#
        this.select = super.getSelect() + '\n';
    }

    public String getGlycoBaseId() { return getSparqlEntity().getValue(GlycanGlycobase.GlycoBaseId); }

    @Override
    public String getWhere() throws SparqlException {
        String where = super.getWhere();
        where += "?" + SaccharideURI + " glycan:has_glycobase_id " + getGlycoBaseId() + " .\n";

        return where;
    }
}
