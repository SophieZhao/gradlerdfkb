/*
 * Copyright (c) 2014. Copyright (c) 2014. Matthew Campbell <matthew.campbell@mq.edu.au>
 *
 * The program can not be distributed to others with out the consent of the copyright holder, until such a time that the copyright holder has released the code for public use.
 */

package models.unicarbdb.core;

import models.unicarbdb.hplc.Lcmucin;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "core", name = "evidence_to_glycoprotein")
public class EvidenceToGlycoprotein {

	@Id
	//public Long Id;
	public Long evidenceToGlycoproteinId;
	
	public Evidence evidence;

	@ManyToOne
	@JoinColumn(name = "glycoprotein_id")
	@Column(name = "glycoprotein_id")
	public Glycoprotein glycoprotein;

	@OneToMany
	public List<models.unicarbdb.hplc.Lcmucin> lcmucins;

	public List<Glycoprotein> evidenceToGlycoproteinss; // = new HashSet<Glycoprotein>(0);
	public EvidenceToBiologicalContext evidenceToGlycoproteinContext;
	public List<EvidenceToBiologicalContext> evidenceToBcs; // = new HashSet<EvidenceContext>(0);

	public Long getEvidenceToGlycoproteinId() {
		return evidenceToGlycoproteinId;
	}

	public void setEvidenceToGlycoproteinId(Long evidenceToGlycoproteinId) {
		this.evidenceToGlycoproteinId = evidenceToGlycoproteinId;
	}

	public Evidence getEvidence() {
		return evidence;
	}

	public void setEvidence(Evidence evidence) {
		this.evidence = evidence;
	}

	public Glycoprotein getGlycoprotein() {
		return glycoprotein;
	}

	public void setGlycoprotein(Glycoprotein glycoprotein) {
		this.glycoprotein = glycoprotein;
	}

	public List<Lcmucin> getLcmucins() {
		return lcmucins;
	}

	public void setLcmucins(List<Lcmucin> lcmucins) {
		this.lcmucins = lcmucins;
	}

	public List<Glycoprotein> getEvidenceToGlycoproteinss() {
		return evidenceToGlycoproteinss;
	}

	public void setEvidenceToGlycoproteinss(List<Glycoprotein> evidenceToGlycoproteinss) {
		this.evidenceToGlycoproteinss = evidenceToGlycoproteinss;
	}

	public EvidenceToBiologicalContext getEvidenceToGlycoproteinContext() {
		return evidenceToGlycoproteinContext;
	}

	public void setEvidenceToGlycoproteinContext(EvidenceToBiologicalContext evidenceToGlycoproteinContext) {
		this.evidenceToGlycoproteinContext = evidenceToGlycoproteinContext;
	}

	public List<EvidenceToBiologicalContext> getEvidenceToBcs() {
		return evidenceToBcs;
	}

	public void setEvidenceToBcs(List<EvidenceToBiologicalContext> evidenceToBcs) {
		this.evidenceToBcs = evidenceToBcs;
	}
}
