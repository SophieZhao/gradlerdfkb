package sparql;

import org.apache.jena.query.*;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by matthew on 19/11/15.
 */
public class SparqlJena {

    //public static Logger logger=(Logger) LoggerFactory.getLogger("org.glytoucan.registry.dao.SparqlDAOJenaImpl");
    protected Logger logger = LoggerFactory.getLogger(getClass());


    public List<SparqlEntity> query(String select) {
//		SimpleAuthenticator authenticator = new SimpleAuthenticator("admin", "pw123".toCharArray());
//		PreemptiveBasicAuthenticator basicAuth = new PreemptiveBasicAuthenticator(authenticator);

        Query query = QueryFactory.create(select); //s2 = the query above
        QueryExecution qe = QueryExecutionFactory.sparqlService("http://ts.glytoucan.org/sparql?",
                query);

//		qef = new QueryExecutionFactoryRetry(qef, 5, 10000);

        // Add delay in order to be nice to the remote server (delay in milli seconds)
//		qef = new QueryExecutionFactoryDelay(qef, 5000);

        // Set up a cache
        // Cache entries are valid for 1 day
        long timeToLive = 24l * 60l * 60l * 1000l;

        // This creates a 'cache' folder, with a database file named 'sparql.db'
        // Technical note: the cacheBackend's purpose is to only deal with streams,
        // whereas the frontend interfaces with higher level classes - i.e. ResultSet and Model

//		CacheBackend cacheBackend = CacheCoreH2.create("sparql", timeToLive, true);
//		CacheFrontend cacheFrontend = new CacheFrontendImpl(cacheBackend);
//		qef = new QueryExecutionFactoryCacheEx(qef, cacheFrontend);



//		QueryExecutionFactoryHttp foo = qef.unwrap(QueryExecutionFactoryHttp.class);
//		System.out.println(foo);

        // Add pagination
//		qef = new QueryExecutionFactoryPaginated(qef, 900);

        // Create a QueryExecution object from a query string ...
//		QueryExecution qe = qef.createQueryExecution(select);

        // and run it.
        ResultSet rs = qe.execSelect();
//		logger.debug(ResultSetFormatter.asText(rs));
//        ResultSetFormatter.out(System.out, rs, query);

        List<SparqlEntity> results = new ArrayList<SparqlEntity>();
        if (!rs.hasNext())
            logger.debug("no results");
        logger.debug(">" + rs.getRowNumber() + "<");
//		OntModel ontology; //replace with your method for creating an OntModel

        while (rs.hasNext()) {
            QuerySolution row = rs.next();
            Iterator<String> columns = row.varNames();
            SparqlEntity se = new SparqlEntity();
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
        return results;
    }



    /*@Override
    public List<SparqlEntity> query(SelectSparql select) throws SparqlException {
        return query(select.getSparql());
    }*/



   /* public String getGraph() {
        return graph;
    }

    public void setGraph(String graph) {
        this.graph = graph;
    }
*/

}
