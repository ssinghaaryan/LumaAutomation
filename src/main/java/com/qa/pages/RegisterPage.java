package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
    //Objects
	@FindBy(id = "input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id = "input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id = "input-email")
	private WebElement emailField;
	
	@FindBy(id = "input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id = "input-password")
	private WebElement passwordField;
	
	@FindBy(id = "input-confirm")
	private WebElement confirmField;
	
	@FindBy(xpath = "//input[@name='agree']")
	private WebElement agreePrivacyPolicyField;
	
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath = "//input[@name='newsletter'][@value='1']")
	private WebElement newsletterOption;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement duplicateEmailWarning;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement privacyPolicyWarning;
	
	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarning;
	
	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarning;
	
	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarning;
	
	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarning;
	
	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;
	
	public RegisterPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
//	Actions
	public void enterFirstName(String firstName) {
		
		firstNameField.sendKeys(firstName);
		
	}
	
	public void enterLastName(String lastName) {
		
		lastNameField.sendKeys(lastName);
		
	}
	
	public void enterEmail(String email) {
		
		emailField.sendKeys(email);
		
	}
	
	public void enterTelephone(String telephone) {
		
		telephoneField.sendKeys(telephone);
		
	}
	
	public void enterPassword(String password) {
		
		passwordField.sendKeys(password);
		
	}
	
	public void enterConfirmPassword(String passwordConfirm) {
		
		confirmField.sendKeys(passwordConfirm);
		
	}
	
	public void selectPrivacyPolicy() {
		
		agreePrivacyPolicyField.click();
		
	}
	
//	public void selectContinue() {
//		
//		continueButton.click();
//		
//	}
	
	public AccountCreationPage selectContinue() {
		
		continueButton.click();
		return new AccountCreationPage(driver);
		
	}
	
	public void selectNewsletterOption() {
		
		newsletterOption.click();
		
	}
	
	public String getEmailDuplicateWarning() {
		
		String duplicateEmailWarningText = duplicateEmailWarning.getText();
		return duplicateEmailWarningText;
		
	}
	
	public String getPrivacyPolicyWarning() {
		
		String privacyPolicyWarningText = privacyPolicyWarning.getText();
		return privacyPolicyWarningText;
	}
	
	public String getFirstNameWarning() {
		
		String firstNameWarningText = firstNameWarning.getText();
		return firstNameWarningText;
		
	}
	
	public String getLastNameWarning() {
		
		String lastNameWarningText = lastNameWarning.getText();
		return lastNameWarningText;
		
	}
	
	public String getEmailWarning() {
		
		String emailWarningText = emailWarning.getText();
		return emailWarningText;
		
	}
	
	public String getTelephoneWarning() {
		
		String telephoneWarningText = telephoneWarning.getText();
		return telephoneWarningText;
		
	}
	
	public String getPasswordWarning() {
		
		String passwordWarningText = passwordWarning.getText();
		return passwordWarningText;
		
	}
	
	public AccountCreationPage allRegisterWithMandateFields(String firstName, String lastName, String email, String telephone, String password, String passwordConfirm) {
		
		firstNameField.sendKeys(firstName);
		lastNameField.sendKeys(lastName);
		emailField.sendKeys(email);
		telephoneField.sendKeys(telephone);
		passwordField.sendKeys(password);
		confirmField.sendKeys(passwordConfirm);
		agreePrivacyPolicyField.click();
		continueButton.click();
		return new AccountCreationPage(driver);
		
	}
	
	public AccountCreationPage allRegisterWithAllFields(String firstName, String lastName, String email, String telephone, String password, String passwordConfirm) {
		
		firstNameField.sendKeys(firstName);
		lastNameField.sendKeys(lastName);
		emailField.sendKeys(email);
		telephoneField.sendKeys(telephone);
		passwordField.sendKeys(password);
		confirmField.sendKeys(passwordConfirm);
		agreePrivacyPolicyField.click();
		newsletterOption.click();
		continueButton.click();
		return new AccountCreationPage(driver);
		
	}
	


}
