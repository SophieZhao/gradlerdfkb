package visitor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class combineTTL {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        final Model dcterms = ModelFactory.createDefaultModel().read( "/tmp/structureREsource.ttl" );
        final Model foafIndex = ModelFactory.createDefaultModel().read( "/tmp/taxonomy.ttl" );

        // If you only have two models, you can use Union model.
        final Model union = ModelFactory.createUnion( dcterms, foafIndex );
        try ( final OutputStream out1 = new FileOutputStream( new File( "/tmp/purl_foaf1.rdf" )) ) {
            union.write( out1, "Turtle", null );
        }

        // In general, though, it's probably better to just create a new model to
        // hold all the triples, and to add the triples to that model.
        final Model blob = ModelFactory.createDefaultModel();
        for ( final Model part : new Model[] { dcterms, foafIndex } ) {
            blob.add( part );
        }
        try ( final OutputStream out2 = new FileOutputStream( new File( "/tmp/purl_foaf2.rdf" )) ) {
            blob.write( out2, "RDF/XML-ABBREV", null );
        }
    }
}
