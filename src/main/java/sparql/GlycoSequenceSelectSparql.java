package sparql;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by matthew on 19/11/15.
 */
public class GlycoSequenceSelectSparql extends SaccharideSelectSparql implements  GlycoSequenceSparql {

    public static final String SaccharideURI = Saccharide.URI;
    public static final String Sequence = "Sequence";
    public static final String GlycanSequenceURI = "GlycanSequenceURI";



    public GlycoSequenceSelectSparql()  {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan#>\n"
                + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
                + "PREFIX glytoucan:  <http://www.glytoucan.org/glyco/owl/glytoucan#>";
        this.select = super.getSelect() + " ?" + Sequence + "\n";
        /*this.from = "FROM <http://rdf.glytoucan.org>\n"
                + "FROM <http://rdf.glytoucan.org/sequence/wurcs>";*/
    }

    public String getPrimaryId() {
        return "\"" + getSparqlEntity().getValue(Saccharide.PrimaryId) + "\"";
    }


    @Override
    public String getWhere() throws SparqlException {
        String whereTmp = super.getWhere();
        whereTmp += "?" + SaccharideURI + " glycan:has_glycosequence ?" + GlycanSequenceURI + " .\n"
                + "?" + GlycanSequenceURI + " glycan:has_sequence ?" + Sequence + " .\n";

        if (StringUtils.isNotBlank(getSparqlEntity().getValue(GlycoSequenceSparql.Format))) {
            whereTmp += "?" + GlycanSequenceURI + " glycan:in_carbohydrate_format glycan:carbohydrate_format_" + getSparqlEntity().getValue(GlycoSequenceSparql.Format) + " .\n";
        }
        return whereTmp;
    }

    protected Log logger = LogFactory.getLog(getClass());

    String glycanUri;

    /**
     *
     * the filter removes any sequences that already have a sequence in the
     * GlyConvert.getTo() format.
     *
     * @return
     */
    public String getFilter() {
        if (getSparqlEntity().getValue(IdentifiersToIgnore) != null) {
//			FILTER (?primaryId != "G95801EZ")}
            String filter = null;
            List<String> ignores = (List<String>) getSparqlEntity().getObjectValue(IdentifiersToIgnore);
            for (Iterator iterator = ignores.iterator(); iterator.hasNext();) {
                String string = (String) iterator.next();
                filter = " ?" + Saccharide.PrimaryId + " != \"" + string + "\" ";
                if (iterator.hasNext())
                    filter += " && ";
            }
            return "FILTER (" + filter + ")";
        } else {
            return "FILTER NOT EXISTS {\n"
                    + "?" + SaccharideURI + " glytoucan:has_derivatized_mass ?existingmass .\n}";
        }
    }

    /*@Override
    public void afterPropertiesSet() throws Exception {
        Assert.state(getPrefix() != null, "A prefix is required");
        Assert.state(getSelect() != null, "A select is required");
    }*/


}
