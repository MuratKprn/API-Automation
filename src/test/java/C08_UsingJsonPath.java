import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C08_UsingJsonPath {

    @Test
    public void usingJSonPath(){

        JSONObject homeTel = new JSONObject();
        homeTel.put("type", "home");
        homeTel.put("number","0123-4567-8910");

        JSONObject iPhone = new JSONObject();
        iPhone.put("type", "iphone");
        iPhone.put("number", "0123-4567-8888");

        JSONArray phoneNumbers = new JSONArray();
        phoneNumbers.put(0,iPhone);
        phoneNumbers.put(1,homeTel);

        JSONObject address = new JSONObject();
        address.put("streetAddress", "naist street");
        address.put("city", "Nara");
        address.put( "postalCode", "630-0192");

        JSONObject personalInfo = new JSONObject();

        personalInfo.put("firstName", "John");
        personalInfo.put("lastName", "doe");
        personalInfo.put("age", 26);
        personalInfo.put("address", address);
        personalInfo.put("phoneNumbers", phoneNumbers);

        System.out.println("Name : " + personalInfo.get("firstName"));
        System.out.println("Lastname : " + personalInfo.get("lastName"));
        System.out.println("Age : " + personalInfo.get("age"));
        System.out.println("Address : " +personalInfo.getJSONObject("address").get("streetAddress")+"\n"
                                        +personalInfo.getJSONObject("address").get("postalCode")+"\n"
                                        +personalInfo.getJSONObject("address").get("city"));

        System.out.println("Tel : " +personalInfo.getJSONArray("phoneNumbers").getJSONObject(0).get("type")+" "
                                    +personalInfo.getJSONArray("phoneNumbers").getJSONObject(0).get("number")+"\n"
                                    +personalInfo.getJSONArray("phoneNumbers").getJSONObject(1).get("type")+" "
                                    +personalInfo.getJSONArray("phoneNumbers").getJSONObject(1).get("number"));
    }
}