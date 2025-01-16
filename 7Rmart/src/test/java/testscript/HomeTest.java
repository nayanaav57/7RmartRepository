package testscript;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class HomeTest extends Base {
	@Test(description="test case to verfiy if user can log out from home page")
	public void checkIfUserCanlogOutFromHomePage() throws Exception
	{
	
	String username =ExcelUtilities.readString(1, 0, "LoginPage");
	String password =ExcelUtilities.readString(1, 1, "LoginPage");
	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterUserName(username);
	loginpage.enterPassWord(password);
	loginpage.submitClick();
	
	HomePage logout=new HomePage(driver);
	logout.clickAdminInHomePage();
	logout.clickLogOut();
	boolean display=logout.isSigninPageDisplayed();
	Assert.assertTrue(display, "unable to logout from home page");
	}
}
