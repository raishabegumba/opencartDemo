package testBasics;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class BaseClass {

	public static WebDriver driver;
	public Properties p;
	public Logger logger;

	@BeforeClass(groups= {"Sanity","Regression","Master","Datadriven"})
	@Parameters({"browser","os"})
	public void setUp(String br, String os) throws IOException
	{
		//load property file
		FileReader fr= new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(fr);

		//load logger
		logger= LogManager.getLogger(this.getClass());
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
		//	capabilities.setPlatform(Platform.WIN11);
		//	capabilities.setBrowserName("chrome");

			//os
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("linux"))
			{
				capabilities.setPlatform(Platform.LINUX);
				
			}
			else if (os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No matching os");
				return;
			}
			
		//browser
		switch(br.toLowerCase())
		{
		case "chrome": driver = new ChromeDriver();break;
		case "firefox": driver= new FirefoxDriver(); break;
		case "edge": driver = new EdgeDriver(); break;
		case "safari": driver = new SafariDriver(); break;
		default:System.out.println("invalid browser"); return;
		
		}
		//launch url 
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
	}	
		
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local")){
		       switch(br.toLowerCase()){
				case "chrome": driver = new ChromeDriver(); break;
				case "firefox": driver = new FirefoxDriver(); break;
				case "edge": driver = new EdgeDriver(); break;
				case "safari": driver = new SafariDriver(); break;
				default : System.out.println("please enter istalled browser"); return;
				}
			}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(p.getProperty("appURL"));
		
		
	}

	@AfterClass(groups= {"Sanity","Regression","Master","Datadriven"})
	public void tearDown()
	{
		driver.quit();
	}
	
	 public String captureScreen (String tname) throws IOException {
		 String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		 TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		 File sourceFile = takesScreenshot.getScreenshotAs (OutputType.FILE);
		 String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" +tname + timeStamp + ".png";
		// String targetFilePath = ("D:\\Frameworks\\NopCommerce1.0\\screenshots" + tname+timeStamp+".png");
		 File targetFile=new File(targetFilePath);
		 sourceFile.renameTo(targetFile);			 
		 return targetFilePath;
		 }


	public String randomString()
	{
		String genString=RandomStringUtils.randomAlphabetic(8);
		return genString;		
	}

	public String randomNumber()
	{
		String genNum=RandomStringUtils.randomNumeric(10);
		return genNum;
	}

	public String randomAlphaNumeric()
	{
		String genString=RandomStringUtils.randomAlphabetic(5);
		String genNum=RandomStringUtils.randomNumeric(5);
		return (genString+genNum);	
	}
}
