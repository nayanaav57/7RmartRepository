package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.WaitUtility;

public class AdminUsersPage {
	WebDriver driver; 
 	public AdminUsersPage(WebDriver driver) //parameterized constructor
 	{ 
 		this.driver=driver; 
 		PageFactory.initElements(driver , this); //to initialize webElements
 		 
 	} 
	
	//@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")private WebElement moreinfobutton;
	
	@FindBy(xpath="(//div[@class='col-lg-3 col-6']//following::i[@class='fas fa-arrow-circle-right'])[1]")private WebElement moreinfobutton;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")private WebElement newbutton;
	
	@FindBy(xpath="//input[@id='username']")private WebElement enternewusername;
	
	@FindBy(xpath="//input[@id='password']")private WebElement enternewpassword;
	
	@FindBy(xpath="//select[@id='user_type']")private WebElement dropdown;
	
	@FindBy(xpath="//button[@name='Create']")private WebElement clicksave;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement alert;
	
	@FindBy(xpath="(((//tbody//descendant::tr)[1]//td)[5]//a[@class='btn btn-sm btn btn-danger btncss'])")private WebElement deletebutton;
	
	
	
public void clickMoreInfo() {
		
		moreinfobutton.click();	}

public void clickNewButton() {
	
	newbutton.click();	}

public void enterusername(String newusername) {
	
	enternewusername.sendKeys(newusername);
}
public void enterpassword(String newpassword) {
	
	enternewpassword.sendKeys(newpassword);
}

public void selectDropDown() {
	
	Select text=new Select(dropdown);
	text.selectByVisibleText("Admin");
}
public void clickSaveButton() {
	
	clicksave.click();	}


public void delete() {
	
	//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	//wait.until(ExpectedConditions.elementToBeClickable(deletebutton));
	WaitUtility wait=new WaitUtility();
	wait.waitForElementToBeClickable(driver, deletebutton);
	deletebutton.click();
	driver.switchTo().alert().accept();
	}
public boolean isAlertMessageDisplayed() {
	return alert.isDisplayed();
}

}
