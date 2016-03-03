package org.glycoinfo.rdf.glycan.wurcs;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import sparql.SelectSparqlBean;
import sparql.SparqlException;
import sparql.GlycoSequenceSparql;
import sparql.Saccharide;


/**
 *
 * SelectSparql for retrieving the Wurcs of
 * The filter removes any existing sequences in the getTo() of the GlyConvert.
 *
 * For instance: Retrieving of original glycoct by using
 * org.glycoinfo.conversion.wurcs.GlycoctToWurcsConverter.
 *
 * @author aoki
 *
 */

public class GlycoSequenceSelectSparql extends SelectSparqlBean implements GlycoSequenceSparql {
    private boolean whereset = false;
    public GlycoSequenceSelectSparql(String sparql) {
        super(sparql);
    }

    public GlycoSequenceSelectSparql() {
        super();
        this.prefix = "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
                + "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan#>\n"
                + "PREFIX rogs: <http://http://www.glycoinfo.org/glyco/owl/relation#>\n"
                + "PREFIX glytoucan:  <http://www.glytoucan.org/glyco/owl/glytoucan#>\n";
        this.select = "DISTINCT ?" + Sequence + "\n"
                + "?" + AccessionNumber + "\n";
        this.from = "FROM <http://rdf.glytoucan.org>\n"
                + "FROM <http://rdf.glytoucan.org/core>\n"
                + "FROM <http://rdf.glytoucan.org/isomer>\n"
                + "FROM <http://rdf.glytoucan.org/sequence/wurcs>\n";
        this.where = "?" + SaccharideURI + " a glycan:saccharide .\n"
                + "?" + SaccharideURI + " glytoucan:has_primary_id ?" + AccessionNumber + " .\n"
                + "?" + SaccharideURI + " glycan:has_glycosequence ?" + GlycanSequenceURI + " .\n"
                + "?" + GlycanSequenceURI + " glycan:has_sequence ?" + Sequence + " .\n"
                + "?" + GlycanSequenceURI + " glycan:in_carbohydrate_format glycan:carbohydrate_format_wurcs .\n"
        ;
    }

    public String getPrimaryId() {
        return "\"" + getSparqlEntity().getValue(Saccharide.PrimaryId) + "\"";
    }

    @Override
    public String getWhere() throws SparqlException {
        String whereCopy = this.where;
        if (null != getSparqlEntity() && null != getSparqlEntity().getValue(Saccharide.PrimaryId))
            whereCopy += "?" + SaccharideURI + " glytoucan:has_primary_id " + getPrimaryId() + " .";

        whereCopy += getFilter();

        return whereCopy;
    }

    protected Log logger = LogFactory.getLog(getClass());

    String glycanUri;


    /**
     *
     * the filter removes any sequences that already have a sequence in the
     * GlyConvert.getTo() format.
     *
     * @return
     */
    public String getFilter() {
        if (getSparqlEntity().getValue(IdentifiersToIgnore) != null) {
//			FILTER (?primaryId != "G95801EZ")}
            String filter = "";
            List<String> ignores = (List<String>) getSparqlEntity().getObjectValue(IdentifiersToIgnore);
            for (Iterator iterator = ignores.iterator(); iterator.hasNext();) {
                String string = (String) iterator.next();
                filter += " ?" + Saccharide.PrimaryId + " != \"" + string + "\" ";
                if (iterator.hasNext())
                    filter += " && ";
            }
            String outputFilter = "FILTER (" + filter + ")\n";
            outputFilter += "FILTER NOT EXISTS { ?" + SaccharideURI + " rogs:hasLinkageIsomer ?existingIsomer }";
            return outputFilter;
        }

        if (getSparqlEntity().getValue(FilterMass) != null) {
            return "FILTER NOT EXISTS {\n"
                    + "?" + SaccharideURI + " glytoucan:has_derivatized_mass ?existingmass .\n}";
        }
        return "";
    }
}
