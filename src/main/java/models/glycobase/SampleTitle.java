package models.glycobase;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Id;

/**
 * Created by matthew on 19/10/2015.
 */
@Entity
@Table(schema="public", name="sample_title")
public class SampleTitle {

    @Id
    public Long Id;

    public int sampleId;

    public String sampleTitle;

    @ManyToOne
    public Structure structure;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public int getSampleId() {
        return sampleId;
    }

    public void setSampleId(int sampleId) {
        this.sampleId = sampleId;
    }

    public String getSampleTitle() {
        return sampleTitle;
    }

    public void setSampleTitle(String sampleTitle) {
        this.sampleTitle = sampleTitle;
    }

    public Structure getStructure() {
        return structure;
    }

    public void setStructure(Structure structure) {
        this.structure = structure;
    }
}
