package models.unicarbkb;

import javax.persistence.*;

/*
this is a v bad name!

 */
@Entity
@Table(schema="public", name="strproteintaxbiolsource")
public class Strproteintaxbiolsource {

    @Id
    public Long id;

    @ManyToOne
    public Structure structure;
    @ManyToOne
    public Proteins proteins;
    @ManyToOne
    public Taxonomy taxonomy;
    @ManyToOne
    public Sourceref sourceref;
    @ManyToOne
    public Reference reference;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Structure getStructure() {
        return structure;
    }

    public void setStructure(Structure structure) {
        this.structure = structure;
    }

    public Proteins getProteins() {
        return proteins;
    }

    public void setProteins(Proteins proteins) {
        this.proteins = proteins;
    }

    public Taxonomy getTaxonomy() {
        return taxonomy;
    }

    public void setTaxonomy(Taxonomy taxonomy) {
        this.taxonomy = taxonomy;
    }

    public Sourceref getSourceref() {
        return sourceref;
    }

    public void setSourceref(Sourceref sourceref) {
        this.sourceref = sourceref;
    }

    public Reference getReference() {
        return reference;
    }

    public void setReference(Reference reference) {
        this.reference = reference;
    }
}