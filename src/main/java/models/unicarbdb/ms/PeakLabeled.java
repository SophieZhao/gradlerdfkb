/*
 * Copyright (c) 2014. Copyright (c) 2014. Matthew Campbell <matthew.campbell@mq.edu.au>
 *
 * The program can not be distributed to others with out the consent of the copyright holder, until such a time that the copyright holder has released the code for public use.
 */

package models.unicarbdb.ms;

import play.db.ebean.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema="ms", name="peak_labeled")
public class PeakLabeled  {
	
	@Id

    @Column(name="peak_labeled_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "peak_labeled_gen")
    @SequenceGenerator(name = "peak_labeled_gen", sequenceName = "ms.peak_labeled_peak_labeled_id_seq", allocationSize=1)
	//public Long Id;
    public Long peakLabeledId;
	
	@ManyToOne
    @JoinColumn(name="peak_list_id")
    @Column(name="peak_list_id")
    public PeakList peakList;

    public Double mzValue;
    public Double intensityValue;
    public Boolean monoisotopic;
    public Integer chargeCount;
    public Double fwhm;
    public Double signalToNoise;

    @OneToMany(mappedBy = "peakLabeled", cascade = CascadeType.ALL)
    public List<PeakAnnotated> peakAnnotateds; // = new HashSet<org.eurocarbdb.dataaccess.ms.PeakAnnotated>();

    public void setPeakList(PeakList peakList) {
        this.peakList = peakList;
    }

    public void setMzValue(Double mzValue) {
        this.mzValue = mzValue;
    }

    public void setIntensityValue(Double intensityValue) {
        this.intensityValue = intensityValue;
    }

    public void setMonoisotopic(Boolean monoisotopic) {
        this.monoisotopic = monoisotopic;
    }

    public void setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
    }

    public void setFwhm(Double fwhm) {
        this.fwhm = fwhm;
    }

    public void setSignalToNoise(Double signalToNoise) {
        this.signalToNoise = signalToNoise;
    }

    public void setPeakAnnotateds(List<PeakAnnotated> peakAnnotateds) {
        this.peakAnnotateds = peakAnnotateds;
    }
}
