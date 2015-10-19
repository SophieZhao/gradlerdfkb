package models.glycobase;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by matthew on 19/10/2015.
 */
@Entity
@Table(schema="public", name="taxonomy")
public class Taxonomy {

    @Id
    public Long Id;

    @ManyToOne
    public Structure structure;

    public String taxonomy;

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

    public String getTaxonomy() {
        return taxonomy;
    }

    public void setTaxonomy(String taxonomy) {
        this.taxonomy = taxonomy;
    }
}
