package sparql.glycobase;

import sparql.SelectSparqlBean;
import sparql.SparqlException;


public class SD4Rp extends SelectSparqlBean implements GlycanGlycobase {
    public static final String RpGu = "RpGu";
    public static final String avgRp = "avgRp";
    public static final String sd="sd";

    public SD4Rp(String sparql) {
        super(sparql);
    }

    public SD4Rp() {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan/> \n" +
                "PREFIX afn: <http://jena.apache.org/ARQ/function#>\n";  //need to add # glycan#

        this.select = "(afn:sqrt(SUM(( ?" + RpGu + " - ?" + avgRp + ")*( ?" + RpGu + " - ?"+ avgRp +"))/(COUNT( ?"+
                RpGu +") - 1 )) AS ?"+ sd +") \n";
    }

    public String getId() {
        return getSparqlEntity().getValue(GlycanGlycobase.GlycoBaseId);
    }


    @Override
    public String getWhere() throws SparqlException {
        String where = "?" + SaccharideURI + " glycan:has_glycobase_id " + getId() + " .\n"
                + "OPTIONAL{?" + SaccharideURI + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " .\n"
                + "?" + ProfileURI + " a glycan:evidence_rpuplc;\n"
                + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " .\n"
                + "?" + PeakURI +" glycan:has_arabinose_unit ?" + RpGu + " .}\n"
                + "{\nSELECT (AVG( ?"+ RpGu +") AS ?" +avgRp + ") WHERE{\n"
                + "?" + SaccharideURI + " glycan:has_glyobase_id " + getId() + " .\n"
                + "OPTIONAL{?"+ SaccharideURI + " glycan:has_lc_chromatogram_peak ?"+ PeakURI + ".\n"
                + "?" + ProfileURI + " a glycan:evidence_rpuplc;\n"
                + " glycan:has_lc_chromatogram_peak ?" + PeakURI + ".\n"
                + "?" + PeakURI +" glycan:has_arabinose_unit ?" + RpGu + " .}\n}\n}";
        return where;
    }

}







