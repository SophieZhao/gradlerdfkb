package models.glycobase;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Id;

/**
 * Created by matthew on 19/10/2015.
 */
@Entity
@Table(schema="public", name="disease")
public class Disease {

    @Id
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
