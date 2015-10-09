/*
 * Copyright (c) 2014. Copyright (c) 2014. Matthew Campbell <matthew.campbell@mq.edu.au>
 *
 * The program can not be distributed to others with out the consent of the copyright holder, until such a time that the copyright holder has released the code for public use.
 */

package models.unicarbdb.core;

import com.avaje.ebean.Page;
import models.unicarbdb.hplc.Lcmucin;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema="core", name="journal_reference")
public class JournalReference  {
	
	/**
	 * 
	 */
	public static final long serialVersionUID = -4737607419557883329L;

	@Id
    public Long journalReferenceId;

	@ManyToOne
    @Column(name="journal_id")
    @JoinColumn(name="journal_id")
    public Journal journal;

    public Integer pubmedId;

    public String authors;

    public String title;

    public Integer publicationYear;

    public Integer journalVolume;

    public Integer journalStartPage;

    public Integer journalEndPage;
    
    @OneToMany(mappedBy="journalReference")
    public List<models.unicarbdb.hplc.Lcmucin> lcmucin;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getJournalReferenceId() {
        return journalReferenceId;
    }

    public void setJournalReferenceId(Long journalReferenceId) {
        this.journalReferenceId = journalReferenceId;
    }

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

    public Integer getPubmedId() {
        return pubmedId;
    }

    public void setPubmedId(Integer pubmedId) {
        this.pubmedId = pubmedId;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public Integer getJournalVolume() {
        return journalVolume;
    }

    public void setJournalVolume(Integer journalVolume) {
        this.journalVolume = journalVolume;
    }

    public Integer getJournalStartPage() {
        return journalStartPage;
    }

    public void setJournalStartPage(Integer journalStartPage) {
        this.journalStartPage = journalStartPage;
    }

    public Integer getJournalEndPage() {
        return journalEndPage;
    }

    public void setJournalEndPage(Integer journalEndPage) {
        this.journalEndPage = journalEndPage;
    }

    public List<Lcmucin> getLcmucin() {
        return lcmucin;
    }

    public void setLcmucin(List<Lcmucin> lcmucin) {
        this.lcmucin = lcmucin;
    }
}
