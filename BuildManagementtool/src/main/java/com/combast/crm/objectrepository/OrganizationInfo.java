package com.combast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfo {
	WebDriver driver;
	public OrganizationInfo(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements( driver,this);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createneworganization;
	@FindBy(name = "search_text")
	private WebElement searchfororg;
	@FindBy(name="search_field")
	private WebElement dropdownfororg;
	@FindBy(name = "submit")
	private WebElement searchbtt;
	
	public WebElement getDropdownfororg() {
		return dropdownfororg;
	}
	public WebElement getSearchbtt() {
		return searchbtt;
	}
	public WebElement getCreatenewOrganization() {
		return createneworganization;
		
	}
	public WebElement getSearchfororg() {
		return searchfororg;
	}
	

}
