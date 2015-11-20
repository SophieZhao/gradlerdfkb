package sparql;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by matthew on 19/11/15.
 */
public class SaccharideSelectSparql extends SelectSparqlBean implements Saccharide {

    public static final String SaccharideURI = Saccharide.URI;
    public static final String Sequence = "Sequence";
    public static final String GlycanSequenceURI = "GlycanSequenceURI";
    public static final String AccessionNumber = Saccharide.PrimaryId;

    public SaccharideSelectSparql(String sparql) {
        super(sparql);
    }

    public SaccharideSelectSparql() {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan#>\n"
                + "PREFIX glytoucan: <http://www.glytoucan.org/glyco/owl/glytoucan#>\n";
        this.select = "DISTINCT ?" + SaccharideURI + "\n?" + PrimaryId + "\n";
//		this.from = "FROM <http://rdf.glytoucan.org>\n";
    }

    public String getPrimaryId() {
        return "\"" + getSparqlEntity().getValue(Saccharide.PrimaryId) + "\"";
    }

    @Override
    public String getWhere() throws SparqlException {
        String lWhere = "?" + SaccharideURI + " a glycan:saccharide .\n?" + SaccharideURI + " glytoucan:has_primary_id ?" + PrimaryId + " .\n";
        if (null != getSparqlEntity() && StringUtils.isNotBlank(getSparqlEntity().getValue(PrimaryId)))
            lWhere += "?" + SaccharideURI + " glytoucan:has_primary_id " + getPrimaryId() + " .\n";
        return lWhere;
    }

    protected Log logger = LogFactory.getLog(getClass());

}
