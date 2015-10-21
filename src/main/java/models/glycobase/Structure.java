package models.glycobase;

import javax.persistence.*;
import java.util.List;

/**
 * Created by matthew on 19/10/2015.
 */
@Entity
@Table(schema="public", name="structure")
public class Structure {

    @Id
    public Long Id;

    public String glycoct;

    @OneToMany
    public List<Hplc> hplc;

    @OneToMany
    public List<Uplc> uplc;

    @OneToMany
    public List<Ce> ce;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getGlycoct() {
        return glycoct;
    }

    public void setGlycoct(String glycoct) {
        this.glycoct = glycoct;
    }

    public List<Hplc> getHplc() {
        return hplc;
    }

    public void setHplc(List<Hplc> hplc) {
        this.hplc = hplc;
    }

    public List<Uplc> getUplc() {
        return uplc;
    }

    public void setUplc(List<Uplc> uplc) {
        this.uplc = uplc;
    }

    public List<Ce> getCe() {
        return ce;
    }

    public void setCe(List<Ce> ce) {
        this.ce = ce;
    }
}
