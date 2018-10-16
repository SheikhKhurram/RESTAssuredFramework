package TestCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Base.SetEndPoint;

public class Validating_SessionID 
{
	SetEndPoint setEndPoint;
	@BeforeMethod 
	public void setUp()
	{
		setEndPoint = new SetEndPoint();
		setEndPoint.setEndPoint();
	}
	
	@Test
	public void validating_Session_ID()
	{
		
	}
}
