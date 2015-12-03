package sparql.glycobase;

import sparql.SelectSparqlBean;
import sparql.SparqlException;


public class SequenceByUoxf extends SelectSparqlBean implements GlycanGlycobase {

    public SequenceByUoxf(String sparql) {
        super(sparql);
    }

    public SequenceByUoxf() {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan/> \n";  //need to add # glycan#
        this.select = "DISTINCT ?" + Sequence + " ?"+ SaccharideURI+ "\n";
//        this.from = "FROM <http://137.92.56.159:443/glycobase>\n";
    }

    public String getUoxf() {
        return "\"" + getSparqlEntity().getValue(GlycanGlycobase.Uoxf) + "\"";
    }


    @Override
    public String getWhere() throws SparqlException {
        String where = "?" + SaccharideURI + " glycan:has_uoxf " + getUoxf() + " .\n"
                + "?" + SaccharideURI + " glycan:has_glycosequence ?" + SequenceURI + " .\n"
                + "?" + SequenceURI + " glycan:has_sequence ?" + Sequence + ".\n";

        return where;
    }
}