package firstAssignment;

import firstAssignment.builder.Books;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.*;

import static io.restassured.RestAssured.given;
import static resources.utilities.faker.FakerBusinessClass.*;

public class Assignment {

    @Test
    public void getCall() throws IOException {


        Response response = given()
                .baseUri("http://localhost:3000/users")
                .contentType(ContentType.JSON)
                .when()
                .log().all()
                .get();

        response.prettyPrint();//print response
        List<Object> list = response.getBody().jsonPath().getList("users");
        int siezeOfArray = list.size();
        System.out.println("list size is = " + list.size());

    }
    @Test
    public void postCallPojo(){
        Books book = new Books(generateID(),generateYear(),generateName());
        //Users user = new Users(generateID(),generateName(),generatetTitle(),generateViews(),Arrays.asList("j1", "j2"),book);

        Response response = given()
                .baseUri("http://localhost:3000/users")
                .contentType(ContentType.JSON)
                .when()
                .body(user)
                .log().all()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();

    }
}
