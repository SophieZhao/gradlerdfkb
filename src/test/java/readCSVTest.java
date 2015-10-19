import glycobase.DigestChildrenParent;
import glycobase.Glycobase;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by matthew on 19/10/2015.
 */
public class readCSVTest {

    @Test
    public void testGlycoBaseRead() {

        assertNotNull("Test file missing",
                getClass().getResource("/glycobase_spread.csv"));

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("glycobase_spread.csv").getFile());
        List<Glycobase> glycobase = new ArrayList<>();

        try (final Stream<String> lines = Files.lines(file.toPath())) {
            glycobase = lines.skip(1).map(line -> line.split("\\t")).map(line -> {
                final int id = Integer.parseInt(line[1]);
                final String name = line[0];
                final String ct = line[2];
                final String uplc = line[3];
                final String hplc = line[4];
                final String ce = line[5];
                final String rpuplc = line[6];
                final String taxonomy = line[7];
                final String tissue = line[8];
                final String disease = line[9];
                final String reportTitle = line[10];
                final String reportIds = line[11];
                final String sampleTitle = line[12];
                final String sampleIds = line[13];
                final String profileTitles = line[14];
                final String profileIds = line[15];
                final String digestionChildren = line[16];
                final String digestionParents = line[17];
                return new Glycobase(name, id, ct, uplc, hplc, ce, rpuplc, taxonomy, tissue, disease, reportTitle, reportIds, sampleTitle, sampleIds, profileTitles, profileIds, digestionChildren, digestionParents);
            }).collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
        most features in csv are stored in an array style
        structure id and name important
         */
        Glycobase glycan = glycobase.get(0);
        System.out.println("data check " + glycan.getUplc());
        assertEquals("[1.01, 1.02, 1.02, 1.02, 1.02, 1.01, 1.02, 1.02, 1.02, 1.03, 1.03]", glycan.getUplc());
    }

