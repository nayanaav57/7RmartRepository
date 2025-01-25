package pages;

//import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.WaitUtility;

public class ManageProductPage {

	WebDriver driver;

	public ManageProductPage(WebDriver driver) // parameterized constructor
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); // to initialize webElements

	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product']//following-sibling::i[@class='fas fa-arrow-circle-right']")
	private WebElement moreinfobutton;
	@FindBy(xpath = "(((//tbody//descendant::tr)[1]//td)[9]//a[@class='btn btn-sm btn btn-danger btncss'])")
	private WebElement deletebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alert;

	

	public ManageProductPage deleteButton() {

		// WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		// wait.until(ExpectedConditions.elementToBeClickable(deletebutton));
		WaitUtility wait = new WaitUtility();
		wait.waitForElementToBeClickable(driver, deletebutton);
		deletebutton.click();
		driver.switchTo().alert().accept();
		return this;
	}

	public boolean isAlertMessageDisplayed() {
		return alert.isDisplayed();
	}
}
