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
@Table(schema="core", name="core.evidence_to_biological_context")
public class EvidenceToBiologicalContext  {
	
	@Id
	//public Long Id;
    public Long evidenceContextId;
    
    public BiologicalContext biologicalContext;
    
    public Evidence evidence;


   public Contributor contributor = null;

   public Date dateEntered = new Date();

   //public Set<EvidenceToGlycoprotein> evidenceToGlycoproteinContext = new HashSet<EvidenceToGlycoprotein>(0);^M  
   public EvidenceToGlycoprotein evidenceToBcs;


}
