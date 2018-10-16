package GettingSessionID;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.qa.Base.SetEndPoint;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class GettingSessionID 
{
	SetEndPoint setEndPoint;
	Response response;
	
	
	@BeforeMethod
	public void gettingSessionID_setup()
	{
		setEndPoint = new SetEndPoint();
		setEndPoint.setEndPoint();
	}
	
     @Test
	public void gettingSessionID_POST_Request()
	{
	
	 response = 
		given()
		.contentType(ContentType.JSON)
		.body(GetSessionID_Body.getbody())
		.when()
		.post("/rest/auth/1/session")
		.then().log().headers()
		.extract().response();
	
		JsonPath json = response.jsonPath();
         
		String name = json.get("session.name");
		String value = json.get("session.value");
	
		
		//return name + "=" + value; 
		
	}
	
	
	
}
