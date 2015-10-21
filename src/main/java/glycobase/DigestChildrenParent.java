package glycobase;

import com.google.common.base.Splitter;
import models.glycobase.DigestChildren;
import models.glycobase.DigestParent;
import models.glycobase.Structure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by matthew on 19/10/2015.
 * Description of class from relevant columns
 */
public class DigestChildrenParent {

    /*
    [[glycobase_id (integer), Technique:(string), name:(string), enzymes:([array string]), retention (GU): (float),
    profile ID: (integer), profile name: (string), profile instrument: (string), profile dextran standard: (string)] ,..., [other children like 1st...]]
     */

    public int glycobaseId;
    public String technique;
    public String name;
    public List<String> enzymes;
    public double gu;
    public int profileId;
    public String profileName;
    public String profileInstrument;
    public String standard;

    String patternEnzyme = "enzymes:(.*)retention";

    public DigestChildrenParent(int glycobaseId, String technique, String name, List<String> enzymes, double gu, int profileId, String profileName, String profileInstrument, String standard) {
        this.glycobaseId = glycobaseId;
        this.technique = technique;
        this.name = name;
        this.enzymes = enzymes;
        this.gu = gu;
        this.profileId = profileId;
        this.profileName = profileName;
        this.profileInstrument = profileInstrument;
        this.standard = standard;
    }

    public static Map<String, String> readDigestChildren(String digestChildren, Structure structure) {

        digestChildren = digestChildren.replaceAll("enzymes:BTG, SPG", "enzymes:BTG;SPG");
        digestChildren = digestChildren.replaceAll("enzymes:SPG, BTG", "enzymes:SPG;BTG");
        digestChildren = digestChildren.replaceAll("enzymes:NANI, ABS", "enzymes:NANI;ABS");
        digestChildren = digestChildren.replaceAll("enzymes:ABS, ABS" , "enzymes:ABS;ABS");
        digestChildren = digestChildren.replaceAll("enzymes:ABS, NANI", "enzymes:ABS;NANI");
        digestChildren = digestChildren.replaceAll("enzymes:BTG, spg", "enzymes:BTG;spg");
        digestChildren = digestChildren.replaceAll("enzymes:spg, BTG", "enzymes:spg;BTG");
        digestChildren = digestChildren.replaceAll("enzymes:JBH, GUH", "enzymes:JBH;GUH");
        digestChildren = digestChildren.replaceAll("enzymes:GUH, JBH", "enzymes:GUH;JBH");
        digestChildren = digestChildren.replaceAll("name:M8 D1,D3", "name:M8 D1D3");
        digestChildren = digestChildren.replaceAll("name:M8 D2,D3", "name:M8 D2D3");
        digestChildren = digestChildren.replaceAll("enzymes:SPH, JBH, GUH", "enzymes:SPH;JBH;GUH");
        digestChildren = digestChildren.replaceAll("enzymes:GUH;JBH, SPH", "enzymes:GUH;JBH;SPH");


        System.out.println("digest child: " + digestChildren);
        List<String> digestChild = Splitter.on("],").splitToList(digestChildren);
        Map<String, String> map = null;
        for (String s : digestChild) {
            if (!s.matches("]")) {
                System.out.println("check: " + s.replaceAll("\\[\\[(\\d+,Technique)", "[[test:$1"));
                s = s.replaceAll("\\[\\[(\\d+,Technique)", "[[test:$1");
                s = s.replaceAll("\\[(\\d+,Technique)", "[[test:$1");

                map = Splitter.onPattern(",[a-zA-Z]")
                        //.omitEmptyStrings()
                        .trimResults()
                        .withKeyValueSeparator(":")
                        .split(s);

                for (Map.Entry<String, String> entry : map.entrySet()) {
                    System.out.println("[" + entry.getKey() + "] " + entry.getValue());

                }

                //need to tidy up choped keys
                DigestChildren digestChildren1 = new DigestChildren();
                digestChildren1.setEnzymes(map.get("nzymes").replaceAll("\\s+", ""));
                digestChildren1.setGu(Double.parseDouble(map.get("etention (GU)").replaceAll("\\s+", "")));
                digestChildren1.setName(map.get("ame").replaceAll("\\s+", ""));

                if(map.get("rofile ID").matches("\\s+NA")){
                    digestChildren1.setProfileId(0);
                }else {
                    digestChildren1.setProfileId(Integer.parseInt(map.get("rofile ID").replaceAll("\\s+", ""))); //can be 'NA'
                }
                digestChildren1.setProfileInstrument(map.get("rofile instrument").replaceAll("\\s+", ""));
                digestChildren1.setProfileName(map.get("rofile name").replaceAll("\\s+", ""));
                digestChildren1.setStandard(map.get("rofile dextran standard").replaceAll("\\s+", ""));
                digestChildren1.setStructure(structure);
                digestChildren1.setTechnique(map.get("echnique").replaceAll("\\s+", ""));

            }
        }
        return map;
    }

