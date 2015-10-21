package models.glycobase;

import javax.persistence.*;

/**
 * Created by matthew on 19/10/2015.
 */
@Entity
@Table(schema="public", name="tissue")
public class Tissue {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tissue_gen")
    @SequenceGenerator(name = "tissue_gen", sequenceName = "tissue_id_seq", allocationSize=1)
    public Long Id;

    @ManyToOne
    public Structure structure;

    public String tissue;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Structure getStructure() {
        return structure;
    }

    public void setStructure(Structure structure) {
        this.structure = structure;
    }

    public String getTissue() {
        return tissue;
    }

    public void setTissue(String tissue) {
        this.tissue = tissue;
    }
}
