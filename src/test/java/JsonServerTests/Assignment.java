package JsonServerTests;

import com.google.gson.Gson;
import Assignment.builder.Book;
import Assignment.builder.User;
import Assignment.builder.UserBuilder;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utilities.ExtManager;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static resources.utilities.faker.FakerBusinessClass.*;

public class Assignment extends BaseTestC {
    int siezeOfArrayFirstGet;
    static UserBuilder userBPost;
    User userPostDesiarilizatedId;
    String idPostReq;

     @Test(priority = 1)
    public void getCall() throws IOException {


        Response response = given()
                .baseUri("http://localhost:3000/users")
                .contentType(ContentType.JSON)
                .when()
                //   .log().all()
                .get();

        //   response.prettyPrint();//print response
        List<Object> list = response.getBody().jsonPath().getList("users");
        siezeOfArrayFirstGet = list.size();
        System.out.println("list size 1 is = " + list.size());

    }

    @Test(priority = 2)
    public void postCallPojo() {
        // Book book = new Book(generateID(), generateYear(), generateName());

        Book book = Book.BookBuilder.builder().setIsbn(generateISBN()).setAuthor(generateName()).setYear(generateYear()).build();

        List<Book> bookList = new ArrayList<>();
        bookList.add(book);

        /*
        User user = new User(generateID(),generateName(),generatetTitle(),generateViews(),Arrays.asList("j1", "j2"),book);
*/
        userBPost = UserBuilder.builder()
                .setJobs(Arrays.asList("j1", "j2"))
                .setName(generateName())
                .setTitle(generatetTitle())
                .setViews(generateViews())
                .setId(generateID())
                .setBook(bookList);

        User postUser = userBPost.build();

        Response response = given()
                .baseUri("http://localhost:3000/users")
                .contentType(ContentType.JSON)
                .when()
                .body(postUser)
                //.log().all()
                .post();
        response.then().statusCode(201);
        // response.prettyPrint();


        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("src/main/resources/schema.json")));

        //deserialization with gson
        Gson gson = new Gson();
        userPostDesiarilizatedId = gson.fromJson(response.asString(), User.class);
        System.out.println("user3.getName() = " + userPostDesiarilizatedId.getName());


        idPostReq = postUser.getId();
        System.out.println("idPostReq = " + idPostReq);

    }

    @Test(priority = 3)
    public void getCall2() throws IOException {


        Response response = given()
                .baseUri("http://localhost:3000/users")
                .contentType(ContentType.JSON)
                .when()
                //  .log().all()
                .get("/" + userPostDesiarilizatedId.getId());

        response.prettyPrint();//print response
      /*  List<Object> list = response.getBody().jsonPath().getList("users");
        int siezeOfArraySecondtGet = list.size();
        System.out.println("list size 2 is = " + list.size());

        Assert.assertEquals((siezeOfArrayFirstGet+1) ,siezeOfArraySecondtGet);*/
    }

    @Test(priority = 4)
    public void updateCall() throws IOException {
        System.out.println("--------UPDATE CALL--------");
     /*  userBPost.setName("assdasdas");
      User user2 = userBPost.build();
       System.out.println("user2-2 = " + user2);
*/
        User updatedUser = UserBuilder.builder()
                .setId(userPostDesiarilizatedId.getId())  // Get original ID
                .setName("NewName")   // Modify the name
                .setTitle(userPostDesiarilizatedId.getTitle())  // Copy the original values
                .setViews(userPostDesiarilizatedId.getViews())
                .setJobs(userPostDesiarilizatedId.getJobs())
                .setBook(userPostDesiarilizatedId.getBooks())
                .build();

        Response response = given()
                .baseUri("http://localhost:3000/users")
                .contentType(ContentType.JSON)
                .when()
                .body(updatedUser)
                //  .queryParam("id",  userS.getId())
                .put("/" + updatedUser.getId());
        //  System.out.println("user2 get id" + userS.getId());

        ExtManager.passResponse(response.asString());




    }
}