    @Test
    public void splitDigestChildren()  {

        //String test = "[[test:842,Technique:HPLC,name:F(6)A3G3S(6)1,enzymes:NANI,retention (GU): 8.89,profile ID: NA,profile name: NA2,profile instrument: NA3,profile dextran standard: NA4]";

        String test2 = "[[652,Technique:UPLC,name:F(6)A1[3]G(4)1S(6)1,enzymes:NANI;JBG,retention (GU): 7.62,profile ID: 1259,profile name: 1259(408)_UND,profile instrument: Acuity H-class (Waters),profile dextran standard: Dextran],[652,Technique:HPLC,name:F(6)A1[3]G(4)1S(6)1,enzymes:NANI,retention (GU): 7.01,profile ID: NA,profile name: NA,profile instrument: NA,profile dextran standard: NA],[652,Technique:CE,name:F(6)A1[3]G(4)1S(6)1,enzymes:NANI,retention (GU): 5.25,profile ID: 1000,profile name: 1000(20)_DIG_GUH,profile instrument: PA800 Plus Pharmaceutical Analysis System (Beckman Coulter),profile dextran standard: Maltodextrin],[652,Technique:CE,name:F(6)A1[3]G(4)1S(6)1,enzymes:NANI,retention (GU): 5.23,profile ID: 996,profile name: 996(20)_DIG_GUH,profile instrument: PA800 Plus Pharmaceutical Analysis System (Beckman Coulter),profile dextran standard: Maltodextrin],[652,Technique:CE,name:F(6)A1[3]G(4)1S(6)1,enzymes:NANI,retention (GU): 5.25,profile ID: 1001,profile name: 1001(20)_DIG_GUH,profile instrument: PA800 Plus Pharmaceutical Analysis System (Beckman Coulter),profile dextran standard: Maltodextrin],[652,Technique:UPLC,name:F(6)A1[3]G(4)1S(6)1,enzymes:NANI,retention (GU): 7.62,profile ID: 1257,profile name: 1257(408)_UND,profile instrument: Acuity H-class (Waters),profile dextran standard: Dextran],[652,Technique:UPLC,name:F(6)A1[3]G(4)1S(6)1,enzymes:NANI,retention (GU): 7.62,profile ID: 1258,profile name: 1258(408)_UND,profile instrument: Acuity H-class (Waters),profile dextran standard: Dextran],[652,Technique:UPLC,name:F(6)A1[3]G(4)1S(6)1,enzymes:NANI,retention (GU): 7.63,profile ID: 1263,profile name: 1263(408)_UND,profile instrument: Acuity H-class (Waters),profile dextran standard: Dextran],[652,Technique:HPLC,name:F(6)A1[3]G(4)1S(6)1,enzymes:NANI,retention (GU): 7.03,profile ID: NA,profile name: NA,profile instrument: NA,profile dextran standard: NA],[652,Technique:UPLC,name:F(6)A1[3]G(4)1S(6)1,enzymes:NANI,retention (GU): 7.63,profile ID: 1262,profile name: 1262(408)_UND,profile instrument: Acuity H-class (Waters),profile dextran standard: Dextran],[652,Technique:CE,name:F(6)A1[3]G(4)1S(6)1,enzymes:NANI,retention (GU): 5.24,profile ID: 999,profile name: 999(20)_DIG_GUH,profile instrument: PA800 Plus Pharmaceutical Analysis System (Beckman Coulter),profile dextran standard: Maltodextrin],[652,Technique:UPLC,name:F(6)A1[3]G(4)1S(6)1,enzymes:NANI,retention (GU): 7.62,profile ID: 1265,profile name: 1265(408)_UND,profile instrument: Acuity H-class (Waters),profile dextran standard: Dextran],[652,Technique:CE,name:F(6)A1[3]G(4)1S(6)1,enzymes:NANI,retention (GU): 5.23,profile ID: 995,profile name: 995(20)_DIG_GUH,profile instrument: PA800 Plus Pharmaceutical Analysis System (Beckman Coulter),profile dextran standard: Maltodextrin],[652,Technique:CE,name:F(6)A1[3]G(4)1S(6)1,enzymes:NANI,retention (GU): 5.23,profile ID: 997,profile name: 997(20)_DIG_GUH,profile instrument: PA800 Plus Pharmaceutical Analysis System (Beckman Coulter),profile dextran standard: Maltodextrin],[652,Technique:CE,name:F(6)A1[3]G(4)1S(6)1,enzymes:NANI,retention (GU): 5.25,profile ID: 1002,profile name: 1002(20)_DIG_GUH,profile instrument: PA800 Plus Pharmaceutical Analysis System (Beckman Coulter),profile dextran standard: Maltodextrin],[652,Technique:CE,name:F(6)A1[3]G(4)1S(6)1,enzymes:NANI,retention (GU): 5.22,profile ID: 993,profile name: 993(20)_DIG_GUH,profile instrument: PA800 Plus Pharmaceutical Analysis System (Beckman Coulter),profile dextran standard: Maltodextrin],[652,Technique:CE,name:F(6)A1[3]G(4)1S(6)1,enzymes:NANI,retention (GU): 5.25,profile ID: 801,profile name: 801(20)_DIG_GUH,profile instrument: PA800 Plus Pharmaceutical Analysis System (Beckman Coulter),profile dextran standard: Maltodextrin],[652,Technique:UPLC,name:F(6)A1[3]G(4)1S(6)1,enzymes:NANI,retention (GU): 7.62,profile ID: 1266,profile name: 1266(408)_UND,profile instrument: Acuity H-class (Waters),profile dextran standard: Dextran],[652,Technique:UPLC,name:F(6)A1[3]G(4)1S(6)1,enzymes:NANI,retention (GU): 7.63,profile ID: 1260,profile name: 1260(408)_UND,profile instrument: Acuity H-class (Waters),profile dextran standard: Dextran],[652,Technique:UPLC,name:F(6)A1[3]G(4)1S(6)1,enzymes:NANI,retention (GU): 7.62,profile ID: 1264,profile name: 1264(408)_UND,profile instrument: Acuity H-class (Waters),profile dextran standard: Dextran],[652,Technique:CE,name:F(6)A1[3]G(4)1S(6)1,enzymes:NANI,retention (GU): 5.23,profile ID: 802,profile name: 802(20)_DIG_GUH,profile instrument: PA800 Plus Pharmaceutical Analysis System (Beckman Coulter),profile dextran standard: Maltodextrin],[652,Technique:CE,name:F(6)A1[3]G(4)1S(6)1,enzymes:NANI,retention (GU): 5.23,profile ID: 994,profile name: 994(20)_DIG_GUH,profile instrument: PA800 Plus Pharmaceutical Analysis System (Beckman Coulter),profile dextran standard: Maltodextrin],[652,Technique:CE,name:F(6)A1[3]G(4)1S(6)1,enzymes:NANI,retention (GU): 5.24,profile ID: 998,profile name: 998(20)_DIG_GUH,profile instrument: PA800 Plus Pharmaceutical Analysis System (Beckman Coulter),profile dextran standard: Maltodextrin],[652,Technique:UPLC,name:F(6)A1[3]G(4)1S(6)1,enzymes:NANI,retention (GU): 7.63,profile ID: 1261,profile name: 1261(408)_UND,profile instrument: Acuity H-class (Waters),profile dextran standard: Dextran],]";

        DigestChildrenParent.readDigestChildren(test2);

    }
}
