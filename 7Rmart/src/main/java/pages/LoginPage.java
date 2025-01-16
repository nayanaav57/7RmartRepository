package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import utilities.PageUtility;
//import utilities.WaitUtility;

public class LoginPage {
	
	WebDriver driver; 
 	public LoginPage(WebDriver driver) //parameterized constructor
 	{ 
 		this.driver=driver; 
 		PageFactory.initElements(driver , this); //to initialize webElements
 		 
 	} 
 	//@FindBy(xpath="//input[@type='text']")private WebElement usernameField;//syntax
 	@FindBy(xpath="//input[@name='username']")private WebElement usernameField;
 	@FindBy(xpath="//input[@name='password']")private WebElement passwordfield;
 	@FindBy(xpath="//button[@type='submit']")private WebElement signbutton;
 	@FindBy(xpath="//p[text()='Dashboard']")private WebElement dashboardvalue;
 	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")private WebElement alertmessage;
 	
 	public void enterUserName(String usernamevalue) {
 		usernameField.sendKeys(usernamevalue);
 	}
 	public void enterPassWord(String passwordvalue) {
 		passwordfield.sendKeys(passwordvalue);
 	}
 	public void submitClick() {
 		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
 		//wait.until(ExpectedConditions.elementToBeClickable(signbutton));
 		//WaitUtility wait = new WaitUtility();//applying wait using method created in wait utility class
 		//wait.waitForElementToBeClickable(driver, signbutton);
 		signbutton.click();
 		//PageUtility page =new PageUtility();// program execution using method created in page utility class
 		//page.javaSriptClick(driver, signbutton);// passing driver and webelement name given for clicking button
 		
 	}
 	
 	public boolean isDashboardDisplayed() {
 		return dashboardvalue.isDisplayed();
 	}
 	
 	public boolean isAlertMessageDisplayed() {
 		//WaitUtility wait = new WaitUtility();//applying wait using method created in wait utility class
 		//wait.waitForAlertToBeVisible(driver);
 		return alertmessage.isDisplayed();
 	}
}

 	

