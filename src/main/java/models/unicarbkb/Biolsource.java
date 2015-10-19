package models.unicarbkb;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public String getTaxonomy() {
        return taxonomy;
    }

    public void setTaxonomy(String taxonomy) {
        this.taxonomy = taxonomy;
    }

    public String getSwiss_prot() {
        return swiss_prot;
    }

    public void setSwiss_prot(String swiss_prot) {
        this.swiss_prot = swiss_prot;
    }

    public List<Sourceref> getSourceref() {
        return sourceref;
    }

    public void setSourceref(List<Sourceref> sourceref) {
        this.sourceref = sourceref;
    }
}

