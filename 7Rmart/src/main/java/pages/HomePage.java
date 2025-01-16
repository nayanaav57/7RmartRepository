package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class HomePage {
	
	WebDriver driver; 
 	public HomePage(WebDriver driver) //parameterized constructor
 	{ 
 		this.driver=driver; 
 		PageFactory.initElements(driver , this); //to initialize webElements
 		 
 	} 
 	
 	@FindBy(xpath="//li[@class='nav-item dropdown']//following-sibling::img")private WebElement clickadmin;
 	@FindBy(xpath="//li[@class='nav-item dropdown show']//following-sibling::a[@href='https://groceryapp.uniqassosiates.com/admin/logout']")private WebElement clicklogout;
 	@FindBy(xpath="//p[text()='Sign in to start your session']")private WebElement signinpage;
 	
 	
public void clickAdminInHomePage() {
	WaitUtility wait=new WaitUtility();
	wait.waitForElementToBeClickable(driver, clickadmin);
		clickadmin.click();	}


public void clickLogOut() {
	WaitUtility wait=new WaitUtility();
	wait.waitForElementToBeClickable(driver, clicklogout);
	clicklogout.click();	}

public boolean isSigninPageDisplayed() {
	
	return signinpage.isDisplayed();

}
}

