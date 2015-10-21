package models.glycobase;

import javax.persistence.*;

/**
 * Created by matthew on 19/10/2015.
 */
@Entity
@Table(schema="public", name="taxonomy")
public class Taxonomy {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "taxonomy_gen")
    @SequenceGenerator(name = "taxonomy_gen", sequenceName = "taxonomy_id_seq", allocationSize=1)
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
