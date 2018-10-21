package TestCases;

public class Test 
{
 public static void main(String[] args) 
 {
	 Test test = new Test();
	 test.test();

} 
 
 public void test()
 {
	 System.out.println(getClass().getResource("json_Document.json").getPath());
 }
}
