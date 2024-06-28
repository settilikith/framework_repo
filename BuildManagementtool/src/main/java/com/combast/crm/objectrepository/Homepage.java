package com.combast.crm.objectrepository;

import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mysql.jdbc.Driver;

public class Homepage {
	WebDriver driver;
	public Homepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	@FindBy(linkText = "Organizations")
	private WebElement orglink;
	@FindBy(linkText = "Contacts")
	private WebElement contactlink;
	public WebElement getContactlink() {
		return contactlink;
	}
	
	@FindBy(linkText = "More")
	private WebElement morelink;
	@FindBy(linkText = "Campaigns")
	private WebElement campaignlink;
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement  symbol;
	@FindBy(linkText = "Sign Out")
	private WebElement signout;
	@FindBy(xpath = "//a[text()='Products']")
	private WebElement productlink;
	private WebElement getProductlink() {
		return productlink;
	}
	public WebElement getSignout() {
		return signout;
	}
	public WebElement getSymbol() {
		return symbol;
	}
	
	public WebElement getOrglink() {
		return orglink;
	}
		public WebElement getMorelink() {
		return morelink;
		
	}
	public  WebElement getCampaignlink() {
		return campaignlink;
		
	}
	public void navigateTocampaginpage() {
		Actions act =new Actions(driver);
		act.moveToElement(morelink).perform();
		campaignlink.click();
		
	}
	public void logoutbutt()
	{
		Actions act =new Actions(driver);
		act.moveToElement(symbol).perform();
		signout.click();
	}

}
