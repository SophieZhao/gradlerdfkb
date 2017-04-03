
import models.unicarbkb.Structure;
import models.unicarbkb.Translation;
import org.apache.commons.lang3.StringUtils;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.*;
import org.apache.jena.sparql.engine.http.QueryEngineHTTP;

import org.eurocarbdb.application.glycanbuilder.BuilderWorkspace;
import org.eurocarbdb.application.glycanbuilder.GlycanRenderer;
import org.eurocarbdb.application.glycanbuilder.GlycanRendererAWT;
import org.junit.Test;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;
import models.unicarbkb.Journal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.*;

import sparql.*;
import sparql.glycobase.GlycanGlycobase;
import sparql.glycobase.GlycoBaseSelectGuSparql;
import sparql.glycobase.GlycobaseSelectSparql;
import sparql.wurcs.GlycoSequenceToWurcsSelectSparql;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * Created by matthew on 07/05/2014.
 */
public class sparqlTest {

    public static Logger logger = (Logger) LoggerFactory
            .getLogger(sparqlTest.class);


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

        List<String> dbXref = new ArrayList<String>();
        List<String> iao = new ArrayList<String>();
        List<String> exactSynonym = new ArrayList<String>();
        List<String> alternativeId = new ArrayList<String>();
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

    @Test
    public void testGlycotoucanCTSearch() {

        List<Structure> structures = Ebean.find(Structure.class).findList();
        String ct = "";

        for(Structure structure : structures) {
            if (structure.id >= 7400) {

                if (structure.glycanst.startsWith("v--")) {
                    structure.glycanst = structure.glycanst.replace("v--", "FreeEnd--");
                }

                if (structure.glycanst.startsWith("FreenEnd")) {
                    structure.glycanst = structure.glycanst.replace("FreenEnd", "FreeEnd");
                }

                if (structure.glycanst.startsWith("FreeEnd?")) {
                    structure.glycanst = structure.glycanst.replace("FreeEnd?", "FreeEnd--?");
                }

                if (structure.glycanst.startsWith("<Gly") || structure.glycanst.contains("0.0000u")) {
                    continue;
                }

                System.out.println(structure.getGlycanst());

                BuilderWorkspace workspace = new BuilderWorkspace(new GlycanRendererAWT());
                workspace.setNotation("cfg"); //cfgbw | uoxf | uoxfcol | text


                GlycanRenderer renderer = workspace.getGlycanRenderer();

                org.eurocarbdb.application.glycanbuilder.Glycan glycan = org.eurocarbdb.application.glycanbuilder.Glycan.fromString(structure.glycanst);
                ct = glycan.toGlycoCTCondensed();

                //System.out.println(ct);
                //  }
                //}

        /*String ct = "RES\\n" +
                "1b:a-dgal-HEX-1:5\\n" +
                "2s:n-acetyl\\n" +
                "3b:b-dgal-HEX-1:5\\n" +
                "4b:a-lgal-HEX-1:5|6:d\\n" +
                "5b:a-dgal-HEX-1:5\\n" +
                "6s:n-acetyl\\n" +
                "7b:b-dglc-HEX-1:5\\n" +
                "8s:n-acetyl\\n" +
                "LIN\\n" +
                "1:1d(2+1)2n\\n" +
                "2:1o(3+1)3d\\n" +
                "3:3o(2+1)4d\\n" +
                "4:3o(3+1)5d\\n" +
                "5:5d(2+1)6n\\n" +
                "6:1o(6+1)7d\\n" +
                "7:7d(2+1)8n";

        ct = "RES\n" +
                "1b:b-dglc-HEX-1:5\n" +
                "2s:n-acetyl\n" +
                "3b:b-dglc-HEX-1:5\n" +
                "4s:n-acetyl\n" +
                "5b:b-dman-HEX-1:5\n" +
                "6b:a-dman-HEX-1:5\n" +
                "7b:a-dman-HEX-1:5\n" +
                "8b:a-lgal-HEX-1:5|6:d\n" +
                "LIN\n" +
                "1:1d(2+1)2n\n" +
                "2:1o(4+1)3d\n" +
                "3:3d(2+1)4n\n" +
                "4:3o(4+1)5d\n" +
                "5:5o(3+1)6d\n" +
                "6:5o(6+1)7d\n" +
                "7:1o(6+1)8d\n" +
                "UND\n" +
                "UND1:100.0:100.0\n" +
                "ParentIDs:1|3|5|6|7|8\n" +
                "SubtreeLinkageID1:x(-1+1)x\n" +
                "RES\n" +
                "9b:b-dglc-HEX-1:5\n" +
                "10s:n-acetyl\n" +
                "11b:a-lgal-HEX-1:5|6:d\n" +
                "12b:b-dgal-HEX-1:5\n" +
                "13b:a-dgro-dgal-NON-2:6|1:a|2:keto|3:d\n" +
                "14s:n-acetyl\n" +
                "LIN\n" +
                "8:9d(2+1)10n\n" +
                "9:9o(3+1)11d\n" +
                "10:9o(4+1)12d\n" +
                "11:12o(-1+2)13d\n" +
                "12:13d(5+1)14n\n" +
                "UND2:100.0:100.0\n" +
                "ParentIDs:1|3|5|6|7|8\n" +
                "SubtreeLinkageID1:x(-1+1)x\n" +
                "RES\n" +
                "15b:b-dglc-HEX-1:5\n" +
                "16s:n-acetyl\n" +
                "17b:a-lgal-HEX-1:5|6:d\n" +
                "18b:b-dgal-HEX-1:5\n" +
                "LIN\n" +
                "13:15d(2+1)16n\n" +
                "14:15o(3+1)17d\n" +
                "15:15o(4+1)18d\n" +
                "UND3:100.0:100.0\n" +
                "ParentIDs:1|3|5|6|7|8\n" +
                "SubtreeLinkageID1:x(-1+1)x\n" +
                "RES\n" +
                "19b:b-dglc-HEX-1:5\n" +
                "20s:n-acetyl\n" +
                "21b:b-dgal-HEX-1:5\n" +
                "LIN\n" +
                "16:19d(2+1)20n\n" +
                "17:19o(4+1)21d";
                */

                ct = ct.replaceAll("\n", "\\\\n").replaceAll("x\\(", "u\\(").replaceAll("\\)x", "\\)u" );
                System.out.println("new ct: " + ct);

                String queryString = "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n" +
                        "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan#>\n" +
                        "PREFIX wurcs: <http://www.glycoinfo.org/glyco/owl/wurcs#>\n" +
                        "SELECT DISTINCT ?glycan ?c\n" +
                        "# FROM <http://rdf.glycoinfo.org/wurcs/0.5.0>\n" +
                        "# FROM <http://rdf.glycoinfo.org/wurcs/0.5.0/ms>\n" +
                        "WHERE {\n" +
                        "  ?glycan a \tglycan:glycosequence ;\n" +
                        "\tglycan:in_carbohydrate_format  glycan:carbohydrate_format_glycoct ;\n" +
                        "\tglycan:has_sequence\n" +
                         "\t\t?c filter(contains(?c, \"RES\\n1b:b-dglc-HEX-1\")) .\n" +
                        //"\t\t?c filter(contains(?c, \"" + ct + "\" )) .\n" +
                        "\n" +
                        "  }\n" +
                        "  ORDER BY ?glycan\n" +
                        "limit 10";


                System.out.println("String: " + queryString  +"\t\tID: " + structure.id);

                Query query = QueryFactory.create(queryString);

                QueryExecution qExe = QueryExecutionFactory.sparqlService("http://test.ts.glytoucan.org/sparql", query);
                ResultSet results = qExe.execSelect();
                ResultSetFormatter.out(System.out, results, query);

            }
        }
    }

