/*
 * Copyright (c) 2014. Copyright (c) 2014. Matthew Campbell <matthew.campbell@mq.edu.au>
 *
 * The program can not be distributed to others with out the consent of the copyright holder, until such a time that the copyright holder has released the code for public use.
 */

package models.unicarbdb.ms;

import models.unicarbdb.hplc.Lcmucin;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema="ms", name="scan")
public class Scan {

    @Id
    @Column(name = "scan_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "scan_gen")
    @SequenceGenerator(name = "scan_gen", sequenceName = "ms.scan_scan_id_seq", allocationSize = 1)
    //public Long id;
    public Long scanId;

    @ManyToOne
    @JoinColumn(name = "acquisition_id")
    @Column(name = "acquisition_id")
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
    @JoinColumn(name = "persubstitution_id")
    public Persubstitution persubstitution;

    @ManyToOne
    @JoinColumn(name = "reducing_end_id")
    public ReducingEnd reducingEnd;

    public Long getScanId() {
        return scanId;
    }

    public void setScanId(Long scanId) {
        this.scanId = scanId;
    }

    public Acquisition getAcquisition() {
        return acquisition;
    }

    public void setAcquisition(Acquisition acquisition) {
        this.acquisition = acquisition;
    }

    public Integer getMsExponent() {
        return msExponent;
    }

    public void setMsExponent(Integer msExponent) {
        this.msExponent = msExponent;
    }

    public Boolean getPolarity() {
        return polarity;
    }

    public void setPolarity(Boolean polarity) {
        this.polarity = polarity;
    }

    public Double getStartMz() {
        return startMz;
    }

    public void setStartMz(Double startMz) {
        this.startMz = startMz;
    }

    public Double getEndMz() {
        return endMz;
    }

    public void setEndMz(Double endMz) {
        this.endMz = endMz;
    }

    public Double getContributorQuality() {
        return contributorQuality;
    }

    public void setContributorQuality(Double contributorQuality) {
        this.contributorQuality = contributorQuality;
    }

    public Integer getOriginalScanId() {
        return originalScanId;
    }

    public void setOriginalScanId(Integer originalScanId) {
        this.originalScanId = originalScanId;
    }

    public List<PeakList> getPeakLists() {
        return peakLists;
    }

    public void setPeakLists(List<PeakList> peakLists) {
        this.peakLists = peakLists;
    }

    public List<Lcmucin> getLcmucin() {
        return lcmucin;
    }

    public void setLcmucin(List<Lcmucin> lcmucin) {
        this.lcmucin = lcmucin;
    }

    public List<ScanToIon> getScanToIon() {
        return scanToIon;
    }

    public void setScanToIon(List<ScanToIon> scanToIon) {
        this.scanToIon = scanToIon;
    }

    public Persubstitution getPersubstitution() {
        return persubstitution;
    }

    public void setPersubstitution(Persubstitution persubstitution) {
        this.persubstitution = persubstitution;
    }

    public ReducingEnd getReducingEnd() {
        return reducingEnd;
    }

    public void setReducingEnd(ReducingEnd reducingEnd) {
        this.reducingEnd = reducingEnd;
    }
}
