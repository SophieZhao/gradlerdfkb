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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Reference getReference() {
        return reference;
    }

    public void setReference(Reference reference) {
        this.reference = reference;
    }

    public Biolsource getBiolsource() {
        return biolsource;
    }

    public void setBiolsource(Biolsource biolsource) {
        this.biolsource = biolsource;
    }
}
