package com.combast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	WebDriver driver;
    public Login(WebDriver driver)
   {
	   this.driver=driver;
	   PageFactory.initElements( driver,this);
   }
    @FindBy(name = "user_name")
    private WebElement usernameEd;
    @FindBy(name = "user_password")
    private WebElement passwordEd;
    @FindBy(id="submitButton")
	private WebElement loginEd;
	public WebElement getUsername() {
		return usernameEd;
	}
	public WebElement getPassword() {
		return passwordEd;
	}
	public WebElement getLogin() {
		return loginEd;
	}
	public void loginToapp(String url,String username,String password)
	{
		driver.get(url);
		driver.manage().window().maximize();
		usernameEd.sendKeys(username);
		passwordEd.sendKeys(password);
		loginEd.click();
         
	}
    

}
