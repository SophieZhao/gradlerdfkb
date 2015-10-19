package glycobase;

import com.google.common.base.Splitter;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by matthew on 19/10/2015.
 * Description of class from relevant colummns
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

    public DigestChildren(int glycobaseId, String technique, String name, List<String> enzymes, double gu, int profileId, String profileName, String profileInstrument, String standard) {
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

    public static Map<String, String> readDigestChildren(String digestChildren) {

        List<String> digestChild = Splitter.on("],").splitToList(digestChildren);
        Map<String, String> map = null;
        for (String s : digestChild) {
            map.clear();
            if (!s.matches("]")) {
                System.out.println("check: " + s.replaceAll("\\[\\[(\\d+,Technique)", "[[test:$1"));
                s = s.replaceAll("\\[\\[(\\d+,Technique)", "[[test:$1");
                s = s.replaceAll("\\[(\\d+,Technique)", "[[test:$1");

                map = Splitter.on(",")
                        //.omitEmptyStrings()
                        .trimResults()
                        .withKeyValueSeparator(":")
                        .split(s);

                for (Map.Entry<String, String> entry : map.entrySet()) {
                    System.out.println("[" + entry.getKey() + "] " + entry.getValue());
                }
            }
        }
        return map;
    }
}
