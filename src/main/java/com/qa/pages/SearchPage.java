package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	WebDriver driver;
	
	@FindBy(linkText = "HP LP3065")
	private WebElement validProduct;
	
	@FindBy(xpath = "//div[@id='content']/h2/following-sibling::p")
	private WebElement invalidProductHeading;
	
	public SearchPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public boolean validProductDisplayStatus() {
		
		boolean displayStatus = validProduct.isDisplayed();
		return displayStatus;
		
	}
	
	public String getInvalidProductHeading() {
		
		String invalidProductHeadingText = invalidProductHeading.getText();
		return invalidProductHeadingText;
		
	}
	
}
