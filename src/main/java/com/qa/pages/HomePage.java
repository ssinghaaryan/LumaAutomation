package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	//Objects
	@FindBy(xpath = "//span[text()='My Account']") // Account button xPath.
	private WebElement myAccountDropDown;
	
	@FindBy(linkText = "Login") // Login Button Link Text.
	private WebElement loginOption;
	
	@FindBy(linkText = "Register")
	private WebElement registerOption;
	
	@FindBy(xpath = "//input[contains(@class,'input-lg')]")
	private WebElement searchBoxField;
	
	@FindBy(xpath = "//div[@id='search']/descendant::button")
	private WebElement searchButton;
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this); // Also means -> PageFactory.initElements(driver, HomePage.class).
		
	}
	
	//Actions
	public void clickMyAccount() {
		
		myAccountDropDown.click();
		
	}
	
//	public void selectLoginOption() {
//		
//		loginOption.click();
//		
//	}
	
	// For Optimizing the code in the Login class.
	public LoginPage selectLoginOption() {
		
		loginOption.click();
		return new LoginPage(driver);
		
	}
	
	
	
//	public void selectRegisterOption() {
//		
//		registerOption.click();
//		
//	}
	
	//For code optimization.
	public RegisterPage selectRegisterOption() {
		
		registerOption.click();
		return new RegisterPage(driver);
		
	}
	
	// -> This method is basically a combination of clickMyAccount() and selectRegisterOption() to optimize the code.
	public RegisterPage navigateToRegisterPage() {
			
		myAccountDropDown.click();
		registerOption.click();
		return new RegisterPage(driver);
			
	}

	public void inputSeachBox(String product) {
		 
		searchBoxField.sendKeys(product);
		
	}
	
//	public void clickSearchButton() {
//		
//		searchButton.click();
//		
//	}
	
	public SearchPage clickSearchButton() {
		
		searchButton.click();
		return new SearchPage(driver);
		
	}
	
	public SearchPage searchProduct(String product) {
		
		searchBoxField.sendKeys(product);
		searchButton.click();
		return new SearchPage(driver);
		
	}
	
}


// Selenium 4 Lecture 15 - Scale Element Reference Exception

//Page Factor (a Design Pattern) is introduced my Selenium to avoid this Scale Element Reference Exception to support the Page Object Model Design Pattern