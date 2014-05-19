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
    public Long structure_id;
    //public String glycan_type;
    //public int source_id; //make this a relationship

    @ManyToOne
    public DefinedSites definedSites;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProtein_name() {
        return protein_name;
    }

    public void setProtein_name(String protein_name) {
        this.protein_name = protein_name;
    }

    public String getSwiss_prot() {
        return swiss_prot;
    }

    public void setSwiss_prot(String swiss_prot) {
        this.swiss_prot = swiss_prot;
    }

    public String getAmino_acid_position() {
        return amino_acid_position;
    }

    public void setAmino_acid_position(String amino_acid_position) {
        this.amino_acid_position = amino_acid_position;
    }

    public Long getStructure_id() {
        return structure_id;
    }

    public void setStructure_id(Long structure_id) {
        this.structure_id = structure_id;
    }

    public DefinedSites getDefinedSites() {
        return definedSites;
    }

    public void setDefinedSites(DefinedSites definedSites) {
        this.definedSites = definedSites;
    }
}