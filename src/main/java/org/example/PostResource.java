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

    Response res = given()
            .pathParam("value", "users")
            .header("Content-Type", "application/json") // Set Content-Type header
            .when().body(payload)
            .post("https://reqres.in/api/{value}");
        // Extract and print the "name" and "job" from the response
        String name = res.jsonPath().getString("name");
        String job = res.jsonPath().getString("job");
        System.out.println("Name: " + name);
        System.out.println("Job: " + job);

        System.out.println(res.getStatusCode());
        System.out.println("  = "+res.getBody().

    asPrettyString());

}
}
