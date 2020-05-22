package api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.response.ValidatableResponse;
import jsons.PostApiJson;

public class PostApiToGetApitoUpdateApi {
	public static void main(String[] args) {
	 given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").
			body(PostApiJson.getJsonPostApi()).when().post("/maps/api/place/add/json").then().log().all()
			.assertThat().statusCode(200).body("scope", equalTo("APP")).header("server", "Apache/2.4.18 (Ubuntu)");
			
	}

}
