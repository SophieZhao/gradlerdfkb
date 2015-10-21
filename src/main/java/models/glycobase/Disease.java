package models.glycobase;

import javax.persistence.*;

/**
 * Created by matthew on 19/10/2015.
 */
@Entity
@Table(schema="public", name="disease")
public class Disease {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "disease_gen")
    @SequenceGenerator(name = "disease_gen", sequenceName = "disease_id_seq", allocationSize=1)
    public Long Id;

    @ManyToOne
    public Structure structure;

    public String disease;

    public void setId(Long id) {
        Id = id;
    }

    public void setStructure(Structure structure) {
        this.structure = structure;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }
}
