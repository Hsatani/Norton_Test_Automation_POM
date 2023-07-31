package com.norton.qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.norton.qa.listener.TestAllureListener;
import com.norton.qa.utils.Constants;


@Listeners(TestAllureListener.class)
public class AccountPageTest extends BaseTest {
	
	
	
	@BeforeClass
	public void AccountPageSetup() {
		accountPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		System.out.println("Successfully logged in to the account");
		
	}
	
	@Test(priority = 1)
	public void AccountPageTitleTest() {
		String actualTitle = accountPage.getAccountPageTitle();
		Assert.assertEquals(actualTitle, Constants.ACCOUNT_PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void AccountPageHeaderTitleTest() {
		String actualTitle = accountPage.getAccountPageHeaderTitle();
		Assert.assertEquals(actualTitle, Constants.ACCOUNT_PAGE_HEADER_TITLE);
		
	}
	
	@Test(priority = 3)
	public void isLogoutLinkExistTest() {
		Assert.assertTrue(accountPage.isLogoutLinkExist());
	}

	@Test(priority = 4)
	public void isManageSubscriptionLinkExisteTest() {
		Assert.assertTrue(accountPage.ismanagesubscriptionlinkExist());
	}
	
	@Test(priority = 5)
	public void isViewAddressLinkExisteTest() {
		Assert.assertTrue(accountPage.isviewAddresslinkExist());
		
	}
	
	
	@Test(priority = 6)
	public void issearchfieldExistTest() {
		Assert.assertTrue(accountPage.issearchfieldExist());
	}
	
	
	@DataProvider
	public Object[][] productData(){
		return new Object[][] {{"laundry bags"}};
	}
	
	//{"Dry cleaner"}, {"liquid"}, 
	
	@Test(priority = 7, dataProvider = "productData")
	public void dosearchTest(String productname) {
		searchresultPage = accountPage.doSearch(productname);
		Assert.assertTrue(searchresultPage.getProductResultCount()>0);
		
	}
	 
//	
//	@DataProvider
//	public Object[][] selectproductData(){
//		return new Object[][] {
//								//{"Dry cleaner", "All Steam Iron With Hoses"}, 
//							    {"liquid","Tide Liquid 2X - 6/25 Oz."}
//								};
//	}
//	
//	
//	@Test(priority = 8, dataProvider = "selectproductData")
//	public void selectProductTest(String productname, String productName ) {
//		searchresultPage = accountPage.doSearch(productname);
//		productInfoPage = searchresultPage.selectProduct(productName);
//		Assert.assertEquals(productInfoPage.getProductHeaderName(),productName);
//	}
	

}
