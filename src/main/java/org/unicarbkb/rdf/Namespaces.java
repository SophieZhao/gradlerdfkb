package org.unicarbkb.rdf;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

/**
 * Created by matthew on 07/05/2014.
 */
public class Namespaces {

    public Model model;

    public Model createModel() {
        Model model = ModelFactory.createDefaultModel();
        this.model = model;
        this.addNameSpaces();

        //model.write(System.out, "TTL");
        return model;

    }

    public void addNameSpaces()
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
    }
}
