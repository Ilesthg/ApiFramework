package org.example;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetSingleUser {

    @Test
    public void test1() {
       Response res= given()
                .baseUri("https://reqres.in/api/")
                .basePath("/users")
                .when()
                .get();
                //.then()
               // .statusCode(200);


       // System.out.println(res.getBody().asString());        // print the response
        res.prettyPrint();


        res.then().statusCode(200);//assert status code, its bc then method
        System.out.println("res.getStatusCode() = " + res.getStatusCode());//print status code
        //res.statusCode();//print status code
    }
}
