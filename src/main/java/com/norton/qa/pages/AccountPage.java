package com.norton.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.norton.qa.utils.Constants;
import com.norton.qa.utils.ElementUtil;
import com.norton.qa.utils.JavaScriptUtil;

public class AccountPage {
	
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	private JavaScriptUtil jsUtil;
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
	}
	
	private By logoutLink = By.linkText("Log out");
	private By headerTitle = By.xpath("//h1[@class = 'section-header__title']");
	private By searchfield = By.xpath("//div[@class = 'site-header__search desktop-search-icon small--hide  123vir']//form//input[@type = 'search']");
	private By seachbtn = By.xpath("//div[@class = 'site-header__search desktop-search-icon small--hide  123vir']//form//button[@type = 'submit']");
	private By managesubscriptionlink = By.linkText("Manage Subscriptions");
	private By viewAddresslink = By.linkText("View addresses (1)");
	private By accountName = By.xpath("//main[@id = 'MainContent']//p[@class = 'h5']");




	public String getAccountPageTitle() {
		return eleUtil.doGetTitle(Constants.ACCOUNT_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
		
	}
	
	public String getAccountName() {
		String name = eleUtil.doGetText(accountName);
		return name;
		
	}
	
	public String getAccountPageHeaderTitle() {
		return eleUtil.doGetText(headerTitle);
	}
	
	public boolean isLogoutLinkExist() {
		return eleUtil.doIsDisplayed(logoutLink);
	}
	
	public boolean ismanagesubscriptionlinkExist() {
		return eleUtil.doIsDisplayed(managesubscriptionlink);
	}
		
	public boolean isviewAddresslinkExist() {
		return eleUtil.doIsDisplayed(viewAddresslink);
	}
	
	public boolean issearchfieldExist() {
		return eleUtil.doIsDisplayed(searchfield);
	}
	
	public SearchResultPage doSearch(String productname) {
		System.out.println("searching the product: "+ productname);
     	eleUtil.doSendKeys(searchfield, productname);
     	jsUtil.clickElementByJS(driver.findElement(seachbtn));
     //	eleUtil.doClick(seachbtn);
  
	//	eleUtil.doActionsSendKeys(searchfield, productname);
	//	eleUtil.doActionClick(seachbtn);		
		return new SearchResultPage(driver);
		
	}
	
	
	public HomePage doLogout() {
		eleUtil.doClick(logoutLink);
		return new HomePage(driver);
	}
	
	
	
	
	
	
	
	
	
}
