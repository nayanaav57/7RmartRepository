package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	
	WebDriver driver; 
 	public ManageNewsPage(WebDriver driver) //parameterized constructor
 	{ 
 		this.driver=driver; 
 		PageFactory.initElements(driver , this); //to initialize webElements
 		 
 	} 
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']//following-sibling::i")private WebElement moreinfobutton;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")private WebElement newbutton;
	@FindBy(xpath="//textarea[@id='news']")private WebElement enternews;
	@FindBy(xpath="//button[text()='Save']")private WebElement savebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement alert;
	public void clickMoreInfo() {
		
		moreinfobutton.click();	}
	
public void clickNewButton() {
		
		newbutton.click();	}

public void enterNews(String newsdata) {
	
	enternews.sendKeys(newsdata);
}
public void clickSaveButton() {
	
	savebutton.click();	}

public boolean isAlertMessageDisplayed() {
		return alert.isDisplayed();
	}
}
