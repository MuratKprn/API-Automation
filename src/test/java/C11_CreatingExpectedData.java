import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C11_CreatingExpectedData {

    @Test
    public void expectedBodyTest(){

        // Send a GET request to the URL https://jsonplaceholder.typicode.com/posts/22
        String url = "https://jsonplaceholder.typicode.com/posts/22";

        // Expected Body
        JSONObject expBody=new JSONObject();
        expBody.put("userId",3);
        expBody.put("id",22);
        expBody.put("title","dolor sint quo a velit explicabo quia nam");
        expBody.put("body","eos qui et ipsum ipsam suscipit aut\n" +
                    "sed omnis non odio\n" +
                    "expedita earum mollitia molestiae aut atque rem suscipit\n" +
                    "nam impedit esse");

        // Returning response
        Response response = given().when().get(url);

        // Assertion
        JsonPath respJsonPath = response.jsonPath();

        assertEquals(expBody.get("userId"),respJsonPath.get("userId"));
        assertEquals(expBody.get("id"),respJsonPath.get("id"));
        assertEquals(expBody.get("title"),respJsonPath.get("title"));
        assertEquals(expBody.get("body"),respJsonPath.get("body"));
    }
}