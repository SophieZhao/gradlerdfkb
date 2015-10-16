import glycobase.Glycobase;
import org.apache.jena.query.*;
import org.apache.jena.sparql.engine.http.QueryEngineHTTP;

import org.junit.Test;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;
import models.unicarbkb.Journal;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        System.out.println("Got " + i + "  - DataSource good.");

        List<Journal> ee = Ebean.find(Journal.class).findList();
        System.out.println("Got " + ee);

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
    public void testGlycoBaseRead() {

        assertNotNull("Test file missing",
                getClass().getResource("/glycobase_spread.csv"));

        System.out.println("check size ");

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("glycobase_spread.csv").getFile());
        List<Glycobase> glycobase = new ArrayList<>();

        try (final Stream<String> lines = Files.lines(file.toPath())) {
            glycobase = lines.skip(1).map(line -> line.split("\\t")).map(line -> {
                final int id = Integer.parseInt(line[1]);
                final String name = line[0];
                final String ct = line[2];
                final String uplc = line[3];
                final String hplc = line[4];
                final String ce = line[5];
                final String rpuplc = line[6];
                final String taxonomy = line[7];
                final String tissue = line[8];
                final String disease = line[9];
                final String reportTitle = line[10];
                final String reportIds = line[11];
                final String sampleTitle = line[12];
                final String sampleIds = line[13];
                final String profileTitles = line[14];
                final String profileIds = line[15];
                final String digestionChildren = line[16];
                final String digestionParents = line[17];
                return new Glycobase(name, id, ct, uplc, hplc, ce, rpuplc, taxonomy, tissue, disease, reportTitle, reportIds, sampleTitle, sampleIds, profileTitles, profileIds, digestionChildren, digestionParents);
            }).collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("check size " + glycobase.size());

        for(Glycobase g : glycobase){
            System.out.println("data check " + g.getHplc());
            String hplc = g.getHplc();
        }




    }
}
