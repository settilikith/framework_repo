package com.examples;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.commons.math3.geometry.spherical.twod.Edge;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CreateContactWithOrg {

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
		int ran=ra.nextInt(1000);
		//Excel
		FileInputStream fa =new FileInputStream("C:\\TekPyramid\\Book1.xlsx");
		Workbook wb =WorkbookFactory.create(fa);
		Sheet s =wb.getSheet("Sheet2");
		Row r = s.getRow(7);
		String orgname = r.getCell(2).toString()+ran;
		String contactLastName =r.getCell(3).getStringCellValue();
		wb.close();
		// Script
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(url);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pass);
		driver.findElement(By.id("submitButton")).submit();
		//create organizations
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//verify organization name
				String o=driver.findElement(By.id("mouseArea_Organization Name")).getText();
				if(o.contains(orgname))
				{
					System.out.println("pass");
				}
				else
				{
					System.out.println("Fail");
				}
		
		Thread.sleep(2000);
		//Create contacts
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(contactLastName);
		
		//add the organization with contacts
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		
		//switch to child window
		Set<String> acc =driver.getWindowHandles();
		Iterator<String> it =acc.iterator();
		while(it.hasNext())
		{
			String wid =it.next();
			driver.switchTo().window(wid);
			String cu =driver.getCurrentUrl();
			if(cu.contains("module=Accounts"))
			{
				break;
			}
		}
		Thread.sleep(2000);
		driver.findElement(By.name("search_text")).sendKeys(orgname);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		//switchto parent window
		Set<String> set = driver.getWindowHandles();
		Iterator<String> i =set.iterator();
		while(i.hasNext())
		{
			String w =i.next();
			driver.switchTo().window(w);
			String c =driver.getCurrentUrl();
			if(c.contains("Contacts&action"))
			{
				break;
			}
		}
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//verify Header contact name
		String h =driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(h.contains(contactLastName))
		{
			System.out.println("pass");
			
		}
		else
		{
			System.out.println("Fail");
		}
		
		
				
		driver.quit();
		
		

	}

}

