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

public class CreateOrgWithphoneno {

	public static void main(String[] args) throws IOException, InterruptedException {
         //Property file
		FileInputStream  fis =new FileInputStream("C:\\Users\\setti\\OneDrive\\Desktop\\personal\\commondata.properties");
		Properties p =new Properties();
		p.load(fis);
		String url =p.getProperty("url");
		String username =p.getProperty("username");
		String pass =p.getProperty("password");
		//Random number
		Random ra =new Random();
		int ran =ra.nextInt();
		
		//excel file
		FileInputStream fu =new FileInputStream("C:\\TekPyramid\\Book1.xlsx");
		Workbook wb =WorkbookFactory.create(fu);
		Sheet s = wb.getSheet("Sheet1");
		Row r =s.getRow(7);
		String data =r.getCell(2).toString()+ran;
		String phonenumber =r.getCell(3).getStringCellValue();
		wb.close();
	
		// script
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(url);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pass);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	    driver.findElement(By.name("accountname")).sendKeys(data);
	    driver.findElement(By.id("phone")).sendKeys(phonenumber);
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    //verify the phone number
	    String ph =driver.findElement(By.id("dtlview_Phone")).getText();
	    if(ph.contains(phonenumber))
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
