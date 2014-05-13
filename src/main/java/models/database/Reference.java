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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getMedline() {
        return medline;
    }

    public void setMedline(String medline) {
        this.medline = medline;
    }

    public String getPmid() {
        return pmid;
    }

    public void setPmid(String pmid) {
        this.pmid = pmid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

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
