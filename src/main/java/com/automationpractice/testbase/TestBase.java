package com.automationpractice.testbase;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.automationpractice.constants.Constants;
import com.automationpractice.utilities.PropertyReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	protected Logger log = Logger.getLogger(TestBase.class.getName());
	public PropertyReader reader = new PropertyReader();
	public Properties properties;

	public void setDriver() {
		String browserName = properties.getProperty("browser");
		String URL = properties.getProperty("application_URL");

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
		}
		
		log.info("browser launched successfully");
		driver.get().manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		driver.get().manage().window().maximize();

		driver.get().get(URL);
		log.info("Successfully navigated to " +URL);
	}

	public WebDriver getDriver() {
		return driver.get();
	}

	@BeforeSuite(alwaysRun = true)
	public void preSetup() {
		PropertyConfigurator.configure(Constants.PROPERTIES_LOG4J);
		properties = new Properties();
		properties = reader.loadAllFiles();
		log.info("Test Started...");

	}

	@AfterSuite(alwaysRun = true)
	public void closeBrowser() {
		driver.get().quit();
		driver.remove();
		log.info("Test Completed");
	}

	@BeforeMethod(alwaysRun = true)
	public void driverSetup() {
		log.info("driver Initialized");
		setDriver();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.get().close();
		log.info("Driver instance killed");
	}
}
