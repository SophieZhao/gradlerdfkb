package sparql.glycobase;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import sparql.GlycoSequenceSparql;
import sparql.Saccharide;
import sparql.SaccharideSelectSparql;
import sparql.SparqlException;

import java.util.Iterator;
import java.util.List;

/**
 * Created by matthew on 19/11/15.
 */
public class GlycobaseSelectSparql extends SaccharideSelectSparql implements  GlycoSequenceSparql {

    public static final String SaccharideURI = Saccharide.URI;
    public static final String Sequence = "Sequence";
    public static final String GlycanSequenceURI = "GlycanSequenceURI";
    public static final String Uoxf = GlycanGlycobase.Uoxf;


    public GlycobaseSelectSparql() {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan>";  //need to add # glycan#
        this.select = super.getSelect() + " ?" + Sequence + "\n";
    }

    public String getPrimaryId() {
        return "\"" + getSparqlEntity().getValue(Saccharide.PrimaryId) + "\"";
    }

    public String getUoxf() {
        return "\"" + getSparqlEntity().getValue(GlycanGlycobase.Uoxf) + "\"";
    }

    /*
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

    */
    @Override
    public String getWhere() throws SparqlException {
        String where = super.getWhere();
        where += "?" + SaccharideURI + " glycan:has_glycosequence ?" + GlycanSequenceURI + " .\n"
                // + "?" + GlycanSequenceURI + " glycan:has_sequence ?" + Sequence + " .\n"
                + "?" + GlycanSequenceURI + " glycan:has_uoxf " + getUoxf() + " .\n";

        return where;
    }
}
