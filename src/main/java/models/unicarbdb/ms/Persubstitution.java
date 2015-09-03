/*
 * Copyright (c) 2014. Copyright (c) 2014. Matthew Campbell <matthew.campbell@mq.edu.au>
 *
 * The program can not be distributed to others with out the consent of the copyright holder, until such a time that the copyright holder has released the code for public use.
 */

package models.unicarbdb.ms;

import models.hplc.Lcmucin;
import play.db.ebean.Model;

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

	
}
