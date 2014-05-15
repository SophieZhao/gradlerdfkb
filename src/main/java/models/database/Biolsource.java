package models.database;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(schema="public", name="biolsource")
public class Biolsource  {

    @Id
    public Long id;

    public String protein;
    public String taxonomy;
    public String swiss_prot;

    @OneToMany
    public List<Sourceref> sourceref;
}
