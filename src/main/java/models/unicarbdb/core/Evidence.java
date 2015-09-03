/*
 * Copyright (c) 2014. Copyright (c) 2014. Matthew Campbell <matthew.campbell@mq.edu.au>
 *
 * The program can not be distributed to others with out the consent of the copyright holder, until such a time that the copyright holder has released the code for public use.
 */

package models.unicarbdb.core;

import java.util.*;

import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

@Entity
@Table(schema = "core", name = "evidence")
public class Evidence  {

    public enum Type {
        /**
         * Generic evidence type
         */
        GENERIC,

        /**
         * Mass-spectrometry evidence type
         */
        MS,

        /**
         * HPLC (high-performance liquid chromatography) evidence type
         */
        HPLC,

        /**
         * NMR (nuclear magnetic resonance) evidence type
         */
        NMR,

        REF,

        LCMS;

    }


    /**
     * Unique id for this piece of evidence
     */
    @Id
    @Column(name = "evidence_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "evidence_gen")
    @SequenceGenerator(name = "evidence_gen", sequenceName = "ms.evidence_evidence_id_seq", allocationSize=1)
    //public Long Id;
    public Long evidenceId;

    /**
     * Type of evidence, defaults to {@link Type.GENERIC}
     */
    public Type evidenceType = Type.GENERIC;

    /** The contributor of this evidence; defaults to the current Contributor. */
    //public Contributor contributor = null;

    /**
     * The date this evidence was entered.
     */
    //@Formats.DateTime(pattern = "dd/MM/yyyy")
    public Date dateEntered = new Date();

    /** The {@link ExperimentStep} to which this evidence is associated,
     *   can be null if not associated to an {@link Experiment}. */
    // public ExperimentStep experimentStep = null;

    /** The {@link Experiment} to which this evidence is associated,
     *   can be null if not associated to an {@link Experiment}. */
    //public Experiment experiment = null;

    /**
     * The {@link Technique} used to create this evidence.
     */
    @ManyToOne
    @JoinColumn(name="technique_id")
    @Column(name="technique_id")
    public Technique technique;

    /** Set of {@link GlycanSequence} associations, internal use only */
    //public Set<GlycanSequenceEvidence> glycanSequenceEvidence
    //    = new HashSet<GlycanSequenceEvidence>(0);

    /**
     * Set of {@link Reference} associations, internal use only
     */
    //public Set<ReferencedEvidence> referencedEvidence
    //    = new HashSet<ReferencedEvidence>(0);
    public Type getEvidenceType() {
        return evidenceType;
    }

    public void setEvidenceType(Type evidenceType) {
        this.evidenceType = evidenceType;
    }

    public Date getDateEntered() {
        return dateEntered;
    }

    public void setDateEntered(Date dateEntered) {
        this.dateEntered = dateEntered;
    }

    public Technique getTechnique() {
        return technique;
    }

    public void setTechnique(Technique technique) {
        this.technique = technique;
    }
}
