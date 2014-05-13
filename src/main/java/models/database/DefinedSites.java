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

    public List<StructureToSiteDefined> getStrSiteDefined() {
        return strSiteDefined;
    }

    public void setStrSiteDefined(List<StructureToSiteDefined> strSiteDefined) {
        this.strSiteDefined = strSiteDefined;
    }

    public Proteins getProteins() {
        return proteins;
    }

    public void setProteins(Proteins proteins) {
        this.proteins = proteins;
    }

    public String amino_acid_position;

    @OneToMany
    public List<StructureToSiteDefined> strSiteDefined;

    @ManyToOne
    public Proteins proteins;


}
