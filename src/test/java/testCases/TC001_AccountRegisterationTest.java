package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterPage;
import testBasics.BaseClass;

public class TC001_AccountRegisterationTest extends BaseClass{
	
	@Test(groups= {"Sanity","Master"})
	//@Test
	public void verify_account_registeration() 
	{
		logger.info("***Starting TC001_AccountRegisterationTest*** ");

		try {
			HomePage hp= new HomePage(driver);
			hp.clickMyAcc();
			logger.info("Clicked on my account link");
			hp.clickReg();
			logger.info("Clicked on registeration link");

			RegisterPage rp= new RegisterPage(driver);
			logger.info("Providing customer details");
			rp.setFirstName(randomString().toUpperCase());
			rp.setLastName(randomString().toUpperCase());
			rp.setEmail(randomString()+"@gmail.com");
			rp.setTelephone(randomNumber());
			String password=randomAlphaNumeric();
			rp.setPassword(password);
			rp.setConfirmPassword(password);
			rp.clickchkbxPrivacyPolicy();
			rp.clickbtnContinue();

			logger.info("Validating Account success message");
			String confirmMsg=rp.getmsgConfirm();
			if(confirmMsg.equals("Your Account Has Been Created!"))
			{
				Assert.assertTrue(true);
			}
			else {
				logger.error("Test Failed");
				logger.debug("Debug logs");
				Assert.assertTrue(false);

			}

		}
		catch(Exception e)
		{
			Assert.fail();//forceful fail the testcase
		}

		logger.info("****End TC001_AccountRegisterationTest***");
	}

}
