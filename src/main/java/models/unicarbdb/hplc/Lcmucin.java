/*
 * Copyright (c) 2014. Copyright (c) 2014. Matthew Campbell <matthew.campbell@mq.edu.au>
 *
 * The program can not be distributed to others with out the consent of the copyright holder, until such a time that the copyright holder has released the code for public use.
 */

package models.unicarbdb.hplc;

import models.unicarbdb.core.*;
import models.unicarbdb.ms.Persubstitution;
import models.unicarbdb.ms.ReducingEnd;
import models.unicarbdb.ms.Scan;

import javax.persistence.Column;
import javax.persistence.*;



@Entity
@Table(schema="hplc", name="lcmucin")
public class Lcmucin  {
	
	@Id
	@Column(name="lcmucin_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lcmucin_gen")
    @SequenceGenerator(name = "lcmucin_gen", sequenceName = "hplc.lcmucin_lcmucin_id_seq", allocationSize=1)
	public Long lcmucinId;

    @ManyToOne
    @JoinColumn(name="column_id")
    public models.unicarbdb.hplc.Column column;

    @ManyToOne
    @JoinColumn(name="glycan_sequence_id")
    public GlycanSequence glycanSequence;

    @ManyToOne
    @JoinColumn(name="method_run_id")
    public models.unicarbdb.hplc.MethodRun methodRun;

    public Double retentionTime;

    public Evidence evidence;
    public Evidence evidencelc;

    public static String getBool() {
        return bool;
    }

    public Long getLcmucinId() {
        return lcmucinId;
    }

    public void setLcmucinId(Long lcmucinId) {
        this.lcmucinId = lcmucinId;
    }

    public models.unicarbdb.hplc.Column getColumn() {
        return column;
    }

    public void setColumn(models.unicarbdb.hplc.Column column) {
        this.column = column;
    }

    public GlycanSequence getGlycanSequence() {
        return glycanSequence;
    }

    public void setGlycanSequence(GlycanSequence glycanSequence) {
        this.glycanSequence = glycanSequence;
    }

    public MethodRun getMethodRun() {
        return methodRun;
    }

    public void setMethodRun(MethodRun methodRun) {
        this.methodRun = methodRun;
    }

    public Double getRetentionTime() {
        return retentionTime;
    }

    public void setRetentionTime(Double retentionTime) {
        this.retentionTime = retentionTime;
    }

    public Evidence getEvidence() {
        return evidence;
    }

    public void setEvidence(Evidence evidence) {
        this.evidence = evidence;
    }

    public Evidence getEvidencelc() {
        return evidencelc;
    }

    public void setEvidencelc(Evidence evidencelc) {
        this.evidencelc = evidencelc;
    }

    public Scan getScan() {
        return scan;
    }

    public void setScan(Scan scan) {
        this.scan = scan;
    }

    public Integer getScanparent() {
        return scanparent;
    }

    public void setScanparent(Integer scanparent) {
        this.scanparent = scanparent;
    }

    public Integer getAcquisitionId() {
        return acquisitionId;
    }

    public void setAcquisitionId(Integer acquisitionId) {
        this.acquisitionId = acquisitionId;
    }

    public String getGwpname() {
        return gwpname;
    }

    public void setGwpname(String gwpname) {
        this.gwpname = gwpname;
    }

    public String getIonizationMethod() {
        return ionizationMethod;
    }

    public void setIonizationMethod(String ionizationMethod) {
        this.ionizationMethod = ionizationMethod;
    }

    public Integer getStandard() {
        return standard;
    }

    public void setStandard(Integer standard) {
        this.standard = standard;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public EvidenceToGlycoprotein getEvidenceToGlycoprotein() {
        return evidenceToGlycoprotein;
    }

    public void setEvidenceToGlycoprotein(EvidenceToGlycoprotein evidenceToGlycoprotein) {
        this.evidenceToGlycoprotein = evidenceToGlycoprotein;
    }

    public JournalReference getJournalReference() {
        return journalReference;
    }

    public void setJournalReference(JournalReference journalReference) {
        this.journalReference = journalReference;
    }

    public Integer getBiologicalContextId() {
        return biologicalContextId;
    }

    public void setBiologicalContextId(Integer biologicalContextId) {
        this.biologicalContextId = biologicalContextId;
    }

    public BiologicalContext getBiologicalContext() {
        return biologicalContext;
    }

    public void setBiologicalContext(BiologicalContext biologicalContext) {
        this.biologicalContext = biologicalContext;
    }

    public ReducingEnd getReducingEnd() {
        return reducingEnd;
    }

    public void setReducingEnd(ReducingEnd reducingEnd) {
        this.reducingEnd = reducingEnd;
    }

    public Persubstitution getPersubstitution() {
        return persubstitution;
    }

    public void setPersubstitution(Persubstitution persubstitution) {
        this.persubstitution = persubstitution;
    }

    public boolean isShowHide() {
        return showHide;
    }

    public void setShowHide(boolean showHide) {
        this.showHide = showHide;
    }

    @ManyToOne
    @JoinColumn(name="scan_id")
    public Scan scan;
    
    public Integer scanparent;
    public Integer acquisitionId;
    public String gwpname;
    public String ionizationMethod;
    public Integer standard;
    public String note;

    @ManyToOne
    @JoinColumn(name = "evidence_to_glycoprotein_id")
    @Column(name = "evidence_to_glycoprotein")
    public EvidenceToGlycoprotein evidenceToGlycoprotein;
    
    @ManyToOne
    @JoinColumn(name="journal_reference_id")
    public JournalReference journalReference;
    
    public Integer biologicalContextId;
    //public BiologicalContext biologicalContext;

    @ManyToOne
    @JoinColumn(name="biological_context_id")
    public models.unicarbdb.core.BiologicalContext biologicalContext;

    @ManyToOne
    @JoinColumn(name = "reducing_end_id")
    @Column(name = "reducing_end_id")
    public ReducingEnd reducingEnd;

    @ManyToOne
    @JoinColumn(name = "persubstitution_id")
    @Column(name = "persubstitution_id")
    public Persubstitution persubstitution;


    public boolean showHide;

    public static final String bool = "FALSE";


}
