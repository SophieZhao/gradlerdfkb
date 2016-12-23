package sparql.glycobase;

import sparql.SelectSparqlBean;
import sparql.SparqlException;

public class LiteratureDetail extends SelectSparqlBean implements GlycanGlycobase {

    public static final String Author = "Author";
    public static final String PageEnd = "PageEnd";
    public static final String PageStart = "PageStart";
    public static final String Volume = "Volume";
    public static final String PublishYear = "PublishYear";
    public static final String Jounral = "Journal";
    public static final String PubmedLink = "PubmedLink";
    public static final String PaperURI = "PaperURI";
    public static final String JournalURI = "JournalURI";


    public LiteratureDetail(String sparql) {
        super(sparql);
    }

    public LiteratureDetail() {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan/> \n"
        + "PREFIX dc: <http://purl.org/dc/elements/1.1/> \n"
        + "PREFIX dcterms: <http://purl.org/dc/terms/> \n"
        + "PREFIX bibo: <http://purl.org/ontology/bibo/> \n"
        + "PREFIX owl: <http://www.w3.org/2002/07/owl#> \n";  //need to add # glycan#
        this.select = "DISTINCT ?" + PubmedId + " ?" + Author + " ?" + PageEnd + " ?" + PageStart
                + " ?" + Volume + " ?" + PublishYear + " ?" + PubmedLink + " ?" + Jounral + " \n";
    }

    public String getTitle() {
        return "\"" + getSparqlEntity().getValue(GlycanGlycobase.PaperTitle) + "\"";
    }


    @Override
    public String getWhere() throws SparqlException {
        String where = "?" + PaperURI + " dc:title " + getTitle() + " ;\n"
                + " bibo:authorList ?" + Author + " ;\n"
                + " bibo:issued ?" + PublishYear + " ;\n"
                + " owl:sameAs ?" + PubmedLink + " .\n" // PubmedLink is the link to posters when it is not a paper

                + "OPTIONAL{\n ?" + PaperURI + " glycan:has_pmid ?" + PubmedId + " ;\n"
                + " dcterms:isPartOf ?" + JournalURI +" ;\n"
                + " bibo:pageEnd ?"+ PageEnd + " ;\n"
                + " bibo:pageStart ?" + PageStart + " ;\n"
                + " bibo:volume ?" + Volume + " .\n"
                + "?" + JournalURI + " a bibo:journal ;\n"
                + " dc:title ?" + Jounral + " .\n}\n";




        return where;
    }

}
