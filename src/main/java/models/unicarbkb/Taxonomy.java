package models.unicarbkb;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(schema="public", name="taxonomy")
public class Taxonomy {

    @Id
    public Long id;

    public String species;

    public String classtype;

    public String common;

    @OneToMany
    public List<Strtaxonomy> strtaxonomy;  //TODO

    /*@OneToMany
    public List<Taxprotein> taxprotein;

    @OneToMany
    public List<Proteinsource> taxproteinsource;

    @OneToMany
    public List<Taxtissue> taxtissue;

    @OneToMany
    public List<Strproteintax> strproteintax;
    */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getClasstype() {
        return classtype;
    }

    public void setClasstype(String classtype) {
        this.classtype = classtype;
    }

    public String getCommon() {
        return common;
    }

    public void setCommon(String common) {
        this.common = common;
    }

    public List<Strtaxonomy> getStrtaxonomy() {
        return strtaxonomy;
    }

    public void setStrtaxonomy(List<Strtaxonomy> strtaxonomy) {
        this.strtaxonomy = strtaxonomy;
    }
}