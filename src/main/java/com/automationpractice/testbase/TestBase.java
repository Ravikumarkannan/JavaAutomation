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
import org.testng.annotations.DataProvider;

import com.automationpractice.constants.Constants;
import com.automationpractice.utilities.ExcelReader;
import com.automationpractice.utilities.PropertyReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	protected Logger log = Logger.getLogger(TestBase.class.getName());
	public ExcelReader excelReader = new ExcelReader();
	public PropertyReader reader = new PropertyReader();
	public static Properties properties;

	public void setDriver() {
		String browserName = properties.getProperty(Constants.BROWSER);
		String URL = properties.getProperty("application_URL");

		if (browserName.equalsIgnoreCase(Constants.BROWSER_CHROME)) {
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
		}
		
		log.info("Driver instance initialized");

		driver.get().get(URL);
		driver.get().manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		driver.get().manage().window().maximize();
	}

	public WebDriver getDriver() {
		return driver.get();
	}

	@BeforeSuite(alwaysRun = true)
	public void preSetup() {
		PropertyConfigurator.configure(Constants.PROPERTIES_LOG4J);
		properties = new Properties();
		properties = reader.loadAllFiles();
		log.info("Test has been Started");

	}

	@AfterSuite(alwaysRun = true)
	public void closeBrowser() {
		driver.remove();
		log.info("Test Completed");
	}

	@BeforeMethod(alwaysRun = true)
	public void driverSetup() {
		setDriver();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.get().close();
		driver.get().quit();
		log.info("Driver instance closed");
	}
	
//	@DataProvider(name = "loginTestData")
//	public Object dataProviderFunc() {
//		return new Object[][] {
//			{"testnew1","test@123"}
//		};
//	}
	
	@DataProvider(name = "loginTestData")
	public Object[][] loginData() {
		Object[][] loginDataArray= excelReader.getExcelData(Constants.EXCEL_FILE_PATH, "sheet1");
		return loginDataArray;
	}
	
}
