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

    //static final String nglycoSequence = "glycosequence";
    //public static Property hasGlycosequence = null;

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

    static final String nhasGlycan = "has_glycan";
    public static Property hasGlycan = null;

    static final String naminoAcid = "amino_acid";
    public static Property aminoAcid = null;

    static final String nglycosylatedAA = "glycosylated_AA";
    public static Property glycosylatedAA = null;

    static final String ninCarbohydrateFormat = "in_carbohydrate_format";
    public static Property inCarbohydrateFormat = null;

    static final String ncarbohydrateFormatGlycoct  = "carbohydrate_format_glycoct";
    public static Property carbohydrateFormatGlycoct = null;

    static final String nCarbohydrateFormatGlyde = "carbohydrate_format_glyde2";
    public static Property carbohydrateFormatGlyde = null;

    static final String ncarbohydrateFormatIupac  = "carbohydrate_format_condensediupac"; //TODO CHECK DEFINITION
    public static Property carbohydrateFormatIupac = null;

    static final String nglycosequence = "glycosequence";
    public static Property glycosequence = null;

    static final String nsaccharide = "saccharide";
    public static Property saccharide = null;

    static final String nproteinName = "has_protein_name"; //TODO ADD TO ONTOLOGY
    public static Property hasProteinName = null;

    static final String nhasSourceNatural = "source_natural";
    public static Property hasSourceNatural = null;

    static final String nhasTaxon = "has_taxon";
    public static Property hasTaxon = null;

    static final String nhasReference = "has_reference";
    public static Property hasReference = null;

    static final String nreferencedCompound = "referenced_compound";
    public static Property referencedCompound = null;

    static final String nfromSource = "is_from_source";
    public static Property fromSource = null;

    static final String nresourceEntry = "resource_entry";
    public static Property resourceEntry = null;
    static final String nhasResourceEntry = "has_resource_entry";
    public static Property hasresourceEntry = null;

    static final String nisFromSource = "is_from_source";
    public static Property isFromSource = null;



    static final String ninGlycanDatabase = "in_glycan_database";
    public static Property inGlycanDatabase = null;

    static final String ninKB = "database_unicarbkb";
    public static Property inKB = null;

    static final String nhasEvidence = "has_evidence";
    public static Property hasEvidence = null;

    static final String npublishedIn = "published_in";
    public static Property publishedIn = null;

    static final String ncomponent = "component";
    public static Property component = null;
    static final String nhasComponent = "has_component";
    public static Property hasComponent = null;

    static final String nhasCardinality = "has_cardinality";
    public static Property hasCardinality = null;
    static final String nhasMonosaccharide = "has_monosaccharide";
    public static Property hasMonosaccharide = null;



    // Instantiate the properties and the resource
    static {
        try {
            // Instantiate the properties
            hasMethod = new PropertyImpl(uri, nhasMethod);
            hasPmid = new PropertyImpl(uri, nhasPmid);
            nnabstract = new PropertyImpl(uri, nabstract);

            //hasGlycosequence = new PropertyImpl(uri, nglycoSequence);
            hasSequence = new PropertyImpl(uri, nhasSequence);

            hasGlycosylatedAA = new PropertyImpl(uri, nhasGlycosylatedAa);
            hasAASequence = new PropertyImpl(uri, nhasAASequence);
            hasUniprotAccession = new PropertyImpl(uri, nhasUniprotAccession);
            aminoAcidType = new PropertyImpl(uri, naminoAcidType);
            modificationType = new PropertyImpl(uri, nmodificationType);
            hasAttachedGlycan = new PropertyImpl(uri, nhasAttachedGlycan);
            hasGlycan = new PropertyImpl(uri, nhasGlycan);

            aminoAcid = new PropertyImpl(uri, naminoAcid);
            glycosylatedAA = new PropertyImpl(uri, nglycosylatedAA);
            inCarbohydrateFormat = new PropertyImpl(uri, ninCarbohydrateFormat);

            carbohydrateFormatGlycoct = new PropertyImpl(uri, ncarbohydrateFormatGlycoct);
            carbohydrateFormatIupac = new PropertyImpl(uri, ncarbohydrateFormatIupac);
            carbohydrateFormatGlyde = new PropertyImpl(uri, nCarbohydrateFormatGlyde);

            glycosequence = new PropertyImpl(uri, nglycosequence);
            saccharide = new PropertyImpl(uri, nsaccharide);

            hasProteinName = new PropertyImpl(uri, nproteinName); //TODO ABOVE
            hasSourceNatural = new PropertyImpl(uri, nhasSourceNatural);
            hasTaxon = new PropertyImpl(uri, nhasTaxon);
            hasReference = new PropertyImpl(uri, nhasReference);
            referencedCompound = new PropertyImpl(uri, nreferencedCompound);
            fromSource = new PropertyImpl(uri, nfromSource);
            resourceEntry = new PropertyImpl(uri, nresourceEntry);

            isFromSource = new PropertyImpl(uri, nisFromSource);

            hasresourceEntry = new PropertyImpl(uri, nhasResourceEntry);
            inGlycanDatabase = new PropertyImpl(uri, ninGlycanDatabase);
            inKB = new PropertyImpl(uri, ninKB);
            hasEvidence = new PropertyImpl(uri, nhasEvidence);
            publishedIn = new PropertyImpl(uri, npublishedIn);
            component = new PropertyImpl(uri, ncomponent);
            hasCardinality = new PropertyImpl(uri, nhasCardinality);
            hasMonosaccharide = new PropertyImpl(uri, nhasMonosaccharide);
            hasComponent = new PropertyImpl(uri, nhasComponent);

            //status = new PropertyImpl
        } catch (ReasonerException e) {
            //ErrorManager.("POSTCON", 1, e);
        }
    }

}
