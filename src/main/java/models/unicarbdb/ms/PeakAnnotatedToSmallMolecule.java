/*
 * Copyright (c) 2014. Copyright (c) 2014. Matthew Campbell <matthew.campbell@mq.edu.au>
 *
 * The program can not be distributed to others with out the consent of the copyright holder, until such a time that the copyright holder has released the code for public use.
 */

package models.unicarbdb.ms;



import javax.persistence.*;

@Entity
@Table(schema="ms", name="ms.peak_annotated_to_small_molecule")
public class PeakAnnotatedToSmallMolecule  {

	@Id
	//public Long Id;
	public Long peakAnnotatedToSmallMoleculeId;
    //public SmallMolecule smallMolecule;
    public PeakAnnotated peakAnnotated;
    public Boolean gain;
    public Integer number;

    public Long getPeakAnnotatedToSmallMoleculeId() {
        return peakAnnotatedToSmallMoleculeId;
    }

    public void setPeakAnnotatedToSmallMoleculeId(Long peakAnnotatedToSmallMoleculeId) {
        this.peakAnnotatedToSmallMoleculeId = peakAnnotatedToSmallMoleculeId;
    }

    public PeakAnnotated getPeakAnnotated() {
        return peakAnnotated;
    }

    public void setPeakAnnotated(PeakAnnotated peakAnnotated) {
        this.peakAnnotated = peakAnnotated;
    }

    public Boolean getGain() {
        return gain;
    }

    public void setGain(Boolean gain) {
        this.gain = gain;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
