package org.unicarbkb.rdf;

import com.avaje.ebean.Ebean;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.shared.uuid.JenaUUID;
import com.hp.hpl.jena.vocabulary.OWL2;
import com.hp.hpl.jena.vocabulary.RDF;
import com.hp.hpl.jena.vocabulary.RDFS;
import com.hp.hpl.jena.vocabulary.XSD;
import com.sun.xml.internal.bind.v2.TODO;
import models.database.DefinedSites;
import models.database.Strtaxonomy;
import models.database.Structure;
import models.database.Taxonomy;

import java.util.List;

import static com.hp.hpl.jena.vocabulary.OWL2.NamedIndividual;
import static org.unicarbkb.rdf.StructureRDF.createStructureFromDefinedSite;

public class TaxonomyBiol {

    /*
    Use this to create taxonomy records
    Need to add IDs from uniprot taxonomy
     */
    public static void createTaxonomy(Model model) {
        try {
            List<Taxonomy> taxonomy;
            taxonomy = Ebean.find(Taxonomy.class).findList();
            for (Taxonomy t : taxonomy) {
                Resource r = model.createResource("taxonomy_" + t.species.toLowerCase().trim());
                r.addProperty(RDF.type, "uniprot:taxon"); //trim some \n in db
                r.addProperty(UNIPROT.scientificName, t.species.toLowerCase().trim());
                r.addProperty(RDFS.subClassOf, "<http://purl.uniprot.org/taxonomy/xyz"); //todo need tax id for this!?

                createSource(model, t);

            }
        } catch (Exception e) {
            System.out.println("Failed createBiolcontext: " + e);
        }
    }

    /*
    Source tells us the taxon and 'has_reference' referencecompound e.g.source linked to glycan structure
     */

    public static void createSource(Model model, Taxonomy taxonomy){
        String sourceURI = "source_" + JenaUUID.generate(); //TODO replace with NCBI needs db update first ***
        Resource r = null;
        try{
            r = model.createResource(sourceURI);
            r.addProperty(RDF.type, GLYCOVOCAB.hasSourceNatural);
            r.addProperty(GLYCOVOCAB.hasTaxon, "http://www.uniprot.org/taxonomy/" + "1"); //TODO replace with NCBI needs db update first ***

            List<Strtaxonomy> strtax = taxonomy.strtaxonomy;
            for (Strtaxonomy s : strtax) {
                r.addProperty(GLYCOVOCAB.hasReference, createSourceReferenceCompound(model, sourceURI, taxonomy, s)); //wrong reference?
            }
        } catch (Exception e) {
            System.out.println("Failed: " + e);
        }

    }

    /*
    this should have one glycan for given taxonomy
     */
    public static Resource createSourceReferenceCompound(Model model, String sourceURI, Taxonomy taxonomy, Strtaxonomy strtaxonomy){
        String referenceURI = "referencecompound_" + JenaUUID.generate();
        Resource r = null;
        try {
            r = model.createResource(referenceURI);
            r.addProperty(RDF.type, GLYCOVOCAB.referencedCompound);
            r.addProperty(GLYCOVOCAB.isFromSource, sourceURI);
            r.addProperty(GLYCOVOCAB.hasresourceEntry, sourceURI);
            r.addProperty(GLYCOVOCAB.hasGlycan, createStructureFromDefinedSite(model, strtaxonomy.structure.id) );
            r.addLiteral(GLYCOVOCAB.fromSource, "source_" + "1"); //TODO replace with NCBI needs db update first ***

            //TODO ADD HAS_EVIDENCE
        } catch (Exception e) {
            System.out.println("Failed: " + e);
        }
    return r;
    }
}
