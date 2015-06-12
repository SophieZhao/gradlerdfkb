package org.unicarbkb.rdf;

import org.expasy.sugarconverter.parser.IupacParser;

/**
 * Created by matthew on 11/06/15.
 */
public class IupacReader {



    public static String readIupacToCT(String iupac){
        IupacParser iupacParser = new IupacParser(iupac.trim());
        String glycoct = null;
        //p.setGlycanType("N-LINKED"); //N-LINKED (-> beta), O-LINKED (-> alpha)
        try
        {
            iupacParser.getCtTree(iupacParser.parse());
             glycoct = iupacParser.getCtSequence();
        }
        catch(Exception ex)
        {
            System.err.println("Problem parsing the sequence");
        }
        return glycoct;
    }
}
