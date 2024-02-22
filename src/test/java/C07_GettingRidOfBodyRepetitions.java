import groovy.json.JsonOutput;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C07_GettingRidOfBodyRepetitions {

    // NOTE: Data may change, check data in Postman

    @Test
    public void gettingRidOfBodyRepetitions(){

        // Send a GET request to the URL https://restful-booker.herokuapp.com/booking/10
        String url = "https://restful-booker.herokuapp.com/booking/10";

        // Returning response
        Response response = given().when().get(url);

        response.then().assertThat() // Test it
                .statusCode(200) // Status Code is 200
                .contentType("application/json") // Content Type is application/json
                .body("firstname", equalTo("Mark"), // The firstname in the response body is "Mark"
                        "lastname",equalTo("Brown"), // The lastname in the response body is "Brown"
                        "totalprice",equalTo(708), // The total price in the response body is "708"
                        "depositpaid",equalTo(false), // The depositpaid in the response is "false"
                        "additionalneeds",equalTo("Breakfast")); // The additionalneeds in the response is "Breakfast"

        System.out.println(response.contentType());
    }
}