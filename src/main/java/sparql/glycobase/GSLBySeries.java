package sparql.glycobase;

import sparql.SelectSparqlBean;
import sparql.SparqlException;

public class GSLBySeries extends SelectSparqlBean implements GlycanGlycobase {


    public static final String name = "name";
    public static final String composition = "composition";
    public static final String monoisotopicMass = "monoisotopicMass";
    public static final String samplePrepURI = "samplePrepURI";
    public static final String gslCode = "gslCode";


    public GSLBySeries(String sparql) {
        super(sparql);
    }

    public GSLBySeries() {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan/> \n";
        this.select = "DISTINCT ?" + SampleName + " ?" + gslCode + " ?"+ GlycoBaseId + " ?" + name + " ?" + composition
                + " ?" + monoisotopicMass + " ?" + Gu +" \n";
    }

    public String getReportName() {
        return "\"" + getSparqlEntity().getValue(GlycanGlycobase.ReportName) + "\"";
    }
    public String getLabelType() { return "\"" + getSparqlEntity().getValue(GlycanGlycobase.LabelType) + "\"";}



    @Override
    public String getWhere() throws SparqlException {
        String where = "?" + SaccharideURI + " a glycan:glycolipid;\n glycan:has_name ?" + name
                + ";\n glycan:has_glycobase_id ?" + GlycoBaseId + ";\n glycan:has_composition ?" + composition
                + ";\n glycan:has_monoisotopic_mass ?" + monoisotopicMass +";\n glycan:has_code ?" + gslCode + ".\n"
                + "?" + ReferenceCompoundURI + " glycan:has_glycan ?" + SaccharideURI + ";\n"
                + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " ;\n glycan:sample_preparation ?" + samplePrepURI
                + ";\n glycan:is_from_report " + getReportName() + ".\n "
                + "OPTIONAL{?" +ReferenceCompoundURI + " glycan:is_from_source ?" + SourceURI + " .\n ?" + SourceURI
                + " glycan:from_sample ?" + SampleName + ".}\n"
                + " ?"+ samplePrepURI + " a glycan:sample_preparation;\n glycan:sample_label " + getLabelType() + ".\n"
                + "?" + PeakURI +" glycan:has_glucose_unit ?" + Gu + ".\n";
        return where;
    }

    @Override
    public String getOrderBy(){
        String order = "?GlycoBaseId";
        return order;
    }

}
