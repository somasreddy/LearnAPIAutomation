package API_Tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetAndPost {

	@Test//(enabled = false)
	public void testGet() {

		baseURI = "https://reqres.in/api/";
		given().
			get("users?page=2").
		then().
			statusCode(200).
			body("data[0].last_name", equalTo("Lawson")).
			log().all().
			body("data.first_name", hasItems("Michael", "Lindsay", "Byron", "Tobias"));

	}

	@Test
	public void testPost() {
//		Map<String, Object> map = new HashMap<>();
//		map.put("name", "somasekhar");
//		map.put("job", "Sr.TAE");
		JSONObject json = new JSONObject();
		json.put("name", "somasekhar");
		json.put("job", "Sr.TAE");
		String mjson = json.toJSONString();
//		System.out.println(mjson);
		
		baseURI = "https://reqres.in/api/";
		
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(mjson).
		when().
			post("users").
		then().
			statusCode(201).
			log().all();

	}

}
