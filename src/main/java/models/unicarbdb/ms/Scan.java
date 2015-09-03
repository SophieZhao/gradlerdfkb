/*
 * Copyright (c) 2014. Copyright (c) 2014. Matthew Campbell <matthew.campbell@mq.edu.au>
 *
 * The program can not be distributed to others with out the consent of the copyright holder, until such a time that the copyright holder has released the code for public use.
 */

package models.unicarbdb.ms;

import models.hplc.Lcmucin;
import play.db.ebean.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema="ms", name="scan")
public class Scan  {

    @Id
    @Column(name="scan_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "scan_gen")
    @SequenceGenerator(name = "scan_gen", sequenceName = "ms.scan_scan_id_seq", allocationSize=1)
    //public Long id;
    public Long scanId;

    @ManyToOne
    @JoinColumn(name="acquisition_id")
    @Column(name="acquisition_id")
    public Acquisition acquisition;
    public Integer msExponent;
    public Boolean polarity;
    public Double startMz;
    public Double endMz;
    public Double contributorQuality;
    public Integer originalScanId;


    @OneToMany(mappedBy = "scan", cascade = CascadeType.ALL)
    public List<PeakList> peakLists; // = new HashSet<org.eurocarbdb.dataaccess.ms.PeakList>();


    @OneToMany(mappedBy = "scan")
    public List<models.unicarbdb.hplc.Lcmucin> lcmucin; // = new HashSet<Lcmucin>(0);

    @OneToMany(mappedBy = "scan")
    public List<ScanToIon> scanToIon; // = new HashSet<ScanToIon>(0);


    @ManyToOne
    @JoinColumn(name="persubstitution_id")
    public Persubstitution persubstitution;

    @ManyToOne
    @JoinColumn(name="reducing_end_id")
    public ReducingEnd reducingEnd;


    public void setAcquisition(Acquisition acquisition) {
        this.acquisition = acquisition;
    }

    public void setMsExponent(Integer msExponent) {
        this.msExponent = msExponent;
    }

    public void setPolarity(Boolean polarity) {
        this.polarity = polarity;
    }

    public void setStartMz(Double startMz) {
        this.startMz = startMz;
    }

    public void setEndMz(Double endMz) {
        this.endMz = endMz;
    }

    public void setContributorQuality(Double contributorQuality) {
        this.contributorQuality = contributorQuality;
    }

    public void setOriginalScanId(Integer originalScanId) {
        this.originalScanId = originalScanId;
    }

    public void setPeakLists(List<PeakList> peakLists) {
        this.peakLists = peakLists;
    }

    public void setLcmucin(List<models.unicarbdb.hplc.Lcmucin> lcmucin) {
        this.lcmucin = lcmucin;
    }

    public void setScanToIon(List<ScanToIon> scanToIon) {
        this.scanToIon = scanToIon;
    }

    public void setPersubstitution(Persubstitution persubstitution) {
        this.persubstitution = persubstitution;
    }

    public void setReducingEnd(ReducingEnd reducingEnd) {
        this.reducingEnd = reducingEnd;
    }

    public Double getEndMz() {
        return endMz;
    }

    public Double getStartMz() {
        return startMz;
    }
}
