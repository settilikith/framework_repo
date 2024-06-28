package com.combast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgInfor {
	WebDriver driver;
	public OrgInfor(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements( driver,this);
		// TODO Auto-generated constructor stub
	}
	@FindBy(className = "dvHeaderText")
	private WebElement verifyed;
	public WebElement getVerifyed() {
		return verifyed;
	}
	

}
