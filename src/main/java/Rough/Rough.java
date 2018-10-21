package Rough;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import GettingSessionID.GettingSessionID;
import Utilities.UtilityMethods;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Rough 
{
      
	Response response; 
	String key;
	
	@BeforeMethod
	public void setup ()
	{
		GettingSessionID get = new GettingSessionID();
		response = get.gettingSessionID_POST_Request();
		key = UtilityMethods.getKey(response);	
		System.out.println(key );
	}

	
	@Test
	public void test()
	{
		response = 
				given().
				header("Cookie", key).
				header("Content-Type" , "application/json")
					.body("{\r\n" + 
							" \"fields\": {\r\n" + 
							"        \"project\": {\r\n" + 
							"            \"key\": \"RES\"\r\n" + 
							"        },\r\n" + 
							"        \"summary\": \"Testing\",\r\n" + 
							"        \r\n" + 
							"        \"issuetype\": {\r\n" + 
							"            \"name\": \"Bug\"\r\n" + 
							"        },\r\n" + 
							"        \"priority\": {\r\n" + 
							"            \"name\": \"High\"\r\n" + 
							"        },\r\n" + 
							"   \r\n" + 
							"        \"description\": \"description\"\r\n" + 
							"        \r\n" + 
							"    }\r\n" + 
							"}")
				.when()
					.post("/api/2/issue")
				.then().log().all()
					.extract().response();
		
	}
	
}
