package org.unicarbkb.rdf;

import com.avaje.ebean.Ebean;
import models.database.Structure;

import java.util.List;

/**
 * Created by matthew on 8/05/2014.
 */
public class StructureRDF {

    List<Structure> structures = Ebean.find(Structure.class).findList();


}
