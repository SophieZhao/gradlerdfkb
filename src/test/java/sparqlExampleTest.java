
import org.junit.Test;


import sparql.SparqlEntity;
import sparql.SparqlException;
import sparql.glycobase.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * Created by matthew on 07/05/2014.
 */
public class sparqlExampleTest {

    StructureByReport getStructureFromReport(){
        StructureByReport report = new StructureByReport();
        SparqlEntity sparqlentity = new SparqlEntity();
        sparqlentity.setValue(GlycanGlycobase.ReportName, "O-Glycans");
        report.setSparqlEntity(sparqlentity);
        return report;
    }
    @Test
    public void testStructureByReport() throws SparqlException{
        System.out.println("sparql query search by report is: \n" +getStructureFromReport().getSparql());
    }

    StructureBySample getStructureFromSample(){
        StructureBySample sample = new StructureBySample();
        SparqlEntity sparqlentity = new SparqlEntity();
        sparqlentity.setValue(GlycanGlycobase.SampleName, "Cow");
        sample.setSparqlEntity(sparqlentity);
        return sample;
    }
    @Test
    public void testStructureBySample() throws SparqlException{
        System.out.println("sparql query search by sample is: \n" +getStructureFromSample().getSparql());
    }

    StructureByGlycobaseID getStructureByID(){
        StructureByGlycobaseID id = new StructureByGlycobaseID();
        SparqlEntity sparqlentity = new SparqlEntity();
        sparqlentity.setValue(GlycanGlycobase.GlycoBaseId, "723");
        id.setSparqlEntity(sparqlentity);
        return id;
    }
    @Test
    public void testStructureByGlycobaseID() throws SparqlException{
        System.out.println("sparql query search by glycobaseID is: \n" +getStructureByID().getSparql());
    }

    StructureByTissue getStructureByTissue(){
        StructureByTissue tissue = new StructureByTissue();
        SparqlEntity sparqlentity = new SparqlEntity();
        sparqlentity.setValue(GlycanGlycobase.Tissue, "Milk");
        tissue.setSparqlEntity(sparqlentity);
        return tissue;
    }
    @Test
    public void testStructureByTissue() throws SparqlException{
        System.out.println("sparql query search by tissue is: \n" +getStructureByTissue().getSparql());
    }

    StructureByTaxon getStructureByTaxon(){
        StructureByTaxon taxon = new StructureByTaxon();
        SparqlEntity sparqlentity = new SparqlEntity();
        sparqlentity.setValue(GlycanGlycobase.Taxon, "HOMO SAPIENS");
        taxon.setSparqlEntity(sparqlentity);
        return taxon;
    }
    @Test
    public void testStructureByTaxon() throws SparqlException{
        System.out.println("sparql query search by taxon is: \n" +getStructureByTaxon().getSparql());
    }

    ProfileByID getProfileByID(){
        ProfileByID profile = new ProfileByID();
        SparqlEntity sparqlentity = new SparqlEntity();
        sparqlentity.setValue(GlycanGlycobase.GlycoBaseId, "775");
        profile.setSparqlEntity(sparqlentity);
        return profile;
    }
    @Test
    public void testProfileByID() throws SparqlException{
        System.out.println("sparql query search profile by id is: \n" +getProfileByID().getSparql());
    }

    SequenceByID getSequenceByID(){
        SequenceByID sequence = new SequenceByID();
        SparqlEntity sparqlentity = new SparqlEntity();
        sparqlentity.setValue(GlycanGlycobase.GlycoBaseId, "775");
        sequence.setSparqlEntity(sparqlentity);
        return sequence;
    }
    @Test
    public void testSequenceByID() throws SparqlException{
        System.out.println("sparql query search sequence by id is: \n" +getSequenceByID().getSparql());
    }

    IdByUoxf getIdByUoxf(){
        IdByUoxf id = new IdByUoxf();
        SparqlEntity sparqlentity = new SparqlEntity();
        sparqlentity.setValue(GlycanGlycobase.Uoxf, "Gal");
        id.setSparqlEntity(sparqlentity);
        return id;
    }
    @Test
    public void testIdByUoxf() throws SparqlException{
        System.out.println("sparql query search glycobaseId by uoxf is: \n" +getIdByUoxf().getSparql());
    }

