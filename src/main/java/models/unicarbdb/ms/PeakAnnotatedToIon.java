/*
 * Copyright (c) 2014. Copyright (c) 2014. Matthew Campbell <matthew.campbell@mq.edu.au>
 *
 * The program can not be distributed to others with out the consent of the copyright holder, until such a time that the copyright holder has released the code for public use.
 */

package models.unicarbdb.ms;



import javax.persistence.*;

@Entity
@Table(schema = "ms", name = "peak_annotated_to_ion")
public class PeakAnnotatedToIon  {

    @Id
    @Column(name="peak_annotated_to_ion_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "peak_annotated_to_ion_gen")
    @SequenceGenerator(name = "peak_annotated_to_ion_gen", sequenceName = "ms.peak_annotated_to_ion_peak_annotated_to_ion_id_seq'", allocationSize=1)
    //public Long Id;
    public Long peakAnnotatedToIonId;


    public Ion ion;

    @ManyToOne
    @JoinColumn(name = "peak_annotated_id")
    @Column(name = "peak_annotated_id")
    public PeakAnnotated peakAnnotated;

    public Integer number;
    public Boolean gain;

    public Long getPeakAnnotatedToIonId() {
        return peakAnnotatedToIonId;
    }

    public void setPeakAnnotatedToIonId(Long peakAnnotatedToIonId) {
        this.peakAnnotatedToIonId = peakAnnotatedToIonId;
    }

    public Ion getIon() {
        return ion;
    }

    public void setIon(Ion ion) {
        this.ion = ion;
    }

    public PeakAnnotated getPeakAnnotated() {
        return peakAnnotated;
    }

    public void setPeakAnnotated(PeakAnnotated peakAnnotated) {
        this.peakAnnotated = peakAnnotated;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Boolean getGain() {
        return gain;
    }

    public void setGain(Boolean gain) {
        this.gain = gain;
    }
}
