package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import constants.Constants;
import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtilities;
import utilities.FakerUtility;

public class AdminUsersTest extends Base {
	
	HomePage homepage;
	AdminUsersPage adminuser;
	
	@Test(retryAnalyzer = retry.Retry.class,description = "test case to verfiy if new user can be created in admin users page")
	public void verfiyIfNewUserIsCreatedInTheAdminUsersPage() throws Exception {

		String username = ExcelUtilities.readString(1, 0, "LoginPage");
		String password = ExcelUtilities.readString(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassWord(password);
		//loginpage.enterPassWord(password);
		homepage=loginpage.submitClick();

		//AdminUsersPage adminuser = new AdminUsersPage(driver);
		FakerUtility fakerutility = new FakerUtility();
		String name = fakerutility.generateName();
		String password1 = fakerutility.generatePassword();
		adminuser=homepage.clickMoreInfoButtonForAdminUsersPage().clickNewButton().enterUserName(name).enterPassword(password1).selectDropDown().clickSaveButton();
		/*adminuser.clickNewButton();
		adminuser.enterUserName(name);
		adminuser.enterPassword(password1);
		adminuser.selectDropDown();
		adminuser.clickSaveButton();*/
		boolean alertshown = adminuser.isAlertMessageDisplayed();
		Assert.assertTrue(alertshown, Constants.ALERTSHOWNMESSAGE1);

	}

	@Test(retryAnalyzer = retry.Retry.class,description = "test case to verfiy if a user can be deleted from admin users page")
	public void VerfiyIfAnyUserCanBeDeletedFromTheAdminUsersPage() throws Exception {

		String username = ExcelUtilities.readString(1, 0, "LoginPage");
		String password = ExcelUtilities.readString(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassWord(password);
		//loginpage.enterPassWord(password);
		homepage=loginpage.submitClick();


		//AdminUsersPage adminuser = new AdminUsersPage(driver);
		adminuser=homepage.clickMoreInfoButtonForAdminUsersPage().clickDeleteButton();
		//adminuser.clickDeleteButton();
		boolean alertshown = adminuser.isAlertMessageDisplayed();
		Assert.assertTrue(alertshown, "failed to delete user from the admin users page");
	}
}
