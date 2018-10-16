package GettingSessionID;

import java.util.HashMap;
import java.util.Map;

public class GetSessionID_Body 
{
       
	protected static Map getbody()
	{
		 Map<String ,Object> object =  new HashMap<String, Object>();
		 object.put("username", "sheik.kurram93" );
		 object.put("password", "123456");
	 
		 return object;
		 
	}
}
