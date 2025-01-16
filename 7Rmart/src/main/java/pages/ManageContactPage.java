package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageContactPage {
	
	WebDriver driver; 
 	public ManageContactPage(WebDriver driver) //parameterized constructor
 	{ 
 		this.driver=driver; 
 		PageFactory.initElements(driver , this); //to initialize webElements
 		 
 	} 
 	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact']//following-sibling::i")private WebElement moreinfobutton;
 	@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']")private WebElement editbutton;
 	@FindBy(xpath="//input[@id='phone']")private WebElement enterphonenumber;
 	@FindBy(xpath="//input[@id='email']")private WebElement enteremail;
 	@FindBy(xpath="//textarea[@name='address']")private WebElement enteraddress;
 	@FindBy(xpath="//textarea[@name='del_time']")private WebElement enterdeliverytime;
 	@FindBy(xpath="//input[@id='del_limit']")private WebElement enterdeliverychargelimit;
 	@FindBy(xpath="//button[@class='btn btn-block-sm btn-info']")private WebElement updatebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement alert;
	
	public void clickMoreInfo() {
		moreinfobutton.click();	
	}
	public void clickEditButton() {
		editbutton.click();	
	}
	public void enterPhoneNumber(String phonenumber) {
		enterphonenumber.clear();
		enterphonenumber.sendKeys(phonenumber);
	}
	public void enterEmail(String email) {
		enteremail.clear();
		enteremail.sendKeys(email);
	}
	public void enterAddress(String address) {
		enteraddress.clear();
		enteraddress.sendKeys(address);
	}
	public void enterDeliveryTime(String time) {
		enterdeliverytime.clear();
		enterdeliverytime.sendKeys(time);
	}
	public void enterDeliveryChargeLimit(String chargelimit) {
		enterdeliverychargelimit.clear();
		enterdeliverychargelimit.sendKeys(chargelimit);
	}
    
    public void clickUpdateButton() {
    	
    	PageUtility page=new PageUtility();
    	page.javaSriptClick(driver, updatebutton);
    	
		//updatebutton.click();	
	}
    public boolean isAlertMessageDisplayed() {
    	return alert.isDisplayed();
    }
    public boolean isUpdateButtonDisplayed() {
    	return updatebutton.isDisplayed();
    }
	
	
}
