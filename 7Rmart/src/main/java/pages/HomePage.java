package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) // parameterized constructor
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); // to initialize webElements

	}

	@FindBy(xpath = "//li[@class='nav-item dropdown']//following-sibling::img")
	private WebElement clickadmin;
	@FindBy(xpath = "//li[@class='nav-item dropdown show']//following-sibling::a[@href='https://groceryapp.uniqassosiates.com/admin/logout']")
	private WebElement clicklogout;
	@FindBy(xpath = "//p[text()='Sign in to start your session']")
	private WebElement signinpage;
	@FindBy(xpath = "(//div[@class='col-lg-3 col-6']//following::i[@class='fas fa-arrow-circle-right'])[1]")
	private WebElement moreinfobutton_of_adminuserspage;
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact']//following-sibling::i")
	private WebElement moreinfobutton_of_managecontactpage;
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext']//following-sibling::i[@class='fas fa-arrow-circle-right']")
	private WebElement moreinfobutton_of_managefooterpage;
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']//following-sibling::i")
	private WebElement moreinfobutton_of_managenewspage;
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product']//following-sibling::i[@class='fas fa-arrow-circle-right']")
	private WebElement moreinfobutton_of_manageproductpage;
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']//following-sibling::i[@class='fas fa-arrow-circle-right']")
	private WebElement moreinfobutton_of_subcategorypage;
	
	public AdminUsersPage clickMoreInfoButtonForAdminUsersPage() {
		moreinfobutton_of_adminuserspage.click();
		return new AdminUsersPage(driver);
	}
	
	public ManageContactPage clickMoreInfoButtonForManageContactPage() {
		moreinfobutton_of_managecontactpage.click();
		return new ManageContactPage(driver);
	}
	public ManageFooterPage clickMoreInfoButtonForManageFooterPage() {
		moreinfobutton_of_managefooterpage.click();
		return new ManageFooterPage(driver);
	}
	
	public ManageNewsPage clickMoreInfoButtonForManageNewsPage() {

		 moreinfobutton_of_managenewspage.click();
		return new ManageNewsPage(driver);
	}
	
	public ManageProductPage clickMoreInfoButtonForManageProductPage() {

		moreinfobutton_of_manageproductpage.click();
		return new ManageProductPage(driver);
	}
	public SubCategoryPage clickMoreInfoButtonForSubCategoryPage() {
		moreinfobutton_of_subcategorypage.click();
		return new SubCategoryPage(driver);
	}
	
	public HomePage clickAdminInHomePage() {
		WaitUtility wait = new WaitUtility();
		wait.waitForElementToBeClickable(driver, clickadmin);
		clickadmin.click();
		return this;
	}

	public HomePage clickLogOut() {
		WaitUtility wait = new WaitUtility();
		wait.waitForElementToBeClickable(driver, clicklogout);
		clicklogout.click();
		return this;
	}

	public boolean isSigninPageDisplayed() {

		return signinpage.isDisplayed();

	}
}
