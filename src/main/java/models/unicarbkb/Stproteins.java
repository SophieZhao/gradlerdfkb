package models.unicarbkb;

import javax.persistence.*;

@Entity
@Table(schema="public", name="stproteins")
public class Stproteins {

    @Id
    public Long id;
    @ManyToOne
    public Structure  structure;
    @ManyToOne
    public Proteins proteins;

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
}