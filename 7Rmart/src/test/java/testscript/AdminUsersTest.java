package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtilities;
import utilities.FakerUtility;

public class AdminUsersTest extends Base {
	@Test (description="test case to verfiy if new user can be created in admin users page")
	public void verfiyIfNewUserIsCreatedInTheAdminUsersPage() throws Exception
	{
	
	String username =ExcelUtilities.readString(1, 0, "LoginPage");
	String password =ExcelUtilities.readString(1, 1, "LoginPage");
	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterUserName(username);
	loginpage.enterPassWord(password);
	loginpage.submitClick();
	
	AdminUsersPage adminuser=new AdminUsersPage(driver);
	adminuser.clickMoreInfo();
	adminuser.clickNewButton();
	FakerUtility fakerutility=new FakerUtility();
	String name=fakerutility.generateName();
	String password1=fakerutility.generatePassword();
	//String newusername =ExcelUtilities.readString(1, 0, "AdminUsersPage");
	adminuser.enterusername(name);
	//String newpassword =ExcelUtilities.readString(1, 1, "AdminUsersPage");
	adminuser.enterpassword(password1);
	adminuser.selectDropDown();
	adminuser.clickSaveButton();
	boolean alertshown=adminuser.isAlertMessageDisplayed();
	Assert.assertTrue(alertshown,"failed to create new user in the admin users page");
	
	}
	@Test(description="test case to verfiy if a user can be deleted from admin users page")
	public void VerfiyIfAnyUserCanBeDeletedFromTheAdminUsersPage() throws Exception
	{
	
	String username =ExcelUtilities.readString(1, 0, "LoginPage");
	String password =ExcelUtilities.readString(1, 1, "LoginPage");
	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterUserName(username);
	loginpage.enterPassWord(password);
	loginpage.submitClick();
	
	AdminUsersPage adminuser=new AdminUsersPage(driver);
	adminuser.clickMoreInfo();
	adminuser.delete();
	boolean alertshown=adminuser.isAlertMessageDisplayed();
	Assert.assertTrue(alertshown,"failed to delete user from the admin users page");
	}
}
