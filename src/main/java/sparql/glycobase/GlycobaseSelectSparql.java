package sparql.glycobase;

import sparql.GlycoSequenceSparql;
import sparql.Saccharide;
import sparql.SaccharideSelectSparql;
import sparql.SparqlException;


/**
 * Created by matthew on 19/11/15.
 */
public class GlycobaseSelectSparql extends SaccharideSelectSparql implements GlycoSequenceSparql {

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


    @Override
    public String getWhere() throws SparqlException {
        String where = super.getWhere();
        where += "?" + SaccharideURI + " glycan:has_glycosequence ?" + GlycanSequenceURI + " .\n"
                // + "?" + GlycanSequenceURI + " glycan:has_sequence ?" + Sequence + " .\n"
                + "?" + GlycanSequenceURI + " glycan:has_uoxf " + getUoxf() + " .\n";

        return where;
    }
}
