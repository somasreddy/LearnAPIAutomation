package API_Tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class TestLocalAPI {

	@SuppressWarnings("unchecked")
	//@Test
	public void testPost() {
		JSONObject json= new JSONObject();
		json.put("firstName", "Mamatha");
		json.put("lastName", "Balla");
		json.put("subjectid","3");
		
		baseURI = "http://localhost:3000";

		given().
			contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(json.toJSONString())
		.when()
			.post("/users").
		then()
			.statusCode(201)
			.log().all();
	}
	
	//@Test
	@SuppressWarnings("unchecked")
	public void testPut() {
		JSONObject json= new JSONObject();
		json.put("firstName", "Ranjana");
		json.put("lastName", "Kulkarni");
		json.put("subjectid","3");
		
		baseURI = "http://localhost:3000";

		given().
			contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(json.toJSONString())
		.when()
			.put("/users/5").
		then()
			.statusCode(200)
			.log().all();
	}
	
	//@Test
	@SuppressWarnings("unchecked")
	public void testPatch() {
		JSONObject json= new JSONObject();
		json.put("subjectid","1");
		
		baseURI = "http://localhost:3000";

		given().
			contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(json.toJSONString())
		.when()
			.patch("/users/4").
		then()
			.statusCode(200)
			.log().all();
	}
	
	@Test
	public void testDelete() {
				
		baseURI = "http://localhost:3000";

		when()
			.delete("/users/TcQ7dTi").
		then()
			.statusCode(200)
			.log().all();
	}
}
