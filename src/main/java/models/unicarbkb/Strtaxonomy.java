package models.unicarbkb;

import javax.persistence.*;

@Entity
@Table(schema="public", name="strtaxonomy")
public class Strtaxonomy {

    @Id
    public Long id;

    @ManyToOne
    public Taxonomy taxonomy;

    @ManyToOne
    public Structure structure;

    public String species;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Taxonomy getTaxonomy() {
        return taxonomy;
    }

    public void setTaxonomy(Taxonomy taxonomy) {
        this.taxonomy = taxonomy;
    }

    public Structure getStructure() {
        return structure;
    }

    public void setStructure(Structure structure) {
        this.structure = structure;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}
