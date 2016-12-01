package sparql.wurcs;

import sparql.SelectSparqlBean;
import sparql.SparqlException;
import sparql.SparqlEntity;
import sparql.GlycoSequenceSparql;
import sparql.Saccharide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MotifSearchSparql extends SelectSparqlBean {

    public static Logger logger = (Logger) LoggerFactory
            .getLogger(MotifSearchSparql.class);

    public MotifSearchSparql() {
        this.define = "DEFINE sql:select-option \"order\"";
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan#>\n"
                + "PREFIX toucan:  <http://www.glytoucan.org/glyco/owl/glytoucan#>\n"
                + "PREFIX wurcs: <http://www.glycoinfo.org/glyco/owl/wurcs#>";
        this.select = "DISTINCT ?" + Saccharide.URI;
//				+ " ?" + Saccharide.PrimaryId;
        this.from = "FROM <http://rdf.glytoucan.org>\n"
                + "FROM <http://rdf.glytoucan.org/sequence/wurcs>\n"
                + "FROM <http://rdf.glycoinfo.org/wurcs/0.5.0>\n"
                + "FROM <http://rdf.glycoinfo.org/wurcs/0.5.0/ms>";
    }

//    @Override
//    public String getWhere() throws SparqlException {
//        this.where = ""
//                + "?" + Saccharide.URI + " glycan:has_glycosequence ?gseq .\n";
//
//
//        SubstructureSearchSparql substructureSearchSparql = new SubstructureSearchSparql();
//        SparqlEntity se = new SparqlEntity();
//        se.setValue(GlycoSequenceSparql.Sequence, getSparqlEntity().getValue(GlycoSequenceSparql.Sequence));
//        substructureSearchSparql.setSparqlEntity(se);
//
//        this.where += substructureSearchSparql.getWhere();
//
//        return where;
//    }
}
