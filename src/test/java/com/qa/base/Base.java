package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.utils.Utilities;

public class Base {

	WebDriver driver;

	public Properties prop;
	public Properties dataProp;

	public Base() {

		prop = new Properties();
		File propFile = new File(System.getProperty("user.dir") + "/src/main/java/com/qa/config/config.properties");

		try {

			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);

		} catch (Throwable e) {

			e.printStackTrace();

		}

		dataProp = new Properties();
		File dataPropFile = new File(System.getProperty("user.dir") + "/src/main/java/com/qa/testdata/testdata.properties");

		try {

			FileInputStream fis2 = new FileInputStream(dataPropFile);
			dataProp.load(fis2);

		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

	public WebDriver browserAndOpenApp(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("safari")) {

			driver = new SafariDriver();

		}

//		driver = new ChromeDriver(); // -> This duplicate line was launching the browser twice on every test.
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIMEOUT));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIMEOUT));
		driver.get(prop.getProperty("url"));

		return driver;

	}

}
