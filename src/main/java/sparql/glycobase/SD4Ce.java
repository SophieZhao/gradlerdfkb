package sparql.glycobase;


import sparql.SelectSparqlBean;
import sparql.SparqlException;


public class SD4Ce extends SelectSparqlBean implements GlycanGlycobase {
    public static final String CeGu = "CeGu";
    public static final String avgCe = "avgCe";
    public static final String sd="sd";

    public SD4Ce(String sparql) {
        super(sparql);
    }

    public SD4Ce() {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan/> \n" +
                "PREFIX afn: <http://jena.apache.org/ARQ/function#>\n";  //need to add # glycan#

        this.select = "(afn:sqrt(SUM(( ?" + CeGu + " - ?" + avgCe + ")*( ?" + CeGu + " - ?"+ avgCe +"))/(COUNT( ?"+
                CeGu +") - 1 )) AS ?"+ sd +") \n";
    }

    public String getId() {
        return getSparqlEntity().getValue(GlycanGlycobase.GlycoBaseId);
    }


    @Override
    public String getWhere() throws SparqlException {
        String where = "?" + SaccharideURI + " glycan:has_glycobase_id " + getId() + " .\n"
                + "OPTIONAL{?" + SaccharideURI + " glycan:has_ce_peak ?" + PeakURI + " .\n"
                + "?" + ProfileURI + " a glycan:evidence_ce;\n"
                + " glycan:has_ce_peak ?" + PeakURI + " .\n"
                + "?" + PeakURI +" glycan:has_glucose_unit ?" + CeGu + " .}\n"
                + "{\nSELECT (AVG( ?"+ CeGu +") AS ?" +avgCe + ") WHERE{\n"
                + "?" + SaccharideURI + " glycan:has_glyobase_id " + getId() + " .\n"
                + "OPTIONAL{?"+ SaccharideURI + " glycan:has_ce_peak ?"+ PeakURI + ".\n"
                + "?" + ProfileURI + " a glycan:evidence_ce;\n"
                + " glycan:has_ce_peak ?" + PeakURI + ".\n"
                + "?" + PeakURI +" glycan:has_glucose_unit ?" + CeGu + " .}\n}\n}";
        return where;
    }

}




