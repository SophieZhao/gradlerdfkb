package org.unicarbkb.rdf;

import com.avaje.ebean.Ebean;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import models.unicarbkb.Biolsource;

import java.util.List;

public class Biolcontext {

    public static void createProteins(Model model) {


        try {
            List<Biolsource> bc = Ebean.find(Biolsource.class).findList();
            for (Biolsource b : bc) {
                Resource p = model.createResource("biolsource_" + b.protein.trim() + "_" + b.swiss_prot.trim());


            }
        } catch (Exception e) {
            System.out.println("Failed createBiolcontext: " + e);
        }

    }
}
