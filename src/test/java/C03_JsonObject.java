import org.json.JSONObject;
import org.junit.Test;

public class C03_JsonObject {

    @Test
    public void jsonData(){

        /* Create this JSON Object and print it in the console:

                {
                 "title":"John",
                 "body":"Hello",
                 "userId":1
                 }                                      */

        JSONObject jsonData = new JSONObject();

        jsonData.put("Title","John");
        jsonData.put("body","Hello");
        jsonData.put("userId",1);

        System.out.println(jsonData);
    }

    @Test
    public void innerJsonData() {

        /* Create this JSON Object and print it in the console:
                {
                "firstname":"Jim",
                "additionalneeds":"Breakfast",
                "bookingdates":{
                               "checkin":"2018-01-01",
                               "checkout":"2019-01-01"
                               },
                "totalprice":111,
                "depositpaid":true,
                "lastname":"Brown"
                }                                                   */

        JSONObject innerJson = new JSONObject();
        innerJson.put("checkin", "2018-01-01");
        innerJson.put("checkout", "2019-01-01");

        JSONObject outerJson = new JSONObject();
        outerJson.put("firstname", "Jim");
        outerJson.put("additionalneeds", "Breakfast");
        outerJson.put("bookingdates", innerJson);
        outerJson.put("totalprice", 111);
        outerJson.put("depositpaid", true);
        outerJson.put("lastname", "Brown");

        System.out.println(outerJson);
    }
}