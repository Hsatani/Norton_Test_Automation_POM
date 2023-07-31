package com.norton.qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.norton.qa.listener.TestAllureListener;
import com.norton.qa.utils.Constants;
import com.norton.qa.utils.ExcelUtil;


@Listeners(TestAllureListener.class)
public class RegistrationTest extends BaseTest{
	
	
	@BeforeClass
	public void setupRegistration() {
		registrationPage = loginPage.doRegisterAccount();
	}
	
	
	
	@DataProvider
	public Object[][] getRegisterData() {
		return ExcelUtil.getTestData(Constants.REGISTER_SHEET_NAME);
	}
	
	@Test(dataProvider = "getRegisterData")
	public void userRegistrationPageTest(String fName, String lName, String email, String pwd) {
		homePage = registrationPage.doregistration( fName,  lName,  email,  pwd);
		String ActualTitle = homePage.getHomePageTitle();
		Assert.assertEquals(Constants.HOME_PAGE_TITLE, ActualTitle);
		
//		accountPage = homePage.navigateToAccountPage();
//		String accName = accountPage.getAccountName();
//		Assert.assertEquals(accName, "Hello, fName!");
		
	}

}
 