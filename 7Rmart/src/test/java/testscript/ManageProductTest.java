package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageProductPage;
import utilities.ExcelUtilities;

public class ManageProductTest extends Base {
	HomePage homepage;
	ManageProductPage manageproduct;
	
	@Test(description = "test case to verify if a product can be deleted from manage product page")
	public void verifyToDeleteProductInManageProductPage() throws Exception {

		String username = ExcelUtilities.readString(1, 0, "LoginPage");
		String password = ExcelUtilities.readString(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassWord(password);
		//loginpage.enterPassWord(password);
		homepage=loginpage.submitClick();

		//ManageProductPage manageproduct = new ManageProductPage(driver);
		manageproduct=homepage.clickMoreInfoButtonForManageProductPage().deleteButton();
		//manageproduct.deleteButton();
		boolean alertshown = manageproduct.isAlertMessageDisplayed();
		Assert.assertTrue(alertshown, Constants.ALERTMESSAGE3);
	}

}
