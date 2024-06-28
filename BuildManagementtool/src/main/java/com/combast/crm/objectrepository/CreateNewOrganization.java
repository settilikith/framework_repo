package com.combast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOrganization {
	WebDriver driver;
	public CreateNewOrganization(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(name = "accountname")
	private WebElement orgnameed;
	
	@FindBy(name="industry")
	private WebElement industrydb;
	
	@FindBy(id="phone")
	private WebElement phoneed;
	
	public WebElement getPhoneed() {
		return phoneed;
	}

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebutt;
		// TODO Auto-generated method stub

	public WebElement getOrgnameed() {
		return orgnameed;
	}

	public WebElement getSavebutt() {
		return savebutt;
	}
	public WebElement getIndustrydb()
	{
		return industrydb;
		
	}
	public void createorg(String orgname)
	{
		orgnameed.sendKeys(orgname);
		savebutt.click();
	}
	public void createorgna(String orgname,String industry)
	{
		orgnameed.sendKeys(orgname);
		Select se =new Select(industrydb);
		se.selectByVisibleText(industry);
		savebutt.click();
	}

	}


