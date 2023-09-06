package com.norton.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.norton.qa.utils.ElementUtil;
import com.norton.qa.utils.JavaScriptUtil;

public class SearchResultPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	private JavaScriptUtil jsUtil;
	private By productResultsItems = By.xpath("//div[@id='snize-search-results-grid-mode']//li");	
	private By productItems = By.xpath("//div[@id='snize-search-results-grid-mode']//li//span[@class = 'snize-title']");
	
	
	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
	}
	
	
	
	public int getProductResultCount() {
		int resultcount = eleUtil.waitForElementsToBeVisible(productResultsItems, 60, 10000).size();
		System.out.println("search product count is:" + resultcount);
		return resultcount;
	}
	
	public ProductInfoPage selectProduct(String productName) {
		List<WebElement> productList = eleUtil.waitForElementsToBeVisible(productItems, 60, 10000);
		for(WebElement e : productList) {
			String pname = e.getText();
			if(pname.equals(productName)) {
				e.click();
				break;
			}
		}
		return new ProductInfoPage(driver);
	}
	
	
	
	

}
