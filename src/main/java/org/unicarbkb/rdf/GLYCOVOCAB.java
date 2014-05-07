package org.unicarbkb.rdf;

import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.impl.PropertyImpl;
import com.hp.hpl.jena.reasoner.ReasonerException;

public class GLYCOVOCAB extends Object {

    /** <p>The RDF model that holds the vocabulary terms</p> */
    //private static Model m_model = ModelFactory.createDefaultModel();

    /** <p>The namespace of the vocabulary as a string</p> */
    //public static final String NS = "http://purl.jp/bio/12/glyco/glycan/";

    /** <p>The namespace of the vocabulary as a resource</p> */
    //public static final Resource NAMESPACE = m_model.createResource( NS );

    /**
     * <p>A scholarly academic article, typically published in a journal.</p>
     */
    //public static final Resource AcademicArticle = m_model.createResource( "http://purl.org/ontology/bibo/AcademicArticle" );


    // URI for vocabulary elements
    /* protected static final String uri = "http://purl.jp/bio/12/glyco/glycan/";
	// Return URI for vocabulary elements public static String getURI()
	public static String getURI()
	{
		return uri; }  */

    protected static final String uri = "http://purl.jp/bio/12/glyco/glycan/";

    // Return URI for vocabulary elements public static String getURI()
    public static String getURI() {
        return uri;
    }

    // Define the property labels and objects
    static final String nhasMethod = "has_method";
    public static Property hasMethod = null;


    static final String nhasPmid = "has_pmid";
    public static Property hasPmid = null;

    static final String nabstract = "abstract";
    public static Property nnabstract = null;
    static final String nglycoSequence = "glycosequence";
    public static Property glycosequence = null;
    static final String nhasSequence = "has_sequence";
    public static Property hasSequence = null;

    static final String nhasGlycosylatedAa = "has_glycosylated_AA";
    public static Property hasGlycosylatedAA = null;

    static final String nhasAASequence = "has_AA_sequence";
    public static Property hasAASequence = null;

    static final String nhasUniprotAccession = "has_uniprot_accession";
    public static Property hasUniprotAccession = null;

    static final String naminoAcidType = "amino_acid_type";
    public static Property aminoAcidType = null;

    static final String nmodificationType = "modification_type";
    public static Property modificationType = null;

    static final String nlocation = "location"; //faldo
    public static Property location = null;

    static final String nhasAttachedGlycan = "has_attached_glycan";
    public static Property hasAttachedGlycan = null;

    static final String naminoAcid = "amino_acid";
    public static Property aminoAcid = null;

    static final String nglycosylatedAA = "glycosylated_AA";
    public static Property glycosylatedAA = null;


    // Instantiate the properties and the resource
    static {
        try {
            // Instantiate the properties
            hasMethod = new PropertyImpl(uri, nhasMethod);
            hasPmid = new PropertyImpl(uri, nhasPmid);
            nnabstract = new PropertyImpl(uri, nabstract);

            glycosequence = new PropertyImpl(uri, nglycoSequence);
            hasSequence = new PropertyImpl(uri, nhasSequence);

            hasGlycosylatedAA = new PropertyImpl(uri, nhasGlycosylatedAa);
            hasAASequence = new PropertyImpl(uri, nhasAASequence);
            hasUniprotAccession = new PropertyImpl(uri, nhasUniprotAccession);
            aminoAcidType = new PropertyImpl(uri, naminoAcidType);
            modificationType = new PropertyImpl(uri, nmodificationType);
            hasAttachedGlycan = new PropertyImpl(uri, nhasAttachedGlycan);

            aminoAcid = new PropertyImpl(uri, naminoAcid);
            glycosylatedAA = new PropertyImpl(uri, nglycosylatedAA);


            //status = new PropertyImpl
        } catch (ReasonerException e) {
            //ErrorManager.("POSTCON", 1, e);
        }
    }

}
