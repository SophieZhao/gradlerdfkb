/*
 * Copyright (c) 2014. Copyright (c) 2014. Matthew Campbell <matthew.campbell@mq.edu.au>
 *
 * The program can not be distributed to others with out the consent of the copyright holder, until such a time that the copyright holder has released the code for public use.
 */

package models.unicarbdb.core;

import play.db.ebean.Model;

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

}
