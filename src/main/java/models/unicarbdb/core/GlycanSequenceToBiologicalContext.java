/*
 * Copyright (c) 2014. Copyright (c) 2014. Matthew Campbell <matthew.campbell@mq.edu.au>
 *
 * The program can not be distributed to others with out the consent of the copyright holder, until such a time that the copyright holder has released the code for public use.
 */

package models.unicarbdb.core;

import java.util.*;
import java.math.BigDecimal;

import javax.persistence.*;

import models.unicarbdb.hplc.Lcmucin;




import com.avaje.ebean.*;

@Entity
@Table(schema="core", name="glycan_sequence_to_biological_context")
public class GlycanSequenceToBiologicalContext {
	
	@Id
	//public Long Id;
	public Long glycanSequenceContextId;

    public BiologicalContext biologicalContext;

    public GlycanSequence glycanSequence;

    public int glycanSequenceId;

    public int biologicalContextId;

    /** The contributor of this object; defaults to the current Contributor. 
    *   note that we *cannot* initialise this property at construction 
    *   time as it causes hibernate to go into an endless intialisation loop. */
    public Contributor contributor = null;

    /** The date this objects was created/entered into the data store. */
    public Date dateEntered = new Date();

    public Long getGlycanSequenceContextId() {
        return glycanSequenceContextId;
    }

    public void setGlycanSequenceContextId(Long glycanSequenceContextId) {
        this.glycanSequenceContextId = glycanSequenceContextId;
    }

    public BiologicalContext getBiologicalContext() {
        return biologicalContext;
    }

    public void setBiologicalContext(BiologicalContext biologicalContext) {
        this.biologicalContext = biologicalContext;
    }

    public GlycanSequence getGlycanSequence() {
        return glycanSequence;
    }

    public void setGlycanSequence(GlycanSequence glycanSequence) {
        this.glycanSequence = glycanSequence;
    }

    public int getGlycanSequenceId() {
        return glycanSequenceId;
    }

    public void setGlycanSequenceId(int glycanSequenceId) {
        this.glycanSequenceId = glycanSequenceId;
    }

    public int getBiologicalContextId() {
        return biologicalContextId;
    }

    public void setBiologicalContextId(int biologicalContextId) {
        this.biologicalContextId = biologicalContextId;
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
