package API_Tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class Static_Test2 {
	@Test
	public void test() {
		baseURI = "https://reqres.in/api/"; //is the base url
		// we can use this as we have static imported the restassured and Matchers library   
		given().
			get("users?page=2"). //end point of the api
		then().
			statusCode(200).
			body("data[1].id", equalTo(8)).
			log().all();
	}

}
