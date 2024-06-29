package com.examples;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateOrgwithverify {
	public static void main(String[] args) throws InterruptedException, IOException {
		//Property file
		FileInputStream fis =new FileInputStream("C:\\Users\\setti\\OneDrive\\Desktop\\personal\\commondata.properties");
		Properties ob =new Properties();
		ob.load(fis);
		String Browser =ob.getProperty("browser");
		String URL =ob.getProperty("url");
		String username =ob.getProperty("username");
		String pass =ob.getProperty("password");
		//Random number
		Random ra =new Random();
		int ran =ra.nextInt();
		//Excel file
		FileInputStream fu =new FileInputStream("C:\\TekPyramid\\Book1.xlsx");
		Workbook wb =WorkbookFactory.create(fu);
		Sheet s = wb.getSheet("Sheet1");
		Row r = s.getRow(4);
		String  orgname =r.getCell(2).toString()+ran;
		String industry =r.getCell(3).toString();
		String type =r.getCell(4).toString();
		wb.close();
		//Script
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get(URL);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pass);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	    driver.findElement(By.name("accountname")).sendKeys(orgname);
	    //Industry dropdown
	    WebElement in =driver.findElement(By.name("industry"));
	    Select se =new Select(in);
	    se.selectByVisibleText(industry);
	    //Type dropdown
	    WebElement de =driver.findElement(By.name("accounttype"));
	    Select su =new Select(de);
	    su.selectByVisibleText(type);
	    
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    // verify the industries dropdown  and type info
	    String actualindutries =driver.findElement(By.id("dtlview_Industry")).getText();
	    if(actualindutries.equals(industry))
	    {
	    	System.out.println("pass");
	    }
	    else
	    {
	    	System.out.println("Fail");
	    }
	    
	    String actualtype =driver.findElement(By.id("dtlview_Organization Name")).getText();
	    if(actualtype.equals(type))
	    {
	    	System.out.println("pass");
	    }
	    else
	    {
	    	System.out.println("fail");
	    }
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	     driver.quit();


}
}
