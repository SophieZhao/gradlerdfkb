/*
 * Copyright (c) 2014. Copyright (c) 2014. Matthew Campbell <matthew.campbell@mq.edu.au>
 *
 * The program can not be distributed to others with out the consent of the copyright holder, until such a time that the copyright holder has released the code for public use.
 */

package models.unicarbdb.core;

import java.util.*;
import java.math.BigDecimal;

import javax.persistence.*;

import models.hplc.Lcmucin;
import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

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


}
