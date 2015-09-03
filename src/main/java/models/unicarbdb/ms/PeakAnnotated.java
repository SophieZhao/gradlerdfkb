/*
 * Copyright (c) 2014. Copyright (c) 2014. Matthew Campbell <matthew.campbell@mq.edu.au>
 *
 * The program can not be distributed to others with out the consent of the copyright holder, until such a time that the copyright holder has released the code for public use.
 */

package models.unicarbdb.ms;

import play.db.ebean.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(schema="ms", name="peak_annotated")
public class PeakAnnotated  {

	@Id
    @Column(name="peak_annotated_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "peak_annotated_gen")
    @SequenceGenerator(name = "peak_annotated_gen", sequenceName = "ms.peak_annotated_peak_annotated_id_seq", allocationSize=1)
	public Long peakAnnotatedId;

	@ManyToOne
    @JoinColumn(name="peak_labeled_id")
    @Column(name="peak_labeled_id")
    public PeakLabeled peakLabeled;
	
	@ManyToOne
    @JoinColumn(name="reducing_end_id")
    @Column(name="reducing_end_id")
	public ReducingEnd reducingEnd;
	
	@ManyToOne
    @JoinColumn(name="persubstitution_id")
    @Column(name="persubstitution_id")
    public Persubstitution persubstitution;

    //public PeakAnnotatedAnnotation peakAnnotatedAnnotation;
    //public Integer glycoCtId;
    public String sequenceGws;
    public String formula;
    public Double calculatedMass;
    public Double contributorQuality;
    public Date dateEntered;
    public Integer contributorId;
    public List<PeakAnnotatedToSmallMolecule> peakAnnotatedToSmallMolecules;

    @OneToMany(mappedBy = "peakAnnotated", cascade = CascadeType.ALL)
    public List<PeakAnnotatedToIon> peakAnnotatedToIons;

    @OneToMany(mappedBy = "peakAnnotated", cascade = CascadeType.ALL)
    public List<Fragmentation> fragmentations;


    public void setPeakLabeled(PeakLabeled peakLabeled) {
        this.peakLabeled = peakLabeled;
    }

    public void setReducingEnd(ReducingEnd reducingEnd) {
        this.reducingEnd = reducingEnd;
    }

    public void setPersubstitution(Persubstitution persubstitution) {
        this.persubstitution = persubstitution;
    }

    /*public void setPeakAnnotatedAnnotation(PeakAnnotatedAnnotation peakAnnotatedAnnotation) {
        this.peakAnnotatedAnnotation = peakAnnotatedAnnotation;
    }*/

    public void setSequenceGws(String sequenceGws) {
        this.sequenceGws = sequenceGws;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public void setCalculatedMass(Double calculatedMass) {
        this.calculatedMass = calculatedMass;
    }

    public void setContributorQuality(Double contributorQuality) {
        this.contributorQuality = contributorQuality;
    }

    public void setDateEntered(Date dateEntered) {
        this.dateEntered = dateEntered;
    }

    public void setContributorId(Integer contributorId) {
        this.contributorId = contributorId;
    }

    public void setPeakAnnotatedToSmallMolecules(List<PeakAnnotatedToSmallMolecule> peakAnnotatedToSmallMolecules) {
        this.peakAnnotatedToSmallMolecules = peakAnnotatedToSmallMolecules;
    }

    public void setPeakAnnotatedToIons(List<PeakAnnotatedToIon> peakAnnotatedToIons) {
        this.peakAnnotatedToIons = peakAnnotatedToIons;
    }

    public void setFragmentations(List<Fragmentation> fragmentations) {
        this.fragmentations = fragmentations;
    }
}
