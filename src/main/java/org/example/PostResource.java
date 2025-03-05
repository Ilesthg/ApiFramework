package org.example;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PostResource {

    @Test
    public void postResource() {
        Object payload =
                "{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"leader\"\n" +
                        "}";

        Response response = given()
                .pathParam("value", "users")
                .header("Content-Type", "application/json") // Set Content-Type header
                .when().body(payload)
                .log().all()// log().body() print the body ---------log().all() will print request body, header and all meta information
                .post("https://reqres.in/api/{value}");
        // Extract and print the "name" and "job" from the response
        String name = response.jsonPath().getString("name");
        String job = response.jsonPath().getString("job");
      /*  System.out.println("Name: " + name);
        System.out.println("Job: " + job);*/

        System.out.println(response.getStatusCode());
        // System.out.println("  = "+response.getBody().asPrettyString());


        /*ASSERTIONS*/
        //System.out.println("job = " + response.jsonPath().getMap("$")); //"$" refers to the root of the JSON response., but we are in https://reqres.in/api/users , but after sneding the post call it return the resource created,getMap("$") correctly retrieves that single resource.
        System.out.println("job = " + response.jsonPath().getString("name"));

    }
}
