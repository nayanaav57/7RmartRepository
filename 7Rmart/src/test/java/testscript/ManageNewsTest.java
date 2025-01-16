package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtilities;

public class ManageNewsTest extends Base {
	@Test(description="test case to verify if a news can be created in manage news page")
	public void verifyToCreateNewsInManageNewsPage() throws Exception {
		
		String username =ExcelUtilities.readString(1, 0, "LoginPage");
		String password =ExcelUtilities.readString(1, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassWord(password);
		loginpage.submitClick();
		
		ManageNewsPage managenews=new ManageNewsPage(driver);
		managenews.clickMoreInfo();
		managenews.clickNewButton();
		String news="test news";
		managenews.enterNews(news);
		managenews.clickSaveButton();
		boolean alertshown=managenews.isAlertMessageDisplayed();
		Assert.assertTrue(alertshown,"failed to execute: verifyToCreateNewsInManageNewsPage");
		
		
	}

}