    @Test
    public void testWURCS(){

        String ct = "RES\n" +
                "1b:b-dglc-HEX-1:5\n" +
                "2s:n-acetyl\n" +
                "3b:b-dglc-HEX-1:5\n" +
                "4s:n-acetyl\n" +
                "5b:b-dman-HEX-1:5\n" +
                "6b:a-dman-HEX-1:5\n" +
                "7b:a-dman-HEX-1:5\n" +
                "8b:a-dman-HEX-1:5\n" +
                "9b:a-dman-HEX-1:5\n" +
                "10b:a-dman-HEX-1:5\n" +
                "LIN\n" +
                "1:1d(2+1)2n\n" +
                "2:1o(4+1)3d\n" +
                "3:3d(2+1)4n\n" +
                "4:3o(4+1)5d\n" +
                "5:5o(3+1)6d\n" +
                "6:6o(2+1)7d\n" +
                "7:5o(6+1)8d\n" +
                "8:8o(3+1)9d\n" +
                "9:8o(6+1)10d\n" +
                "UND\n" +
                "UND1:100.0:100.0\n" +
                "ParentIDs:7|9|10\n" +
                "SubtreeLinkageID1:o(2+1)d\n" +
                "RES\n" +
                "11b:a-dman-HEX-1:5";

        ct = ct.replaceAll("\n", "\\\\n");

        String queryString = "PREFIX glycan: <http://purl.jp/bio/12/glyco/glycan#>\n" +
                "PREFIX glytoucan:  <http://www.glytoucan.org/glyco/owl/glytoucan#>\n" +
                "PREFIX  xsd:  <http://www.w3.org/2001/XMLSchema#>\n" +
                "\n" +
                "SELECT DISTINCT ?Sequence\n" +
                "FROM <http://rdf.glytoucan.org>\n" +
                "FROM <http://rdf.glytoucan.org/sequence/wurcs>\n" +
                "\n" +
                "WHERE {\n" +
                "?SaccharideURI a glycan:saccharide .\n" +
                "?SaccharideURI glycan:has_glycosequence ?GlycanSequenceURI .\n" +
                "?GlycanSequenceURI glycan:has_sequence ?Sequence .\n" +
                "?GlycanSequenceURI glycan:in_carbohydrate_format glycan:carbohydrate_format_wurcs .\n" +
                "?SaccharideURI glycan:has_glycosequence ?FormatGlycoSequenceURI .\n" +
                "?FormatGlycoSequenceURI glycan:in_carbohydrate_format glycan:carbohydrate_format_glycoct .\n" +
                "?FormatGlycoSequenceURI glycan:has_sequence" + " \"" + ct + "\"" + "^^xsd:string ." +
                "}";

        System.out.println("String: " + queryString );

        Query query = QueryFactory.create(queryString);

        QueryExecution qExe = QueryExecutionFactory.sparqlService("http://test.ts.glytoucan.org/sparql", query);
        ResultSet results = qExe.execSelect();
        ResultSetFormatter.out(System.out, results, query);
    }

