/*
 * Copyright (c) 2014. Copyright (c) 2014. Matthew Campbell <matthew.campbell@mq.edu.au>
 *
 * The program can not be distributed to others with out the consent of the copyright holder, until such a time that the copyright holder has released the code for public use.
 */

package models.unicarbdb.hplc;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Expr;
import com.avaje.ebean.Junction;
import models.core.*;
import models.ms.*;
import models.unicarbdb.core.Evidence;
import models.unicarbdb.core.GlycanSequence;
import models.unicarbdb.core.JournalReference;
import models.unicarbdb.ms.Scan;
import org.apache.commons.lang.StringUtils;
import org.eurocarbdb.application.glycanbuilder.Glycan;
import org.eurocarbdb.application.glycanbuilder.GlycoCTCondensedParser;
import org.eurocarbdb.application.glycanbuilder.MassOptions;
import play.Logger;
import play.db.ebean.Model;

import javax.persistence.Column;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static models.core.GlycanSequence.countSubstring;

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
    public models.hplc.Column column;

    @ManyToOne
    @JoinColumn(name="glycan_sequence_id")
    public GlycanSequence glycanSequence;

    @ManyToOne
    @JoinColumn(name="method_run_id")
    public models.hplc.MethodRun methodRun;

    public Double retentionTime;

    public Evidence evidence;
    public Evidence evidencelc;

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
    public models.core.BiologicalContext biologicalContext;

    @ManyToOne
    @JoinColumn(name = "reducing_end_id")
    @Column(name = "reducing_end_id")
    public ReducingEnd reducingEnd;

    @ManyToOne
    @JoinColumn(name = "persubstitution_id")
    @Column(name = "persubstitution_id")
    public Persubstitution persubstitution;

    /*
    This is temp while we curated and cleanup for version 2.0 release
    true = hide
     */
    public boolean showHide;

    public static final String bool = "FALSE";


    p

    /*
    TODO need to remove the below
     */
    public void setColumn(models.unicarbdb.hplc.Column column) {
        this.column = column;
    }

    public void setGlycanSequence(GlycanSequence glycanSequence) {
        this.glycanSequence = glycanSequence;
    }

    public void setMethodRun(MethodRun methodRun) {
        this.methodRun = methodRun;
    }

    public void setRetentionTime(Double retentionTime) {
        this.retentionTime = retentionTime;
    }

    public void setEvidence(Evidence evidence) {
        this.evidence = evidence;
    }

    public void setEvidencelc(Evidence evidencelc) {
        this.evidencelc = evidencelc;
    }

    public void setScan(models.unicarbdb.ms.Scan scan) {
        this.scan = scan;
    }

    public void setScanparent(Integer scanparent) {
        this.scanparent = scanparent;
    }

    public void setAcquisitionId(Integer acquisitionId) {
        this.acquisitionId = acquisitionId;
    }

    public void setGwpname(String gwpname) {
        this.gwpname = gwpname;
    }

    public void setIonizationMethod(String ionizationMethod) {
        this.ionizationMethod = ionizationMethod;
    }

    public void setStandard(Integer standard) {
        this.standard = standard;
    }

    public void setJournalReference(JournalReference journalReference) {
        this.journalReference = journalReference;
    }

    public void setBiologicalContextId(Integer biologicalContextId) {
        this.biologicalContextId = biologicalContextId;
    }
}
