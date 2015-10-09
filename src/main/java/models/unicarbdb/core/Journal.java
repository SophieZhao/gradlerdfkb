/*
 * Copyright (c) 2014. Copyright (c) 2014. Matthew Campbell <matthew.campbell@mq.edu.au>
 *
 * The program can not be distributed to others with out the consent of the copyright holder, until such a time that the copyright holder has released the code for public use.
 */

package models.unicarbdb.core;



import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema="core", name="journal")
public class Journal  {
	
	@Id
    @Column(name="journal_id")
    public Long id;

    public String journalTitle;

    public String journalAbbrev;
    
    @OneToMany
    public List<JournalReference> journalref;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJournalTitle() {
        return journalTitle;
    }

    public void setJournalTitle(String journalTitle) {
        this.journalTitle = journalTitle;
    }

    public String getJournalAbbrev() {
        return journalAbbrev;
    }

    public void setJournalAbbrev(String journalAbbrev) {
        this.journalAbbrev = journalAbbrev;
    }

    public List<JournalReference> getJournalref() {
        return journalref;
    }

    public void setJournalref(List<JournalReference> journalref) {
        this.journalref = journalref;
    }
}
