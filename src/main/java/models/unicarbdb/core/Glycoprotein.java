/*
 * Copyright (c) 2014. Copyright (c) 2014. Matthew Campbell <matthew.campbell@mq.edu.au>
 *
 * The program can not be distributed to others with out the consent of the copyright holder, until such a time that the copyright holder has released the code for public use.
 */

package models.unicarbdb.core;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(schema = "core", name = "glycoprotein")
public class Glycoprotein  {
	
	@Id
	//public Long Id;
    public Long glycoproteinId;
    public Taxonomy taxonomyByNativeSpecies;
    public Taxonomy taxonomyByExpressedSpecies;
    public String uniprotId;
    public String variant;
    public String glycoproteinName;
    public String glycoproteinSequence;
    public Integer sequenceOffset;
    //public Set glycoproteinAttachments = new HashSet(0);

    @OneToMany
    public List<EvidenceToGlycoprotein> evidenceToGlycoproteins;

    //public EvidenceToGlycoprotein evidenceToGlycoproteinss;

    public String description;
    public List<GlycanSequenceToGlycoprotein> glycanSequenceGlycoproteins; // = new HashSet<GlycanSequenceGlycoprotein>(0);


}
