/*
 * Copyright (c) 2014. Copyright (c) 2014. Matthew Campbell <matthew.campbell@mq.edu.au>
 *
 * The program can not be distributed to others with out the consent of the copyright holder, until such a time that the copyright holder has released the code for public use.
 */

package models.unicarbdb.ms;

import play.data.format.Formats;
import play.db.ebean.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(schema="ms", name="peak_list")
public class PeakList  {



	@Id
    @Column(name="peak_list_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "peak_list_gen")
    @SequenceGenerator(name = "peak_list_gen", sequenceName = "ms.peak_list_peak_list_id_seq", allocationSize=1)
	//public Long id;

	public Long peakListId;

    //public PeakProcessing peakProcessing;
	@ManyToOne
    @Column(name="scan_id")
    @JoinColumn(name="scan_id")
    public Scan scan;

    public PeakListAnnotation peakListAnnotation;

    //@Formats.DateTime(pattern="dd/MM/yyyy")
    public Date dateEntered = new Date();

    public Boolean deisotoped;
    public Boolean chargeDeconvoluted;
    public Double basePeakMz;
    public Double basePeakIntensity;
    public Double lowMz;
    public Double highMz;
    public Integer contributorId;
    public Double contributorQuality;

    @OneToMany(mappedBy = "peakList", cascade = CascadeType.ALL)
    public List<PeakLabeled> peakLabeled; // = new HashSet<org.eurocarbdb.dataaccess.ms.PeakLabeled>();
    //public Set<org.eurocarbdb.dataaccess.ms.PeakListToDataProcessing> PeakListToDataProcessings = new HashSet<org.eurocarbdb.dataaccess.ms.PeakListToDataProcessing>();


    public void setScan(Scan scan) {
        this.scan = scan;
    }

    public void setPeakListAnnotation(PeakListAnnotation peakListAnnotation) {
        this.peakListAnnotation = peakListAnnotation;
    }

    public void setDateEntered(Date dateEntered) {
        this.dateEntered = dateEntered;
    }

    public void setDeisotoped(Boolean deisotoped) {
        this.deisotoped = deisotoped;
    }

    public void setChargeDeconvoluted(Boolean chargeDeconvoluted) {
        this.chargeDeconvoluted = chargeDeconvoluted;
    }

    public void setBasePeakMz(Double basePeakMz) {
        this.basePeakMz = basePeakMz;
    }

    public void setBasePeakIntensity(Double basePeakIntensity) {
        this.basePeakIntensity = basePeakIntensity;
    }

    public void setLowMz(Double lowMz) {
        this.lowMz = lowMz;
    }

    public void setHighMz(Double highMz) {
        this.highMz = highMz;
    }

    public void setContributorId(Integer contributorId) {
        this.contributorId = contributorId;
    }

    public void setContributorQuality(Double contributorQuality) {
        this.contributorQuality = contributorQuality;
    }

    public void setPeakLabeled(List<PeakLabeled> peakLabeled) {
        this.peakLabeled = peakLabeled;
    }
}
