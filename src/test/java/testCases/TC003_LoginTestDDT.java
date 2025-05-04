package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccPage;
import testBasics.BaseClass;
import utilities.DataProviderClass;

public class TC003_LoginTestDDT extends BaseClass{
	
	@Test(dataProvider ="LoginData", dataProviderClass=DataProviderClass.class, groups= {"Datadriven"})
	public void loginDDT(String un, String pwd, String status)
	{
		logger.info("****Start TC003_LoginTestDDT ***********" );
		try
		{
			//home page
			logger.info("**** My account -> Login link clicked***********" );
			HomePage hp = new HomePage(driver);
			hp.clickMyAcc();
			hp.clickLgn();

			logger.info("**** Passed credentials***********" );
			//login Page
			LoginPage lp= new LoginPage(driver);
			lp.setUsername(un);
			lp.setPassword(pwd);
			lp.clickLoginBtn();

			
			//My Account Page 
			MyAccPage mp= new MyAccPage(driver);
			boolean targetPage=mp.isMyAccountDisplayed();
			System.out.println("My account page is displayed?:"+targetPage );
			System.out.println("login status is:"+ status);
			
			logger.info("**** My account -> Logout link not clicked ***********" );
			//Thread.sleep(5000);
			if(status.equalsIgnoreCase("valid")) 
			{
				if(targetPage==true)
				{
					mp.clickMyAccount();
					mp.clickLogout();
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);
				}
			}
			
			
			if(status.equalsIgnoreCase("invalid"))
			{
				if(targetPage==true)
				{
					
					mp.clickMyAccount();
					mp.clickLogout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
				
			}
			

		}
		catch(Exception e)
		{
			Assert.fail();
		}

		logger.info("****End TC003_LoginTestDDT ***********" );

	}
		
	}


