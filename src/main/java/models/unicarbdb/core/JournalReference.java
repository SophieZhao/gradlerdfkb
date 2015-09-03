/*
 * Copyright (c) 2014. Copyright (c) 2014. Matthew Campbell <matthew.campbell@mq.edu.au>
 *
 * The program can not be distributed to others with out the consent of the copyright holder, until such a time that the copyright holder has released the code for public use.
 */

package models.unicarbdb.core;

import com.avaje.ebean.Page;
import models.hplc.Lcmucin;
import play.db.ebean.Model;

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

}
