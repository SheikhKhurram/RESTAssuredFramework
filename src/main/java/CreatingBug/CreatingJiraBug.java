package CreatingBug;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import GettingSessionID.GettingSessionID;
import Utilities.UtilityMethods;
import io.restassured.http.ContentType;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;
public class CreatingJiraBug 
{
      Response response;
      GettingSessionID gettingSessionID = new GettingSessionID();
       
	public Response creatingBug()
	{
		response = 
				given().
					contentType(ContentType.JSON)
					.header("Cookie" , UtilityMethods.getKey(gettingSessionID.gettingSessionID_POST_Request()))
					.body(" {\r\n" + 
							"  \"fields\" :\r\n" + 
							"        {\r\n" + 
							"        \"project\": \r\n" + 
							"        {\r\n" + 
							"            \"key\": \"RES\"\r\n" + 
							"        },\r\n" + 
							"        \r\n" + 
							"        \"summary\": \"Raising a bug from eclipse rest API\",\r\n" + 
							"        \r\n" + 
							"        \"description\": \"THis is invoked from java rest assured API he he automation\",\r\n" + 
							"        \r\n" + 
							"        \"issuetype\": \r\n" + 
							"        {\r\n" + 
							"            \"name\": \"Bug\"\r\n" + 
							"        }\r\n" + 
							"  }\r\n" + 
							"}")
				.when()
					.post("/api/2/issue")
				.then().log().all()
					.extract().response();
		
		return response;
	}
	
	
}
