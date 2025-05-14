package ExternalJsonFile;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utilities.ReaderJsonToString;


import java.io.IOException;
//import java.nio.file.Path;


public class PostReqExternalFile {


    @Test
    public void postRequestUsingExternalFile() throws IOException {

        String a = ReaderJsonToString.readJsontoString(System.getProperty("user.dir") + "/src/test/java/ExternalJsonFile/request.json");
        System.out.println(a);


        Response response = given()
                .baseUri("http://localhost:3000/users")
                .contentType(ContentType.JSON)
                .body(a)
                .when()
                .log().all()
                //.queryParam("users" , "/users")
                .post();
        response.prettyPrint();
        HashMap<String, Object> hm = response.getBody().jsonPath().getJsonObject("$");
        System.out.println("b.size() = " + hm);

    }

}
