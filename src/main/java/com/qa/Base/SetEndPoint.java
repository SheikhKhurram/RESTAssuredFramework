package com.qa.Base;

import io.restassured.RestAssured;

public class SetEndPoint 
{
    
	
	public void setEndPoint()
	{
		RestAssured.baseURI =  "http://localhost"; 
		RestAssured.port =  8080;
		RestAssured.basePath = "";		
	}
	
	
}
