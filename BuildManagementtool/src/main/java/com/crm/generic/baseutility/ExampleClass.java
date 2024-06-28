package com.crm.generic.baseutility;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class ExampleClass {
	@BeforeSuite
	public void configBs()
	{
		System.out.println("Connect to DB,Report config");
	}
	@BeforeClass
	public void configBC()
	{
		System.out.println("Launch the browser");
	}
	@BeforeMethod
	public void configBM()
	{
		System.out.println("login");
	}
	@AfterMethod
	public void configAM()
	{
		System.out.println("logout");
	}
	@AfterClass
	public void configAc()
	{
		System.out.println("close the browser");
	}
	
	@AfterSuite
	public void configAs()
	{
		System.out.println("close Db,Report backup");
	}


}
