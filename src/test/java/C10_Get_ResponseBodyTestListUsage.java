import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C10_Get_ResponseBodyTestListUsage {

    @Test
    public void ListUsage(){

        // Send a GET request to the URL http://dummy.restapiexample.com/api/v1/employees
        String url = "http://dummy.restapiexample.com/api/v1/employees";

        // Returning response
        Response response=given().when().get(url);

        response.then().assertThat() // Test it
                .statusCode(200) // Status Code is 200
                .contentType("application/json") // Content Type is application/json
                .body("data.id",hasSize(24), // The number of employees in the response body is 24
                        "data.employee_name",hasItem("Ashton Cox"), // One of the employee name is "Ashton Cox"
                        "data.employee_age",hasItems(61,21,35)); // The values for ages are 61, 21 and 35
    }
}