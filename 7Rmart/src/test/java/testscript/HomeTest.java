package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class HomeTest extends Base {
	HomePage homepage;
	@Test(description = "test case to verfiy if user can log out from home page")
	public void checkIfUserCanlogOutFromHomePage() throws Exception {

		String username = ExcelUtilities.readString(1, 0, "LoginPage");
		String password = ExcelUtilities.readString(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassWord(password);//chaining of method
		//loginpage.enterPassWord(password);
		homepage=loginpage.submitClick();// chaining of pages 

		//HomePage homepage = new HomePage(driver);// chaining of pages -advantage: no need to pass driver two times
		homepage.clickAdminInHomePage().clickLogOut();
		//homepage.clickLogOut();
		boolean display = homepage.isSigninPageDisplayed();
		Assert.assertTrue(display,Constants.DISPLAYMESSAGE);
	}
}
