package Selenium.api.bdd;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;							//Important static imports
import static io.restassured.RestAssured.*;




public class GetApi{
	
	@Test
	public void getapiresponse() {
		
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/employees";
		
		Response response= 
		
		
		given()
		.when()
			.get()			//or we can pass url directly inside too instead of base uri
			
		.then()
			.statusCode(200)
			.and()
			.statusLine("HTTP/1.1 200 OK")
			.and()
		//.body("employee_name",contains("venky"))
			
			.and()
			.header("Content-Type","text/html; charset=UTF-8")
			.log().all()
			.extract().response();
			
			
		System.out.println(response.getBody().asString());
		JsonPath path = response.jsonPath();
		System.out.println(path.get("[0].employee_name"));
		
	}
	
	
	
	
	
}