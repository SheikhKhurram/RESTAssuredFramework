package project;

import com.qa.Base.SetEndPoint;

import GettingSessionID.GettingSessionID;
import Utilities.UtilityMethods;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
public class CreatingProject 
{
    SetEndPoint setEndPoint;
    GettingSessionID gettingSessionID;
    Response sessionKeyResponse;
    Response createProjectResponse;
    
	public void SetUp()
	{
		setEndPoint = new SetEndPoint();
		setEndPoint.setEndPoint();
		gettingSessionID = new GettingSessionID();
		sessionKeyResponse = gettingSessionID.gettingSessionID_POST_Request();
	}
	
//	public void creatingProject()
//	{
//		createProjectResponse  = 
//				given()
//					.accept(ContentType.JSON)
//					.header("cookie" , UtilityMethods.getKey(sessionKeyResponse))
//					
//			 .when().get().thenReturn().
//				
//	    		 
//	}
}
