/*
 * Copyright (c) 2014. Copyright (c) 2014. Matthew Campbell <matthew.campbell@mq.edu.au>
 *
 * The program can not be distributed to others with out the consent of the copyright holder, until such a time that the copyright holder has released the code for public use.
 */

package models.unicarbdb.ms;

import play.db.ebean.Model;

import javax.persistence.*;

@Entity
@Table(schema="ms", name="ms.acquisition_to_persubstitution")
public class AcquisitionToPersubstitution  {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acquisition_to_persubstitutio_acquisition_to_persubstitutio_seq_gen")
    @SequenceGenerator(name = "acquisition_to_persubstitutio_acquisition_to_persubstitutio_seq_gen", sequenceName = "ms.acquisition_to_persubstitutio_acquisition_to_persubstitutio_seq", allocationSize=1)
	//public Long Id;
	public Long AcquisitiontoPersubstitutionId;
	
	 public Acquisition acquisition;
	 public Persubstitution persubstitution;


}
