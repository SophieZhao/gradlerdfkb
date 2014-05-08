package models.database;

import javax.persistence.*;

@Entity
@Table(schema="public", name="translation")
public class Translation  {

    @Id
    public Long id;

    public String iupac;

    public String ct;

    public String gws;

    @ManyToOne
    public Structure structure;

}
