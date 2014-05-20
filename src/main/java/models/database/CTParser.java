package models.database;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.vocabulary.RDF;
import org.eurocarbdb.MolecularFramework.io.GlycoCT.SugarImporterGlycoCTCondensed;
import org.eurocarbdb.MolecularFramework.io.Glyde.SugarExporterGlydeIIC;
import org.eurocarbdb.MolecularFramework.io.SugarImporterException;
import org.eurocarbdb.MolecularFramework.sugar.Sugar;
import org.eurocarbdb.MolecularFramework.util.visitor.GlycoVisitorException;
import org.unicarbkb.rdf.GLYCOVOCAB;
import visitor.GlycoVisitorMonosaccharideList;
import visitor.MonosaccharideComponent;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import org.jdom.Content;

public class CTParser {

    private Sugar m_sugar;

    public static void readCT(Model model, Structure structure, Resource r) {
        List<Translation> translation = structure.translation;
        for (Translation t : translation) {
            try {
                if (!(t.getCt() == null)) {
                    System.out.println("ct is " + t.getCt());
                    SugarImporterGlycoCTCondensed t_importer = new SugarImporterGlycoCTCondensed();
                    Sugar t_sugar = t_importer.parse(t.getCt().trim());
                    GlycoVisitorMonosaccharideList t_visitorMs = new GlycoVisitorMonosaccharideList();
                    t_visitorMs.start(t_sugar);

                    if (t_visitorMs.getMultiplier() != null) {
                        for (MonosaccharideComponent t_compomentElement : t_visitorMs.getComponents().values()) {
                            r.addProperty(GLYCOVOCAB.hasComponent, createComponent(t_compomentElement.getMsdbString(), t_compomentElement.getNumber(), model));
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("errors: " + e);
            }


        }
    }

    private static Resource createComponent(String msdbString, Integer number, Model model) {

        String componentURI = "component_" + number + URLEncoder.encode(msdbString);

        Resource r = null;
        try {
            r = model.createResource(componentURI);
            r.addProperty(RDF.type, GLYCOVOCAB.component);
            r.addProperty(GLYCOVOCAB.hasCardinality, String.valueOf(number)); //have this problem a few times
            r.addProperty(GLYCOVOCAB.hasMonosaccharide, "<http://www.monosaccharidedb.org/query_monosaccharide_by_name.action?scheme=msdb&name=" + URLEncoder.encode(msdbString) + ">"); //, RDF.getURI());   //createMonosaccharide(Model model, msdbString));
        } catch (Exception e) {
            System.out.println("errors with component: " + e);
        }
        return r;
    }

    public static String createGlyde(Translation translation) {
        String t_sequenceXML = null;
        try {
            if (translation.ct.length() < 1) {
                if (!(translation.getCt() == null)) {
                    System.out.println("ct is " + translation.getCt());
                    SugarImporterGlycoCTCondensed t_importer = new SugarImporterGlycoCTCondensed();
                    Sugar t_sugar = t_importer.parse(translation.getCt().trim());

                    SugarExporterGlydeIIC t_exporter = new SugarExporterGlydeIIC();
                    t_exporter.start(t_sugar);

                    t_sequenceXML = t_exporter.getXMLCode();
                    System.out.println(t_sequenceXML);
                }
            }
        } catch (SugarImporterException e) {
            System.out.println("help here just");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (GlycoVisitorException e) {
            e.printStackTrace();
        }

        return t_sequenceXML;
    }

   /* public static Resource createMonosaccharide(Model model, String msdbString){
        String msURI = "http://www.monosaccharidedb.org/query_monosaccharide_by_name.action?scheme=msdb&name=" +  URLEncoder.encode(msdbString);
        Resource r;

        r = model.createResource(msURI);
        r.addProperty()
    }*/

}
