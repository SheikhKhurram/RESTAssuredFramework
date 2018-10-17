package TestCases;

import java.io.File;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Base.SetEndPoint;

import CreatingBug.CreatingJiraBug;
import GettingSessionID.GettingSessionID;
import Utilities.UtilityMethods;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
public class ValidatingCreatingBug 
{
	SetEndPoint setEndPoint;
	Response response;
	
	@BeforeMethod
	public void setUp()
	{
		setEndPoint = new SetEndPoint();
		setEndPoint.setEndPoint();	
		CreatingJiraBug creatingJiraBug = new CreatingJiraBug();
		response = creatingJiraBug.creatingBug();
	}
	
	
	@Test
	public void validating_Session_ID_StatusCode()
	{
	    Assert.assertEquals(UtilityMethods.getStatuscode(response), HttpStatus.SC_CREATED ,"Status code is not 201");
	}
	
	@Test
	public void validating_SessionID_StatusResponseTime()
	{
		Assert.assertTrue(UtilityMethods.getResponseTime(response) < 400 , "Reponse time more than 400ms");
	}
	
	
	@Test
	public void validating_jsonSchema()
	{
		response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("C:\\Users\\khurram\\eclipse-workspace"
				+ "\\REST_API_Framework\\src\\test\\java\\CreateBug.json"));
		
	}
	
	
	
}
