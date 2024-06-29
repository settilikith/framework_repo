package annotations;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.combast.crm.objectrepository.CreateNewOrganization;
import com.comcast.crm.contacttest.CreateOrganization;
import com.comcast.crm.contacttest.Createnewcontract;
import com.comcast.crm.contacttest.Homepage;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.crm.generic.baseutility.Baseclass;

public class Createcontact extends Baseclass{
	@Test(groups="smokeTest")
	public void  createcontacttest() throws EncryptedDocumentException, Throwable {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		String orgname =ej.readdatafromexcel("Sheet2", 1, 2)+j.getRandomNumber();
		//Homepage
		Homepage h =new Homepage(driver);
				h.getOrglink().click();		
		
		Thread.sleep(2000);
		//new Organization
		CreateOrganization cc =new CreateOrganization(driver);
		cc.getCreatenewOrganization().click();
		cc.getOrgnameed().sendKeys(orgname);
		h.getSavebt().click();
		Thread.sleep(2000);
		//new contract
		 h.getContactlink().click();
		h.navigatetocampaign();
		Createnewcontract c =new Createnewcontract(driver);
		c.getPlus().click();
		c.getContractfirst().sendKeys(orgname);
		c.getContractlast().sendKeys(orgname);
		c.getOrgsy().click();
		
		c.NavigatetoChildwindow();
		c.getSearchtext().sendKeys(orgname);
		c.getSearchin().click();
		
		WebElement ul =driver.findElement(By.xpath("//a[text()='"+orgname+"']"));
		ul.click();
	    c.Navigatetoparentwindow();
		h.getSavebt().click();
	}

	@Test(groups="regressionTest")
	public void createcontactwithorgtest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		String orgname =ej.readdatafromexcel("Sheet2", 1, 2)+j.getRandomNumber();
		//Homepage
		Homepage hp =new Homepage(driver);
				hp.getOrglink().click();		
		
		Thread.sleep(2000);
		//new Organization
		CreateOrganization cc =new CreateOrganization(driver);
		cc.getCreatenewOrganization().click();
		cc.getOrgnameed().sendKeys(orgname);
		hp.getSavebt().click();
		
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
		//new contract
		hp.getContactlink().click();
		hp.navigatetocampaign();
		Createnewcontract c =new Createnewcontract(driver);
		c.getPlus().click();
		c.getContractfirst().sendKeys(orgname);
		c.getContractlast().sendKeys(orgname);
		c.getOrgsy().click();
		
		c.NavigatetoChildwindow();
		c.getSearchtext().sendKeys(orgname);
		c.getSearchin().click();
		
		WebElement ul =driver.findElement(By.xpath("//a[text()='"+orgname+"']"));
		ul.click();
	    c.Navigatetoparentwindow();
		hp.getSavebt().click();	
	}
	@Test(groups="regressionTest")
	public void createContactWithsupportDateTest() throws Throwable, IOException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		String orgname=ej.readdatafromexcel("Sheet2", 4, 2);
		
		java.util.Date dateobj =new java.util.Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String start =sim.format(dateobj);
		System.out.println(start);
		Calendar cal =sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 30);
		String end =sim.format(cal.getTime());
		System.out.println(end);
		
				Homepage hp =new Homepage(driver);
				hp.getContactlink().click();
				

		
		Thread.sleep(2000);
		Createnewcontract c =new Createnewcontract(driver);
		c.getPlus().click();
		c.getContractlast().sendKeys(orgname);
		//supported data
		WebElement e=driver.findElement(By.name("support_start_date"));
		e.clear();
		e.sendKeys(start);
		//end data
		WebElement u =driver.findElement(By.name("support_end_date"));
		u.clear();
		u.sendKeys(end);
				hp.getSavebt().click();
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
	}

}
