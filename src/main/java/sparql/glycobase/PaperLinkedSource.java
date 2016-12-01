package sparql.glycobase;

import sparql.SelectSparql;
import sparql.SelectSparqlBean;
import sparql.SparqlException;

public class PaperLinkedSource extends SelectSparqlBean implements GlycanGlycobase {

    public static final String Uoxf = GlycanGlycobase.Uoxf;
    public static final String PaperURI = "PaperURI";
    public static final String avgGu = "avgGu";

    public PaperLinkedSource(String sparql) {
        super(sparql);
    }

    public PaperLinkedSource() {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan/> \n"
                + "PREFIX dc: <http://purl.org/dc/elements/1.1/> \n"
                + "PREFIX bibo: <http://purl.org/ontology/bibo/> \n";  //need to add # glycan#
        this.select = "DISTINCT ?" + ReportName + " ?" + SampleName +" ?" + Taxon + " ?" + Tissue + " \n";
    }

    public String getTitle() {
        return "\"" + getSparqlEntity().getValue(GlycanGlycobase.PaperTitle) + "\"";
    }


    @Override
    public String getWhere() throws SparqlException {
        String where = "?" + ReferenceCompoundURI + " glycan:published_in ?" + PaperURI + " ;\n"
                + " glycan:is_from_source ?" + SourceURI + " .\n"
                + "OPTIONAL{\n?" + ReferenceCompoundURI + " glycan:is_from_report ?" + ReportName + " .\n}\n"
                + "?" + PaperURI + " dc:title " + getTitle() + " .\n"
                + "?" + SourceURI + " glycan:from_sample ?" + SampleName + " .\n"
                + "OPTIONAL{\n?" + SourceURI + " glycan:has_taxon ?" + Taxon + " ;\n"
                + " glycan:has_tissue ?" + Tissue + " .\n}\n";
        return where;
    }
}



