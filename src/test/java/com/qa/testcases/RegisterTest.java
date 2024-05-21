package com.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.pages.AccountCreationPage;
import com.qa.pages.HomePage;
import com.qa.pages.RegisterPage;
import com.qa.utils.Utilities;

public class RegisterTest extends Base {
	
	public RegisterTest() {
		super();
	}
 
//	WebDriver driver = new ChromeDriver() -> Initializing this way throw error where browser was quitting after 1st test case and was not getting started again for the following cases. Hence declared as below and initialized in setup().
	public WebDriver driver; // -> This is declared "public" as this driver reference is getting used in the Listeners class for the OnFailure method for taking screenshot.
	RegisterPage registerPage;
	AccountCreationPage accountCreationPage;
	
	@BeforeMethod
	public void setup() {
		
		driver = browserAndOpenApp(prop.getProperty("browser"));
		
		HomePage homePage = new HomePage(driver);
		
		registerPage = homePage.navigateToRegisterPage();
		
		// This and below line is commented out as naviagateToRegisterPage() has both these lines in HomePage page.
//		homePage.clickMyAccount();
		
		// -> This is written like this because RegisterPage object is created in the selectRegistrationOption method in HomePage page, and is declared here this way and globally above.
//		registerPage = homePage.selectRegisterOption();
		
//		driver.findElement(By.xpath("//span[text()=\"My Account\"]")).click();
//		driver.findElement(By.linkText("Register")).click();
		
	}
	
	@Test(priority = 1)
	public void validRegisterWithMandateCredentials() {
		
		// -> This is commented out as RegisterPage object is created in HomePage page and declared globally above.
//		RegisterPage registerPage = new RegisterPage(driver);
		
		// -> This is the more optimized way of working with elements.
		accountCreationPage = registerPage.allRegisterWithMandateFields(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), Utilities.generateEmailWithTimeStamp(), dataProp.getProperty("telephone"), dataProp.getProperty("validPwd"), dataProp.getProperty("validPwd"));
		
		// -> All these are commented out as the above allRegisterWithMandateFields() is used to for all the fields and declared together in the RegisterPage page.
		// -> This is the 2nd way of working with elements.
/*		registerPage.enterFirstName(dataProp.getProperty("firstName"));
		registerPage.enterLastName(dataProp.getProperty("lastName"));
		registerPage.enterEmail(Utilities.generateEmailWithTimeStamp());
		registerPage.enterTelephone(dataProp.getProperty("telephone"));
		registerPage.enterPassword(dataProp.getProperty("validPwd"));
		registerPage.enterConfirmPassword(dataProp.getProperty("validPwd"));
*/	
		
//		registerPage.selectPrivacyPolicy();
//		accountCreationPage = registerPage.selectContinue();
		
		// -> This is the very first way of finding elements and performing actions.
/*		driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
		driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephone"));
		driver.findElement(By.id("input-password")).sendKeys("01234");
		driver.findElement(By.id("input-confirm")).sendKeys("01234");  
		driver.findElement(By.xpath("//input[@name=\"agree\"]")).click();
		driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();
*/		
		// -> This is commented out as AccountCreationPage object is created in RegisterPage page and declared globally above.
//		AccountCreationPage accountCreationPage = new AccountCreationPage(driver);
		
		String actualSuccessHeading = accountCreationPage.getAccountCreationHeading();
		
//		String actualSuccessHeading = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		Assert.assertEquals(actualSuccessHeading, dataProp.getProperty("accountCreatedWarning"), "Account Creation Page not visible");

	}

	@Test(priority = 2)
	public void validRegisterWithAllFields() {
		
//		RegisterPage registerPage = new RegisterPage(driver);
		
		registerPage.allRegisterWithAllFields(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), prop.getProperty("validEmail"), dataProp.getProperty("telephone"), dataProp.getProperty("validPwd"), dataProp.getProperty("validPwd"));
		
/*		registerPage.enterFirstName(dataProp.getProperty("firstName"));
		registerPage.enterLastName(dataProp.getProperty("lastName"));
		registerPage.enterEmail(Utilities.generateEmailWithTimeStamp());
		registerPage.enterTelephone(dataProp.getProperty("telephone"));
		registerPage.enterPassword("01234");
		registerPage.enterConfirmPassword("01234");
		registerPage.selectPrivacyPolicy();
		registerPage.selectNewsletterOption();
		accountCreationPage = registerPage.selectContinue();
*/
		
