package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageContactPage;

import utilities.ExcelUtilities;
import utilities.FakerUtility;

public class ManageContactTest extends Base {
	
	HomePage homepage;
	ManageContactPage managecontact;
	
	@Test(retryAnalyzer = retry.Retry.class, description = "test case verify if contact details can be edited in manage contact page")
	public void verifyToEditContactUsDetailsInManageContactPage() throws Exception {

		String username = ExcelUtilities.readString(1, 0, "LoginPage");
		String password = ExcelUtilities.readString(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassWord(password);
		//loginpage.enterPassWord(password);
		homepage=loginpage.submitClick();

		//ManageContactPage managecontact = new ManageContactPage(driver);
		String phonenumber = ExcelUtilities.readInteger(2, 0, "ManageContactPage");
		// FakerUtility fakerutility=new FakerUtility();
		// int phonenumber= fakerutility.generateRandomNumber();
		String email = ExcelUtilities.readString(2, 1, "ManageContactPage");
		String address = ExcelUtilities.readString(2, 2, "ManageContactPage");
		String deliverytime = ExcelUtilities.readInteger(2, 3, "ManageContactPage");
		String chargelimit = ExcelUtilities.readInteger(2, 4, "ManageContactPage");
		
		managecontact= homepage.clickMoreInfoButtonForManageContactPage().clickEditButton().enterPhoneNumber(phonenumber).enterEmail(email).enterAddress(address).enterDeliveryTime(deliverytime).enterDeliveryChargeLimit(chargelimit).clickUpdateButton();
		
		/*managecontact.clickEditButton();
		
		managecontact.enterPhoneNumber(phonenumber);
		managecontact.enterEmail(email);
		
		managecontact.enterAddress(address);
		
		managecontact.enterDeliveryTime(deliverytime);
		
		managecontact.enterDeliveryChargeLimit(chargelimit);

		managecontact.clickUpdateButton();*/
		boolean alertshown = managecontact.isAlertMessageDisplayed();
		Assert.assertTrue(alertshown, Constants.ALERTMESSAGE);

	}

	@Test(description = "test case to ensure that update button is displayed in manage contact page")
	public void checkIfUpdateButtonIsDispalyedInManageContactPage() throws Exception {

		String username = ExcelUtilities.readString(1, 0, "LoginPage");
		String password = ExcelUtilities.readString(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassWord(password);
		//loginpage.enterPassWord(password);
		homepage=loginpage.submitClick();
		//ManageContactPage managecontact = new ManageContactPage(driver);
		managecontact=homepage.clickMoreInfoButtonForManageContactPage().clickEditButton();
		//managecontact.clickEditButton();
		boolean updatebuttonshown = managecontact.isUpdateButtonDisplayed();
		Assert.assertTrue(updatebuttonshown, Constants.UPDATEBUTTONMESSAGE);

	}

}
