package com.comcast.crm.contacttest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganization {
	WebDriver driver;
	public CreateOrganization(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	}	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createneworganization;
	
	@FindBy(name = "accountname")
	private WebElement orgnameed;

	
	public WebElement getCreatenewOrganization() {
		return createneworganization;
		
	}
	public WebElement  getOrgnameed() {
		return orgnameed ;
		
	}

}
