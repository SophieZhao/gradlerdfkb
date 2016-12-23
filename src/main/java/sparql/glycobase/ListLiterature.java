package sparql.glycobase;

import sparql.SelectSparqlBean;
import sparql.SparqlException;


public class ListLiterature extends SelectSparqlBean implements GlycanGlycobase {

    public static final String Uoxf = GlycanGlycobase.Uoxf;
    public static final String RefURI = "RefURI";
    public static final String PaperTitle = "PaperTitle";
    public static final String PaperAuthor = "PaperAuthor";
    public static final String PaperYear = "PaperYear";
    public static final String PubmedLink = "PubmedLink";
    public static final String JournalName = "JournalName";
    public static final String JournalURI = "JournalURI";
    public static final String Pmid = "Pmid";

    public ListLiterature(String sparql) {
        super(sparql);
    }

    public ListLiterature() {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan/> \n" +
                "PREFIX bibo: <http://purl.org/ontology/bibo/> \n" +
                "PREFIX dc: <http://purl.org/dc/elements/1.1/> \n" +
                "PREFIX dcterms: <http://purl.org/dc/terms/> \n" +
                "PREFIX owl: <http://www.w3.org/2002/07/owl#> \n";
        this.select = "DISTINCT ?" + Pmid + " ?" + PaperTitle + " ?" + PaperAuthor + " ?" + PaperYear
                + " ?"+ PubmedLink + " ?" + JournalName+ "\n";
    }

    @Override
    public String getWhere() throws SparqlException {
        String where = "?" + RefURI + " a bibo:Article ;\n"
                + " glycan:has_pmid ?" + Pmid + " ;\n"
                + " bibo:authorList ?" + PaperAuthor + " ;\n"
                + " dc:title ?" + PaperTitle + " ;\n"
                + " bibo:issued ?" + PaperYear + " ;\n"
                + " owl:sameAs ?" + PubmedLink + " ;\n"
                + " dcterms:isPartOf ?"+ JournalURI + " .\n"
                + "?" + JournalURI +" dc:title ?" + JournalName + " .\n";

        return where;
    }
}



