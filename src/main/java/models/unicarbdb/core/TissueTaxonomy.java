/*
 * Copyright (c) 2014. Copyright (c) 2014. Matthew Campbell <matthew.campbell@mq.edu.au>
 *
 * The program can not be distributed to others with out the consent of the copyright holder, until such a time that the copyright holder has released the code for public use.
 */

package models.unicarbdb.core;

import com.avaje.ebean.Ebean;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table(schema="core", name="tissue_taxonomy")
public class TissueTaxonomy {
	
	    /** Direct children of this TissueTaxonomy. */
	    //public Set<TissueTaxonomy> childTissueTaxonomies = new HashSet<TissueTaxonomy>(0);

	    	@Id
	//@Column(name="id")
	//public Long Id;
	public Long tissueTaxonomyId;
	    /** The direct parent TissueTaxonomy of this one. */
	    public TissueTaxonomy parentTissueTaxonomy;
	    /** Given name for this tissue taxon. */
	    public String tissueTaxon;
	    /** MeSH Identifier */
	    public String meshId;
	    /** Textual description of this tissue taxon, as given by MeSH */
	    public String description;
	    /** Date this entry was last modified. */
	    public Date dateLastModified;
	    /** Set of synonyms for this tissue taxon. */
	    public List<TissueTaxonomySynonym> tissueTaxonomySynonyms; // = new HashSet<TissueTaxonomySynonym>(0);

	    /** Hierachical data for this taxon using Nested Sets. */
	    //public TissueTaxonomyRelations relations;
	    /** The full set of biological contexts that refer to this tissue taxon. */
	    public List<BiologicalContext> biologicalContexts; // = new HashSet<BiologicalContext>(0);


}
