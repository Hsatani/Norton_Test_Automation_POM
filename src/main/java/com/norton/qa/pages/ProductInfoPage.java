package com.norton.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.norton.qa.utils.ElementUtil;
import com.norton.qa.utils.JavaScriptUtil;

public class ProductInfoPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	private JavaScriptUtil jsUtil;
	private By productHeaderName = By.xpath("//div[@id = 'ProductSection-template--15270540574911__main-7430950981']//nav[@class = 'breadcrumb']");
	private By quantitylabel = By.xpath("//label[@class = 'custom_lbl_cls']");
	private By increaseItemButton = By.xpath("//button[@class = 'js-qty__adjust js-qty__adjust--minus']");
	private By decreaseItemButton = By.xpath("//button[@class = 'js-qty__adjust js-qty__adjust--plus']");
	private By addtoCartBtn = By.xpath("//div[@class = 'atc_cart_button']//button[@class = 'btn btn--full add-to-cart']");
	private By newquantity = By.id("Quantity-template--15270540574911__main-7430950981");
	
	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
	}
	
	public String getProductHeaderName() {
		String ProductHeaderName = driver.findElement(productHeaderName).getText();
		return ProductHeaderName;
	}
	
	
	
	public String increaseItem() {
		jsUtil.clickElementByJS(driver.findElement(increaseItemButton));
		String quantity = eleUtil.doGetText(newquantity);
		return quantity;
	}
	
	public String decreaseItem() {
		jsUtil.clickElementByJS(driver.findElement(decreaseItemButton));
		String quantity = eleUtil.doGetText(newquantity);
		return quantity;
		
	}
	
	
	

}
