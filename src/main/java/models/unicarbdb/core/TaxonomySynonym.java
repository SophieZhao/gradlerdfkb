/*
 * Copyright (c) 2014. Copyright (c) 2014. Matthew Campbell <matthew.campbell@mq.edu.au>
 *
 * The program can not be distributed to others with out the consent of the copyright holder, until such a time that the copyright holder has released the code for public use.
 */

package models.unicarbdb.core;

import java.util.*;

import javax.persistence.*;





import com.avaje.ebean.*;

@Entity
@Table(schema="core", name="taxomony_synonym" )
public class TaxonomySynonym {

	@Id
	//public Long Id;
	public Long taxonomySynonymId;
	
	//@OneToMany
	public Taxonomy taxonomy;
	public String synonym;

	public Long getTaxonomySynonymId() {
		return taxonomySynonymId;
	}

	public void setTaxonomySynonymId(Long taxonomySynonymId) {
		this.taxonomySynonymId = taxonomySynonymId;
	}

	public Taxonomy getTaxonomy() {
		return taxonomy;
	}

	public void setTaxonomy(Taxonomy taxonomy) {
		this.taxonomy = taxonomy;
	}

	public String getSynonym() {
		return synonym;
	}

	public void setSynonym(String synonym) {
		this.synonym = synonym;
	}
}
