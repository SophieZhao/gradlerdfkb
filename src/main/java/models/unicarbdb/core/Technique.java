/*
 * Copyright (c) 2014. Copyright (c) 2014. Matthew Campbell <matthew.campbell@mq.edu.au>
 *
 * The program can not be distributed to others with out the consent of the copyright holder, until such a time that the copyright holder has released the code for public use.
 */

package models.unicarbdb.core;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(schema="core", name="technique")
public class Technique  {
	
	@Id
	//public Long Id;
	public Long techniqueId;
     
    public String techniqueAbbrev;
     
    public String techniqueName;

    @OneToMany(mappedBy = "technique")
    public List<Evidence> evidenceList;

    public Long getTechniqueId() {
        return techniqueId;
    }

    public void setTechniqueId(Long techniqueId) {
        this.techniqueId = techniqueId;
    }

    public String getTechniqueAbbrev() {
        return techniqueAbbrev;
    }

    public void setTechniqueAbbrev(String techniqueAbbrev) {
        this.techniqueAbbrev = techniqueAbbrev;
    }

    public String getTechniqueName() {
        return techniqueName;
    }

    public void setTechniqueName(String techniqueName) {
        this.techniqueName = techniqueName;
    }

    public List<Evidence> getEvidenceList() {
        return evidenceList;
    }

    public void setEvidenceList(List<Evidence> evidenceList) {
        this.evidenceList = evidenceList;
    }
}
