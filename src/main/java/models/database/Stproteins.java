package models.database;

import java.util.*;
import javax.persistence.*;
import com.avaje.ebean.*;

@Entity
@Table(schema="public", name="stproteins")
public class Stproteins {

    @Id
    public Long id;
    @ManyToOne
    public Structure  structure;
    @ManyToOne
    public Proteins proteins;

}