package models.database;

import java.util.*;
import javax.persistence.*;
import com.avaje.ebean.*;

@Entity
@Table(schema="public", name="structure")
public class Structure {

    @Id
    public Long id;

    public String compositionId;
    public String glycanst;
    public String aminolink;
    public String core;
    public String type;
    public String antigenic;
    public String lectin;
    public String endoglycosidase;
    public String link;

    @OneToMany
    public List<Streference> references;

    @OneToMany
    public List<Stproteins> stproteins;

    //@OneToMany
    //public List<Translation> translation;

    //@OneToMany
    //public List<Strproteintaxbiolsource> strproteintaxbiolsource;
}