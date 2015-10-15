package org.unicarbkb.rdf;


import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.impl.PropertyImpl;
import org.apache.jena.reasoner.ReasonerException;

public class UNIPROT {

    protected static final String uri = "http://purl.uniprot.org/core/";
    public static RDFNode uniprotAccession;

    // Return URI for vocabulary elements public static String getURI()
    public static String getURI() {
        return uri;
    }

    static final String nscientificName = "scientificName";
    public static Property scientificName = null;

    static {
        try {
            // Instantiate the properties
            scientificName = new PropertyImpl(uri, nscientificName);
        } catch (ReasonerException e) {
            //ErrorManager.("POSTCON", 1, e);
        }

    }
}
