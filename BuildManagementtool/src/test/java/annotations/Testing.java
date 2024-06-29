package annotations;

import org.testng.annotations.Test;

public class Testing {
	
	@Test(priority = 1,dependsOnMethods ="method2",invocationCount = 2,threadPoolSize = 2,timeOut = 1000 )
	public void  method()
	{
		System.out.println("working");
	}
	@Test
	public void method2()
	{
		System.out.println("used");
	}

}
