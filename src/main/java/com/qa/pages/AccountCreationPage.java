package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreationPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//div[@id='content']/h1")
	private WebElement accountCreationHeading;
	
	public AccountCreationPage (WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public String getAccountCreationHeading() {
		
		String actualAccountCreationHeading = accountCreationHeading.getText();
		return actualAccountCreationHeading;
		
	}

}
