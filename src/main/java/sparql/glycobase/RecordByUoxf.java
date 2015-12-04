package sparql.glycobase;

import sparql.SelectSparqlBean;
import sparql.SparqlException;



public class RecordByUoxf extends SelectSparqlBean implements GlycanGlycobase {

    public RecordByUoxf(String sparql) {
        super(sparql);
    }

    public RecordByUoxf() {
        super();
        this.prefix = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan/> \n";;  //need to add # glycan#
        this.select = "DISTINCT ?" + PeakURI + " ?" + Gu + " ?" + EvidenceType + " ?"+ ReportName
                + " ?"+ SampleName + " ?" + Taxon + " ?" + EvidenceURI + "\n";
//        this.from = "FROM <http://137.92.56.159:443/glycobase>\n";
    }

    public String getUoxf() {
        return "\"" + getSparqlEntity().getValue(GlycanGlycobase.Uoxf) + "\"";
    }


    @Override
    public String getWhere() throws SparqlException {
        String where = "{ ?" + SaccharideURI + " glycan:has_uoxf " + getUoxf() + " ;\n"
                + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " .\n"
                + "?" + PeakURI + " glycan:has_glucose_unit ?" + Gu + " .\n"
                + "?" + ReferenceCompoundURI + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " ;\n"
                + " glycan:is_from_report ?" + ReportName + " ;\n"
                + " glycan:is_from_source ?" + SourceURI + " .\n"
                + "?" + SourceURI + " glycan:from_sample ?" + SampleName + " .\n"
                + "OPTIONAL{ ?" + SourceURI + " glycan:has_taxon ?" + Taxon + " .}\n"
                + "?" + EvidenceURI + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " ;\n"
                + " a glycan:evidence_hplc ;\n"
                + " a ?" + EvidenceType + " .}\n"

                + "UNION{\n"+ "?" + SaccharideURI + " glycan:has_uoxf " + getUoxf() + " ;\n"
                + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " .\n"
                + "?" + PeakURI + " glycan:has_glucose_unit ?" + Gu + " .\n"
                + "?" + ReferenceCompoundURI + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " ;\n"
                + " glycan:is_from_report ?" + ReportName + " ;\n"
                + " glycan:is_from_source ?" + SourceURI + " .\n"
                + "?" + SourceURI + " glycan:from_sample ?" + SampleName + " .\n"
                + "OPTIONAL{ ?" + SourceURI + " glycan:has_taxon ?" + Taxon + " .}\n"
                + "?" + EvidenceURI + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " ;\n"
                + " a glycan:evidence_uplc ;\n"
                + " a ?" + EvidenceType + " .}\n"

                + "UNION{\n"+ "?" + SaccharideURI + " glycan:has_uoxf " + getUoxf() + " ;\n"
                + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " .\n"
                + "?" + PeakURI + " glycan:has_arabinose_unit ?" + Au + " .\n"
                + "?" + ReferenceCompoundURI + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " ;\n"
                + " glycan:is_from_report ?" + ReportName + " ;\n"
                + " glycan:is_from_source ?" + SourceURI + " .\n"
                + "?" + SourceURI + " glycan:from_sample ?" + SampleName + " .\n"
                + "OPTIONAL{ ?" + SourceURI + " glycan:has_taxon ?" + Taxon + " .}\n"
                + "?" + EvidenceURI + " glycan:has_lc_chromatogram_peak ?" + PeakURI + " ;\n"
                + " a glycan:evidence_rpuplc ;\n"
                + " a ?" + EvidenceType + " .}\n"

                + "UNION{\n"+ "?" + SaccharideURI + " glycan:has_uoxf " + getUoxf() + " ;\n"
                + " glycan:has_ce_peak ?" + PeakURI + " .\n"
                + "?" + PeakURI + " glycan:has_glucose_unit ?" + Gu + " .\n"
                + "?" + ReferenceCompoundURI + " glycan:has_ce_peak ?" + PeakURI + " ;\n"
                + " glycan:is_from_report ?" + ReportName + " ;\n"
                + " glycan:is_from_source ?" + SourceURI + " .\n"
                + "?" + SourceURI + " glycan:from_sample ?" + SampleName + " .\n"
                + "OPTIONAL{ ?" + SourceURI + " glycan:has_taxon ?" + Taxon + " .}\n"
                + "?" + EvidenceURI + " glycan:has_ce_peak ?" + PeakURI + " ;\n"
                + " a glycan:evidence_ce ;\n"
                + " a ?" + EvidenceType + " .}\n";

        return where;
    }
}

