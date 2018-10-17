package Utilities;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class UtilityMethods 
{
     
	public static long getResponseTime(Response reponse)
	{
		return reponse.getTime();
	}
	
	public static int getStatuscode(Response response)
	{
		return response.getStatusCode();
	}
	
	public static Object validatingBody(Response response , String jsonPath)
	{
		return response.body().jsonPath().get(jsonPath);
	}
	
	public static String getKey(Response response)
	{
		JsonPath json = response.jsonPath();
		String name = json.getString("session.name");
		String value = json.getString("session.value");
		return name+"="+value;
	}
	
	
}
