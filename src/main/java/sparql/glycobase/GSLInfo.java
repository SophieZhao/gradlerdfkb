package sparql.glycobase;

import sparql.SelectSparqlBean;
import sparql.SparqlException;


public class GSLInfo extends SelectSparqlBean implements GlycanGlycobase {

    public static final String alternativeName = "alternativeName";
    public static final String series = "series";
    public static final String gslCode = "gslCode";
    public static final String category = "category";



    public GSLInfo(String sparql) {
        super(sparql);
    }

    public GSLInfo() {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan/> \n";
        this.select = "DISTINCT ?" + alternativeName + " ?" + gslCode + " ?" + series  + " ?" + category +" \n";
    }

    public String getId() {
        return getSparqlEntity().getValue(GlycanGlycobase.GlycoBaseId);
    }


    @Override
    public String getWhere() throws SparqlException {
        String where = "?" + SaccharideURI + " a glycan:glycolipid;\n glycan:has_alternative_name ?" + alternativeName
                + ";\n glycan:has_glycobase_id ?" + getId()
                + ";\n glycan:has_series ?" + series
                +";\n glycan:has_code ?" + gslCode + ".\n"
                + "OPTIONAL{?" + SaccharideURI + " glycan:is_from_category ?" + category + " .}\n";
        return where;
    }

}
