import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C09_Post_JsonPathBodyTest {

    @Test
    public void JsonPathBodyTest(){

        // Send a POST request to the URL https://restful-booker.herokuapp.com/booking
        String url = "https://restful-booker.herokuapp.com/booking";

        JSONObject dates = new JSONObject();
        dates.put( "checkin" , "2021-06-01");
        dates.put( "checkout" , "2021-06-10");

        JSONObject reqBody = new JSONObject();
        reqBody.put("firstname" , "Eric");
        reqBody.put("lastname" , "Brown");
        reqBody.put("totalprice", 500);
        reqBody.put("depositpaid",false);
        reqBody.put("bookingdates",dates);
        reqBody.put("additionalneeds", "wi-fi");

        // Returning response
        Response response = given().contentType(ContentType.JSON).when().body(reqBody.toString()).post(url);

        response.then().assertThat() // Test it
                .statusCode(200) // Status Code is 200
                .contentType("application/json") // Content Type is application/json
                .body("booking.firstname", equalTo("Eric"), // The firstname in the response body is "Eric"
                         "booking.lastname", equalTo("Brown"), // The lastname in the response body is "Brown"
                         "booking.totalprice", equalTo(500), // The totalprice in the response body is "500"
                         "booking.depositpaid", equalTo(false), // The depositpaid in the response body is "false"
                         "booking.bookingdates.checkin", equalTo("2021-06-01"), // The checkin date in the response body is "2021-06-01"
                         "booking.bookingdates.checkout", equalTo("2021-06-10"), // The checkout date in the response body is "2021-06-10"
                         "booking.additionalneeds",equalTo("wi-fi")); // The additionalneeds in the response body is "wi-fi"
    }
}