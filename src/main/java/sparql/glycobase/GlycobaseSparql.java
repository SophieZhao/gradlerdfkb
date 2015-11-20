package sparql.glycobase;

import sparql.Saccharide;

/**
 * Created by matthew on 19/11/15.
 */
public interface GlycobaseSparql {
    public static final String Format = "GlycoSequenceFormat";
    public static final String Sequence = "Sequence";
    public static final String URI = "GlycoSequenceURI";
    public static final String AccessionNumber = Saccharide.PrimaryId;
    public static final String SaccharideURI = Saccharide.URI;
    public static final String GlycanSequenceURI = "GlycanSequenceURI";
    public static final String IdentifiersToIgnore = "GlycanSequenceIdentifiersToIgnore";
    public static final String FilterMass = "GlycanSequenceFilterMass";
}
