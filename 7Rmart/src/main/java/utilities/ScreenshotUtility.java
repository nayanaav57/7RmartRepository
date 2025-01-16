package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility {
	
	public void getScreenShot(WebDriver driver, String failedTestCase) throws IOException {
		TakesScreenshot scrShot = (TakesScreenshot) driver;// type casting, advantage- code reusability
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE);// the method to capture screenshot of the current browser window and will be saved as image file
		

File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot");// file path where screenshot is present
		if (!f1.exists()) {
			f1.mkdirs();
		}
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());// to get current date and time for that date class is used 
		String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedTestCase + timeStamp+ ".png";
		File finalDestination = new File(destination);
		
		FileHandler.copy(screenShot, finalDestination);
	}

}

