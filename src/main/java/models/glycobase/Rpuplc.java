package models.glycobase;

import javax.persistence.*;
import javax.persistence.Id;

/**
 * Created by matthew on 19/10/2015.
 */
@Entity
@Table(schema="public", name="rpuplc")
public class Rpuplc {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rpuplc_gen")
    @SequenceGenerator(name = "rpuplc_gen", sequenceName = "rpuplc_id_seq", allocationSize=1)
    public Long Id;

    @ManyToOne
    public Structure structure;

    public double au;

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

    public double getAu() {
        return au;
    }

    public void setAu(double au) {
        this.au = au;
    }
}
