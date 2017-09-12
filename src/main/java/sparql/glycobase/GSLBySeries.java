package sparql.glycobase;

import sparql.SelectSparql;
import sparql.SelectSparqlBean;
import sparql.SparqlException;

public class GSLBySeries extends SelectSparqlBean implements GlycanGlycobase {

    public static final String Uoxf = GlycanGlycobase.Uoxf;
    public static final String composition = "composition";
    public static final String monoisotopicMass = "monoisotopicMass";
    public static final String gslCode = "gslCode";


    public GSLBySeries(String sparql) {
        super(sparql);
    }

    public GSLBySeries() {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan/> \n";
        this.select = "DISTINCT ?" + SampleName + " ?" + gslCode + " ?"+ GlycoBaseId + " ?" + Uoxf + " ?" + composition
                + " ?" + monoisotopicMass + " ?" + Gu +" \n";
    }

    public String getReportName() {
        return "\"" + getSparqlEntity().getValue(GlycanGlycobase.ReportName) + "\"";
    }
    public String getLabelType() { return "\"" + getSparqlEntity().getValue(GlycanGlycobase.LabelType) + "\"";}



    @Override
    public String getWhere() throws SparqlException {
        String where = "?" + SaccharideURI + " a glycan:glycolipid;\n glycan:has_uoxf ?" + Uoxf
                + ";\n glycan:has_glycobase_id ?" + GlycoBaseId + ";\n glycan:has_alternative_name ?" + composition
                + ";\n glycan:has_average_molecular_weight ?" + monoisotopicMass +";\n glycan:has_code ?" + gslCode + ".\n"
                + "?" + ReferenceCompoundURI + " glycan:has_glycan ?" + SaccharideURI + ";\n"
                + " glycan:has_lc_chromatogram_peak ?" + PeakURI
                + ";\n glycan:is_from_report " + getReportName() + ".\n "
                + "OPTIONAL{?" +ReferenceCompoundURI + " glycan:is_from_source ?" + SourceURI + " .\n ?" + SourceURI
                + " glycan:from_sample ?" + SampleName + ".}\n"
                + " ?"+ ProfileURI + " glycan:has_label " + getLabelType() + ";\n"
                + " glycan:has_lc_chromatogram_peak ?" + PeakURI + ".\n"
                + "?" + PeakURI +" glycan:has_glucose_unit ?" + Gu + ".\n";
        return where;
    }

    @Override
    public String getOrderBy(){
        String order = "?GlycoBaseId";
        return order;
    }

}
