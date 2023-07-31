package com.norton.qa.tests;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.norton.qa.listener.TestAllureListener;
import com.norton.qa.utils.Constants;

import io.qameta.allure.Story;


@Story("User story 02: Norton supply Login functionality ")
@Listeners(TestAllureListener.class)
public class LoginPageTest extends BaseTest{
	
	@Test(priority = 1)
	public void LoginPageTitleTest() {
		String actualTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actualTitle,Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void LoginPageUrlTest() {
		
		Assert.assertTrue(loginPage.getLoginPageUrl());
	}
	
	@Test(priority = 3)
	public void isForgotPwdLinkExistsTest() {
		Assert.assertTrue(loginPage.isForwardpasswordLinkExists());
	}
	
	@Test(priority = 4)
	public void isRegisterAccountLinkExistsTest() {
		Assert.assertTrue(loginPage.isRegisteraccountLinkExists());
	}
	
	@Test(priority = 5)
	public void doLoginTest() {
		loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Assert.assertEquals(accountPage.getAccountPageTitle(), Constants.ACCOUNT_PAGE_TITLE);
	}
}
