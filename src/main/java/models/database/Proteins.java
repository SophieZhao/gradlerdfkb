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
/*
    @OneToMany
    public List<Proteinstaxonomy> proteinsTax;

    @OneToMany
    public List<Strproteintax> strproteintax;*/

}
