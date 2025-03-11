package org.ExampleReqres;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class getListofUsers {
    @Test
    public void getListOfUsers() {
        given().
                baseUri("https://reqres.in")
                .basePath("/api/users")
                .queryParam("page","2")
                .when()
                .get();
    }
    @Test
    public void getListOfUsers2() {
        Response res=
                given()
                .baseUri("https://reqres.in/api/")
                //.basePath("/api")
                .pathParam("user", "/users")
                .queryParam("page","2")
                .when()
                .get("{user}");

        res.then().statusCode(200);
    }


    @Test
    public void getListOfUsers3() {
        Response response =
                given()
                        .pathParam("value", "users")
                        .get("https://reqres.in/api/{value}");
/*
baseUri:
The baseUri should only include the base URL of the API (https://reqres.in/api). It should not include the path parameter placeholder ({value}).

get():
The get() method should include the endpoint with the path parameter placeholder (/{value}). REST Assured will replace {value} with the actual value (users) when the request is sent.*/


        response.prettyPrint(); // to print the response


        System.out.println("response.getStatusCode() = " + response.getStatusCode());
    }
}
