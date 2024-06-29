package maven;

import org.testng.annotations.Test;

public class ContactTest {
	@Test
	public void createcontactTest()
	{
		String url=System.getProperty("url");
		String browser=System.getProperty("browser");
		String username=System.getProperty("username");
		String password=System.getProperty("password");
		System.out.println(browser);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		System.out.println("execute createcontactTest");
	}
	@Test
	public void modifycontactTest()
	{
		System.out.println("execute modifycontactTest");
	}

}
