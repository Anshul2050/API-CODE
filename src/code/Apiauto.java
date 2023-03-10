package code;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import payload.PayLoad;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
// add place -> update place -> get place to validate if new address is present in the response
public class Apiauto {
	

	public static void main(String[] args) {
		
		RestAssured.baseURI ="https://rahulshettyacademy.com";
		
		String response =given().queryParam("key","qaclick123")
		.body(PayLoad.addPlaceBody()).when().post("maps/api/place/add/json")
		.then().extract().response().asString();

		System.out.println(response);
		
		JsonPath js = new JsonPath(response);
		
		String place_id =js.getString("place_id");
		
		System.out.println(place_id);
		
		String new_address = "Madhav Nagar";
		
		String update_place=given().queryParam("key", "qaclick123").queryParam("place_id", place_id)
		.body("{\r\n"
				+ "\"place_id\":\""+place_id+"\",\r\n"
				+ "\"address\":\""+new_address+"\",\r\n"
				+ "\"website\": \"http://googleabc.com\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}\r\n"
				+ "").when().put("maps/api/place/update/json").then().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated")).extract().response()
		 .asString();
		
		System.out.println("\n"+update_place);
		
		String get_place = given().queryParam("key", "qaclick123").queryParam("place_id", place_id).when().get("maps/api/place/get/json")
		.then().extract().asString();
		System.out.println("\n"+get_place);
		
		JsonPath jsnew = new JsonPath(get_place);
		
		String updated_address=jsnew.getString("address");
		
		System.out.println("\n"+updated_address);
		
		Assert.assertEquals(updated_address, new_address);
		
		
		
		
		
	}

}
