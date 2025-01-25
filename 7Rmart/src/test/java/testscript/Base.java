package testscript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constants;
import utilities.ScreenshotUtility;
import utilities.WaitUtility;

public class Base {

	public WebDriver driver; // object is declared globally
	public ScreenshotUtility scrshot;
	public Properties properties;
	public FileInputStream fileinputstream;

	@BeforeMethod(alwaysRun = true)
	
	 /* public void initializebrowser() {
	  
	  driver = new ChromeDriver();
	  driver.get("https://groceryapp.uniqassosiates.com/admin/login");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  driver.manage().window().maximize(); }*/
	 

	@Parameters("browser")
	public void initializebrowser(String browser) throws Exception {

		try {
			properties = new Properties();
			fileinputstream = new FileInputStream(Constants.CONFIGFILE);
			properties.load(fileinputstream);
		} catch (Exception e) {
			System.out.println("file not found");
		}
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {

			throw new Exception("browser is not correct");
		}

		driver.get(properties.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICIT_WAIT));
		driver.manage().window().maximize();
	}

	@AfterMethod(alwaysRun = true)
	public void browserQuit(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) // status of test case is checked here
		{
			scrshot = new ScreenshotUtility();// creating object
			scrshot.getScreenShot(driver, iTestResult.getName());// calling method using the object if test case fail, pass driver and name of failed test case																
		}

		driver.quit();
	}

}
