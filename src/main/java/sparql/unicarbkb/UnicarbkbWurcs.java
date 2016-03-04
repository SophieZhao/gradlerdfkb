package sparql.unicarbkb;

import com.avaje.ebean.Ebean;
import models.unicarbkb.Structure;
import org.apache.commons.lang3.StringUtils;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.eurocarbdb.application.glycanbuilder.BuilderWorkspace;
import org.eurocarbdb.application.glycanbuilder.GlycanRenderer;
import org.eurocarbdb.application.glycanbuilder.GlycanRendererAWT;
import sparql.SparqlEntity;
import sparql.SparqlException;
import sparql.SparqlJena;
import sparql.wurcs.GlycoSequenceToWurcsSelectSparql;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * Created by matthew on 4/03/2016.
 */
public class UnicarbkbWurcs {

    public static String checkTouCan() throws SparqlException {

        List<Structure> structures = Ebean.find(Structure.class).findList();
        HashSet<String> resultList = new HashSet<>();

        String ct = "";

        for (Structure structure : structures) {
            List<SparqlEntity> results = new ArrayList<SparqlEntity>();

            //if (structure.id >= 7400 && structure.id <=7410 ) {
            if (structure.id == 7400) {
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
                ct = glycan.toGlycoCTCondensed();
                System.out.println("this was the ct: " + ct);
                ct = StringUtils.chomp(ct);

                GlycoSequenceToWurcsSelectSparql s = new GlycoSequenceToWurcsSelectSparql("glycoct");
                SparqlEntity sparqlEntity = new SparqlEntity();
                sparqlEntity.setValue(GlycoSequenceToWurcsSelectSparql.FromSequence, ct.replaceAll("\n", "\\\\n").replaceAll("x\\(", "u\\(").replaceAll("\\)x", "\\)u").trim());
                s.setSparqlEntity(sparqlEntity);

                List<SparqlEntity> ss = query2(s.getSparql().replaceAll("null", "").replace("?Sequence", ""));
                System.out.println("testing " + ss);
                for(SparqlEntity sparqlEntity1 : ss){
                    System.out.println("testing this area: " + sparqlEntity1.getValue("PrimaryId") );
                }


            }

        }
        return "done";
    }


    public static List<SparqlEntity> query2(String select) {

        Query query = QueryFactory.create(select); //s2 = the query above
        QueryExecution qe = QueryExecutionFactory.sparqlService("http://ts.glytoucan.org/sparql?", query);

        ResultSet rs = qe.execSelect();
        ResultSetFormatter.out(System.out, rs, query);

        List<SparqlEntity> results = new ArrayList<SparqlEntity>();
        if (!rs.hasNext())
            System.out.println("fuck " + rs.toString());

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

}
