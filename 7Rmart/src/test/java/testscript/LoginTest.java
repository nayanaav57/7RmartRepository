package testscript;

import org.testng.Assert;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class LoginTest extends Base {
	

	// @DataProvider(name ="credentials")

	// public Object[][]testData(){

	// Object data[][] = {{"admin","admin"},{"hello","admin"},{"admin","xx"}};
	// return data;
	// }
	@Test(description = "test case to verfiy if user can login using valid credentials", groups = { "regression" })
	// (dataProvider="credentials")
	public void verifyTheUserIsAbleToLoginUsingValidCredentials() throws Exception { // String username,//String
																						// password)

		String username = ExcelUtilities.readString(1, 0, "LoginPage");// for username
		String password = ExcelUtilities.readString(1, 1, "LoginPage");// for password
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassWord(password).submitClick();// chaining of method
		//loginpage.enterPassWord(password);
		//loginpage.submitClick();
		boolean ishomepageloaded = loginpage.isDashboardDisplayed();
		Assert.assertTrue(ishomepageloaded,Constants.MESSAGE1);
	}

	@Test(description = "test case to verfiy if user cannot login using invalid username")
	@Parameters({ "username", "password" })
	public void verifyTheUserUnableToLoginUsingInvalidUserName(String username, String password) throws Exception {

		// String username =ExcelUtilities.readString(2, 0, "LoginPage");
		// String password =ExcelUtilities.readString(2, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassWord(password).submitClick();
		//loginpage.enterPassWord(password);
		//loginpage.submitClick();
		boolean isalertmessageshown = loginpage.isAlertMessageDisplayed();
		Assert.assertTrue(isalertmessageshown, Constants.MESSAGE2);
	}

	@Test(description = "test case to verfiy if user cannot login using invalid password")
	public void verifyTheUserUnableToLoginUsingInvalidPassword() throws Exception {
		// String username ="admin";
		// String password ="admin";

		String username = ExcelUtilities.readString(3, 0, "LoginPage");
		String password = ExcelUtilities.readString(3, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassWord(password).submitClick();
		//loginpage.enterPassWord(password);
		//loginpage.submitClick();
		boolean isalertmessageshown = loginpage.isAlertMessageDisplayed();
		Assert.assertTrue(isalertmessageshown, Constants.MESSAGE3);

	}

	@Test(description = "test case to verfiy if user cannot login using invalid username and password")
	public void verifyTheUserUnableToLoginUsingInvalidUsernameAndPassword() throws Exception {

		// String username ="staffadmin";
		// String password ="hello";
		String username = ExcelUtilities.readString(4, 0, "LoginPage");
		String password = ExcelUtilities.readString(4, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassWord(password).submitClick();
		//loginpage.enterPassWord(password);
		//loginpage.submitClick();
		boolean isalertmessageshown = loginpage.isAlertMessageDisplayed();
		Assert.assertTrue(isalertmessageshown, Constants.MESSAGE4);
	}
}
