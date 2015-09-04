/*
 * Copyright (c) 2014. Copyright (c) 2014. Matthew Campbell <matthew.campbell@mq.edu.au>
 *
 * The program can not be distributed to others with out the consent of the copyright holder, until such a time that the copyright holder has released the code for public use.
 */

package models.unicarbdb.core;

import java.util.*;
import java.math.BigDecimal;

import javax.persistence.*;





import com.avaje.ebean.*;

@Entity
@Table(schema="core", name="core.glycan_sequence_to_evidence")
public class GlycanSequenceToEvidence  {
	
	@Id
	//public Long Id;
    private Long glycanSequenceEvidenceId;

    private GlycanSequence glycanSequence;

    private Evidence evidence;

    private Double quantitationByPercent;

   /** The contributor of this object; defaults to the current Contributor. 
   *   note that we *cannot* initialise this property at construction 
   *   time as it causes hibernate to go into an endless intialisation loop. */
   private Contributor contributor = null;

   /** The date this objects was created/entered into the data store. */
   private Date dateEntered = new Date();

    public Long getGlycanSequenceEvidenceId() {
        return glycanSequenceEvidenceId;
    }

    public void setGlycanSequenceEvidenceId(Long glycanSequenceEvidenceId) {
        this.glycanSequenceEvidenceId = glycanSequenceEvidenceId;
    }

    public GlycanSequence getGlycanSequence() {
        return glycanSequence;
    }

    public void setGlycanSequence(GlycanSequence glycanSequence) {
        this.glycanSequence = glycanSequence;
    }

    public Evidence getEvidence() {
        return evidence;
    }

    public void setEvidence(Evidence evidence) {
        this.evidence = evidence;
    }

    public Double getQuantitationByPercent() {
        return quantitationByPercent;
    }

    public void setQuantitationByPercent(Double quantitationByPercent) {
        this.quantitationByPercent = quantitationByPercent;
    }

    public Contributor getContributor() {
        return contributor;
    }

    public void setContributor(Contributor contributor) {
        this.contributor = contributor;
    }

    public Date getDateEntered() {
        return dateEntered;
    }

    public void setDateEntered(Date dateEntered) {
        this.dateEntered = dateEntered;
    }
}
