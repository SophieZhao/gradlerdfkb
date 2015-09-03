/*
 * Copyright (c) 2014. Copyright (c) 2014. Matthew Campbell <matthew.campbell@mq.edu.au>
 *
 * The program can not be distributed to others with out the consent of the copyright holder, until such a time that the copyright holder has released the code for public use.
 */

package models.unicarbdb.core;

import java.util.*;
import java.math.BigDecimal;

import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

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


}
