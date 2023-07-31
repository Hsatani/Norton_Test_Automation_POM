package com.norton.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.norton.qa.utils.ElementUtil;
import com.norton.qa.utils.JavaScriptUtil;

public class RegistrationPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	private JavaScriptUtil jsUtil;
	
	
	private  By fName = By.id("FirstName");
	private  By lName = By.id("LastName");
	private By email = By.id("Email");
	private By pwd = By.id("CreatePassword");
	private By createbtn = By.xpath("//input[@type = 'submit']");
	
//	private  By fName = By.xpath("//input[@id = 'FirstName']");
//	private  By lName = By.xpath("//input[@id = 'LastName']");
//	private By email = By.xpath("//input[@id = 'Email']");
//	private By pwd = By.xpath("//input[@id = 'CreatePassword']");
//	private By createbtn = By.xpath("//input[@type = 'submit']");
//	
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
	}
	
	
	public HomePage doregistration(String fName, String lName, String email, String pwd) {
		
		eleUtil.doSendKeys(this.fName, fName);
		eleUtil.doSendKeys(this.lName, lName);
		eleUtil.doSendKeys(this.email,email);
		eleUtil.doSendKeys(this.pwd, pwd);
		
		eleUtil.doClick(createbtn);
		return new HomePage(driver);
		
	}
	
	

}
