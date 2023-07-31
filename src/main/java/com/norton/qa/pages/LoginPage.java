package com.norton.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.norton.qa.utils.Constants;
import com.norton.qa.utils.ElementUtil;

public class LoginPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	
	
	//By Locators
	private By emailid = By.id("CustomerEmail");
	private By pwd     = By.id("CustomerPassword");
	//private By signinbtn = By.xpath("//button[@type= 'submit' and @class = 'btn']//parent::p[@style = 'text-align: right;']");
	private By signinbtn = By.xpath("//p[@style = 'text-align: right;']//button[contains(@type,'submit')]");
	private By forgotpwdlink = By.id("RecoverPassword");
	private By registeraccountlink = By.id("customer_register_link");
	private By createAccountbtn = By.id("customer_register_link");



	//Page Actions Methods

	public String getLoginPageTitle(){
		return eleUtil.doGetTitle(Constants.LOGIN_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
	}
	
	public boolean getLoginPageUrl() {
		return eleUtil.waitForURLToContain(Constants.LOGIN_PAGE_URL_FRACTION,Constants.DEFAULT_TIME_OUT);	
	}
	
	
	public boolean isForwardpasswordLinkExists() {
		return eleUtil.doIsDisplayed(forgotpwdlink);
	}
	
	public boolean isRegisteraccountLinkExists() {
		return eleUtil.doIsDisplayed(registeraccountlink);
	}
	
	
	public AccountPage doLogin(String userid, String password) {
		eleUtil.doSendKeys(emailid, userid);
		eleUtil.doSendKeys(pwd, password);
		eleUtil.doClick(signinbtn);
		return new AccountPage(driver);
	}
	
	
	public RegistrationPage doRegisterAccount() {
		eleUtil.doClick(createAccountbtn);
		return new RegistrationPage(driver);
	}
	
	
	
	
	
	
	
	
}