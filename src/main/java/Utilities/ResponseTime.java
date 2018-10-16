package Utilities;

import io.restassured.response.Response;

public class ResponseTime 
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
	
}
