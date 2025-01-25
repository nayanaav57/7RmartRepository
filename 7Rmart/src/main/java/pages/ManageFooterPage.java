package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class ManageFooterPage {

	WebDriver driver;

	public ManageFooterPage(WebDriver driver) // parameterized constructor
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); // to initialize webElements

	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext']//following-sibling::i[@class='fas fa-arrow-circle-right']")
	private WebElement moreinfobutton;
	@FindBy(xpath = "(//tbody//descendant::tr)[1]//a[@class='btn btn-sm btn btn-primary btncss']")
	private WebElement editbutton;
	@FindBy(xpath = "//textarea[@id='content']")
	private WebElement enteraddress;
	@FindBy(xpath = "//input[@id='email']")
	private WebElement enteremail;
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement enterphonenumber;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-info']")
	private WebElement updatebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alert;

	

	public ManageFooterPage clickEditButton() {
		editbutton.click();
		return this;
	}

	public ManageFooterPage enterAddress(String address) {
		enteraddress.clear();
		enteraddress.sendKeys(address);
		return this;
		
	}

	public ManageFooterPage enterEmail(String email) {
		enteremail.clear();
		enteremail.sendKeys(email);
		return this;
	}

	public ManageFooterPage enterPhoneNumber(String phonenumber) {
		enterphonenumber.clear();
		enterphonenumber.sendKeys(phonenumber);
		return this;
	}

	public ManageFooterPage clickUpdateButton() {
		// WaitUtility wait=new WaitUtility();
		// wait.waitForElementToBeClickable(driver, updatebutton);
		updatebutton.click();
		return this;
	}

	public boolean isAlertMessageDisplayed() {
		return alert.isDisplayed();
	}

	public boolean isUpdateButtonDisplayed() {
		return updatebutton.isDisplayed();
	}
}
