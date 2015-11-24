package sparql.glycobase;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import sparql.Saccharide;
import sparql.SelectSparqlBean;
import sparql.SparqlException;

/**
 * Created by matthew on 19/11/15.
 */
public class GlycanSelectSparql extends SelectSparqlBean implements GlycanGlycobase  {

    public static final String Uoxf = GlycanGlycobase.Uoxf;

    public GlycanSelectSparql(String sparql) {
        super(sparql);
    }

    public GlycanSelectSparql() {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan#>\n"
                + "PREFIX glytoucan: <http://www.glytoucan.org/glyco/owl/glytoucan#>\n";
        this.select = "DISTINCT ?" + SaccharideURI + " ?" + Uoxf ;
        this.from = "FROM <http://137.92.56.159:443/glycobase>\n";
    }

    @Override
    public String getWhere() throws SparqlException {
        String where = "?" + ReferenceCompoundURI + " glycan:has_glycan ?" + SaccharideURI + " .\n"
                + "?" + SaccharideURI + " glycan:has_uoxf ?" + Uoxf + " .\n";
        return where;
    }

    protected Log logger = LogFactory.getLog(getClass());

}
