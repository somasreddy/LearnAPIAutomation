package API_Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Intro_Test1 {
@Test
	public void test1() {
		Response response=RestAssured.get("https://reqres.in/api/users?page=2");
		int statuscode=response.getStatusCode();
		System.out.println(statuscode);
		System.out.println(response.getTime());
		System.out.println(response.asString());
		System.out.println(response.getHeaders().toString());
		Assert.assertEquals(statuscode, 200);
	}
}
