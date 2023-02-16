package base;



import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import io.github.bonigarcia.wdm.WebDriverManager;
import util.Utility;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;



public class Base {
	public static WebDriver driver;


	@BeforeClass

	public void initiateCriverInstance() throws IOException

	{
		if (Utility.fetchPropertyValue("executionmode").equals("remote"))
		{
			if(Utility.fetchPropertyValue("browserName").equals("chrome"))
			{

				//	driver = WebDriverManager.chromedriver().create();

				ChromeOptions options = new ChromeOptions();

				options.addArguments("disable-dev-shm-usage");	
				URL u = new URL("http://localhost:4444/wd/hub") ;
				driver = new RemoteWebDriver( u ,options);

			} 
			else if(Utility.fetchPropertyValue("browserName").equals("firefox"))
			{

				FirefoxOptions options = new FirefoxOptions();

				options.addArguments("disable-dev-shm-usage");	
				URL u = new URL("http://localhost:4444/wd/hub") ;
				driver = new RemoteWebDriver( u ,options);
			}

			else 
			{
				ChromeOptions options = new ChromeOptions();
				options.addArguments("disable-dev-shm-usage");	
				URL u = new URL("http://localhost:4444/wd/hub") ;
				driver = new RemoteWebDriver( u ,options);
			}
		}
		else 

		{
			driver = WebDriverManager.chromedriver().create();
		}



		driver.manage().window().maximize();
		driver.get(Utility.fetchPropertyValue("appURL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

@AfterClass
	public void closeDriverInstance()
	{
		driver.quit();
	}

	
	
	
	public static void takescreenshot(String filename) throws IOException

	{

		String scrBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		File file = OutputType.FILE.convertFromBase64Png(scrBase64);
		String timestamp = new SimpleDateFormat("_yyyy_MM_dd__hh_mm_ss").format(new Date());
		FileUtils.copyFile(file, new File("./Screenshots/"+ filename +timestamp+".png"), true);


	}
}
