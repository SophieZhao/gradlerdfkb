package models.unicarbkb;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIupac() {
        return iupac;
    }

    public void setIupac(String iupac) {
        this.iupac = iupac;
    }

    public String getCt() {
        return ct;
    }

    public void setCt(String ct) {
        this.ct = ct;
    }

    public String getGws() {
        return gws;
    }

    public void setGws(String gws) {
        this.gws = gws;
    }

    public Structure getStructure() {
        return structure;
    }

    public void setStructure(Structure structure) {
        this.structure = structure;
    }
}
