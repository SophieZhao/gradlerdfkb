package sparql.glycobase;

import sparql.SelectSparqlBean;
import sparql.SparqlException;


public class GSLGu extends SelectSparqlBean implements GlycanGlycobase {

    public static final String Uoxf = GlycanGlycobase.Uoxf;
    public static final String composition = "composition";
    public static final String monoisotopicMass = "monoisotopicMass";
    public static final String samplePrepURI = "samplePrepURI";
    public static final String gslCode = "gslCode";


    public GSLGu(String sparql) {
        super(sparql);
    }

    public GSLGu() {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan/> \n";
        this.select = "DISTINCT ?" + GlycoBaseId + " ?" + gslCode + " ?" + Uoxf + " ?" + composition + " ?" + monoisotopicMass + " ?" + Gu +" \n";
    }

    public String getLabelType() { return "\"" + getSparqlEntity().getValue(GlycanGlycobase.LabelType) + "\"";}


    @Override
    public String getWhere() throws SparqlException {
        String where = "?" + SaccharideURI + " a glycan:glycolipid;\n glycan:has_name ?" + Uoxf
                + ";\n glycan:has_glycobase_id ?" + GlycoBaseId + ";\n glycan:has_composition ?" + composition
                + ";\n glycan:has_mono_mass ?" + monoisotopicMass +";\n glycan:has_code ?" + gslCode + ".\n"
                + "OPTIONAL{?" + ReferenceCompoundURI + " glycan:has_glycan ?" + SaccharideURI + ";\n"
                + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " ;\n glycan:is_from_profile ?" + ProfileURI + ".\n"
                + "?" + ProfileURI + " glycan:has_label " + getLabelType() + ".\n"
                + "?" + PeakURI +" glycan:has_glucose_unit ?" + Gu + " .}\n";
        return where;
    }

    @Override
    public String getOrderBy(){
        String order = "?GlycoBaseId";
        return order;
    }
}
