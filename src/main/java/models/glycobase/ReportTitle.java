package models.glycobase;

import javax.persistence.*;

/**
 * Created by matthew on 19/10/2015.
 */
@Entity
@Table(schema="public", name="report_title")
public class ReportTitle {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "report_title_gen")
    @SequenceGenerator(name = "report_title_gen", sequenceName = "report_title_id_seq", allocationSize=1)
    public Long Id;

    public int reportId;

    public String reportTitle;

    @ManyToOne
    public Structure structure;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public String getReportTitle() {
        return reportTitle;
    }

    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle;
    }

    public Structure getStructure() {
        return structure;
    }

    public void setStructure(Structure structure) {
        this.structure = structure;
    }
}
