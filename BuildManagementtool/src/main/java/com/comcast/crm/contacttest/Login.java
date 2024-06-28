package com.comcast.crm.contacttest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	WebDriver driver;
	public Login(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements( driver,this);
	}
	@FindBy(name="user_name")
	private WebElement user;
	@FindBy(name="user_password")
	private WebElement password;
	@FindBy(id="submitButton")
	private WebElement login;
	
	public WebElement getLogin() {
		return login;
	}
	public WebElement getUser()
	{
		return user;
		
	}
	public WebElement getPassword()
	{
		return password;
		
	}

}
