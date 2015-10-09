/*
 * Copyright (c) 2014. Copyright (c) 2014. Matthew Campbell <matthew.campbell@mq.edu.au>
 *
 * The program can not be distributed to others with out the consent of the copyright holder, until such a time that the copyright holder has released the code for public use.
 */

package models.unicarbdb.ms;

import models.unicarbdb.hplc.Lcmucin;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema="ms", name="persubstitution")
public class Persubstitution  {
	
	@Id
    @Column(name="persubstitution_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "persubstitution_gen")
    @SequenceGenerator(name = "persubstitution_gen", sequenceName = "ms.persubstitution_persubstitution_id_seq", allocationSize=1)
	//public Long Id;
	 public Long persubstitutionId;
	 public String abbreviation;
	 public String name;
	 
	 @OneToMany
	 public List<PeakAnnotated> peakAnnotateds; // = new HashSet<org.eurocarbdb.dataaccess.ms.PeakAnnotated>();


	@OneToMany(mappedBy = "persubstitution")
	public List<Scan> scan; // = new HashSet<scan>(0);

	@OneToMany(mappedBy = "persubstitution")
	public List<models.unicarbdb.hplc.Lcmucin> lcmucin;

	public List<AcquisitionToPersubstitution> AcquisitionToPersubstitutions; // = new HashSet<org.eurocarbdb.dataaccess.ms.AcquisitionToPersubstitution>();

	public Long getPersubstitutionId() {
		return persubstitutionId;
	}

	public void setPersubstitutionId(Long persubstitutionId) {
		this.persubstitutionId = persubstitutionId;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PeakAnnotated> getPeakAnnotateds() {
		return peakAnnotateds;
	}

	public void setPeakAnnotateds(List<PeakAnnotated> peakAnnotateds) {
		this.peakAnnotateds = peakAnnotateds;
	}

	public List<Scan> getScan() {
		return scan;
	}

	public void setScan(List<Scan> scan) {
		this.scan = scan;
	}

	public List<Lcmucin> getLcmucin() {
		return lcmucin;
	}

	public void setLcmucin(List<Lcmucin> lcmucin) {
		this.lcmucin = lcmucin;
	}

	public List<AcquisitionToPersubstitution> getAcquisitionToPersubstitutions() {
		return AcquisitionToPersubstitutions;
	}

	public void setAcquisitionToPersubstitutions(List<AcquisitionToPersubstitution> acquisitionToPersubstitutions) {
		AcquisitionToPersubstitutions = acquisitionToPersubstitutions;
	}
}