    @Test
    public void testSelectToWurcsSparql() throws SparqlException, UnsupportedEncodingException {
        GlycoSequenceToWurcsSelectSparql s = new GlycoSequenceToWurcsSelectSparql("glycoct");
        SparqlEntity se = new SparqlEntity();
        se.setValue(GlycoSequenceToWurcsSelectSparql.FromSequence, "RES\n1b:a-dgal-HEX-1:5\n2s:n-acetyl\n3b:b-dgal-HEX-1:5\n4b:b-dglc-HEX-1:5\n5s:n-acetyl\n6b:b-dgal-HEX-1:5\n7b:a-lgal-HEX-1:5|6:d\n8b:b-dglc-HEX-1:5\n9s:n-acetyl\n10b:b-dglc-HEX-1:5\n11s:n-acetyl\n12b:b-dgal-HEX-1:5\n13b:a-lgal-HEX-1:5|6:d\nLIN\n1:1d(2+1)2n\n2:1o(3+1)3d\n3:3o(3+1)4d\n4:4d(2+1)5n\n5:4o(4+1)6d\n6:6o(2+1)7d\n7:3o(6+1)8d\n8:8d(2+1)9n\n9:1o(6+1)10d\n10:10d(2+1)11n\n11:10o(4+1)12d\n12:12o(2+1)13d".replaceAll("\n", "\\\\n"));
        s.setSparqlEntity(se);
        logger.debug(s.getSparql());
        Query query = QueryFactory.create(s.getSparql().replaceAll("null", "").replace("?Sequence", ""));
//        QueryExecution qe = QueryExecutionFactory.sparqlService("http://localhost:3030/glycobase/query",query);
        QueryExecution qe = QueryExecutionFactory.sparqlService("http://test.ts.glytoucan.org/sparql",query);
        ResultSet rs = qe.execSelect();

        List<SparqlEntity> results = new ArrayList<SparqlEntity>();

        while (rs.hasNext()) {
            QuerySolution row = rs.next();
            Iterator<String> columns = row.varNames();
            SparqlEntity se2 = new SparqlEntity();
            while (columns.hasNext()) {
                String column = columns.next();
                RDFNode cell = row.get(column);

                if (cell.isResource()) {
                    Resource resource =  cell.asResource();
                    //do something maybe with the OntModel???
                    if (resource.isLiteral())
                        se.setValue(column, resource.asLiteral().getString());
                    else
                        se.setValue(column, resource.toString());
                }
                else if (cell.isLiteral()) {
                    se.setValue(column, cell.asLiteral().getString());
                } else if (cell.isAnon()) {
                    se.setValue(column, "anon");
                } else {
                    se.setValue(column, cell.toString());
                }
            }
            results.add(se);
        }

        for(SparqlEntity entity : results){
            System.out.println("results: " + entity.getValue("PrimaryId"));

        }
    }

