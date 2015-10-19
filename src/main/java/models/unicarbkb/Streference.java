package models.unicarbkb;

import javax.persistence.*;

@Entity
@Table(schema="public", name="streference")
public class Streference  {

    @Id
    public Long id;
    @ManyToOne
    public Structure structure;
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

    public Reference getReference() {
        return reference;
    }

    public void setReference(Reference reference) {
        this.reference = reference;
    }
}
