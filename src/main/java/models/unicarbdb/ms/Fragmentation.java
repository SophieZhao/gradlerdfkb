/*
 * Copyright (c) 2014. Copyright (c) 2014. Matthew Campbell <matthew.campbell@mq.edu.au>
 *
 * The program can not be distributed to others with out the consent of the copyright holder, until such a time that the copyright holder has released the code for public use.
 */

package models.unicarbdb.ms;

import play.db.ebean.Model;

import javax.persistence.*;

@Entity
@Table(schema="ms", name="fragmentation")
public class Fragmentation  {

	@Id
    @Column(name="fragmentation_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fragmentation_gen")
    @SequenceGenerator(name = "fragmentation_gen", sequenceName = "ms.fragmentation_fragmentation_id_seq", allocationSize=1)
	//public Long Id;
	public Long fragmentationId;

    @ManyToOne
    @JoinColumn(name = "peak_annotated_id")
    @Column(name = "peak_annotated_id")
    public PeakAnnotated peakAnnotated;

    public String fragmentType;
    public String fragmentDc;
    public String fragmentAlt;
    public Integer fragmentPosition;
    public Integer cleavageOne;
    public Integer cleavageTwo;


    public PeakAnnotated getPeakAnnotated() {
        return peakAnnotated;
    }

    public void setPeakAnnotated(PeakAnnotated peakAnnotated) {
        this.peakAnnotated = peakAnnotated;
    }

    public String getFragmentType() {
        return fragmentType;
    }

    public void setFragmentType(String fragmentType) {
        this.fragmentType = fragmentType;
    }

    public String getFragmentDc() {
        return fragmentDc;
    }

    public void setFragmentDc(String fragmentDc) {
        this.fragmentDc = fragmentDc;
    }

    public String getFragmentAlt() {
        return fragmentAlt;
    }

    public void setFragmentAlt(String fragmentAlt) {
        this.fragmentAlt = fragmentAlt;
    }

    public Integer getFragmentPosition() {
        return fragmentPosition;
    }

    public void setFragmentPosition(Integer fragmentPosition) {
        this.fragmentPosition = fragmentPosition;
    }

    public Integer getCleavageOne() {
        return cleavageOne;
    }

    public void setCleavageOne(Integer cleavageOne) {
        this.cleavageOne = cleavageOne;
    }

    public Integer getCleavageTwo() {
        return cleavageTwo;
    }

    public void setCleavageTwo(Integer cleavageTwo) {
        this.cleavageTwo = cleavageTwo;
    }
}
