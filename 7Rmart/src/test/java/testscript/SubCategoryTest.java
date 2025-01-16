package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.SubCategoryPage;
import utilities.ExcelUtilities;
import utilities.FakerUtility;

public class SubCategoryTest extends Base{
	@Test(description="test case to verify if subcategory details can be added in subcategory page")
	public void verifyToAddSubCategoryDetailsInSubCategoryPage() throws Exception {
		
		String username =ExcelUtilities.readString(1, 0, "LoginPage");
		String password =ExcelUtilities.readString(1, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassWord(password);
		loginpage.submitClick();
		
		SubCategoryPage subcategory=new SubCategoryPage(driver);
		subcategory.clickMoreInfo();
		subcategory.clickNewButton();
		subcategory.selectDropDown();
		//String value =ExcelUtilities.readString(3, 0, "SubCategoryPage");
		FakerUtility fakerutility=new FakerUtility();
		String value=fakerutility.generateName();
		subcategory.enterSubcategory(value);
		subcategory.fileUpload();
		subcategory.clickSaveButton();
		boolean alertshown=subcategory.isAlertMessageDisplayed();
		Assert.assertTrue(alertshown,"failed to add details in subcategory page");
	}

}
