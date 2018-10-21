package CreatingBug;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import GettingSessionID.GettingSessionID;
import Utilities.UtilityMethods;
import io.restassured.http.ContentType;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.sun.org.apache.bcel.internal.classfile.JavaClass;
public class CreatingJiraBug 
{
      Response response;
      GettingSessionID gettingSessionID = new GettingSessionID();
       
      
      
	public Response creatingBug(String sessionKey)
	{
		response = 
				given().
					contentType(ContentType.JSON)
					.header("cookie" , sessionKey)
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
				.then().log().body()
					.extract().response();
		response.as(JavaObjectValidation.class);
		 // System.out.println(UtilityMethods.getKey(gettingSessionID.gettingSessionID_POST_Request();
		return response;
	}
	
	
}
