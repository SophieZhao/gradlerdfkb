/*
 * Copyright (c) 2014. Copyright (c) 2014. Matthew Campbell <matthew.campbell@mq.edu.au>
 *
 * The program can not be distributed to others with out the consent of the copyright holder, until such a time that the copyright holder has released the code for public use.
 */

package models.unicarbdb.hplc;

import java.util.*;

import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import models.*;

import com.avaje.ebean.*;

@Entity
@Table(schema="hplc", name="method_run")
public class MethodRun  {
	
	@Id
	//public Long Id;
	public Long methodRunId;

	 //public Profile profile;

	 public Double temperature;
   
	 public String solventA;

	 public String solventB;
	 
	 public String solventC;

	 public String solventD;

	 public Double flowRate;

	 public Double runTime;

	 public String phase;
 
	 public String flowGradient;

	@OneToMany
	 public List<Lcmucin> lcmucins;

}
