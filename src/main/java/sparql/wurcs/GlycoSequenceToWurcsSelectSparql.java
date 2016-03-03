package sparql.wurcs;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import sparql.GlycoSequenceSelectSparql;
import sparql.GlycoSequenceSparql;
import sparql.SparqlException;

/**
 *
 * SelectSparql for retrieving the Wurcs of
 * The filter removes any existing sequences in the getTo() of the GlyConvert.
 *
 * For instance: Retrieving of original glycoct by using
 * org.glycoinfo.conversion.wurcs.GlycoctToWurcsConverter.
 *
 * @author aoki
 *
 */
//@Component
public class GlycoSequenceToWurcsSelectSparql extends GlycoSequenceSelectSparql {
    protected Log logger = LogFactory.getLog(getClass());

    public static final String FormatGlycoSequenceURI = "FormatGlycoSequenceURI";
    public static final String FromSequence = "FromSequence";
    public static final String GlycoCT = "Glycoct";

    String format;

    public GlycoSequenceToWurcsSelectSparql() {
        super();
        this.where += "?" + SaccharideURI + " glycan:has_glycosequence ?" + FormatGlycoSequenceURI + " .\n";
        this.where += "?" + SaccharideURI + " glytoucan:has_primary_id ?" + GlycoSequenceSparql.AccessionNumber + " .\n";
    }

    public GlycoSequenceToWurcsSelectSparql(String format) throws SparqlException {
        super();
        this.format = format;
        this.where += "?" + SaccharideURI + " glycan:has_glycosequence ?" + FormatGlycoSequenceURI + " .\n"
                + "?" + FormatGlycoSequenceURI + " glycan:in_carbohydrate_format glycan:carbohydrate_format_" + format + " . \n";
        this.where += "?" + SaccharideURI + " glytoucan:has_primary_id ?" +  GlycoSequenceSparql.AccessionNumber + " .\n";
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String getWhere() throws SparqlException {
        //return this.where + "?" + FormatGlycoSequenceURI + " glycan:has_sequence \"" + getSparqlEntity().getValue(FromSequence) + "\"^^xsd:string .\n";
        return this.where + "?" + FormatGlycoSequenceURI + " glycan:has_sequence ?" + GlycoCT + " .\n"
                + "FILTER (str(?" + GlycoCT + ") =\"" +  getSparqlEntity().getValue(FromSequence) + "\"^^xsd:string) .\n";

    }
}