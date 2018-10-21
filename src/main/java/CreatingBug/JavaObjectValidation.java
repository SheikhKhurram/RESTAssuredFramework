package CreatingBug;

public class JavaObjectValidation 
{
      
	/**
	 * {
    "id": "10218",
    "key": "RES-33",
    "self": "http://localhost:8080/rest/api/2/issue/10218"
      }
	 * 
	 * **/
	private String id;
    private String key;
    private String self;

    public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getSelf() {
		return self;
	}

	public void setSelf(String self) {
		this.self = self;
	}

    public void setId(String id)
    {
    	this.id = id;
    }
	
	public String getId()
	{
		return id;
	}
	
}
