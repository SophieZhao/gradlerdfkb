package sparql.glycobase;

import sparql.SelectSparqlBean;
import sparql.SparqlException;

public class SD4Hplc extends SelectSparqlBean implements GlycanGlycobase {
    public static final String HplcGu = "HplcGu";
    public static final String avgHp = "avgHp";
    public static final String sd="sd";

    public SD4Hplc(String sparql) {
        super(sparql);
    }

    public SD4Hplc() {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan/> \n" +
                "PREFIX afn: <http://jena.apache.org/ARQ/function#>\n";  //need to add # glycan#

        this.select = "(afn:sqrt(SUM(( ?" + HplcGu + " - ?" + avgHp + ")*( ?" + HplcGu + " - ?"+ avgHp +"))/(COUNT( ?"+
                HplcGu +") - 1 )) AS ?"+ sd +") \n";
    }

    public String getId() {
        return getSparqlEntity().getValue(GlycanGlycobase.GlycoBaseId);
    }


    @Override
    public String getWhere() throws SparqlException {
        String where = "?" + SaccharideURI + " glycan:has_glycobase_id " + getId() + " .\n"
                + "OPTIONAL{?" + SaccharideURI + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " .\n"
                + "?" + ProfileURI + " a glycan:evidence_hplc;\n"
                + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " .\n"
                + "?" + PeakURI +" glycan:has_glucose_unit ?" + HplcGu + " .}\n"
                + "{\nSELECT (AVG( ?"+ HplcGu +") AS ?" +avgHp + ") WHERE{\n"
                + "?" + SaccharideURI + " glycan:has_glyobase_id " + getId() + " .\n"
                + "OPTIONAL{?"+ SaccharideURI + " glycan:has_lc_chromatogram_peak ?"+ PeakURI + ".\n"
                + "?" + ProfileURI + " a glycan:evidence_hplc;\n"
                + " glycan:has_lc_chromatogram_peak ?" + PeakURI + ".\n"
                + "?" + PeakURI +" glycan:has_glucose_unit ?" + HplcGu + " .}\n}\n}";
        return where;
    }

}






