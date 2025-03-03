package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//a[@title='My Account']")
	WebElement lnkMyAcc;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Register']")
	WebElement lnkReg;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Login']")
	WebElement lnkLgn;
	
	public void clickMyAcc()
	{
		lnkMyAcc.click();
	}
	
	public void clickReg()
	{
		lnkReg.click();
	}
	
	public void clickLgn()
	{
		lnkLgn.click();
	}
	

}
