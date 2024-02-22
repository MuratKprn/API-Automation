import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C04_Put_ResponseAssertion {

    @Test
    public void put01(){

        // Send a GET request to the URL https://jsonplaceholder.typicode.com/posts/70
        String url = "https://jsonplaceholder.typicode.com/posts/70";

        JSONObject reqBody = new JSONObject();
        reqBody.put("title", "Eric");
        reqBody.put("body", "Hello");
        reqBody.put("userId", 10);
        reqBody.put("id", 70);

        // Returning Response
        Response response = given().contentType(ContentType.JSON).when().body(reqBody.toString()).put(url);

        response.then().assertThat() // Test it
                .statusCode(200) // Status Code is 200
                .header("Server", "cloudflare") // The value of the Header named Server is cloudflare
                .contentType("application/json; charset=utf-8") // Content Type is application/json; charset=utf-8
                .statusLine("HTTP/1.1 200 OK"); // Status Line's HTTP/1.1 200 OK

        System.out.println(response.getHeaders());
    }
}