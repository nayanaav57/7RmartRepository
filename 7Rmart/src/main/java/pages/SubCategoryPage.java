package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import constants.Constants;
import utilities.FileUploadUtility;

public class SubCategoryPage {
	WebDriver driver;

	public SubCategoryPage(WebDriver driver) // parameterized constructor
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); // to initialize webElements

	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']//following-sibling::i[@class='fas fa-arrow-circle-right']")
	private WebElement moreinfobutton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newbutton;
	@FindBy(xpath = "//select[@class='form-control selectpicker']")
	private WebElement dropdown;
	@FindBy(xpath = "//input[@id='subcategory']")
	private WebElement entersubcategory;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement choosefile;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	private WebElement savebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alert;

	

	public SubCategoryPage clickNewButton() {
		newbutton.click();
		return this;
	}

	public SubCategoryPage selectDropDown() {

		Select text = new Select(dropdown);
		text.selectByVisibleText("pen");
		return this;
	}

	public SubCategoryPage enterSubcategory(String subcategory) {
		entersubcategory.sendKeys(subcategory);
		return this;
	}

	public SubCategoryPage fileUpload() {

		FileUploadUtility fileupload = new FileUploadUtility();
		fileupload.fileUploadUsingSendKeys(choosefile, Constants.PENIMAGE);
		return this;
		// choosefile.sendKeys("C:\\Users\\nayan\\Downloads\\pen.jpg");
	}

	public SubCategoryPage clickSaveButton() {
		savebutton.click();
		return this;
	}

	public boolean isAlertMessageDisplayed() {
		return alert.isDisplayed();
	}
}
