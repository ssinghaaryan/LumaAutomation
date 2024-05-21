package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(id = "input-email")
	private WebElement emailAddressField;
	
	@FindBy(id = "input-password")
	private WebElement passwordField;
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement noEmailPasswordMatchWarning;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions
	public void enterEmail(String email) {
		
		emailAddressField.sendKeys(email);
		
	}
	
	public void enterPassword(String password) {
		
		passwordField.sendKeys(password);
		
	}
	
//	public void clickLoginButton() {
//		
//		loginButton.click();
//		
//	}
	
	// For optimizing the code in the Login class
	public AccountPage clickLoginButton() {
		
		loginButton.click();
		return new AccountPage(driver);
		
	}
	
	public AccountPage login(String email, String password) {
		
		emailAddressField.sendKeys(email);
		passwordField.sendKeys(password);
		loginButton.click();
		return new AccountPage(driver);
		
	}
	
	public String noEmailPasswordMatchText() {
		
		String warningText = noEmailPasswordMatchWarning.getText();
		return warningText;
		
	}

}