    ReactionByID getReactionByID(){
        ReactionByID reaction = new ReactionByID();
        SparqlEntity sparqlentity = new SparqlEntity();
        sparqlentity.setValue(GlycanGlycobase.GlycoBaseId, "775");
        reaction.setSparqlEntity(sparqlentity);
        return reaction;
    }
    @Test
    public void testReactionByID() throws SparqlException{
        System.out.println("sparql query search reaction by id is: \n" +getReactionByID().getSparql());
    }

    LiteratureByID getLiteratureByID(){
        LiteratureByID literature = new LiteratureByID();
        SparqlEntity sparqlentity = new SparqlEntity();
        sparqlentity.setValue(GlycanGlycobase.GlycoBaseId, "775");
        literature.setSparqlEntity(sparqlentity);
        return literature;
    }
    @Test
    public void testLiteratureByID() throws SparqlException{
        System.out.println("sparql query search literature recorded GU by id is: \n" +getLiteratureByID().getSparql());
    }

    RecordByID getRecordByID(){
        RecordByID record = new RecordByID();
        SparqlEntity sparqlentity = new SparqlEntity();
        sparqlentity.setValue(GlycanGlycobase.GlycoBaseId, "775");
        record.setSparqlEntity(sparqlentity);
        return record;
    }
    @Test
    public void testRecordByID() throws SparqlException{
        System.out.println("sparql query search all records by id is: \n" +getRecordByID().getSparql());
    }

    StructureByProfile getStructureByProfile(){
        StructureByProfile structure = new StructureByProfile();
        SparqlEntity sparqlentity = new SparqlEntity();
        sparqlentity.setValue(GlycanGlycobase.ProfileId, "1400");
        structure.setSparqlEntity(sparqlentity);
        return structure;
    }
    @Test
    public void testStructureByProfile() throws SparqlException{
        System.out.println("sparql query search structures by profileID is: \n" +getStructureByProfile().getSparql());
    }

    StructureByGuRange getStructureByGuRange(){
        StructureByGuRange structure = new StructureByGuRange();
        SparqlEntity sparqlentity = new SparqlEntity();
        sparqlentity.setValue(GlycanGlycobase.EvidenceType, "uplc");
        sparqlentity.setValue(GlycanGlycobase.GuLowBoundary, "2");
        sparqlentity.setValue(GlycanGlycobase.GuHighBoundary, "3");
        structure.setSparqlEntity(sparqlentity);
        return structure;
    }
    @Test
    public void testStructureByGuRange() throws SparqlException{
        System.out.println("sparql query search structures by gu range is: \n" +getStructureByGuRange().getSparql());
    }

    ListProfile getListProfile(){
        ListProfile structure = new ListProfile();
        SparqlEntity sparqlentity = new SparqlEntity();
        sparqlentity.setValue(GlycanGlycobase.EvidenceType, "hplc");
        structure.setSparqlEntity(sparqlentity);
        return structure;
    }
    @Test
    public void testListProfile() throws SparqlException{
        System.out.println("sparql query list all profiles is: \n" +getListProfile().getSparql());
    }

    ListStructureOnProtein getGlycanOnProtein(){
        ListStructureOnProtein structure = new ListStructureOnProtein();
        SparqlEntity sparqlentity = new SparqlEntity();
        structure.setSparqlEntity(sparqlentity);
        return structure;
    }
    @Test
    public void testGlycanOnProtein() throws SparqlException{
        System.out.println("sparql query list protein with attached glycan is: \n" +getGlycanOnProtein().getSparql());
    }

    StructureByProtein getStructureByProtein(){
        StructureByProtein structure = new StructureByProtein();
        SparqlEntity sparqlentity = new SparqlEntity();
        sparqlentity.setValue(GlycanGlycobase.ProteinName, "Human IgG");
        structure.setSparqlEntity(sparqlentity);
        return structure;
    }
    @Test
    public void testStructureByProtein() throws SparqlException{
        System.out.println("sparql query glycans on certain protein is: \n" +getStructureByProtein().getSparql());
    }

    ListLiterature getLiterature(){
        ListLiterature structure = new ListLiterature();
        SparqlEntity sparqlentity = new SparqlEntity();
        structure.setSparqlEntity(sparqlentity);
        return structure;
    }
    @Test
    public void testListLiterature() throws SparqlException{
        System.out.println("sparql query list all literatures is: \n" +getLiterature().getSparql());
    }

