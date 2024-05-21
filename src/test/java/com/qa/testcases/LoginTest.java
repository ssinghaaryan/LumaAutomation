package com.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.pages.AccountPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.utils.Utilities;

public class LoginTest extends Base { 
	
	public LoginTest() {
		super();
	}
	
		public WebDriver driver; // -> This is declared "public" as this driver reference is getting used in the Listeners class for the OnFailure method for taking screenshot.
		LoginPage loginPage;
	
	@BeforeMethod
	public void setup() {
		
//		loadProperties(); // -> One way to load property file in Login i.e. as Base class is already extended, loadProperties() can be called easily like this.
		driver = browserAndOpenApp(prop.getProperty("browser"));
		
		HomePage homePage = new HomePage(driver);
		
		// -> This are the actions that are defined in the HomePage page class to avoid hard coding of the selectors.
		homePage.clickMyAccount();
		homePage.selectLoginOption();
		
		loginPage = homePage.selectLoginOption();
		
		// -> Above 2 lines replaced these 2 by using the POM in HomePage page class.
//		driver.findElement(By.xpath("//span[text()=\"My Account\"]")).click();
//		driver.findElement(By.linkText("Login")).click();
		
	}
	
	@DataProvider(name="validCredentialsProvider")
	public Object[][] supplyTestData() {
		
		Object[][] data = Utilities.getTestDataFromExcel("Login"); // Sheet Name on the excel is "Login".
		return data;
		
	}
	
	@Test(priority = 1, dataProvider="validCredentialsProvider")
	public void verifyLoginValidCredentials(String email, String password) {
//		WebDriverManager driver = new Driver();
		
		// 1. -> This is using the LoginPage page objects and actions for interacting with the elements. 
		// 2. -> This is commented out as it is being declared via HomePage page and here globally above.
//		LoginPage loginPage = new LoginPage(driver);
		
		// -> This  login() method in LoginPage page has all 3 functions of entering email, password and clicking the login button and also creating object for the AccountPage.
		AccountPage accountPage = loginPage.login(email, password);
		
//		loginPage.enterEmailAddress(email);
//		loginPage.enterPassword(password);
//		AccountPage accountPage = loginPage.clickLoginButton();
		
		// -> This is the standard way of finding element and interacting with it.
//		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
//		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPwd"));
//		driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();
		
		// -> This is commented out as it is declared in the LoginPage page and declared locally just above -> (AccounPage accountPage = new AccountPage(driver)).
//		AccountPage accountPage = new AccountPage(driver);
		
		Assert.assertTrue(accountPage.editAccountInfoFieldDisplayed(), "Edit Account Info not displayed");
		
	}
	
	@Test(priority = 2)
	public void verifyLoginInvalidCredentials() {
		
//		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.login(Utilities.generateEmailWithTimeStamp(), dataProp.getProperty("invalidPwd"));
		
		loginPage.enterEmail(Utilities.generateEmailWithTimeStamp());
		loginPage.enterPassword(dataProp.getProperty("invalidPwd"));
		loginPage.clickLoginButton();
		
//		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
//		driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("invalidPwd"));
//		driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();
	
		String actualWarningText = loginPage.noEmailPasswordMatchText();
		
//		String actualWarningText = driver.findElement(By.xpath("//div[contains(@class,\"alert-dismissible\")]")).getText();		
		String expectedWarningText = dataProp.getProperty("noEmailPwdMatchWarning");
		
		Assert.assertTrue(actualWarningText.contains(expectedWarningText), "Expected Warning Text not displayed");
		
	}
	
	@Test(priority = 3)
	public void verifyLoginInvalidEmailandValidPassword() {
		
//		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.enterEmail(Utilities.generateEmailWithTimeStamp());
		loginPage.enterPassword(prop.getProperty("validPwd"));
		loginPage.clickLoginButton();

//		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
//		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPwd"));
//		driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();
		
		String actualWarningText = loginPage.noEmailPasswordMatchText();
		
//		String actualWarningText = driver.findElement(By.xpath("//div[contains(@class,\"alert-dismissible\")]")).getText();
		String expectedWarningText = dataProp.getProperty("noEmailPwdMatchWarning");
		
		Assert.assertTrue(actualWarningText.contains(expectedWarningText), "Expected Warning Text not displayed");
		
	}
	
	@Test(priority = 4)
	public void verifyLoginValidEmailandInvalidPassword() {
		
//		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.enterEmail(prop.getProperty("validEmail"));
		loginPage.enterPassword(dataProp.getProperty("invalidPwd"));
		loginPage.clickLoginButton();

//		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
//		driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("invalidPwd"));
//		driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();
		
		String actualWarningText = loginPage.noEmailPasswordMatchText();
		
//		String actualWarningText = driver.findElement(By.xpath("//div[contains(@class,\"alert-dismissible\")]")).getText();
		String expectedWarningText = dataProp.getProperty("noEmailPwdMatchWarning");
		
		Assert.assertTrue(actualWarningText.contains(expectedWarningText), "Expected Warning Text not displayed");
		
	}
	
	@Test(priority = 5)
	public void verifyLoginNoCredentials() {
		
//		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.clickLoginButton(); // Only this cause -> no input in email and password fields are required.

//		driver.findElement(By.id("input-email")).sendKeys("");
//		driver.findElement(By.id("input-password")).sendKeys("");
//		driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();
		
		String actualWarningText = loginPage.noEmailPasswordMatchText();
		
		// -> This element that is found using xpath below is declared a WebElemtn in the LoginPage page and is sent here using the "noEmailPasswordMatchText" method above.
//		String actualWarningText = driver.findElement(By.xpath("//div[contains(@class,\"alert-dismissible\")]")).getText();
		String expectedWarningText = dataProp.getProperty("noEmailPwdMatchWarning");
		
		Assert.assertTrue(actualWarningText.contains(expectedWarningText), "Expected Warning Text not displayed");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
