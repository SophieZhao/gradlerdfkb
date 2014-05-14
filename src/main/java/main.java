import com.avaje.ebean.Ebean;
import com.hp.hpl.jena.rdf.model.Model;
import models.database.Proteins;
import models.database.Reference;
import models.database.Structure;
import org.unicarbkb.rdf.Namespaces;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static org.unicarbkb.rdf.Glycoproteins.createProteins;
import static org.unicarbkb.rdf.ReferenceRDF.createPublication;
import static org.unicarbkb.rdf.StructureRDF.createStructureResource;

/**
 * Created by matthew on 07/05/2014.
 */
public class main {

    public static void main(String[] args) {
        Namespaces n = new Namespaces();
        Model m = n.createModel();

        /*
        create structures from structure table
         */
        //createStructureResource(m);


        List<Reference> reference = Ebean.find(Reference.class).findList();
        for(Reference r : reference) {
            createPublication(r,m);
        }

        /*List<Proteins> proteins = Ebean.find(Proteins.class).findList();
        for(Proteins p : proteins){
            createProteins(m,p);
        }*/

        m.write(System.out, "TTL");

        /* String fileName = "/tmp/out";
        FileWriter out = null;
        try {
            out = new FileWriter( fileName );
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            model.write( out, "TTL" );
        }
        finally {
            try {
                out.close();
            }
            catch (IOException closeException) {
                // ignore
            }
        } */


    }
}
