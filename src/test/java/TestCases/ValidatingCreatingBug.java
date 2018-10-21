package TestCases;

import java.io.File;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.Base.SetEndPoint;

import CreatingBug.CreatingJiraBug;
import GettingSessionID.GettingSessionID;
import Utilities.UtilityMethods;
import io.restassured.response.Response;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ValidatingCreatingBug 
{
	SetEndPoint setEndPoint;
	Response create_Response;
	Response session_Response;
	CreatingJiraBug creatingJiraBug;
	GettingSessionID getSessionID;
	String sessionKey = "";
	
	@BeforeTest
	public void setUp()
	{
		setEndPoint = new SetEndPoint();
		setEndPoint.setEndPoint();
	
		getSessionID = new GettingSessionID();
		 session_Response = getSessionID.gettingSessionID_POST_Request();
		
		sessionKey = UtilityMethods.getKey(session_Response);
		
		creatingJiraBug = new CreatingJiraBug();
		create_Response = creatingJiraBug.creatingBug(sessionKey);
	}
	
	
	@Test
	public void validating_Session_ID_StatusCode()
	{
	    Assert.assertEquals(UtilityMethods.getStatuscode(create_Response), HttpStatus.SC_CREATED ,"Status code is not 201");
	}
	
	@Test
	public void validating_SessionID_StatusResponseTime()
	{
		Assert.assertTrue(UtilityMethods.getResponseTime(create_Response) < 400 , "Reponse time more than 400ms");
	}
	
	
	@Test
	public void validating_jsonSchema()
	{
		System.out.println(this.getClass().getResource("json_Document.json").getPath());
		create_Response.then().assertThat().body(matchesJsonSchemaInClasspath("json_Document.json"));
		
	}
	
	
	
}
