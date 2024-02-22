import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C13_Get_ExpectedDataTestWithSoftAssert {

    @Test
    public void softAsserTest(){

        // Send a POST request to the URL http://dummy.restapiexample.com/api/v1/employee/3
        String url = "http://dummy.restapiexample.com/api/v1/employee/3";

        // ExpectedBody
        JSONObject data = new JSONObject();
        data.put("id",3);
        data.put("employee_name","Ashton Cox");
        data.put("employee_salary",86000);
        data.put("employee_age",66);
        data.put("profile_image","");

        JSONObject expBody = new JSONObject();
        expBody.put("status","success");
        expBody.put("data",data);
        expBody.put("message","Successfully! Record has been fetched.");

        // Send Request and Save Response
        Response response = given().when().get(url);

        //4-Assertion
        JsonPath respJP = response.jsonPath(); // Cast the Returning response to JsonPath
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(respJP.get("status"),expBody.get("status"));
        softAssert.assertEquals(respJP.get("data.id"),expBody.getJSONObject("data").get("id"));
        softAssert.assertEquals(respJP.get("data.employee_name"),expBody.getJSONObject("data").get("employee_name"));
        softAssert.assertEquals(respJP.get("data.employee_salary"),expBody.getJSONObject("data").get("employee_salary"));
        softAssert.assertEquals(respJP.get("data.employee_age"),expBody.getJSONObject("data").get("employee_age"));
        softAssert.assertEquals(respJP.get("data.profile_image"),expBody.getJSONObject("data").get("profile_image"));
        softAssert.assertEquals(respJP.get("message"),expBody.get("message"));
        softAssert.assertAll();
    }
}