    @Test
    public void testKBtoWurcsSparql()  throws SparqlException {

        List<Structure> structures = Ebean.find(Structure.class).findList();
        HashSet<String> resultList = new HashSet<String>();

        String ct = "";

        for(Structure structure : structures) {
            if (structure.id >= 7400  ) {

                if (structure.glycanst.startsWith("v--")) {
                    structure.glycanst = structure.glycanst.replace("v--", "FreeEnd--");
                }

                if (structure.glycanst.startsWith("FreenEnd")) {
                    structure.glycanst = structure.glycanst.replace("FreenEnd", "FreeEnd");
                }

                if (structure.glycanst.startsWith("FreeEnd?")) {
                    structure.glycanst = structure.glycanst.replace("FreeEnd?", "FreeEnd--?");
                }

                if (structure.glycanst.startsWith("<Gly") || structure.glycanst.contains("0.0000u")) {
                    continue;
                }

                System.out.println(structure.getGlycanst());

                BuilderWorkspace workspace = new BuilderWorkspace(new GlycanRendererAWT());
                workspace.setNotation("cfg"); //cfgbw | uoxf | uoxfcol | text
                GlycanRenderer renderer = workspace.getGlycanRenderer();
                org.eurocarbdb.application.glycanbuilder.Glycan glycan = org.eurocarbdb.application.glycanbuilder.Glycan.fromString(structure.glycanst.trim());
                if(glycan != null) {
                    ct = glycan.toGlycoCTCondensed();
                    System.out.println("this was the ct: " + ct);
                    GlycoSequenceToWurcsSelectSparql s = new GlycoSequenceToWurcsSelectSparql("glycoct");
                    SparqlEntity se = new SparqlEntity();
                    ct = StringUtils.chomp(ct);
                    se.setValue(GlycoSequenceToWurcsSelectSparql.FromSequence, ct.replaceAll("\n", "\\\\n").replaceAll("x\\(", "u\\(").replaceAll("\\)x", "\\)u").trim());
                    s.setSparqlEntity(se);
                    logger.debug(s.getSparql());

                    Query query = QueryFactory.create(s.getSparql().replaceAll("null", "").replace("?Sequence", ""));
                    System.out.println("Id " + structure.id + " Query: " + s.getSparql().replaceAll("null", "").replace("?Sequence", ""));
                    QueryExecution qe = QueryExecutionFactory.sparqlService("http://test.ts.glytoucan.org/sparql", query);
                    ResultSet rs = qe.execSelect();

                    List<SparqlEntity> results = new ArrayList<SparqlEntity>();
                    HashSet<String> resultsList = new HashSet<String>();

                    while (rs.hasNext()) {
                        QuerySolution row = rs.next();
                        Iterator<String> columns = row.varNames();
                        SparqlEntity se2 = new SparqlEntity();
                        while (columns.hasNext()) {
                            String column = columns.next();
                            RDFNode cell = row.get(column);

                            if (cell.isResource()) {
                                Resource resource = cell.asResource();
                                //do something maybe with the OntModel???
                                if (resource.isLiteral())
                                    se.setValue(column, resource.asLiteral().getString());
                                else
                                    se.setValue(column, resource.toString());
                            } else if (cell.isLiteral()) {
                                se.setValue(column, cell.asLiteral().getString());
                            } else if (cell.isAnon()) {
                                se.setValue(column, "anon");
                            } else {
                                se.setValue(column, cell.toString());
                            }
                        }
                        results.add(se);
                    }

                    for (SparqlEntity entity : results) {
                        //System.out.println("results: " + entity.getValue("PrimaryId"));
                        resultList.add(structure.id + "\t" + entity.getValue("PrimaryId").toString());
                    }
                }
            }
        }
        PrintWriter writer= null;
        try {
            writer = new PrintWriter( new OutputStreamWriter( new FileOutputStream( "/tmp/HashSet.txt"), "UTF-8" ));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(String c : resultList){
            System.out.println(c);
            writer.println(c);
        }
    }


    @Test
    public void testKBtoWurcsSparqlTranslation()  throws SparqlException {

        List<Translation> translations = Ebean.find(Translation.class).findList();
        HashSet<String> resultList = new HashSet<String>();

        String ct = "";

        for(Translation translation : translations) {
            System.out.println("id check " + translation.id + " ct " + translation.ct);
            if(translation.ct == null)
                continue;

            if (translation.structure.id > 0 ) {

                ct = translation.ct;

                GlycoSequenceToWurcsSelectSparql s = new GlycoSequenceToWurcsSelectSparql("glycoct");
                SparqlEntity se = new SparqlEntity();
                ct = StringUtils.chomp(ct);
                System.out.println("ct on top: " + ct);
                if (ct != null) {
                    se.setValue(GlycoSequenceToWurcsSelectSparql.FromSequence, ct.replaceAll("\n", "\\\\n").replaceAll("x\\(", "u\\(").replaceAll("\\)x", "\\)u").trim());
                    s.setSparqlEntity(se);
                    logger.debug(s.getSparql());

                    Query query = QueryFactory.create(s.getSparql().replaceAll("null", "").replace("?Sequence", ""));
                    System.out.println("Id " + translation.structure.id + " Query: " + s.getSparql().replaceAll("null", "").replace("?Sequence", ""));
                    QueryExecution qe = QueryExecutionFactory.sparqlService("http://test.ts.glytoucan.org/sparql", query);
                    ResultSet rs = qe.execSelect();

                    List<SparqlEntity> results = new ArrayList<SparqlEntity>();
                    HashSet<String> resultsList = new HashSet<String>();

                    while (rs.hasNext()) {
                        QuerySolution row = rs.next();
                        Iterator<String> columns = row.varNames();
                        SparqlEntity se2 = new SparqlEntity();
                        while (columns.hasNext()) {
                            String column = columns.next();
                            RDFNode cell = row.get(column);

                            if (cell.isResource()) {
                                Resource resource = cell.asResource();
                                //do something maybe with the OntModel???
                                if (resource.isLiteral())
                                    se.setValue(column, resource.asLiteral().getString());
                                else
                                    se.setValue(column, resource.toString());
                            } else if (cell.isLiteral()) {
                                se.setValue(column, cell.asLiteral().getString());
                            } else if (cell.isAnon()) {
                                se.setValue(column, "anon");
                            } else {
                                se.setValue(column, cell.toString());
                            }
                        }
                        results.add(se);
                    }

                    for (SparqlEntity entity : results) {
                        //System.out.println("results: " + entity.getValue("PrimaryId"));
                        resultList.add(translation.structure.id + "\t" + entity.getValue("PrimaryId").toString());
                    }
                }

            }
        }

        for(String c : resultList){
            System.out.println(c);
        }
    }

//    @Test
//    public void motifTouCanSearch() {}
//        MotifSearchSparql getMotifSearchSparql() {
//        MotifSearchSparql motfs = new MotifSearchSparql();
//        SparqlEntity se = new SparqlEntity();
//        // G00047MO
//        se.setValue(GlycoSequence.Sequence, "WURCS=2.0/3,3,2/[x2122h-1x_1-5_2*NCC/3=O][12112h-1b_1-5][11221m-1a_1-5]/1-2-3/a3-b1_a4-c1");
//        motfs.setSparqlEntity(se);
//
//    }


}
