import org.junit.Test;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class C01_Get_Query {

    @Test
    public void get01(){

        // Send a GET request to the URL https://restful-booker.herokuapp.com/booking/10
        String url = "https://restful-booker.herokuapp.com/booking/10";

        // Returning Response
        Response response = given().when().get(url);

        // Status Code is 200
        System.out.println("Status Code: " + response.getStatusCode());

        // Content Type is application/json; charset=utf-8
        System.out.println("Content Type: " + response.getContentType());

        // Status Line's HTTP/1.1 200 OK
        System.out.println("Status Line: " + response.getStatusLine());

        // The value of the Header named Server is Cowboy
        System.out.println("Header/Server:" + response.getHeader("Server"));

        // Response Time is less than 5 seconds
        System.out.println("Test Time: " + response.getTime()+"ms");

        // And test manually
    }
}