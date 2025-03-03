package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccPage extends BasePage {

	public MyAccPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//div[@id='content']/h2[text()='My Account']")
	WebElement myAccountPageDisplayed;
	
	@FindBy(xpath="//li[@class='dropdown open']//a[@title='My Account']")
	WebElement lnkMyAcc;
	
	@FindBy(xpath="//div[@id='top-links']//a[text()='Logout']")
	WebElement lnkLogout;
	
	public boolean isMyAccountDisplayed()
	{
		try
		{
			return myAccountPageDisplayed.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
	}
	

	public void clickMyAccount()
	{
		lnkMyAcc.click();
	}
	
	public void clickLogout()
	{
		lnkLogout.click();
	}


}
