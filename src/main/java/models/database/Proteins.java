package models.database;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.*;

@Entity
@Table(schema="public", name="proteins")
public class Proteins {

    @Id
    public Long id;

    public String name;

    public String swissProt;

    public String description;

    @OneToMany
    public List<Stproteins> stproteins;

    //@ManyToOne
    //public List<ProteinGlycosylationSites> proteinsites;

    //@OneToMany
    //public List<StructureToSites> stsite;

/*
these to follow
 */
    /*@OneToMany
    public List<GeneralSites> proteinGeneralSites;
*/
    @OneToMany
    public List<DefinedSites> proteinDefinedSites;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSwissProt() {
        return swissProt;
    }

    public void setSwissProt(String swissProt) {
        this.swissProt = swissProt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Stproteins> getStproteins() {
        return stproteins;
    }

    public void setStproteins(List<Stproteins> stproteins) {
        this.stproteins = stproteins;
    }

    public List<DefinedSites> getProteinDefinedSites() {
        return proteinDefinedSites;
    }

    public void setProteinDefinedSites(List<DefinedSites> proteinDefinedSites) {
        this.proteinDefinedSites = proteinDefinedSites;
    }
/*
    @OneToMany
    public List<Proteinstaxonomy> proteinsTax;

    @OneToMany
    public List<Strproteintax> strproteintax;*/

}
