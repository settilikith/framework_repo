package com.comcast.crm.contacttest;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	WebDriver driver;
	public Homepage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(linkText = "Organizations")
	private WebElement orglink;
	public WebElement getOrglink() {
		return orglink;
	}

	public WebElement getSymbol() {
		return symbol;
	}

	public WebElement getSignout() {
		return signout;
	}
	@FindBy(linkText = "Contacts")
	private WebElement contactlink;
	
	@FindBy(linkText = "More")
	private WebElement moreopt;
	
	@FindBy(xpath = "//a[text()='Campaigns']")
	private WebElement campaign;
	
	@FindBy(xpath="//input[@value='Cancel  ']/preceding-sibling::input[@title='Save [Alt+S]']")
	private WebElement savebt;
	
	@FindAll({@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']"),@FindBy(xpath = "//img[@style='padding: 0px;padding-left:5px']/preceding::img[@style='padding: 0px;padding-left:5px']")})
	private WebElement symbol;
	
	@FindBys({@FindBy(xpath = "//a[text()='Sign Out']"),@FindBy(xpath = "//a[@href='index.php?module=Users&action=Logout']")})
	private WebElement signout;
	
	public WebElement getCampaign() {
		return campaign;
	}

	public WebElement getMoreopt() {
		return moreopt;
	}

	public WebElement getContactlink()
	{
		return contactlink;
		
	}
	public void  navigatetocampaign() {
		Actions act =new Actions(driver);
		act.moveToElement(campaign).perform();
		
	}
	public WebElement getSavebt() {
		return savebt;
	}
	public void navigatetosignout()
	{
		Actions act =new Actions(driver);
		act.moveToElement(symbol).perform();;
		signout.click();
	}
	

}
