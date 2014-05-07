import com.avaje.ebean.Ebean;
import com.hp.hpl.jena.rdf.model.Model;
import models.database.Reference;
import org.unicarbkb.rdf.Namespaces;

import java.util.List;

import static org.unicarbkb.rdf.ReferenceRDF.createPublication;

/**
 * Created by matthew on 07/05/2014.
 */
public class main {

    public static void main(String[] args) {
        Namespaces n = new Namespaces();
        Model m = n.createModel();

        List<Reference> reference = Ebean.find(Reference.class).findList();
        for(Reference r : reference) {
            createPublication(r,m);
        }

        m.write(System.out, "TTL");

    }

}
