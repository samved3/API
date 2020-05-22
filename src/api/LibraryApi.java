package api;

import org.testng.annotations.Test;

import com.github.fge.jsonschema.main.cli.Main;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import jsons.PostApiJson;

import static  io.restassured.RestAssured.*;

public class LibraryApi {
//		Add book in Library

	public static void main(String[] args) 
		
	 {
		// TODO Auto-generated method stub

	
	
		PostApiJson paj=new PostApiJson();
		RestAssured.baseURI="http://216.10.245.166";
		String response=given().header("Content-Type", "application/json").body(PostApiJson.libraryGetJson()).
		when().post("/Library/Addbook.php").then().assertThat().statusCode(200).extract().response().toString();
		
		JsonPath js= new JsonPath(response);
		String id=js.getString("ID");
		System.out.println("id");
	}
	
}
