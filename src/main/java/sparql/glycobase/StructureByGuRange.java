package sparql.glycobase;

import sparql.SelectSparqlBean;
import sparql.SparqlException;


public class StructureByGuRange extends SelectSparqlBean implements GlycanGlycobase {

    public static final String Uoxf = GlycanGlycobase.Uoxf;

    public StructureByGuRange(String sparql) {
        super(sparql);
    }

    public StructureByGuRange() {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan/> \n";
        this.select = "DISTINCT ?" + SaccharideURI + " ?" + Uoxf + " ?" + Gu + "\n";
//        this.from = "FROM <http://137.92.56.159:443/glycobase>\n";
    }

    public String getEvidenceType() { return getSparqlEntity().getValue(GlycanGlycobase.EvidenceType);}
    public String getUoxfLowBoundary() {return getSparqlEntity().getValue(GlycanGlycobase.GuLowBoundary);}
    public String getUoxfHighBoundary() {return getSparqlEntity().getValue(GlycanGlycobase.GuHighBoundary);}


    @Override
    public String getWhere() throws SparqlException {
        String type = getEvidenceType();
        String where = "";
        if(type.equals("uplc")){
            where += "?" + PeakURI + " glycan:has_glucose_unit ?"+ Gu + " .\n"
                    + "?" + EvidenceURI + " a glycan:evidence_uplc;\n glycan:has_lc_chromatogram_peak ?" + PeakURI + ".\n"
                    + "?" + SaccharideURI + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " ;\nglycan:has_uoxf ?"+ Uoxf+" .\n"
                    + "FILTER(?"+Gu +">"+getUoxfLowBoundary()+" && ?"+ Gu +"<"+getUoxfHighBoundary() + ")";
        }
        else if(type.equals("hplc")){
            where += "?" + PeakURI + " glycan:has_glucose_unit ?"+ Gu + " .\n"
                    + "?" + EvidenceURI + " a glycan:evidence_hplc;\n glycan:has_lc_chromatogram_peak ?" + PeakURI + ".\n"
                    + "?" + SaccharideURI + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " ;\nglycan:has_uoxf ?"+ Uoxf+" .\n"
                    + "FILTER(?"+Gu +">"+getUoxfLowBoundary()+" && ?"+ Gu +"<"+getUoxfHighBoundary() + ")";
        }
        else if(type.equals("rpuplc")){
            where += "?" + PeakURI + " glycan:has_arabinose_unit ?"+ Gu + " .\n"
                    + "?" + EvidenceURI + " a glycan:evidence_rpuplc;\n glycan:has_lc_chromatogram_peak ?" + PeakURI + ".\n"
                    + "?" + SaccharideURI + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " ;\nglycan:has_uoxf ?"+ Uoxf+" .\n"
                    + "FILTER(?"+Gu +">"+getUoxfLowBoundary()+" && ?"+ Gu +"<"+getUoxfHighBoundary() + ")";
        }
        else if(type.equals("ce")){
            where += "?" + PeakURI + " glycan:has_glucose_unit ?"+ Gu + " .\n"
                    + "?" + EvidenceURI + " a glycan:evidence_ce;\n glycan:has_ce_peak ?" + PeakURI + ".\n"
                    + "?" + SaccharideURI + " glycan:has_ce_peak ?" + PeakURI + " ;\nglycan:has_uoxf ?"+ Uoxf+" .\n"
                    + "FILTER(?"+Gu +">"+getUoxfLowBoundary()+" && ?"+ Gu +"<"+getUoxfHighBoundary() + ")";
        }

        return where;
    }
}
