package sparql.glycobase;

import sparql.SelectSparql;
import sparql.SelectSparqlBean;
import sparql.SparqlException;


public class SequenceByID extends SelectSparqlBean implements GlycanGlycobase {

    public static final String Uoxf = GlycanGlycobase.Uoxf;
    public SequenceByID(String sparql) {
        super(sparql);
    }

    public SequenceByID() {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan/> \n";  //need to add # glycan#
        this.select = "DISTINCT ?" + Uoxf + " ?" + Sequence + " ?"+ SaccharideURI+ " ?"+ GlycoBaseId + "\n";
    }

    public String getId() {
        return getSparqlEntity().getValue(GlycanGlycobase.GlycoBaseId);
    }


    @Override
    public String getWhere() throws SparqlException {
        String where = "?" + SaccharideURI + " glycan:has_glycobase_id " + getId() + " ;\n"
                + " glycan:has_uoxf ?" + Uoxf + ";\n"
                + " glycan:has_glycobase_id ?" + GlycoBaseId + " ;\n"
                + " glycan:has_glycosequence ?" + SequenceURI + " .\n"
                + "?" + SequenceURI + " glycan:has_sequence ?" + Sequence + ".\n";

        return where;
    }
}