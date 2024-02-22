import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C02_Get_ResponseAssertion {

    @Test
    public void get01(){

        // Send a GET request to the URL https://restful-booker.herokuapp.com/booking/10
        String url = "https://restful-booker.herokuapp.com/booking/1";

        // Returning Response
        Response response = given().when().get(url);

        response.then()
                .assertThat()  // Test it
                .statusCode(200) // Status Code is 200
                .contentType("application/json; charset=utf-8") // Content Type is application/json; charset=utf-8
                .header("Server","Cowboy") // The value of the Header named Server is Cowboy
                .statusLine("HTTP/1.1 200 OK"); // Status Line's HTTP/1.1 200 OK
    }
}