package models.database;

import java.util.*;
import javax.persistence.*;
import javax.swing.*;

import com.avaje.ebean.*;
/**
 * Created by matthew on 07/05/2014.
 */

@Entity
@Table(schema="public", name="reference")
public class Reference {

    @Id
    public Long id;

    public String first;

    public int year;

    public String volume;
    public String pages;
    public String medline;
    public String pmid;
    public String title;
    public String authors;
    //public String source;

    //@ManyToOne(fetch=FetchType.EAGER)
    @ManyToOne
    public Journal journal;

    //@OneToMany
    //public List<Streference> streference;

    //@OneToMany
    //public List<Sourceref> sourceref;

    //@OneToMany
    //public List<Refmethod> refmethod;

    // @OneToMany
    //public List<Ftmerge> ftmerge;

    //@OneToMany
    //public List<Strproteintaxbiolsource> strproteintaxbiolsource;
}
