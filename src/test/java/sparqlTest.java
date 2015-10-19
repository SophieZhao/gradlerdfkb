import com.avaje.ebean.enhance.ant.StringReplace;
import com.google.common.base.Splitter;
import glycobase.DigestChildren;
import glycobase.Glycobase;
import org.apache.commons.lang3.StringUtils;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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


}
