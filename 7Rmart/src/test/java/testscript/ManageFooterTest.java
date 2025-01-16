package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageFooterPage;
import utilities.ExcelUtilities;

public class ManageFooterTest extends Base {
	
	@Test(description="test case to verify if footer text details can be edited in manage footer page")
	public void verifyToEditFooterTextDetailsInManageFooterPage() throws Exception {
		
		String username =ExcelUtilities.readString(1, 0, "LoginPage");
		String password =ExcelUtilities.readString(1, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassWord(password);
		loginpage.submitClick();
		
		ManageFooterPage managefooter=new ManageFooterPage(driver);
		managefooter.clickMoreInfo();
		managefooter.clickEditButton();
		String enteraddress =ExcelUtilities.readString(1, 0, "ManageFooterPage");
		managefooter.enterAddress(enteraddress);
		String enteremail =ExcelUtilities.readString(1, 1, "ManageFooterPage");
		managefooter.enterEmail(enteremail);
		String enterphonenumber =ExcelUtilities.readNumber(1, 2, "ManageFooterPage");
		managefooter.enterPhoneNumber(enterphonenumber);
		managefooter.clickUpdateButton();
		boolean alertshown=managefooter.isAlertMessageDisplayed();
		Assert.assertTrue(alertshown,"failed to execute: verifyToEditFooterTextDetailsInManageFooterPage");
		
	}
	@Test(description="test case to verify if update button is displayed in manage footer page")
	public void checkIfUpdateButtonIsDispalyedInManageFooterPage() throws Exception {
		
		String username =ExcelUtilities.readString(1, 0, "LoginPage");
		String password =ExcelUtilities.readString(1, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassWord(password);
		loginpage.submitClick();
		ManageFooterPage managefooter=new ManageFooterPage(driver);
		managefooter.clickMoreInfo();
		managefooter.clickEditButton();
		boolean updatebuttonshown=managefooter.isUpdateButtonDisplayed();
		Assert.assertTrue(updatebuttonshown,"update button is not displayed");
		
	}
}
