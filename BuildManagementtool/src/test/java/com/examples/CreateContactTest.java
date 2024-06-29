package com.examples;

import org.testng.annotations.Test;
import com.crm.generic.baseutility.ExampleClass;

public class CreateContactTest extends ExampleClass {
	@Test(groups="smokeTest")
	public void createContact()
	{
		System.out.println("execute createContact");
	}
	@Test(groups="regressionTest")
	public void createContactWithDate()
	{
		System.out.println("execute createContactwithDate");
	}

}
