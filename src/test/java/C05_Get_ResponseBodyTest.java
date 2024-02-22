import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C05_Get_ResponseBodyTest {

    @Test
    public  void responseBodyTest(){

        // Send a GET request to the URL  https://jsonplaceholder.typicode.com/posts/44
        String url = "https://jsonplaceholder.typicode.com/posts/44";

        // Returning Response
        Response response = given().when().get(url);

        response.then().assertThat() // Test it
                .statusCode(200) // Status Code is 200
                .contentType("application/json; charset=utf-8") // Content Type is application/json; charset=utf-8
                .body("userId", Matchers.equalTo(5)) // The userId in the response body is 5
                .body("title", Matchers.equalTo("optio dolor molestias sit")); // The title in the response body is "optio dolor molestias sit"
    }
}
