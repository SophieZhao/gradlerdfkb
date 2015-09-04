/*
 * Copyright (c) 2014. Copyright (c) 2014. Matthew Campbell <matthew.campbell@mq.edu.au>
 *
 * The program can not be distributed to others with out the consent of the copyright holder, until such a time that the copyright holder has released the code for public use.
 */

package models.unicarbdb.hplc;

import java.util.*;

import javax.persistence.*;




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


	public Long getMethodRunId() {
		return methodRunId;
	}

	public void setMethodRunId(Long methodRunId) {
		this.methodRunId = methodRunId;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public String getSolventA() {
		return solventA;
	}

	public void setSolventA(String solventA) {
		this.solventA = solventA;
	}

	public String getSolventB() {
		return solventB;
	}

	public void setSolventB(String solventB) {
		this.solventB = solventB;
	}

	public String getSolventC() {
		return solventC;
	}

	public void setSolventC(String solventC) {
		this.solventC = solventC;
	}

	public String getSolventD() {
		return solventD;
	}

	public void setSolventD(String solventD) {
		this.solventD = solventD;
	}

	public Double getFlowRate() {
		return flowRate;
	}

	public void setFlowRate(Double flowRate) {
		this.flowRate = flowRate;
	}

	public Double getRunTime() {
		return runTime;
	}

	public void setRunTime(Double runTime) {
		this.runTime = runTime;
	}

	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public String getFlowGradient() {
		return flowGradient;
	}

	public void setFlowGradient(String flowGradient) {
		this.flowGradient = flowGradient;
	}

	public List<Lcmucin> getLcmucins() {
		return lcmucins;
	}

	public void setLcmucins(List<Lcmucin> lcmucins) {
		this.lcmucins = lcmucins;
	}
}
