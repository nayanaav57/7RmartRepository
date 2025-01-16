package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageContactPage;

import utilities.ExcelUtilities;
import utilities.FakerUtility;

public class ManageContactTest extends Base {
	@Test(retryAnalyzer= retry.Retry.class,description="test case verify if contact details can be edited in manage contact page")
public void verifyToEditContactUsDetailsInManageContactPage() throws Exception {
		
		String username =ExcelUtilities.readString(1, 0, "LoginPage");
		String password =ExcelUtilities.readString(1, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassWord(password);
		loginpage.submitClick();
		
		ManageContactPage managecontact=new ManageContactPage(driver);
		managecontact.clickMoreInfo();
		managecontact.clickEditButton();
		//FakerUtility fakerutility=new FakerUtility();
		//int phonenumber= fakerutility.generateRandomNumber();
		String phonenumber =ExcelUtilities.readNumber(2, 0, "ManageContactPage");
		managecontact.enterPhoneNumber(phonenumber);
		String email =ExcelUtilities.readString(2, 1, "ManageContactPage");
		managecontact.enterEmail(email);
		String address =ExcelUtilities.readString(2, 2, "ManageContactPage");
		managecontact.enterAddress(address);
		String deliverytime=ExcelUtilities.readNumber(2, 3, "ManageContactPage");
		managecontact.enterDeliveryTime(deliverytime);
		String chargelimit=ExcelUtilities.readNumber(2, 4, "ManageContactPage");
		managecontact.enterDeliveryChargeLimit(chargelimit);
	
		managecontact.clickUpdateButton();
		boolean alertshown=managecontact.isAlertMessageDisplayed();
		Assert.assertTrue(alertshown,"failed to execute:verifyToEditContactUsDetailsInManageContactPage");
		
	}
	@Test(description="test case to ensure that update button is displayed in manage contact page")
	public void checkIfUpdateButtonIsDispalyedInManageContactPage() throws Exception {
		
		String username =ExcelUtilities.readString(1, 0, "LoginPage");
		String password =ExcelUtilities.readString(1, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassWord(password);
		loginpage.submitClick();
		ManageContactPage managecontact=new ManageContactPage(driver);
		managecontact.clickMoreInfo();
		managecontact.clickEditButton();
		boolean updatebuttonshown=managecontact.isUpdateButtonDisplayed();
		Assert.assertTrue(updatebuttonshown,"update button is not displayed");
		
	}

}
