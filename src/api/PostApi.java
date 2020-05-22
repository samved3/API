package api;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import jsons.PostApiJson;

import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;

import static io.restassured.RestAssured.*;

public class PostApi {
	public static void main(String[] args) {
//		POST 
//		given- all input details.
//		when-Submit the API
//		then-Validate the response.
//		PostApiJson json = new PostApiJson();
//		RestAssured.baseURI="https://rahulshettyacademy.com";

//			given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").
//			body(PostApiJson.getJsonPostApi()).when().post("/maps/api/place/add/json").then().log().all()
//			.assertThat().statusCode(200).body("scope", equalTo("APP")).header("server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();

//	String value=	given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").
//		body(PostApiJson.getJsonPostApi()).when().post("/maps/api/place/add/json").then()
//		.assertThat().statusCode(200).body("scope", equalTo("APP")).header("server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
//	
//	JsonPath js= new JsonPath(value);
////	parent and child json: direction.long
////	no path=place_id
//	String placeID=js.getString("place_id");
//	System.out.println(placeID);
	
//	update 
//	String newAddress="Africa";
//	given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").body("{\r\n" + 
//			"\"place_id\":\""+placeID+"\",\r\n" + 
//			"\"address\":\""+newAddress+"\",\r\n" + 
//			"\"key\":\"qaclick123\"\r\n" + 
//			"}\r\n" + 
//			"").
//	when().put("maps/api/place/update/json")
//	.then().assertThat().log().all().statusCode(200).body("msg",equalTo("Address successfully updated"));
	
		//Get Place API
//	String addressField=given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeID).when().get("maps/api/place/get/json")
//			.then().assertThat().log().all().statusCode(200).extract().response().asString();
//	JsonPath js1= new JsonPath(addressField);
//	String extractedAdd=js1.getString("address");
//	Assert.assertEquals(extractedAdd, newAddress);
	//Library API
	PostApiJson paj=new PostApiJson();
	RestAssured.baseURI="http://216.10.245.166";
	String response=given().header("Content-Type", "application/json").body(PostApiJson.libraryGetJson()).
	when().post("/Library/Addbook.php").then().assertThat().statusCode(200).extract().response().toString();
	
	JsonPath jsap= new JsonPath(response);
	String id=jsap.getString("ID");
	System.out.println(id);
	
	
	}

}
