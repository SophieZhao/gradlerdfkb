/*
 * Copyright (c) 2014. Copyright (c) 2014. Matthew Campbell <matthew.campbell@mq.edu.au>
 *
 * The program can not be distributed to others with out the consent of the copyright holder, until such a time that the copyright holder has released the code for public use.
 */

package models.unicarbdb.core;

import com.avaje.ebean.Ebean;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.beans.Expression;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema="core", name="taxonomy")
//@AttributeOverride(name = "id", column = @Column(name = "taxonomy_id"))
public class Taxonomy  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9205630211054431670L;

	
	//@Column(name="id")
	//@AttributeOverride(name = "Id", column = @Column(name = "taxonomy_id"))
	@Id	
	public Long taxonomyId;
	

	public Taxonomy parentTaxonomy;

	//public NcbiTaxonomy ncbiTaxonomy;
	public int ncbiId;

	public String rank;

	/** Taxon name. Note that internally this is always lower-case, and 
	 *   first-letter-upper-cased on access. */
	public String taxon;

	//public TaxonomyRelations relations;

	//public Set<Taxonomy> childTaxonomies = new HashSet<Taxonomy>(0);

	@OneToMany
	public List<BiologicalContext> biologicalContexts; // = new HashSet<BiologicalContext>(0);

	//@OneToMany
	//public List<TaxonomySynonym> taxonomySynonyms; // = new HashSet<TaxonomySynonym>(0);

	//public Set<TaxonomySubtype> taxonomySubtypes = new HashSet<TaxonomySubtype>(0);

	//public Set<TaxonomySubtype> taxonomySupertypes = new HashSet<TaxonomySubtype>(0);

	public enum Rank
	{
		Kingdom,
		Phylum,
		Class,
		Order,
		Family,
		Genus,
		Species,
		Subspecies,
		Unranked;
	}


    public String getTaxon() {
        return taxon;
    }

    public void setTaxon(String taxon) {
        this.taxon = taxon;
    }
}
