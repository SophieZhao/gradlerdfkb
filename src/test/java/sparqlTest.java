
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.*;
import org.apache.jena.sparql.engine.binding.Binding;
import org.apache.jena.sparql.engine.http.QueryEngineHTTP;

import org.junit.Test;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;
import models.unicarbkb.Journal;
import org.slf4j.Logger;
import sparql.*;
import sparql.glycobase.GlycanGlycobase;
import sparql.glycobase.GlycoBaseSelectGuSparql;
import sparql.glycobase.GlycobaseSelectSparql;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * Created by matthew on 07/05/2014.
 */
public class sparqlTest {

    @Test
    public void testConnection() {

        String sql = "select count(*) as count from journal";
        SqlRow row =
                Ebean.createSqlQuery(sql)
                        .findUnique();

        Integer i = row.getInteger("count");

        List<Journal> journal = Ebean.find(Journal.class).findList();
        assertNotNull(journal);
    }

    @Test
    public void testSparql() {

        String queryStr = "select distinct ?Concept where {[] a ?Concept} LIMIT 10";
        Query query = QueryFactory.create(queryStr);

        // Remote execution.
        try (QueryExecution qexec = QueryExecutionFactory.sparqlService("http://dbpedia.org/sparql", query)) {
            // Set the DBpedia specific timeout.
            ((QueryEngineHTTP) qexec).addParam("timeout", "10000");

            // Execute.
            ResultSet rs = qexec.execSelect();
            ResultSetFormatter.out(System.out, rs, query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDO() {
        String doid = "1485";
        String queryString = "prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                "prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "prefix owl: <http://www.w3.org/2002/07/owl#>\n" +
                "\n" +
                "select ?s ?p ?o \n" +
                "from <http://purl.obolibrary.org/obo/merged/DOID>\n" +
                "\n" +
                "WHERE {\n" +
                "   <http://purl.obolibrary.org/obo/DOID_" + doid + "> ?p ?o\n" +
                "}";

        Query query = QueryFactory.create(queryString);
        QueryExecution qExe = QueryExecutionFactory.sparqlService("http://sparql.hegroup.org/sparql/", query);
        ResultSet results = qExe.execSelect();
        ResultSetFormatter.out(System.out, results, query) ;

        assertNotNull(results);

        /*Model model = ModelFactory.createDefaultModel();
        Selector selector = new SimpleSelector(null, model.getProperty("<http://www.geneontology.org/formats/oboInOwl#hasDbXref>"), (RDFNode) null);  // you need to cast the last null as otherwise the method is ambigious
        */

        List<String> dbXref = new ArrayList<>();
        List<String> iao = new ArrayList<>();
        List<String> exactSynonym = new ArrayList<>();
        List<String> alternativeId = new ArrayList<>();
        String diseaseLabel;

        while(results.hasNext()){
            QuerySolution querySolution = results.nextSolution();

            if(querySolution.get("p").toString().matches("rdfs:label ")) {
                diseaseLabel = querySolution.get("o").toString();
            }

            if(querySolution.get("p").toString().matches("http://www.geneontology.org/formats/oboInOwl#hasDbXref")){
                System.out.println(querySolution.get("p").toString() + "   " + querySolution.get("o").toString());
                dbXref.add(querySolution.get("o").toString());
            }


            if(querySolution.get("p").toString().matches("http://purl.obolibrary.org/obo/IAO_0000115")){
                System.out.println(querySolution.get("p").toString() + "   " + querySolution.get("o").toString());
                iao.add(querySolution.get("o").toString());
            }

            if(querySolution.get("p").toString().matches("http://www.geneontology.org/formats/oboInOwl#hasExactSynonym")){
                System.out.println(querySolution.get("p").toString() + "   " + querySolution.get("o").toString());
                exactSynonym.add(querySolution.get("o").toString());
            }

            if(querySolution.get("p").toString().matches("http://www.geneontology.org/formats/oboInOwl#hasAlternativeId")){
                System.out.println(querySolution.get("p").toString() + "   " + querySolution.get("o").toString());
                alternativeId.add(querySolution.get("o").toString());
            }

        }

        assertNotNull(dbXref);
        assertNotNull(iao);
    }


    @Test
    public void testDOQuery2() {

            String queryString = "prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                    "prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                    "prefix owl: <http://www.w3.org/2002/07/owl#>\n" +
                    "\n" +
                    "select *\n" +
                    "from <http://purl.obolibrary.org/obo/merged/DOID>\n" +
                    "\n" +
                    "WHERE {\n" +
                    "   <http://purl.obolibrary.org/obo/DOID_1485> <http://www.w3.org/2000/01/rdf-schema#subClassOf> ?o\n" +
                    "}";

            Query query = QueryFactory.create(queryString);
            System.out.println("String: " + queryString);
            QueryExecution qExe = QueryExecutionFactory.sparqlService("http://sparql.hegroup.org/sparql/", query);
            ResultSet results = qExe.execSelect();
            ResultSetFormatter.out(System.out, results, query) ;
    }

    GlycoSequenceSelectSparql getGlycoSequenceSparql() {
        GlycoSequenceSelectSparql ins = new GlycoSequenceSelectSparql();
        SparqlEntity sparqlentity = new SparqlEntity();
        sparqlentity.setValue(Saccharide.PrimaryId, "G00009BX");
        ins.setSparqlEntity(sparqlentity);
        return ins;
    }

    @Test
    public void testSelectSparql() throws SparqlException {
        //logger.debug(getGlycoSequenceSparql().getSparql());

        System.out.println("test query output: " + getGlycoSequenceSparql().getSparql());

        SparqlJena jena = new SparqlJena();
        jena.query( getGlycoSequenceSparql().getSparql() );

        assertEquals(
                " PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan#>\n" +
                        "PREFIX glytoucan:  <http://www.glytoucan.org/glyco/owl/glytoucan#> SELECT DISTINCT ?SaccharideURI\n" +
                        "?PrimaryId\n" +
                        " ?Sequence\n" +
                        " FROM <http://rdf.glytoucan.org>\n" +
                        "FROM <http://rdf.glytoucan.org/sequence/wurcs> WHERE {\n" +
                        "?SaccharideURI a glycan:saccharide .\n" +
                        "?SaccharideURI glytoucan:has_primary_id ?PrimaryId .\n" +
                        "?SaccharideURI glytoucan:has_primary_id \"G00009BX\" .\n" +
                        "?SaccharideURI glycan:has_glycosequence ?GlycanSequenceURI .\n" +
                        "?GlycanSequenceURI glycan:has_sequence ?Sequence .\n" +
                        "}",
                getGlycoSequenceSparql().getSparql());
    }

    GlycobaseSelectSparql getGlycoBaseQuery() {
        GlycobaseSelectSparql glycobase = new GlycobaseSelectSparql();
        SparqlEntity sparqlentity = new SparqlEntity();
        sparqlentity.setValue(Saccharide.PrimaryId, "235");
        glycobase.setSparqlEntity(sparqlentity);
        return glycobase;
    }

    @Test
    public void testSelectGlycobaseEntry() throws SparqlException {
        System.out.println("sparql query is: " + getGlycoBaseQuery().getSparql() );

    }

    GlycobaseSelectSparql getGlycoBaseQueryUoxf() {
        GlycobaseSelectSparql glycobase = new GlycobaseSelectSparql();
        SparqlEntity sparqlentity = new SparqlEntity();
        sparqlentity.setValue(GlycanGlycobase.Uoxf, "A2");
        glycobase.setSparqlEntity(sparqlentity);
        return glycobase;
    }

    @Test
    public void testSelectGlycobaseEntryUoxf() throws SparqlException {
        System.out.println("sparql query is: " + getGlycoBaseQueryUoxf().getSparql() );

    }

    GlycoBaseSelectGuSparql getGlycoBaseQueryGu() {
        GlycoBaseSelectGuSparql glycobase = new GlycoBaseSelectGuSparql();
        SparqlEntity sparqlentity = new SparqlEntity();
        String gu = "6.2";
        gu += "\"^^xsd:float .\n";
        sparqlentity.setValue(GlycanGlycobase.Gu, gu);
        glycobase.setSparqlEntity(sparqlentity);
        return glycobase;
    }

    @Test
    public void testSelectGlycobaseEntryGu() throws SparqlException {
        System.out.println("sparql query is: " + getGlycoBaseQueryGu().getSparql() );

    }


}
