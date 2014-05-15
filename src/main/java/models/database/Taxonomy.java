package models.database;

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

   // @OneToMany
   // public List<Strtaxonomy> strtaxonomy;  //TODO

    /*@OneToMany
    public List<Taxprotein> taxprotein;

    @OneToMany
    public List<Proteinsource> taxproteinsource;

    @OneToMany
    public List<Taxtissue> taxtissue;

    @OneToMany
    public List<Strproteintax> strproteintax;
    */

}