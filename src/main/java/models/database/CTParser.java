package models.database;

import com.avaje.ebean.Ebean;
import org.eurocarbdb.MolecularFramework.io.SugarImporterException;
import org.eurocarbdb.MolecularFramework.io.GlycoCT.SugarImporterGlycoCTCondensed;
import org.eurocarbdb.MolecularFramework.io.Glyde.SugarExporterGlydeIIC;
import org.eurocarbdb.MolecularFramework.io.Linucs.SugarExporterLinucs;
import org.eurocarbdb.MolecularFramework.io.carbbank.SugarExporterCarbBank;
import org.eurocarbdb.MolecularFramework.io.kcf.GlycoVisitorFromGlycoCTAnomer;
import org.eurocarbdb.MolecularFramework.io.kcf.SugarExporterKcf;
import org.eurocarbdb.MolecularFramework.io.namespace.GlycoVisitorFromGlycoCT;
import org.eurocarbdb.MolecularFramework.sugar.Sugar;
import org.eurocarbdb.MolecularFramework.util.traverser.GlycoTraverser;
import org.eurocarbdb.MolecularFramework.util.visitor.GlycoVisitorException;
import org.eurocarbdb.resourcesdb.GlycanNamescheme;
import org.eurocarbdb.MolecularFramework.sugar.GlycoEdge;
import org.eurocarbdb.MolecularFramework.sugar.GlycoNode;
import org.eurocarbdb.MolecularFramework.sugar.Monosaccharide;
import org.eurocarbdb.MolecularFramework.sugar.NonMonosaccharide;
import org.eurocarbdb.MolecularFramework.sugar.Substituent;
import org.eurocarbdb.MolecularFramework.sugar.Sugar;
import org.eurocarbdb.MolecularFramework.sugar.SugarUnitAlternative;
import org.eurocarbdb.MolecularFramework.sugar.SugarUnitCyclic;
import org.eurocarbdb.MolecularFramework.sugar.SugarUnitRepeat;
import org.eurocarbdb.MolecularFramework.sugar.UnvalidatedGlycoNode;
import org.eurocarbdb.MolecularFramework.util.traverser.GlycoTraverser;
import org.eurocarbdb.MolecularFramework.util.traverser.GlycoTraverserNodes;
import org.eurocarbdb.MolecularFramework.util.visitor.GlycoVisitor;
import org.eurocarbdb.MolecularFramework.util.visitor.GlycoVisitorException;
import visitor.GlycoVisitorGlycanType;
import visitor.GlycoVisitorMonosaccharideList;
import visitor.MonosaccharideComponent;

import java.util.Iterator;
import java.util.List;

public class CTParser {

    private Sugar m_sugar;

    public static void readCT() {


        List<Translation> translation = Ebean.find(Translation.class).findList();
        for(Translation t : translation) {
            try {

                if (!(t.getCt() == null)) {
                    System.out.println("ct is " + t.getCt());
                    SugarImporterGlycoCTCondensed t_importer = new SugarImporterGlycoCTCondensed();
                    //Sugar t_sugar = t_importer.parse(t.getCt());

                    Sugar t_sugar = t_importer.parse(t.getCt().trim());
                    System.out.println("please: " + t_sugar);
                    GlycoVisitorGlycanType t_visitorType = new GlycoVisitorGlycanType();
                    GlycoVisitorMonosaccharideList t_visitorMs = new GlycoVisitorMonosaccharideList();
                    t_visitorMs.start(t_sugar);

                    if ( t_visitorMs.getMultiplier() != null )
                    {
                        //List<Component> t_list = new ArrayList<Component>();
                        for (MonosaccharideComponent t_compomentElement : t_visitorMs.getComponents().values())

                        {
                            System.out.println("please22 : " + t_compomentElement.setMsdbString());
                        /*    Component t_component = new Component(this.createComponentURI(t_compomentElement));
                            t_component.setHasCardinality(t_compomentElement.getNumber());
                            t_component.setHasMonosaccharide(new Monosaccharide(this.createMonosaccharideURI(t_compomentElement),true));
                            t_list.add(t_component); */
                        }
                       // a_glycan.setHasComponent(t_list);
                    }




                    Iterator<GlycoNode> node = t_sugar.getNodeIterator();
                    //for(GlycoNode n : node){
                    //}
                    while(node.hasNext()) {

                    System.out.println("test :" + node.next().getParentNode().toString());
                    }


                    /*GlycoVisitorGlycanType t_visitorType = new GlycoVisitorGlycanType();
                    t_visitorType.start(t_sugar);

                        this.m_sugar = t_sugar;
                        GlycoTraverser t_traverser = this.getTraverser(this);
                        t_traverser.traverseGraph(m_sugar);*/




                }



            /*GlycoVisitorGlycanType t_visitorType = new GlycoVisitorGlycanType();
            t_visitorType.start(t_sugar);
            if (t_visitorType.getType() == null)*/

            } catch (Exception e) {
                System.out.println("errors: " + e);
            }
        }

    }

    public GlycoTraverser getTraverser(GlycoVisitor a_visitor) throws GlycoVisitorException
    {
        return new GlycoTraverserNodes(a_visitor);
    }

}
