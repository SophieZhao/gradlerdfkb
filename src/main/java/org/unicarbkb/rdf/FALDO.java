package org.unicarbkb.rdf;

import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.impl.PropertyImpl;
import com.hp.hpl.jena.reasoner.ReasonerException;

public class FALDO {

    protected static final String uri = "http://biohackathon.org/resource/faldo";

    // Return URI for vocabulary elements public static String getURI()
    public static String getURI() {
        return uri;
    }

    // Define the property labels and objects
    static final String nexactPosition = "ExactPosition";
    public static Property ExactPosition = null;

    static final String nlocation = "Location";
    public static Property Location = null;

    static {
        try {
            // Instantiate the properties
            ExactPosition = new PropertyImpl(uri, nexactPosition);
            Location = new PropertyImpl(uri, nlocation);
        } catch (ReasonerException e) {
            //ErrorManager.("POSTCON", 1, e);
        }
    }
}
