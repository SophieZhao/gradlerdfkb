package sparql.glycobase;

import sparql.SelectSparql;
import sparql.SelectSparqlBean;
import sparql.SparqlException;

public class StructureByReference extends SelectSparqlBean implements GlycanGlycobase {

    public static final String Uoxf = GlycanGlycobase.Uoxf;
    public static final String PaperURI = "PaperURI";
    public static final String avgGu = "avgGu";

    public StructureByReference(String sparql) {
        super(sparql);
    }

    public StructureByReference() {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan/> \n"
                    + "PREFIX dc: <http://purl.org/dc/elements/1.1/> \n";  //need to add # glycan#
        this.select = "DISTINCT ?" + GlycoBaseId + " ?" + Uoxf + " ?" + LabelType +" (AVG(?" + Gu + ") AS ?" + avgGu + ") \n";
    }

    public String getTitle() {
        return "\"" + getSparqlEntity().getValue(GlycanGlycobase.PaperTitle) + "\"";
    }


    @Override
    public String getWhere() throws SparqlException {
        String where = "?" + ReferenceCompoundURI + " glycan:published_in ?" + PaperURI + " ;\n"
                + " glycan:is_from_profile ?" + ProfileURI + " ;\n"
                + " glycan:has_glycan ?"+ SaccharideURI + " .\n"
                + "?" + SaccharideURI + " glycan:has_glycobase_id ?"+ GlycoBaseId + " ;\n"
                + " glycan:has_uoxf ?" + Uoxf + " .\n"
                + "?" + ProfileURI + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " ;\n"
                + " glycan:has_label ?" + LabelType + " .\n"
                + "?" + PeakURI + " glycan:has_glucose_unit ?" + Gu + " .\n"
                + "?" + PaperURI + " dc:title " + getTitle() + " .\n";
        return where;
    }

    @Override
    public String getGroupBy(){
        String group = "?" + GlycoBaseId + " ?"+ Uoxf + " ?" + LabelType;
        return group;
    }
}


