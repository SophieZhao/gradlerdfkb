/*
 * Copyright (c) 2015. Copyright (c) 2015. Matthew Campbell
 *
 * The program can not be distributed to others with out the consent of the copyright holder, until such a time that the copyright holder has released the code for public use.
 */

package models.unicarbdb.core;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by matthew on 1/10/2014.
 */
@Entity
@Table(schema = "core", name = "glycan_composition_refresh")
public class GlycanCompositionRefresh  {

    @Id
    @Column(name = "glycan_composition_id")
    public Long glycanCompositionRefreshId;

    //@ManyToOne
    // @JoinColumn(name = "glycan_sequence_id")
    //public GlycanSequence glycanSequence;

    public Long glycanSequenceId;

    public int pen;
    public int dhex;

    public void setGlycanSequenceId(Long glycanSequenceId) {
        this.glycanSequenceId = glycanSequenceId;
    }

    public int hex;
    public int hexnac;
    public int neugc;
    public int neuac;
    public int sulphate;

    @Column(scale = 2)
    public Double mass;


    public void setPen(int pen) {
        this.pen = pen;
    }

    public void setDhex(int dhex) {
        this.dhex = dhex;
    }

    public void setHex(int hex) {
        this.hex = hex;
    }

    public void setHexnac(int hexnac) {
        this.hexnac = hexnac;
    }

    public void setNeugc(int neugc) {
        this.neugc = neugc;
    }

    public void setNeuac(int neuac) {
        this.neuac = neuac;
    }

    public void setSulphate(int sulphate) {
        this.sulphate = sulphate;
    }



    public void setMass(Double mass) {
        this.mass = mass;
    }

}
