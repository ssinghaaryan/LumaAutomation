package com.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.pages.HomePage;
import com.qa.pages.SearchPage;

public class SearchTest extends Base {
	
	public SearchTest() {
		super();
	}
	
	public WebDriver driver; // -> This is declared "public" as this driver reference is getting used in the Listeners class for the OnFailure method for taking screenshot.
	SearchPage searchPage;
	HomePage homePage;
	
	@BeforeMethod
	public void setup() {
		
		driver = browserAndOpenApp(prop.getProperty("browser"));
		homePage = new HomePage(driver);
		
	}
	
	@Test(priority = 1)
	public void searchWithValidProducts() {
		
//		HomePage homePage = new HomePage(driver);
		searchPage = homePage.searchProduct(dataProp.getProperty("validProduct"));
		
		// -> This is commented out as both inputSearchBox() and clickSearchButton() are declared in the HomePage page under the searchProduct(), so just calling the method is sufficient.
//		homePage.inputSeachBox(dataProp.getProperty("validProduct"));
//		searchPage = homePage.clickSearchButton();
		
//		driver.findElement(By.xpath("//input[contains(@class,'input-lg')]")).sendKeys(dataProp.getProperty("validProduct"));
//		driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		
		// -> This is commented out as SearchPage object is created in HomePage page under the clickSearchButton() method and is declared here globally.
//		SearchPage searchPage = new SearchPage(driver);
		
		Assert.assertTrue(searchPage.validProductDisplayStatus(), "Valid Product not displayed");
		
//		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
		
	}
	
	@Test(priority = 2)
	public void searchWithInvalidProducts() {
		
//		HomePage homePage = new HomePage(driver);
		
		searchPage = homePage.searchProduct(dataProp.getProperty("invalidProduct"));
		
//		homePage.inputSeachBox(dataProp.getProperty("invalidProduct"));
//		searchPage = homePage.clickSearchButton();
		
//		driver.findElement(By.xpath("//input[contains(@class,'input-lg')]")).sendKeys(dataProp.getProperty("invalidProduct"));
//		driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		
//		SearchPage searchPage = new SearchPage(driver);
		
		String actualSearchMessage = searchPage.getInvalidProductHeading(); 
		
//		String actualSearchMessage = driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText();
		Assert.assertEquals(actualSearchMessage, dataProp.getProperty("noProductMatchWarning"), "No message displayed for invalid search");
		
	}
	
	@Test(priority = 3, dependsOnMethods="searchWithInvalidProducts")
	public void searchWithNoProduct() {
		
//		HomePage homePage = new HomePage(driver);
		
		searchPage = homePage.clickSearchButton();
		
//		driver.findElement(By.xpath("//input[contains(@class,'input-lg')]")).sendKeys("");
//		driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		
//		SearchPage searchPage = new SearchPage(driver);
		
		String actualSearchMessage = searchPage.getInvalidProductHeading();
		
//		String actualSearchMessage = driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText();
		Assert.assertEquals(actualSearchMessage, dataProp.getProperty("noProductMatchWarning"), "No message displayed for invalid search");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
