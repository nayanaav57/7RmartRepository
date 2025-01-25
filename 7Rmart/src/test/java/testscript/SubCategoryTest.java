package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.SubCategoryPage;
import utilities.ExcelUtilities;
import utilities.FakerUtility;

public class SubCategoryTest extends Base {
	
	HomePage homepage;
	SubCategoryPage subcategory;
	
	@Test(description = "test case to verify if subcategory details can be added in subcategory page")
	public void verifyToAddSubCategoryDetailsInSubCategoryPage() throws Exception {

		String username = ExcelUtilities.readString(1, 0, "LoginPage");
		String password = ExcelUtilities.readString(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassWord(password);
		//loginpage.enterPassWord(password);
		homepage=loginpage.submitClick();

		//SubCategoryPage subcategory = new SubCategoryPage(driver);
		FakerUtility fakerutility = new FakerUtility();
		String value = fakerutility.generateName();
		subcategory=homepage.clickMoreInfoButtonForSubCategoryPage().clickNewButton().selectDropDown().enterSubcategory(value).fileUpload().clickSaveButton();
		/*subcategory.clickNewButton();
		subcategory.selectDropDown();
		subcategory.enterSubcategory(value);
		subcategory.fileUpload();
		subcategory.clickSaveButton();*/
		boolean alertshown = subcategory.isAlertMessageDisplayed();
		Assert.assertTrue(alertshown, Constants.ALERTMESSAGE4);
	}

}
