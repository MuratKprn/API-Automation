import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class C12_Post_ExpectedDataAndJsonPathWithAssertion {

    @Test
    public void expBodyPostTesti(){

        // Send a POST request to the URL https://restful-booker.herokuapp.com/booking
        String url = "https://restful-booker.herokuapp.com/booking";

        // Request Body
        JSONObject innerData = new JSONObject();
        innerData.put("checkin" , "2021-06-01");
        innerData.put("checkout" , "2021-06-10");

        JSONObject reqBody = new JSONObject();
        reqBody.put("firstname" , "Jamal");
        reqBody.put("lastname" , "Rain");
        reqBody.put("totalprice" , 500);
        reqBody.put("depositpaid" , false);
        reqBody.put("bookingdates" , innerData);
        reqBody.put("additionalneeds" , "wi-fi");

        // Expected Body
        JSONObject expBody = new JSONObject();
        expBody.put("bookingid",24);
        expBody.put("booking",reqBody);

        // Send Request and Save Response
        Response response = given().contentType(ContentType.JSON).when().body(reqBody.toString()).post(url);

        // Assertion
        JsonPath respJP = response.jsonPath();

        assertEquals(expBody.getJSONObject("booking").get("firstname"),respJP.get("booking.firstname"));
        assertEquals(expBody.getJSONObject("booking").get("lastname"),respJP.get("booking.lastname"));
        assertEquals(expBody.getJSONObject("booking").get("totalprice"),respJP.get("booking.totalprice"));
        assertEquals(expBody.getJSONObject("booking").get("depositpaid"),respJP.get("booking.depositpaid"));
        assertEquals(expBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),respJP.get("booking.bookingdates.checkin"));
        assertEquals(expBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),respJP.get("booking.bookingdates.checkout"));
        assertEquals(expBody.getJSONObject("booking").get("additionalneeds"),respJP.get("booking.additionalneeds"));
    }
}
