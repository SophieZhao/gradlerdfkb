package sparql.glycobase;

import sparql.GlycoSequenceSparql;
import sparql.Saccharide;
import sparql.SaccharideSelectSparql;
import sparql.SparqlException;

/**
 * Created by matthew on 20/11/15.
 */
public class GlycoBaseSelectGuSparql extends GlycanSelectSparql implements GlycoSequenceSparql {

    /*
    Using GlycanSelectSparql here to set the select part of query
    also usinf from <glycobase>
     */

    public static final String SaccharideURI = Saccharide.URI;
    public static final String Sequence = "Sequence";
    public static final String GlycanSequenceURI = "GlycanSequenceURI";
    public static final String Uoxf = GlycanGlycobase.Uoxf;


    public GlycoBaseSelectGuSparql() {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan>";  //need to add # glycan#
        this.select = super.getSelect() + "\n"; //+ " ?" + Sequence + "\n";
    }


    public String getGu() {
        return "\"" + getSparqlEntity().getValue(GlycanGlycobase.Gu) + "\"";
    }


    @Override
    public String getWhere() throws SparqlException {
        //String where = super.getWhere();
        String where =  "?" + GlycanSequenceURI + " glycan:has_glucose_unit " + getGu() + " .\n";

        return where;
    }
}
