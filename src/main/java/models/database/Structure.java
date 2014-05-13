package models.database;

import java.util.*;
import javax.persistence.*;
import com.avaje.ebean.*;

@Entity
@Table(schema="public", name="structure")

public class Structure {

    @Id
    public Long id;

    public String compositionId;
    public String glycanst;
    public String aminolink;
    public String core;
    public String type;
    public String antigenic;
    public String lectin;
    public String endoglycosidase;
    public String link;

    @OneToMany
    public List<Streference> references;

    @OneToMany
    public List<Stproteins> stproteins;

    @OneToMany
    public List<Translation> translation;

    public List<Streference> getReferences() {
        return references;
    }

    public void setReferences(List<Streference> references) {
        this.references = references;
    }

    public List<Stproteins> getStproteins() {
        return stproteins;
    }

    public void setStproteins(List<Stproteins> stproteins) {
        this.stproteins = stproteins;
    }

    public List<Translation> getTranslation() {
        return translation;
    }

    public void setTranslation(List<Translation> translation) {
        this.translation = translation;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompositionId() {
        return compositionId;
    }

    public void setCompositionId(String compositionId) {
        this.compositionId = compositionId;
    }

    public String getGlycanst() {
        return glycanst;
    }

    public void setGlycanst(String glycanst) {
        this.glycanst = glycanst;
    }

    public String getAminolink() {
        return aminolink;
    }

    public void setAminolink(String aminolink) {
        this.aminolink = aminolink;
    }

    public String getCore() {
        return core;
    }

    public void setCore(String core) {
        this.core = core;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAntigenic() {
        return antigenic;
    }

    public void setAntigenic(String antigenic) {
        this.antigenic = antigenic;
    }

    public String getLectin() {
        return lectin;
    }

    public void setLectin(String lectin) {
        this.lectin = lectin;
    }

    public String getEndoglycosidase() {
        return endoglycosidase;
    }

    public void setEndoglycosidase(String endoglycosidase) {
        this.endoglycosidase = endoglycosidase;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    //@OneToMany
    //public List<Strproteintaxbiolsource> strproteintaxbiolsource;
}

/*
<glycan/1>
a glycan:saccharide, owl:NamedIndividual ;
      glycan:has_component
      <http://rdf.glycome-db.org/component/1_x-dglc-HEX-x%3Ax> , <http://rdf.glycome-db.org/component/3_a-dgal-HEX-1%3A5> ;  ///painful bit
      glycan:has_glycosequence
              <http://rdf.glycome-db.org/sequence/46/>
      glycan:has_image <http://www.glycome-db.org/getSugarImage.action?id=46&type=cfg&filetype=svg> , <http://www.glycome-db.org/getSugarImage.action?id=46&type=cfg&filetype=png> ;
      glycan:in_glycan_database^M
              glycan:database_carbbank ;^M
      dcterms:identifier "37272"^^xsd:string .^M


<http://rdf.glycome-db.org/sequence/14657/ct>^M
      a       owl:NamedIndividual , glycan:glycosequence ;^M
      glycan:has_sequence """RES.......  xsd:string ;
      glycan:in_carbohydrate_format^M
              glycan:carbohydrate_format_glycoct .
 */