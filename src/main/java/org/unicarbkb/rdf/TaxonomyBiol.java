package org.unicarbkb.rdf;

import com.avaje.ebean.Ebean;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.vocabulary.RDF;
import com.hp.hpl.jena.vocabulary.RDFS;
import models.database.Taxonomy;

import java.util.List;

public class TaxonomyBiol {

    /*
    Use this to create taxonomy records
    Need to add IDs from uniprot taxonomy
     */
    public static void createTaxonomy(Model model) {
        try {
            List<Taxonomy> taxonomy;
            taxonomy = Ebean.find(Taxonomy.class).findList();
            for(Taxonomy t : taxonomy){
                Resource r = model.createResource("taxonomy_" + t.species.toLowerCase().trim());
                r.addProperty(RDF.type, "uniprot:taxon" ); //trim some \n in db
                r.addProperty(UNIPROT.scientificName, t.species.toLowerCase().trim() );
                r.addProperty(RDFS.subClassOf, "<http://purl.uniprot.org/taxonomy/xyz" ); //todo need tax id for this!?

            }
        } catch (Exception e) {
            System.out.println("Failed createBiolcontext: " + e);
        }
}
