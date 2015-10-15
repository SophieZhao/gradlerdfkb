package org.unicarbkb.rdf;

import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.impl.PropertyImpl;
import org.apache.jena.reasoner.ReasonerException;


public class BIBOVOCAB extends Object {

    // URI for vocabulary elements
    protected static final String uri = "http://purl.org/ontology/bibo/";

    // Return URI for vocabulary elements public static String getURI()
    public static String getURI() {
        return uri;
    }

    // Define the property labels and objects
    static final String npageStart = "pageStart";
    public static Property pageStart = null;
    static final String npageEnd = "pageEnd";
    public static Property pageEnd = null;


    static final String nabstract = "abstract";
    public static Property nnabstract = null;
    static final String nvolume = "volume";
    public static Property volume = null;

    static final String ntitle = "title";
    public static Property title = null;

    static final String nshortTitle = "shortTitle";
    public static Property shortTitle = null;

    static final String njournal = "Journal";
    public static Property journal = null;

    static final String narticle = "Article";
    public static Property article = null;

    static final String nauthorList = "authorList";
    public static Property authorList = null;

    static final String nhasMethod = "has_method";
    public static Property hasMethod = null;

    // Instantiate the properties and the resource
    static {
        try {
            // Instantiate the properties
            pageStart = new PropertyImpl(uri, npageStart);
            pageEnd = new PropertyImpl(uri, npageEnd);


            nnabstract = new PropertyImpl(uri, nabstract);
            volume = new PropertyImpl(uri, nvolume);

            title = new PropertyImpl(uri, ntitle);
            shortTitle = new PropertyImpl(uri, nshortTitle);
            journal = new PropertyImpl(uri, njournal);
            article = new PropertyImpl(uri, narticle);
            authorList = new PropertyImpl(uri, nauthorList);

            hasMethod = new PropertyImpl(uri, nhasMethod);

            //status = new PropertyImpl
        } catch (ReasonerException e) {
            //ErrorManager.("POSTCON", 1, e);
        }
    }
}
