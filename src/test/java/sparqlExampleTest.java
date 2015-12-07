
import org.apache.jena.ontology.Profile;
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

//    GlycobaseSelectSparql getGlycoBaseQuery() {
//        GlycobaseSelectSparql glycobase = new GlycobaseSelectSparql();
//        SparqlEntity sparqlentity = new SparqlEntity();
//        sparqlentity.setValue(Saccharide.PrimaryId, "235");
//        glycobase.setSparqlEntity(sparqlentity);
//        return glycobase;
//    }
//
//    @Test
//    public void testSelectGlycobaseEntry() throws SparqlException {
//        System.out.println("sparql query search by id is: " + getGlycoBaseQuery().getSparql());
//        System.out.println("sparql query search by uoxf is: " + getGlycoBaseQueryUoxf().getSparql());
//
//    }
//
//
//    GlycobaseSelectSparql getGlycoBaseQueryUoxf () {
//        GlycobaseSelectSparql glycobase = new GlycobaseSelectSparql();
//        SparqlEntity sparqlentity = new SparqlEntity();
//        sparqlentity.setValue(GlycanGlycobase.Uoxf, "A2");
//        glycobase.setSparqlEntity(sparqlentity);
//        return glycobase;
//    }
//
//
//    @Test
//    public void testSelectGlycobaseEntryUoxf ()throws SparqlException {
//        System.out.println("sparql query is: " + getGlycoBaseQueryUoxf().getSparql());
//
//    }


//    GlycoBaseSelectGuSparql getGlycoBaseQueryGu() {
//        GlycoBaseSelectGuSparql glycobase = new GlycoBaseSelectGuSparql();
//        SparqlEntity sparqlentity = new SparqlEntity();
//        String gu = "6.2";
//        gu += "\"^^xsd:float .\n";
//        sparqlentity.setValue(GlycanGlycobase.Gu, gu);
//        glycobase.setSparqlEntity(sparqlentity);
//        return glycobase;
//    }
//
//    @Test
//    public void testSelectGlycobaseEntryGu() throws SparqlException {
//        System.out.println("sparql query is: " + getGlycoBaseQueryGu().getSparql());
//
//    }

//    ListProfile getGlycoBaseQueryProfile(){
//        ListProfile profile = new ListProfile();
//        SparqlEntity sparqlentity = new SparqlEntity();
//        profile.setSparqlEntity(sparqlentity);
//
//        return profile;
//    }
//
//    @Test
//    public void testListProfile() throws SparqlException{
//        System.out.println("List hplc profile sparql query is: \n" +getGlycoBaseQueryProfile().getSparql());
//    }

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

    ProfileByUoxf getProfileByUoxf(){
        ProfileByUoxf profile = new ProfileByUoxf();
        SparqlEntity sparqlentity = new SparqlEntity();
        sparqlentity.setValue(GlycanGlycobase.Uoxf, "F(6)A3G(4)3");
        profile.setSparqlEntity(sparqlentity);
        return profile;
    }
    @Test
    public void testProfileByUoxf() throws SparqlException{
        System.out.println("sparql query search profile by uoxf is: \n" +getProfileByUoxf().getSparql());
    }

    SequenceByUoxf getSequenceByUoxf(){
        SequenceByUoxf sequence = new SequenceByUoxf();
        SparqlEntity sparqlentity = new SparqlEntity();
        sparqlentity.setValue(GlycanGlycobase.Uoxf, "F(6)A3G(4)3");
        sequence.setSparqlEntity(sparqlentity);
        return sequence;
    }
    @Test
    public void testSequenceByUoxf() throws SparqlException{
        System.out.println("sparql query search sequence by uoxf is: \n" +getSequenceByUoxf().getSparql());
    }

    ReactionByUoxf getReactionByUoxf(){
        ReactionByUoxf reaction = new ReactionByUoxf();
        SparqlEntity sparqlentity = new SparqlEntity();
        sparqlentity.setValue(GlycanGlycobase.Uoxf, "F(6)A3G(4)3");
        reaction.setSparqlEntity(sparqlentity);
        return reaction;
    }
    @Test
    public void testReactionByUoxf() throws SparqlException{
        System.out.println("sparql query search reaction by uoxf is: \n" +getReactionByUoxf().getSparql());
    }

    LiteratureByUoxf getLiteratureByUoxf(){
        LiteratureByUoxf literature = new LiteratureByUoxf();
        SparqlEntity sparqlentity = new SparqlEntity();
        sparqlentity.setValue(GlycanGlycobase.Uoxf, "F(6)A3G(4)3");
        literature.setSparqlEntity(sparqlentity);
        return literature;
    }
    @Test
    public void testLiteratureByUoxf() throws SparqlException{
        System.out.println("sparql query search literature recorded GU by uoxf is: \n" +getLiteratureByUoxf().getSparql());
    }

    RecordByUoxf getRecordByUoxf(){
        RecordByUoxf record = new RecordByUoxf();
        SparqlEntity sparqlentity = new SparqlEntity();
        sparqlentity.setValue(GlycanGlycobase.Uoxf, "F(6)A3G(4)3");
        record.setSparqlEntity(sparqlentity);
        return record;
    }
    @Test
    public void testRecordByUoxf() throws SparqlException{
        System.out.println("sparql query search all records by uoxf is: \n" +getRecordByUoxf().getSparql());
    }

    StructureByProfile getStructureByProfile(){
        StructureByProfile structure = new StructureByProfile();
        SparqlEntity sparqlentity = new SparqlEntity();
        sparqlentity.setValue(GlycanGlycobase.ProfileId, "02746e8a-c004-4b62-97fe-7923531643e2");
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
        System.out.println("sparql query glycans on protein is: \n" +getGlycanOnProtein().getSparql());
    }

    ListLiterature getLiterature(){
        ListLiterature structure = new ListLiterature();
        SparqlEntity sparqlentity = new SparqlEntity();
        structure.setSparqlEntity(sparqlentity);
        return structure;
    }
    @Test
    public void testListLiterature() throws SparqlException{
        System.out.println("sparql query glycans on protein is: \n" +getLiterature().getSparql());
    }
}
