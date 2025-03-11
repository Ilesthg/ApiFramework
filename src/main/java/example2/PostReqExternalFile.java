package example2;
import static  io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.reporters.Files;
import resources.utilities.faker.FakerBusinessClass;
import resources.utilities.faker.FakerServiceClass;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;


public class PostReqExternalFile {


    @Test
    public void postRequestUsingExternalFile() throws IOException {

        String a =Files.readFile(new File(System.getProperty("user.dir") + "/src/main/java/example2/request.json"))
                .replace("title1" , FakerBusinessClass.generatetTitle())
                .replace("id1", String.valueOf(FakerBusinessClass.generateID()))
                .replace("views1", String.valueOf(FakerBusinessClass.generateViews()));


        Response response = given()
                .baseUri("http://localhost:3000/users")
                .contentType(ContentType.JSON)
                .body(a)
                .when()
                .log().all()
                //.queryParam("users" , "/users")
                .post();
        response.prettyPrint();
      HashMap<String, Object>  hm=  response.getBody().jsonPath().getJsonObject("$");
        System.out.println("b.size() = " + hm);

    }

}
