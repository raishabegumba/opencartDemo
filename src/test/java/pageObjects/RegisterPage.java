package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

	public RegisterPage(WebDriver driver) {
		super(driver);
	}
		
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstName;

	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastName;

	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtTelephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtConfirmPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkbxPrivacyPolicy;

	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirm;
	
	public void setFirstName(String str)
	{
		txtFirstName.sendKeys(str);
	}

	public void setLastName(String str)
	{
		txtLastName.sendKeys(str);
	}

	public void setEmail(String str)
	{
		txtEmail.sendKeys(str);
	}

	public void setTelephone(String str)
	{
		txtTelephone.sendKeys(str);
	}

	public void setPassword(String str)
	{
		txtPassword.sendKeys(str);
	}
	
	public void setConfirmPassword(String str)
	{
		txtConfirmPassword.sendKeys(str);
	}

	public void clickchkbxPrivacyPolicy()
	{
		chkbxPrivacyPolicy.click();
	}
	
	public void clickbtnContinue()
	{
		btnContinue.click();
	}
	
	public String getmsgConfirm()
	{
		try {
			return msgConfirm.getText();
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
	}

}
