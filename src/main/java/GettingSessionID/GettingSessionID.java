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
	private SetEndPoint setEndPoint;
	private Response response;
	
	
//	public void gettingSessionID_setup()
//	{
//		setEndPoint = new SetEndPoint();
//		setEndPoint.setEndPoint();
//	}
//	
     
	public Response gettingSessionID_POST_Request()
	{
	
	 response = 
		given()
		.contentType(ContentType.JSON)
		.body(GetSessionID_Body.getbody())
		.when()
		.post("/rest/auth/1/session")
		.then()
		.extract().response();
	
	       return response; 
		
	}
	
	
	
}
