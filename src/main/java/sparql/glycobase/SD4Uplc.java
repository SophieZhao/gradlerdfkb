package sparql.glycobase;


import sparql.SelectSparqlBean;
import sparql.SparqlException;

public class SD4Uplc extends SelectSparqlBean implements GlycanGlycobase {
    public static final String avgUp = "avgUp";;
    public static final String sd="sd";

    public SD4Uplc(String sparql) {
        super(sparql);
    }

    public SD4Uplc() {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan/> \n" +
                "PREFIX afn: <http://jena.apache.org/ARQ/function#>\n";  //need to add # glycan#

        this.select = "(afn:sqrt(SUM(( ?" + Gu + " - ?" + avgUp + ")*( ?" + Gu + " - ?"+ avgUp +"))/(COUNT( ?"+
                Gu +") - 1 )) AS ?"+ sd +") \n";
    }

    public String getId() {
        return getSparqlEntity().getValue(GlycanGlycobase.GlycoBaseId);
    }


    @Override
    public String getWhere() throws SparqlException {
        String where = "?" + SaccharideURI + " glycan:has_glycobase_id " + getId() + " .\n"
                + "OPTIONAL{?" + SaccharideURI + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " .\n"
                + "?" + ProfileURI + " a glycan:evidence_uplc;\n"
                + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " .\n"
                + "?" + PeakURI +" glycan:has_glucose_unit ?" + Gu + " .}\n"
                + "{\nSELECT (AVG( ?"+ Gu +") AS ?" +avgUp + ") WHERE{\n"
                + "?" + SaccharideURI + " glycan:has_glyobase_id " + getId() + " .\n"
                + "OPTIONAL{?"+ SaccharideURI + " glycan:has_lc_chromatogram_peak ?"+ PeakURI + ".\n"
                + "?" + ProfileURI + " a glycan:evidence_uplc;\n"
                + " glycan:has_lc_chromatogram_peak ?" + PeakURI + ".\n"
                + "?" + PeakURI +" glycan:has_glucose_unit ?" + Gu + " .}\n}\n}";
        return where;
    }

}








