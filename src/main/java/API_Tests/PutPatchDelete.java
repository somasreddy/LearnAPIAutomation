package API_Tests;

import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutPatchDelete {

	@Test
	public void testPut() {
		JSONObject json = new JSONObject();
		json.put("name", "somasekhar");
		json.put("job", "Lead TAE");
		String mjson = json.toJSONString();
		
		baseURI = "https://reqres.in/api/";
		
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(mjson).
		when().
			put("users/2").
		then().
			statusCode(200).
			log().all();

	}
	
	@Test
	public void testPatch() {
		JSONObject json = new JSONObject();
		json.put("name", "somasekhar");
		json.put("job", "Lead TAE");
		String mjson = json.toJSONString();
		
		baseURI = "https://reqres.in/api/";
		
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(mjson).
		when().
			patch("users/2").
		then().
			statusCode(200).
			log().all();

	}
	
	@Test
	public void testDelete() {
		baseURI = "https://reqres.in/api/";

		when().
			delete("users/2").
		then().
			statusCode(204).
			log().all();
	}
	
}
