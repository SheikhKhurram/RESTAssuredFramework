package TestCases;

import java.net.http.HttpResponse;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Base.SetEndPoint;

import GettingSessionID.GettingSessionID;
import Utilities.UtilityMethods;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasItems;

public class Validating_SessionID 
{
	SetEndPoint setEndPoint;
	GettingSessionID gettingSessionID;
	Response response;
	
	@BeforeMethod 
	public void setUp()
	{
		setEndPoint = new SetEndPoint();
		setEndPoint.setEndPoint();
		gettingSessionID = new GettingSessionID();
		response = gettingSessionID.gettingSessionID_POST_Request();
	}
	
	@Test
	public void validating_Session_ID_StatusCode()
	{
	    Assert.assertEquals(UtilityMethods.getStatuscode(response), HttpStatus.SC_OK);
	}
	
	@Test
	public void validating_SessionID_StatusResponseTime()
	{
		Assert.assertTrue(UtilityMethods.getResponseTime(response) < 400 , "Reponse time more than 400ms");
	}
	
	@Test
	public void validating_SessionID_validatingJsonString()
	{
		response.then().assertThat().body("session" , hasItems("name" , "value"));
	}
	
	@Test
	public void validation_jsonSchemaValidation()
	{
	
	}
}
