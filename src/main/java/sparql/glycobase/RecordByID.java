package sparql.glycobase;

import sparql.SelectSparqlBean;
import sparql.SparqlException;



public class RecordByID extends SelectSparqlBean implements GlycanGlycobase {
    public static final String LabelType = "LabelType";


    public RecordByID(String sparql) {
        super(sparql);
    }

    public RecordByID() {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan/> \n";;  //need to add # glycan#
        this.select = "DISTINCT ?" + PeakURI + " ?" + LabelType+" ?" + Gu + " ?" + EvidenceType + " ?"+ ReportName
                + " ?"+ SampleName + " ?" + Taxon + " ?" + ProfileURI + "\n";
    }

    public String getId() {return getSparqlEntity().getValue(GlycanGlycobase.GlycoBaseId);}


    @Override
    public String getWhere() throws SparqlException {
        String where = "{ ?" + SaccharideURI + " glycan:has_glycobase_id " + getId() + " ;\n"
                + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " .\n"
                + "?" + PeakURI + " glycan:has_glucose_unit ?" + Gu + " .\n"
                + "?" + ReferenceCompoundURI + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " ;\n"
                + " glycan:is_from_report ?" + ReportName + " ;\n"
                + " glycan:is_from_source ?" + SourceURI + " .\n"
                + "?" + SourceURI + " glycan:from_sample ?" + SampleName + " .\n"
                + "OPTIONAL{ ?" + SourceURI + " glycan:has_taxon ?" + Taxon + " .}\n"
                + "?" + ProfileURI + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " ;\n"
                + " glycan:has_label ?" + LabelType + ";\n"
                + " a glycan:evidence_hplc ;\n"
                + " a ?" + EvidenceType + " .}\n"

                + "UNION{\n"+ "?" + SaccharideURI + " glycan:has_glycobase_id " + getId() + " ;\n"
                + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " .\n"
                + "?" + PeakURI + " glycan:has_glucose_unit ?" + Gu + " .\n"
                + "?" + ReferenceCompoundURI + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " ;\n"
                + " glycan:is_from_report ?" + ReportName + " ;\n"
                + " glycan:is_from_source ?" + SourceURI + " .\n"
                + "?" + SourceURI + " glycan:from_sample ?" + SampleName + " .\n"
                + "OPTIONAL{ ?" + SourceURI + " glycan:has_taxon ?" + Taxon + " .}\n"
                + "?" + ProfileURI + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " ;\n"
                + " glycan:has_label ?" + LabelType + ";\n"
                + " a glycan:evidence_uplc ;\n"
                + " a ?" + EvidenceType + " .}\n"

                + "UNION{\n"+ "?" + SaccharideURI + " glycan:has_glycobase_id " + getId() + " ;\n"
                + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " .\n"
                + "?" + PeakURI + " glycan:has_arabinose_unit ?" + Gu + " .\n"
                + "?" + ReferenceCompoundURI + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " ;\n"
                + " glycan:is_from_report ?" + ReportName + " ;\n"
                + " glycan:is_from_source ?" + SourceURI + " .\n"
                + "?" + SourceURI + " glycan:from_sample ?" + SampleName + " .\n"
                + "OPTIONAL{ ?" + SourceURI + " glycan:has_taxon ?" + Taxon + " .}\n"
                + "?" + ProfileURI + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " ;\n"
                + " glycan:has_label ?" + LabelType + ";\n"
                + " a glycan:evidence_rpuplc ;\n"
                + " a ?" + EvidenceType + " .}\n"

                + "UNION{\n"+ "?" + SaccharideURI + " glycan:has_glycobase_id " + getId() + " ;\n"
                + " glycan:has_ce_peak ?" + PeakURI + " .\n"
                + "?" + PeakURI + " glycan:has_glucose_unit ?" + Gu + " .\n"
                + "?" + ReferenceCompoundURI + " glycan:has_ce_peak ?" + PeakURI + " ;\n"
                + " glycan:is_from_report ?" + ReportName + " ;\n"
                + " glycan:is_from_source ?" + SourceURI + " .\n"
                + "?" + SourceURI + " glycan:from_sample ?" + SampleName + " .\n"
                + "OPTIONAL{ ?" + SourceURI + " glycan:has_taxon ?" + Taxon + " .}\n"
                + "?" + ProfileURI + " glycan:has_ce_peak ?" + PeakURI + " ;\n"
                + " glycan:has_label ?" + LabelType + ";\n"
                + " a glycan:evidence_ce ;\n"
                + " a ?" + EvidenceType + " .}\n";

        return where;
    }
}

