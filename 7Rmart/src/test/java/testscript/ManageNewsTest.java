package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtilities;

public class ManageNewsTest extends Base {
	
	HomePage homepage;
	ManageNewsPage managenewspage;
	
	@Test(description = "test case to verify if a news can be created in manage news page")
	public void verifyToCreateNewsInManageNewsPage() throws Exception {

		String username = ExcelUtilities.readString(1, 0, "LoginPage");
		String password = ExcelUtilities.readString(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassWord(password);
		//loginpage.enterPassWord(password);
		homepage=loginpage.submitClick();

		//ManageNewsPage managenews = new ManageNewsPage(driver);
		String news = ExcelUtilities.readString(1, 0, "ManageNewsPage");
		managenewspage=homepage.clickMoreInfoButtonForManageNewsPage().clickNewButton().enterNews(news).clickSaveButton();
		/*managenews.clickNewButton();
		
		managenews.enterNews(news);
		managenews.clickSaveButton();*/
		boolean alertshown = managenewspage.isAlertMessageDisplayed();
		Assert.assertTrue(alertshown, Constants.ALERTMESSAGE2);

	}

}
