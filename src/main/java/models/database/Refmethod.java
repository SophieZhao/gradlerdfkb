package models.database;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(schema="public", name="refmethod")
public class Refmethod {

    @Id
    public Long id;
    @ManyToOne
    public Reference reference;
    @ManyToOne
    public Method method;

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

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

}
