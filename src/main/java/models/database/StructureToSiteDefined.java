package models.database;

import java.util.*;
import javax.persistence.*;
import com.avaje.ebean.*;

@Entity
@Table(name="structure_to_site_defined", schema="glycosuite")
public class StructureToSiteDefined {

    @Id
    public Long id;
    public String protein_name;
    public String swiss_prot;
    public String amino_acid_position;
    //public String note;
    public int structure_id;
    //public String glycan_type;
    //public int source_id; //make this a relationship

    @ManyToOne
    public DefinedSites definedSites;

}