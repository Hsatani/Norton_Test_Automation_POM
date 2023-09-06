package com.norton.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.norton.qa.utils.Constants;
import com.norton.qa.utils.ElementUtil;
import com.norton.qa.utils.JavaScriptUtil;

public class HomePage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		new JavaScriptUtil(driver);
	}
	
	
	
	private By actbtn = By.xpath("//a[@class = 'site-nav__link site-nav__link--icon small--hide']");
	
	
	public String getHomePageTitle() {
		return eleUtil.doGetTitle(Constants.HOME_PAGE_TITLE,Constants.DEFAULT_TIME_OUT);
	}
	
	
	
	
	public AccountPage navigateToAccountPage() {
		 eleUtil.doClick(actbtn);
		 
		 return new AccountPage(driver);
	}
}
