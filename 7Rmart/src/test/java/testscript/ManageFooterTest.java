package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageFooterPage;
import utilities.ExcelUtilities;

public class ManageFooterTest extends Base {
	
	HomePage homepage;
	ManageFooterPage managefooter;

	@Test(description = "test case to verify if footer text details can be edited in manage footer page")
	public void verifyToEditFooterTextDetailsInManageFooterPage() throws Exception {

		String username = ExcelUtilities.readString(1, 0, "LoginPage");
		String password = ExcelUtilities.readString(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassWord(password);
		//loginpage.enterPassWord(password);
		homepage=loginpage.submitClick();

		//ManageFooterPage managefooter = new ManageFooterPage(driver);
		String enteraddress = ExcelUtilities.readString(1, 0, "ManageFooterPage");
		String enteremail = ExcelUtilities.readString(1, 1, "ManageFooterPage");
		String enterphonenumber = ExcelUtilities.readInteger(1, 2, "ManageFooterPage");
		managefooter=homepage.clickMoreInfoButtonForManageFooterPage().clickEditButton().enterAddress(enteraddress).enterEmail(enteremail).enterPhoneNumber(enterphonenumber).clickUpdateButton();
		/*managefooter.clickEditButton();
		
		managefooter.enterAddress(enteraddress);
		
		managefooter.enterEmail(enteremail);
		
		managefooter.enterPhoneNumber(enterphonenumber);
		managefooter.clickUpdateButton();*/
		boolean alertshown = managefooter.isAlertMessageDisplayed();
		Assert.assertTrue(alertshown, Constants.ALERTMESSAGE1);

	}

	@Test(description = "test case to verify if update button is displayed in manage footer page")
	public void checkIfUpdateButtonIsDispalyedInManageFooterPage() throws Exception {

		String username = ExcelUtilities.readString(1, 0, "LoginPage");
		String password = ExcelUtilities.readString(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassWord(password);
		//loginpage.enterPassWord(password);
		homepage=loginpage.submitClick();
		//ManageFooterPage managefooter = new ManageFooterPage(driver);
		managefooter=homepage.clickMoreInfoButtonForManageFooterPage().clickEditButton();
		//managefooter.clickEditButton();
		boolean updatebuttonshown = managefooter.isUpdateButtonDisplayed();
		Assert.assertTrue(updatebuttonshown, Constants.UPDATEBUTTONMESSAGE1);

	}
}
