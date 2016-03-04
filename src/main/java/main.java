
import glycobase.Glycobase;
import org.apache.jena.rdf.model.Model;
import org.unicarbkb.rdf.Namespaces;
import sparql.SparqlException;
import sparql.unicarbkb.UnicarbkbWurcs;

import java.io.FileWriter;
import java.io.IOException;

import static org.unicarbkb.rdf.MassSpec.createLcStructureResource;

/**
 * Created by matthew on 07/05/2014.
 */
public class main {

    public static void main(String[] args) {

        try {
            UnicarbkbWurcs.checkTouCan();
        } catch (SparqlException e) {
            e.printStackTrace();
        }

        /*try {
            Glycobase.readCSV();
        } catch (IOException e) {
            e.printStackTrace();
        }*/


        //Namespaces n = new Namespaces();
        //Model m = n.createModel();

        /*
        build unicarbdb
        see use of to ebeans for db access
         */
        //createLcStructureResource(m);



    /*
        List<Proteins> proteins = Ebean.find(Proteins.class).findList();
        for(Proteins p : proteins){
            createProteins(m,p);
        }

        createStructureResource(m);



       createTaxonomy(m);


       List<Reference> reference = Ebean.find(Reference.class).findList();
        for(Reference r : reference) {
            createPublication(r,m);
        }

        createSourceReferenceCompound(m);





        //m.write(System.out, "TTL");

      */

        /*String fileName = "/tmp/out";
        FileWriter out = null;
        try {
            out = new FileWriter( fileName );
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            m.write( out, "TTL" );
        }
        finally {
            try {
                out.close();
            }
            catch (IOException closeException) {
                // ignore
            }
        }
*/
        //CTParser.readCT();

    }


}
