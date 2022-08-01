package API_Tests;

import static io.restassured.RestAssured.*;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;

public class TestSoapAPI {

	
	@Test
	public void validateSoapRequest()throws IOException {
		File f=new File("./Input/SoapAdd.xml");
		FileInputStream fileIn= new FileInputStream(f);
		String reqBody= IOUtils.toString(fileIn, "utf-8");
				
		baseURI ="http://www.dneonline.com";
		given()
			.contentType("text/xml")
			.accept(ContentType.XML)
			.body(reqBody).
		when().
			post("/calculator.asmx").
		then()
			.statusCode(200)
			.log().all().and()
			.body("//AddResult.text()", equalTo("8"));
	}
	
}
