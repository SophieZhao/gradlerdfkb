package sparql.glycobase;


import sparql.SelectSparqlBean;
import sparql.SparqlException;

public class MassByID extends SelectSparqlBean implements GlycanGlycobase{
    public static final String MonoMass = "MonoMass";

    public MassByID(String sparql){ super(sparql);}

    public MassByID(){
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan/> \n";  //need to add # glycan#
        this.select = "DISTINCT ?" + SaccharideURI + " ?" + MonoMass +" \n";
    }

    public String getGlycoBaseId() { return getSparqlEntity().getValue(GlycanGlycobase.GlycoBaseId); }

    @Override
    public String getWhere() throws SparqlException{
        String where = "?" + SaccharideURI + " glycan:has_glycobase_id " + getGlycoBaseId() + ".\n"
                + "OPTIONAL{?" + SaccharideURI + " glycan:has_average_molecular_weight ?" + MonoMass + ".}\n";

        return where;
    }


}
