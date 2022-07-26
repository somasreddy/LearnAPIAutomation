package API_Tests;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class Static_Test2 {
	@Test
	public void test() {
		baseURI = "https://reqres.in/api/";
		given().
			get("users?page=2").
		then().
			statusCode(200).
			body("data[1].id", equalTo(8)).
			log().all();
	}

}
