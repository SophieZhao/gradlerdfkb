/*
 * Copyright (c) 2014. Copyright (c) 2014. Matthew Campbell <matthew.campbell@mq.edu.au>
 *
 * The program can not be distributed to others with out the consent of the copyright holder, until such a time that the copyright holder has released the code for public use.
 */

package models.unicarbdb.hplc;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema="hplc", name="column")
public class Column  {
	
	@Id
	//public Long Id;
	public Long columnId;

	public String packingMaterial;

	public double columnSizeWidth;
 
	public double columnSizeLength;
    
	public String particleSize;

	public String model;

	@OneToMany
	public List<Lcmucin> lcmucins;

}
