package org.unicarbkb.rdf;

import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.impl.PropertyImpl;
import com.hp.hpl.jena.reasoner.ReasonerException;

/**
 * Created by matthew on 8/05/2014.
 */
public class UNIPROT {

    protected static final String uri = "http://purl.uniprot.org/core/Protein/";
    public static RDFNode uniprotAccession;

    // Return URI for vocabulary elements public static String getURI()
    public static String getURI() {
        return uri;
    }


}
