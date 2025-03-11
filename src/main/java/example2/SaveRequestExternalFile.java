package example2;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import resources.utilities.faker.FakerBusinessClass;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static io.restassured.RestAssured.*;

public class SaveRequestExternalFile {

    @Test
    public void saveRequestExternalFile() throws IOException {


        String requestBody = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "/src/main/java/example2/request.json")))
                .replace("title1", FakerBusinessClass.generatetTitle())
                .replace("id1", String.valueOf(FakerBusinessClass.generateID()));


        Response response = given()
                .baseUri("http://localhost:3000/users")
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .log().all()
                //.queryParam("users" , "/users")
                .post();
        response.prettyPrint();

        byte[] f = response.asByteArray();

        Files.write(Paths.get("response.json"), response.getBody().asByteArray());


        response.getStatusCode();
    }
}
