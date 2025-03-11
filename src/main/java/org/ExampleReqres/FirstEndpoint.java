package org.ExampleReqres;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class FirstEndpoint {

    @Test
    public void test1() {
        given()
                .baseUri("https://api.github.com")//
                .basePath("/users")
                .when()
                .get()
                .then()
                .statusCode(200);
    }

    @Test
    public void test2() {
        Response response =
        given()
                .get("https://reqres.in/api/users");
                //.then().extract().response();

        response.prettyPrint(); // to print the response
         Headers header =   response.getHeaders();

        for (Header head: header) {
           //  System.out.println("head = " + head);
            System.out.println("header name = " + head.getName());
            System.out.println("header value = " + head.getValue());

        }

        System.out.println(  header.get("Content-Type"));

        System.out.println("response.getStatusCode() = " + response.getStatusCode());
    }

}
