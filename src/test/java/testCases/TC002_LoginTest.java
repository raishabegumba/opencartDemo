package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;


import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccPage;
import testBasics.BaseClass;

public class TC002_LoginTest extends BaseClass{

	@Test(groups= {"Regression", "Master"}) 
	public void verifyLogin()
	{

		logger.info("****Start TC002_LoginTest ***********" );
		try
		{
			//home page
			HomePage hp = new HomePage(driver);
			hp.clickMyAcc();
			hp.clickLgn();

			//login Page
			LoginPage lp= new LoginPage(driver);
			lp.setUsername(p.getProperty("Username"));
			lp.setPassword(p.getProperty("Password"));
			lp.clickLoginBtn();

			//My Account Page 
			MyAccPage mp= new MyAccPage(driver);
			boolean targetPage=mp.isMyAccountDisplayed();
			Assert.assertTrue(targetPage);//last statment of  testcase 
		
		}
		catch(Exception e)
		{
			Assert.fail();
		}

		logger.info("****End TC002_LoginTest ***********" );

	}

}