/*		driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
		driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephone"));
		driver.findElement(By.id("input-password")).sendKeys("01234");
		driver.findElement(By.id("input-confirm")).sendKeys("01234");
		driver.findElement(By.xpath("//input[@name=\"agree\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"newsletter\"][@value=\"1\"]")).click(); // This field is what is included additionally.
		driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();
*/
		
//		AccountCreationPage accountCreationPage = new AccountCreationPage(driver);
		
		String actualSuccessHeading = accountCreationPage.getAccountCreationHeading();
		
//		String actualSuccessHeading = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		Assert.assertEquals(actualSuccessHeading, dataProp.getProperty("accountCreatedWarning"), "Account Creation Page not visible");

	}
	
	@Test(priority = 3)
	public void verifyRegisterWithExistingEmail() {
		
//		RegisterPage registerPage = new RegisterPage(driver);
		
		registerPage.allRegisterWithAllFields(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), prop.getProperty("validEmail"), dataProp.getProperty("telephone"), dataProp.getProperty("validPwd"), dataProp.getProperty("validPwd"));
		
/*		registerPage.enterFirstName(dataProp.getProperty("firstName"));
		registerPage.enterLastName(dataProp.getProperty("lastName"));
		registerPage.enterEmail(prop.getProperty("validEmail"));
		registerPage.enterTelephone(dataProp.getProperty("telephone"));
		registerPage.enterPassword("01234");
		registerPage.enterConfirmPassword("01234");
		registerPage.selectPrivacyPolicy();
		registerPage.selectNewsletterOption();
		registerPage.selectContinue();
*/

/*		driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));
		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
		driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephone"));
		driver.findElement(By.id("input-password")).sendKeys("01234");
		driver.findElement(By.id("input-confirm")).sendKeys("01234");
		driver.findElement(By.xpath("//input[@name=\"agree\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"newsletter\"][@value=\"1\"]")).click();
		driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();
*/
		
//		String actualSuccessHeading = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		
		String actualWarning = registerPage.getEmailDuplicateWarning();
		
//		String actualWarning = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();		
		Assert.assertTrue(actualWarning.contains(dataProp.getProperty("existingEmailWarning")), "Warning regarding email duplicate not displayed");
		
//		Assert.assertEquals(actualSuccessHeading, "Your Account Has Been Created!", "Account Creation Page not visible");
		
	}
	
	@Test(priority = 4)
	public void verifyRegisterWithoutInput() {
		
//		RegisterPage registerPage = new RegisterPage(driver);
		
		registerPage.selectContinue();
		
//		driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();
		
		//Privacy Warning
		String actualPrivacyWarning = registerPage.getPrivacyPolicyWarning();
//		String actualPrivacyWarning = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		Assert.assertTrue(actualPrivacyWarning.contains(dataProp.getProperty("privacyWarning")), "Privacy Policy warning not displayed");
		
		//First Name
		String actualFirstNameWarning = registerPage.getFirstNameWarning();
//		String actualFirstNameWarning = driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText();
		Assert.assertTrue(actualFirstNameWarning.contains(dataProp.getProperty("firstNameWarning")), "First Name warning not displayed");
		
		//Last Name
		String actualLastNameWarning = registerPage.getLastNameWarning();
//		String actualLastNameWarning = driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText();
		Assert.assertTrue(actualLastNameWarning.contains(dataProp.getProperty("lastNameWarning")), "Last Name warning not displayed");

		//Email
		String actualEmailWarning = registerPage.getEmailWarning();
//		String actualEmailWarning = driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText();
		Assert.assertTrue(actualEmailWarning.contains(dataProp.getProperty("emailWarning")), "Email warning not displayed");

		//Telephone
		String actualTelephoneWarning = registerPage.getTelephoneWarning();
//		String actualTelephoneWarning = driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText();
		Assert.assertTrue(actualTelephoneWarning.contains(dataProp.getProperty("telephoneWarning")), "Telephone Warning not displayed");
		
		//Password
		String actualPasswordWarning = registerPage.getPasswordWarning();
//		String actualPasswordWarning = driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText();
		Assert.assertTrue(actualPasswordWarning.contains(dataProp.getProperty("pwdWarning")), "Password Warning not displayed");
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}

}

























































