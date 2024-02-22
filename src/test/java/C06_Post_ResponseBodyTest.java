import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C06_Post_ResponseBodyTest {

    @Test
    public void PostResponseBodyTest(){

        // Send a POST request to the URL https://jsonplaceholder.typicode.com/posts
        String url="https://jsonplaceholder.typicode.com/posts";

        JSONObject reqBody = new JSONObject();
        reqBody.put("title","API");
        reqBody.put("body","API Nice");
        reqBody.put("userId",10);

        // Returning Response
        Response response = given().contentType(ContentType.JSON).when().body(reqBody.toString()).post(url);

        response.then().assertThat() // Test it
                .statusCode(201) // Status Code is 201
                .contentType("application/json") // Content Type is application/json
                .body("title",equalTo("API")) // The title in the response body is "API"
                .body("userId",lessThan(100)) // The userId in the response body less than "100"
                .body("body",containsString("API")); // Body contains the text "API"
    }
}