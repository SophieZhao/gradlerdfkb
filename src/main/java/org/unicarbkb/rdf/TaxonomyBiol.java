package org.unicarbkb.rdf;

import com.avaje.ebean.Ebean;
import models.unicarbkb.Strproteintaxbiolsource;
import models.unicarbkb.Taxonomy;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;

import java.util.List;

import static org.unicarbkb.rdf.ReferenceRDF.createPublication;
import static org.unicarbkb.rdf.StructureRDF.createResourceEntry;
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
                Resource r = model.createResource("http://rdf.unicarbkb.org/taxonomy/" + t.getId()); //+ URLEncoder.encode(t.species.toLowerCase().trim()));
                r.addProperty(RDF.type, "uniprot:taxon"); //trim some \n in db
                r.addProperty(UNIPROT.scientificName, t.species.toLowerCase().trim());
                r.addProperty(RDFS.subClassOf, "<http://purl.uniprot.org/taxonomy/xyz"); //todo need tax id for this!?
            }
        } catch (Exception e) {
            System.out.println("Failed createTaxonomy: " + e);
        }
    }


    /*
    this should have one glycan for given taxonomy
     */
    public static void createSourceReferenceCompound(Model model) {
        List<Strproteintaxbiolsource> strproteintaxbiolsource = Ebean.find(Strproteintaxbiolsource.class).findList();
        for (Strproteintaxbiolsource s : strproteintaxbiolsource) {
            String referenceURI = "http://rdf.unicarbkb.org/referencecompound/" + s.getId(); // + JenaUUID.generate();
            Resource r = null;
            try {
                r = model.createResource(referenceURI);
                r.addProperty(RDF.type, GLYCOVOCAB.referencedCompound);
                r.addProperty(GLYCOVOCAB.hasGlycan, createStructureFromDefinedSite(model, s.structure.id)); //TODO check output
                //Reference ref = Ebean.find(Reference.class, s.reference.id);
                r.addProperty(GLYCOVOCAB.publishedIn, createPublication(s.reference, model));
                r.addProperty(GLYCOVOCAB.hasresourceEntry, createResourceEntry(model, s.structure));
                r.addProperty(GLYCOVOCAB.fromSource, createSource(model, s));
                //TODO ADD HAS_EVIDENCE
            } catch (Exception e) {
                System.out.println("Failed: " + e);
            }
        }
        createTaxonomy(model);
    }

    /*
  Source tells us the taxon and 'has_reference' referencecompound e.g.source linked to glycan structure
   */
    public static Resource createSource(Model model, Strproteintaxbiolsource strproteintaxbiolsource) {
        //List<Sourceref> sourceRef = Ebean.find(Sourceref.class).findList();
        Resource r = null;
        //for (Sourceref sref : sourceRef) {
        String sourceURI = "http://rdf.unicarbkb.org/source/" + strproteintaxbiolsource.getId(); // + JenaUUID.generate(); //TODO replace with NCBI needs db update first ***
        try {
            r = model.createResource(sourceURI);
            r.addProperty(RDF.type, GLYCOVOCAB.hasSourceNatural);
            r.addProperty(GLYCOVOCAB.hasTaxon, "http://purl.uniprot.org/taxonomy/" + "1"); //TODO replace with NCBI needs db update first ***
        } catch (Exception e) {
            System.out.println("Failed: " + e);
        }
        //}
        return r;
    }


}
