package models.database;

import java.util.*;
import javax.persistence.*;
import com.avaje.ebean.*;

@Entity
@Table(name="defined_sites", schema="glycosuite")
public class DefinedSites {

    @Id
    public Long id;
    public String protein_name;
    public String swiss_prot;
    public String amino_acid_position;

    @OneToMany
    public List<StructureToSiteDefined> strSiteDefined;

    @ManyToOne
    public Proteins proteins;


}
