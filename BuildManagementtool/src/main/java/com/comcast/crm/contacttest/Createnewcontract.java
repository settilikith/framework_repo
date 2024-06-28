package com.comcast.crm.contacttest;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class Createnewcontract {
	WebDriver driver;
	JavaUtility j=new JavaUtility();
	public Createnewcontract(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver,this);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement Plus;
	
	@FindBy(name =  "firstname")
	private WebElement contractfirst;
	
	@FindBy(name="lastname")
	private WebElement contractlast;
	
	
	@FindBy(xpath = "//input[@name='account_id']/following-sibling::img[@title='Select']")
	private WebElement orgsy;
	
	@FindBy(name = "search_text")
	private WebElement searchtext;
	
	@FindBy(name = "search")
	private WebElement searchin;
	
	@FindBy(name="support_start_date")
	private WebElement startdata;
	
	@FindBy(name ="support_end_date")
	private WebElement enddata;
	@FindBy(xpath ="//span[@class='dvHeaderText']")
	private WebElement headermsg;
	
	public WebElement getHeadermsg() {
		return headermsg;
	}

	public WebElement getStartdata() {
		return startdata;
	}

	public WebElement getEnddata() {
		return enddata;
	}

	public WebElement getSearchin() {
		return searchin;
	}

	public WebElement getSearchtext() {
		return searchtext;
	}

	public WebElement getOrgsy() {
		return orgsy;
	}
	
	public  WebElement getPlus() {
		return Plus;
		
	}
	public WebElement getContractfirst()
	{
		return contractfirst;
		
	}
	public WebElement getContractlast(){
		return contractlast;
		
		
	}
	public void NavigatetoChildwindow()
	{
		Set<String> set =driver.getWindowHandles();
		Iterator<String> i=set.iterator();
		while(i.hasNext())
		{
			String w=i.next();
			driver.switchTo().window(w);
			String actual =driver.getCurrentUrl();
			if(actual.contains("module=Accounts"))
			{
				break;
			}
		}
		
	}
	public void Navigatetoparentwindow()
	{
		Set<String> set =driver.getWindowHandles();
		Iterator<String> i=set.iterator();
		while(i.hasNext())
		{
			String w=i.next();
			driver.switchTo().window(w);
			String actual =driver.getCurrentUrl();
			if(actual.contains("Contacts&action"))
			{
				break;
			}
		}
	}
	
}
