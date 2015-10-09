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
@Table(schema="core", name="core.glycan_sequence_to_reference")
public class GlycanSequenceToReference  {
	
	@Id
	//public Long Id;
	public Long glycanSequenceReferenceId;

	public Reference reference;

	public GlycanSequence glycanSequence;


	public Contributor contributor = null;

	public Date dateEntered = new Date();

	public Long getGlycanSequenceReferenceId() {
		return glycanSequenceReferenceId;
	}

	public void setGlycanSequenceReferenceId(Long glycanSequenceReferenceId) {
		this.glycanSequenceReferenceId = glycanSequenceReferenceId;
	}

	public Reference getReference() {
		return reference;
	}

	public void setReference(Reference reference) {
		this.reference = reference;
	}

	public GlycanSequence getGlycanSequence() {
		return glycanSequence;
	}

	public void setGlycanSequence(GlycanSequence glycanSequence) {
		this.glycanSequence = glycanSequence;
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
