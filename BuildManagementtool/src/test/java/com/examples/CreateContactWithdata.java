package com.examples;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
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

public class CreateContactWithdata {

	public static void main(String[] args) throws IOException, InterruptedException {
		//property file
				FileInputStream fis =new FileInputStream("C:\\Users\\setti\\OneDrive\\Desktop\\personal\\commondata.properties");
				Properties p = new Properties();
				p.load(fis);
				String url =p.getProperty("url");
				String username =p.getProperty("username");
				String pass =p.getProperty("password");
				//Random
				Random ra = new Random();
				int ran=ra.nextInt();
				//Excel
				FileInputStream fa =new FileInputStream("C:\\TekPyramid\\Book1.xlsx");
				Workbook wb =WorkbookFactory.create(fa);
				Sheet s =wb.getSheet("Sheet2");
				Row r = s.getRow(4);
				String lastname = r.getCell(2).toString()+ran;
				wb.close();
				//script
				WebDriver driver=new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.manage().window().maximize();
				driver.get(url);
				driver.findElement(By.xpath("//input[@type='text']")).sendKeys(username);
				driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pass);
				driver.findElement(By.id("submitButton")).submit();
				driver.findElement(By.xpath("//a[text()='Contacts']")).click();
				driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
				//date formate
				java.util.Date dateobj =new java.util.Date();
				SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
				String start =sim.format(dateobj);
				System.out.println(start);
				Calendar cal =sim.getCalendar();
				cal.add(Calendar.DAY_OF_MONTH, +30);
				String end =sim.format(cal.getTime());
				System.out.println(end);
				driver.findElement(By.name("lastname")).sendKeys(lastname);
				//supported data
			WebElement e=driver.findElement(By.name("support_start_date"));
			e.clear();
			e.sendKeys(start);
			//end data
			WebElement u =driver.findElement(By.name("support_end_date"));
			u.clear();
			u.sendKeys(end);
//			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			
			//verify the start and end data
			String startdate=driver.findElement(By.id("dtlview_Support Start Date")).getText();
			System.out.println(startdate);
			if(startdate.contains(start))
			{
				System.out.println("Pass");
			}
			else
			{
				System.out.println("Fail");
			}
		String enddate=driver.findElement(By.id("dtlview_Support End Date")).getText();
		System.out.println(enddate);
		if(enddate.contains(end))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.quit();
		// TODO Auto-generated method stub

	}

}
