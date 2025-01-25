package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PageUtility {

	public void javaSriptClick(WebDriver driver, WebElement element) {// java script click is used if normal click does
																		// not work
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void scrollBy(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
	}

	public String generateCurrentDateAndTime() {

		Date date = new Date();
		SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		return formater.format(date);
	}

	public void dragAndDrop(WebDriver driver, WebElement drag, WebElement drop) {

		Actions action = new Actions(driver);
		action.dragAndDrop(drag, drop).build().perform();// move to location it has to be dropped
	}

	public void doubleClick(WebDriver driver, WebElement element) {

		Actions action = new Actions(driver);
		action.doubleClick(element).build().perform();

	}

	public void rightClick(WebDriver driver, WebElement element) {

		Actions action = new Actions(driver);
		action.contextClick(element).build().perform();
	}

	public void performMouseHovering(WebDriver driver, WebElement element) {

		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

}