    public static Map<String, String> readDigestParent(String digestChildren, Structure structure) {

        digestChildren = digestChildren.replaceAll("enzymes:BTG, SPG", "enzymes:BTG;SPG");
        digestChildren = digestChildren.replaceAll("enzymes:SPG, BTG", "enzymes:SPG;BTG");
        digestChildren = digestChildren.replaceAll("enzymes:NANI, ABS", "enzymes:NANI;ABS");
        digestChildren = digestChildren.replaceAll("enzymes:ABS, ABS" , "enzymes:ABS;ABS");
        digestChildren = digestChildren.replaceAll("enzymes:ABS, NANI", "enzymes:ABS;NANI");
        digestChildren = digestChildren.replaceAll("enzymes:BTG, spg", "enzymes:BTG;spg");
        digestChildren = digestChildren.replaceAll("enzymes:spg, BTG", "enzymes:spg;BTG");
        digestChildren = digestChildren.replaceAll("enzymes:JBH, GUH", "enzymes:JBH;GUH");
        digestChildren = digestChildren.replaceAll("enzymes:GUH, JBH", "enzymes:GUH;JBH");
        digestChildren = digestChildren.replaceAll("name:M8 D1,D3", "name:M8 D1D3");
        digestChildren = digestChildren.replaceAll("name:M8 D2,D3", "name:M8 D2D3");
        digestChildren = digestChildren.replaceAll("enzymes:SPH, JBH, GUH", "enzymes:SPH;JBH;GUH");
        digestChildren = digestChildren.replaceAll("enzymes:GUH;JBH, SPH", "enzymes:GUH;JBH;SPH");


        System.out.println("digest child: " + digestChildren);
        List<String> digestChild = Splitter.on("],").splitToList(digestChildren);
        Map<String, String> map = null;
        for (String s : digestChild) {
            if (!s.matches("]")) {
                System.out.println("check: " + s.replaceAll("\\[\\[(\\d+,Technique)", "[[test:$1"));
                s = s.replaceAll("\\[\\[(\\d+,Technique)", "[[test:$1");
                s = s.replaceAll("\\[(\\d+,Technique)", "[[test:$1");

                map = Splitter.onPattern(",[a-zA-Z]")
                        //.omitEmptyStrings()
                        .trimResults()
                        .withKeyValueSeparator(":")
                        .split(s);

                for (Map.Entry<String, String> entry : map.entrySet()) {
                    System.out.println("[" + entry.getKey() + "] " + entry.getValue());

                }

                //need to tidy up choped keys
                DigestParent digestParent = new DigestParent();
                digestParent.setEnzymes(map.get("nzymes").replaceAll("\\s+", ""));
                digestParent.setGu(Double.parseDouble(map.get("etention (GU)").replaceAll("\\s+", "")));
                digestParent.setName(map.get("ame").replaceAll("\\s+", ""));

                if(map.get("rofile ID").matches("\\s+NA")){
                    digestParent.setProfileId(0);
                }else {
                    digestParent.setProfileId(Integer.parseInt(map.get("rofile ID").replaceAll("\\s+", ""))); //can be 'NA'
                }
                digestParent.setProfileInstrument(map.get("rofile instrument").replaceAll("\\s+", ""));
                digestParent.setProfileName(map.get("rofile name").replaceAll("\\s+", ""));
                digestParent.setStandard(map.get("rofile dextran standard").replaceAll("\\s+", ""));
                    digestParent.setStructure(structure);
                digestParent.setTechnique(map.get("echnique").replaceAll("\\s+", ""));

            }
        }
        return map;
    }
}
