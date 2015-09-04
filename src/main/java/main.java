import com.avaje.ebean.Ebean;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ResIterator;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import models.database.Proteins;
import models.database.Reference;
import models.database.Structure;
import models.unicarbdb.hplc.Lcmucin;
import org.unicarbkb.rdf.Namespaces;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static org.unicarbkb.rdf.Glycoproteins.createProteins;
import static org.unicarbkb.rdf.MassSpec.createLcStructureResource;
import static org.unicarbkb.rdf.ReferenceRDF.createPublication;
import static org.unicarbkb.rdf.StructureRDF.createStructureResource;
import static org.unicarbkb.rdf.TaxonomyBiol.*;
import models.database.CTParser;

/**
 * Created by matthew on 07/05/2014.
 */
public class main {

    public static void main(String[] args) {
        Namespaces n = new Namespaces();
        Model m = n.createModel();

        /*
        build unicarbdb
        see use of to ebeans for db access
         */
        createLcStructureResource(m);



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

        String fileName = "/tmp/out";
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

        //CTParser.readCT();

    }


}
