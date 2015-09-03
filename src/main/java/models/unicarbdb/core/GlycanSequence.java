/*
 * Copyright (c) 2014. Copyright (c) 2014. Matthew Campbell <matthew.campbell@mq.edu.au>
 *
 * The program can not be distributed to others with out the consent of the copyright holder, until such a time that the copyright holder has released the code for public use.
 */

package models.unicarbdb.core;

import com.avaje.ebean.Ebean;
import models.hplc.Lcmucin;
import org.eurocarbdb.MolecularFramework.io.GlycoCT.SugarImporterGlycoCTCondensed;
import org.eurocarbdb.MolecularFramework.io.SugarImporterException;
import org.eurocarbdb.MolecularFramework.io.namespace.GlycoVisitorToGlycoCT;
import org.eurocarbdb.MolecularFramework.sugar.Sugar;
import org.eurocarbdb.MolecularFramework.util.visitor.GlycoVisitorException;
import org.eurocarbdb.application.glycanbuilder.*;
import org.eurocarbdb.resourcesdb.Config;
import org.eurocarbdb.resourcesdb.GlycanNamescheme;
import org.eurocarbdb.resourcesdb.io.MonosaccharideConversion;
import org.eurocarbdb.resourcesdb.io.MonosaccharideConverter;
import org.glycomedb.residuetranslator.ResidueTranslator;
import play.data.format.Formats;
import play.db.ebean.Model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

@Entity
@Table(schema = "core", name = "glycan_sequence")
public class GlycanSequence  {

    @Id
    @Column(name="glycan_sequence_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "glycan_sequence_gen")
    @SequenceGenerator(name = "glycan_sequence_gen", sequenceName = "core.glycan_sequence_glycan_sequence_id_seq", allocationSize=1)
    public Long glycanSequenceId;

    /** The original (first) contributor of this glycan sequence. */
    @ManyToOne
    @JoinColumn(name="contributor_id")
    @Column(name="contributor_id")
    private Contributor contributor;

    /**
     * Numeric count of the number of Residues in this glycan sequence.
     */
    private int residueCount;

    /**
     * Monoisotopic mass
     */
    private BigDecimal massMonoisotopic;

    /**
     * Average mass
     */
    private BigDecimal massAverage;

    /**
     * The date/time on which this sequence was entered into Eurocarb.
     */
    //@Formats.DateTime(pattern="dd/MM/yyyy")
    private Date dateEntered = new Date();

    /**
     * Unsure - needs clarification?
     */
    //@Formats.DateTime(pattern="dd/MM/yyyy")
    private Date dateContributed = new Date() ;

    /**
     * The set of {@link BiologicalContext}s associated with
     * this sequence, represented as a set of {@link GlycanSequenceContext}s.
     */
    //@OnetoMany
    private List<GlycanSequenceToBiologicalContext> glycanContexts; // = new HashSet<GlycanSequenceContext>(0);

    /** The set of {@link Reference}s associated with this sequence,
     *   represented as a set of {@link GlycanSequenceReference}s. */
    //private List<GlycanSequenceReference> glycanReferences; //= new HashSet<GlycanSequenceReference>(0);

    /**
     * The set of {@link Evidence} associated with this sequence,
     * represented as a set of {@link GlycanSequenceEvidence}.
     */
    private List<GlycanSequenceToEvidence> glycanEvidence; // = new HashSet<GlycanSequenceEvidence>(0);

    /** Set of individual residues in the sugar sequence encapsulated
     *   by this GlycanSequence. Each GlycanResidue object captures info about
     *   parent/child residues. */
    //private Set<GlycanResidue> glycanResidues = new HashSet<GlycanResidue>();

    /** Contains the actual sequence of the glycan represented by this {@link GlycanSequence} */
    // private SugarSequence sequence;

    /**
     * sequence in iupac format.  @see SequenceFormat#Iupac
     */
    private String sequenceIupac;

    /**
     * sequence in glycoct format.  @see SequenceFormat#Glycoct
     */
    public String sequenceCt;

    /**
     * sequence in stalliano (GWS) format.  @see SequenceFormat#GWS
     */
    public String sequenceGWS;

    /**
     * sequence in glycam format
     */
    private String sequenceGlycam;

    /**
     * True if the {@link SugarSequence} of this GlycanSequence
     * contains no unknown elements.
     */
    //private Boolean isDefinite;

    @OneToMany(mappedBy = "glycanSequence")
    public List<models.unicarbdb.hplc.Lcmucin> lcmucin; //= new HashSet<Lcmucin>(0);

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "glycanSequence")
    public List<GlycanComposition> glycanCompositions;


    //private Set<Structures> structures = new HashSet<Structures>(0);

    //private Set<GlycosuiteStructure> glycosuiteStructures = new HashSet<GlycosuiteStructure>(0);

    // private Set<GlycanSeqToCoresEpitopes> glycanCores = new HashSet<GlycanSeqToCoresEpitopes>(0);

    public static Finder<Long, GlycanSequence> find = new Finder<Long, GlycanSequence>(Long.class, GlycanSequence.class);

    /*
    To be used for updating glycan composition table only, TODO needs  cleaning up
     */



    public void setContributor(Contributor contributor) {
        this.contributor = contributor;
    }

    public void setResidueCount(int residueCount) {
        this.residueCount = residueCount;
    }

    public void setMassMonoisotopic(BigDecimal massMonoisotopic) {
        this.massMonoisotopic = massMonoisotopic;
    }

    public void setMassAverage(BigDecimal massAverage) {
        this.massAverage = massAverage;
    }

    public void setDateEntered(Date dateEntered) {
        this.dateEntered = dateEntered;
    }

    public void setDateContributed(Date dateContributed) {
        this.dateContributed = dateContributed;
    }

    public void setGlycanContexts(List<GlycanSequenceToBiologicalContext> glycanContexts) {
        this.glycanContexts = glycanContexts;
    }

    public void setGlycanEvidence(List<GlycanSequenceToEvidence> glycanEvidence) {
        this.glycanEvidence = glycanEvidence;
    }

    public void setSequenceIupac(String sequenceIupac) {
        this.sequenceIupac = sequenceIupac;
    }

    public void setSequenceCt(String sequenceCt) {
        this.sequenceCt = sequenceCt;
    }

    public void setSequenceGWS(String sequenceGWS) {
        this.sequenceGWS = sequenceGWS;
    }

    public void setSequenceGlycam(String sequenceGlycam) {
        this.sequenceGlycam = sequenceGlycam;
    }

    public void setLcmucin(List<models.unicarbdb.hplc.Lcmucin> lcmucin) {
        this.lcmucin = lcmucin;
    }

    public void setGlycanCompositions(List<GlycanComposition> glycanCompositions) {
        this.glycanCompositions = glycanCompositions;
    }
}
