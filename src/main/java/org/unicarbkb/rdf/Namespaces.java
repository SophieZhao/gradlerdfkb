package org.unicarbkb.rdf;


import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.RDF;

/**
 * Created by matthew on 07/05/2014.
 */
public class Namespaces {

    public Model model;

    private static final String BASE1 = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
    private static final String BASE2 = "http://purl.org/ontology/bibo/";
    private static final String BASE3 = "http://xmlns.com/foaf/0.1/";
    private static final String BASE4 = "http://www.w3.org/2002/07/owl#";
    private static final String BASE5 = "http://purl.jp/bio/12/glyco/glycan/";
    private static final String BASE6 = "http://purl.org/dc/terms/";
    private static final String BASE7 = "http://purl.org/dc/elements/1.1/";
    private static final String BASE8 = "http://www.w3.org/2001/XMLSchema#";
    private static final String BASE9 = "http://www.w3.org/2000/01/rdf-schema#";
    private static final String BASE10 = "http://www.biohackathon.org/resource/faldo/";
    //private static final String BASE11 ="http://purl.uniprot.org/core/Protein/";
    private static final String BASE11 = "http://purl.uniprot.org/core/";
    private static final String BASE12 = "http://www.berkeleybop.org/ontologies/ms.owl";
    private static final String BASE13 = "http://purl.obolibrary.org/obo/uo.owl";

    public Model createModel() {
        Model model = ModelFactory.createDefaultModel();
        this.model = model;

        model.setNsPrefix("rdf", BASE1);
        model.setNsPrefix("bibo", BASE2);
        model.setNsPrefix("foaf", BASE3);
        model.setNsPrefix("owl", BASE4);
        model.setNsPrefix("glycan", BASE5);
        model.setNsPrefix("dcterms", BASE6);
        model.setNsPrefix("dc", BASE7);
        model.setNsPrefix("xsd", BASE8);
        model.setNsPrefix("rdfs", BASE9);
        model.setNsPrefix("faldo", BASE10);
        model.setNsPrefix("uniprot", BASE11);
        model.setNsPrefix("ms", BASE12);
        model.setNsPrefix("pato", BASE13);

        //this.addNameSpaces();
        this.addGlycoSites();
        //model.read("test.ttl");


        //model.write(System.out, "TTL");
        return model;

    }

    /*public void addNameSpaces()
    {
        this.model.setNsPrefix( "rdf", "http://www.w3.org/1999/02/22-rdf-syntax-ns#");
        this.model.setNsPrefix( "bibo", "http://purl.org/ontology/bibo/");
        this.model.setNsPrefix( "foaf", "http://xmlns.com/foaf/0.1/");
        this.model.setNsPrefix( "owl", "http://www.w3.org/2002/07/owl#");
        this.model.setNsPrefix( "glycan", "http://purl.jp/bio/12/glyco/glycan#");
        this.model.setNsPrefix( "dcterms", "http://purl.org/dc/terms/");
        this.model.setNsPrefix( "dc", "http://purl.org/dc/elements/1.1/");
        this.model.setNsPrefix( "xsd", "http://www.w3.org/2001/XMLSchema#");
        this.model.setNsPrefix( "rdfs", "http://www.w3.org/2000/01/rdf-schema#");
        this.model.setNsPrefix( "faldo", "http://biohackathon.org/resource/faldo#");
        this.model.setNsPrefix( "uniprot",  "http://purl.uniprot.org/core/Protein/");
    }*/

    /*
    Create <asp/ser/thr/>
    */
    public void addGlycoSites() {
        Resource asp = model.createResource("asparagine");
        asp.addProperty(RDF.type, GLYCOVOCAB.aminoAcid);
        Resource thr = model.createResource("threonine");
        thr.addProperty(RDF.type, GLYCOVOCAB.aminoAcid);
        Resource ser = model.createResource("serine");
        ser.addProperty(RDF.type, GLYCOVOCAB.aminoAcid);

        //model.write(System.out, "TTL");


    }
}
