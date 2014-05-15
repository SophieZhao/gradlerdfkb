package models.database;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(schema="public", name="sourceref")
public class Sourceref {

    @Id
    public Long id;

    @ManyToOne
    public Reference reference;

    @ManyToOne
    public Biolsource biolsource;

    //@OneToMany
    //public List<Strproteintaxbiolsource> strproteintaxbiolsource;

}
