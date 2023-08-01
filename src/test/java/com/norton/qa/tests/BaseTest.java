package com.norton.qa.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.norton.qa.factory.DriverFactory;
import com.norton.qa.pages.AccountPage;
import com.norton.qa.pages.HomePage;
import com.norton.qa.pages.LoginPage;
import com.norton.qa.pages.ProductInfoPage;
import com.norton.qa.pages.RegistrationPage;
import com.norton.qa.pages.SearchResultPage;


public class BaseTest {
	
	
	DriverFactory df;
	WebDriver driver;
	Properties prop;
	LoginPage loginPage;
	AccountPage accountPage;
	SearchResultPage searchresultPage;
	ProductInfoPage productInfoPage;
	RegistrationPage registrationPage;
	HomePage homePage;
	
	
	
	@BeforeTest
	public void setup() {
		
		df = new DriverFactory();
		prop = df.init_prop();
		driver = df.initDriver(prop);
		loginPage = new LoginPage(driver);
		accountPage = new AccountPage(driver);
		homePage = new HomePage(driver);
		registrationPage = new RegistrationPage(driver);
		
		
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
		
	}
}
