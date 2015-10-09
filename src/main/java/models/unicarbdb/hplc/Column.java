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

	public Long getColumnId() {
		return columnId;
	}

	public void setColumnId(Long columnId) {
		this.columnId = columnId;
	}

	public String getPackingMaterial() {
		return packingMaterial;
	}

	public void setPackingMaterial(String packingMaterial) {
		this.packingMaterial = packingMaterial;
	}

	public double getColumnSizeWidth() {
		return columnSizeWidth;
	}

	public void setColumnSizeWidth(double columnSizeWidth) {
		this.columnSizeWidth = columnSizeWidth;
	}

	public double getColumnSizeLength() {
		return columnSizeLength;
	}

	public void setColumnSizeLength(double columnSizeLength) {
		this.columnSizeLength = columnSizeLength;
	}

	public String getParticleSize() {
		return particleSize;
	}

	public void setParticleSize(String particleSize) {
		this.particleSize = particleSize;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public List<Lcmucin> getLcmucins() {
		return lcmucins;
	}

	public void setLcmucins(List<Lcmucin> lcmucins) {
		this.lcmucins = lcmucins;
	}
}
