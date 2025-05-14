package utilities;

import org.testng.reporters.Files;
import resources.utilities.faker.FakerBusinessClass;

import java.io.File;

public class ReaderJsonToString {

    public static String readJsontoString(String jsonFile) {
        try {
           return Files.readFile(new File(jsonFile))
                    .replace("title1", FakerBusinessClass.generatetTitle())
                    .replace("id1", String.valueOf(FakerBusinessClass.generateID()))
                    .replace("views1", String.valueOf(FakerBusinessClass.generateViews()));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }


    }
}
//System.getProperty("user.dir") + "/src/main/java/ExternalJsonFile/request.json")