    StructureByReference getStructureByReference(){
        StructureByReference structure = new StructureByReference();
        SparqlEntity sparqlentity = new SparqlEntity();
        sparqlentity.setValue(GlycanGlycobase.PaperTitle, "HPLC-based analysis of serum N-glycans on a 96-well plate platform with dedicated database software.");
        structure.setSparqlEntity(sparqlentity);
        return structure;
    }
    @Test
    public void testStructureByReference() throws SparqlException{
        System.out.println("sparql query glycans from certain paper is: \n" +getStructureByReference().getSparql());
    }

    ListReport getReport(){
        ListReport report = new ListReport();
        SparqlEntity sparqlentity = new SparqlEntity();
        report.setSparqlEntity(sparqlentity);
        return report;
    }
    @Test
    public void testListReport() throws SparqlException{
        System.out.println("sparql query list all report is: \n" +getReport().getSparql());
    }

    ListSample getSample(){
        ListSample sample = new ListSample();
        SparqlEntity sparqlentity = new SparqlEntity();
        sample.setSparqlEntity(sparqlentity);
        return sample;
    }
    @Test
    public void testListSample() throws SparqlException{
        System.out.println("sparql query list all sample is: \n" +getSample().getSparql());
    }

    ListTaxon getTaxon(){
        ListTaxon taxon = new ListTaxon();
        SparqlEntity sparqlentity = new SparqlEntity();
        taxon.setSparqlEntity(sparqlentity);
        return taxon;
    }
    @Test
    public void testListTaxon() throws SparqlException{
        System.out.println("sparql query list all taxon is: \n" +getTaxon().getSparql());
    }

    ListTissue getTissue(){
        ListTissue tissue = new ListTissue();
        SparqlEntity sparqlentity = new SparqlEntity();
        tissue.setSparqlEntity(sparqlentity);
        return tissue;
    }
    @Test
    public void testListTissue() throws SparqlException{
        System.out.println("sparql query list all tissue is: \n" +getTissue().getSparql());
    }

    AvgHplcGu getAvgHpgu(){
        AvgHplcGu hpgu = new AvgHplcGu();
        SparqlEntity avgHpSpqEntity = new SparqlEntity();
        avgHpSpqEntity.setValue(GlycanGlycobase.GlycoBaseId, "683");
        hpgu.setSparqlEntity(avgHpSpqEntity);
        return hpgu;
    }
    @Test
    public void testAvgHpgu() throws SparqlException{
        System.out.println("sparql query average hplc gu value is: \n" +getAvgHpgu().getSparql());
    }

    AvgUplcGu getAvgUpgu(){
        AvgUplcGu upgu = new AvgUplcGu();
        SparqlEntity avgUpSpqEntity = new SparqlEntity();
        avgUpSpqEntity.setValue(GlycanGlycobase.GlycoBaseId, "683");
        upgu.setSparqlEntity(avgUpSpqEntity);
        return upgu;
    }
    @Test
    public void testAvgUpgu() throws SparqlException{
        System.out.println("sparql query average uplc gu value is: \n" +getAvgUpgu().getSparql());
    }

    AvgRpGu getAvgRpgu(){
        AvgRpGu rpgu = new AvgRpGu();
        SparqlEntity avgRpSpqEntity = new SparqlEntity();
        avgRpSpqEntity.setValue(GlycanGlycobase.GlycoBaseId, "778");
        rpgu.setSparqlEntity(avgRpSpqEntity);
        return rpgu;
    }
    @Test
    public void testAvgRpgu() throws SparqlException{
        System.out.println("sparql query average rplc gu value is: \n" +getAvgRpgu().getSparql());
    }

    AvgCeGu getAvgCegu(){
        AvgCeGu cegu = new AvgCeGu();
        SparqlEntity avgCeSpqEntity = new SparqlEntity();
        avgCeSpqEntity.setValue(GlycanGlycobase.GlycoBaseId, "683");
        cegu.setSparqlEntity(avgCeSpqEntity);
        return cegu;
    }
    @Test
    public void testAvgCegu() throws SparqlException{
        System.out.println("sparql query average ce gu value is: \n" +getAvgCegu().getSparql());
    }
}
