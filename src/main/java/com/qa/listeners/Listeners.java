package com.qa.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.utils.ExtentReporter;
import com.qa.utils.Utilities;

public class Listeners implements ITestListener {
	
	ExtentReports extentReport;
	ExtentTest extentTest;

	@Override
	public void onTestStart(ITestResult result) {
		
		// -> This means that we are generating a test in the report.
		extentTest = extentReport.createTest(result.getName());
		// -> This is for logging the details for test case into the report. 
		extentTest.log(Status.INFO, result.getName() + " started executing");
//		System.out.println(testName + " started executing");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		extentTest.log(Status.PASS, result.getName() + " successfully executed");
//		System.out.println(testName + " successfully executed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		// -> Code for taking the screenshot and adding it to the "Screenshots" folder.
		WebDriver driver = null;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		
		// -> Receiving the screenshot path from the Utilities class where the code for it is defined.
		String screenshotDestinationPath = Utilities.captureScreenshot(driver, result.getName());
		
		extentTest.addScreenCaptureFromPath(screenshotDestinationPath);
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, result.getName() + " got failed");
		
	}
	

	@Override
	public void onTestSkipped(ITestResult result) {
		
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, result.getName() + " got skipped");
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		System.out.println("Execution started.");
		
		extentReport = ExtentReporter.generateExtenedReport();
		
	}

	@Override
	public void onFinish(ITestContext context) {
	
		extentReport.flush();
		
		String pathOfReportFile = System.getProperty("user.dir") + "/test-output/ExtentReports/extentReport.html";
		File extentReport = new File(pathOfReportFile);
		
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}













