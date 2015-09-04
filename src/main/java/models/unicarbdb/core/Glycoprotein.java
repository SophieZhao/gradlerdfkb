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

    public Long getGlycoproteinId() {
        return glycoproteinId;
    }

    public void setGlycoproteinId(Long glycoproteinId) {
        this.glycoproteinId = glycoproteinId;
    }

    public Taxonomy getTaxonomyByNativeSpecies() {
        return taxonomyByNativeSpecies;
    }

    public void setTaxonomyByNativeSpecies(Taxonomy taxonomyByNativeSpecies) {
        this.taxonomyByNativeSpecies = taxonomyByNativeSpecies;
    }

    public Taxonomy getTaxonomyByExpressedSpecies() {
        return taxonomyByExpressedSpecies;
    }

    public void setTaxonomyByExpressedSpecies(Taxonomy taxonomyByExpressedSpecies) {
        this.taxonomyByExpressedSpecies = taxonomyByExpressedSpecies;
    }

    public String getUniprotId() {
        return uniprotId;
    }

    public void setUniprotId(String uniprotId) {
        this.uniprotId = uniprotId;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public String getGlycoproteinName() {
        return glycoproteinName;
    }

    public void setGlycoproteinName(String glycoproteinName) {
        this.glycoproteinName = glycoproteinName;
    }

    public String getGlycoproteinSequence() {
        return glycoproteinSequence;
    }

    public void setGlycoproteinSequence(String glycoproteinSequence) {
        this.glycoproteinSequence = glycoproteinSequence;
    }

    public Integer getSequenceOffset() {
        return sequenceOffset;
    }

    public void setSequenceOffset(Integer sequenceOffset) {
        this.sequenceOffset = sequenceOffset;
    }

    public List<EvidenceToGlycoprotein> getEvidenceToGlycoproteins() {
        return evidenceToGlycoproteins;
    }

    public void setEvidenceToGlycoproteins(List<EvidenceToGlycoprotein> evidenceToGlycoproteins) {
        this.evidenceToGlycoproteins = evidenceToGlycoproteins;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<GlycanSequenceToGlycoprotein> getGlycanSequenceGlycoproteins() {
        return glycanSequenceGlycoproteins;
    }

    public void setGlycanSequenceGlycoproteins(List<GlycanSequenceToGlycoprotein> glycanSequenceGlycoproteins) {
        this.glycanSequenceGlycoproteins = glycanSequenceGlycoproteins;
    }
}
