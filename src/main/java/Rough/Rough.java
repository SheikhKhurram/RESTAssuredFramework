package Rough;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CreatingBug.JavaObjectValidation;
import GettingSessionID.GettingSessionID;
import Utilities.UtilityMethods;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Rough 
{
      
	Response response; 
	String key;
	JavaObjectValidation j;
	
	@BeforeTest
	public void setup ()
	{
		GettingSessionID get = new GettingSessionID();
		response = get.gettingSessionID_POST_Request();
		key = UtilityMethods.getKey(response);	
		 j = new JavaObjectValidation();
		//System.out.println(key );
	}

	
	@Test (priority = 1)
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
					.post("rest/api/2/issue")
				.then()
					.extract().response();
		
		j = response.as(JavaObjectValidation.class);
		
	}
	
	@Test(priority = 2)
	public void validatingId()
	{
		Assert.assertEquals( j.getId(), "10227");
	}
	
}
