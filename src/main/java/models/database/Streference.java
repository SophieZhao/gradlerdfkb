package models.database;

import java.util.*;
import javax.persistence.*;
import com.avaje.ebean.*;

@Entity
@Table(schema="public", name="streference")
public class Streference  {

    @Id
    public Long id;
    @ManyToOne
    public Structure structure;
    @ManyToOne
    public Reference reference;


}
