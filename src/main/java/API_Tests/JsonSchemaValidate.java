package API_Tests;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.Test;

public class JsonSchemaValidate {

	@Test
	public void test() {
		baseURI = "https://reqres.in/api"; 
		
		given().
			get("/users?page=2"). 
		then().
			assertThat().body(matchesJsonSchemaInClasspath("schema.json"));	
		
	}
}
