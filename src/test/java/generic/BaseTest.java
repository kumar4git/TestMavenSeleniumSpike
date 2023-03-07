package generic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

public class BaseTest 
{
	public WebDriver driver;
	public WebDriverWait wait;
	
	
	@Parameters({"browser","url","timeout"})
	@BeforeMethod
	public void openApp(String browser, String url, String timeout) 
	{
		Reporter.log("Open the browser: "+browser, true);
		if (browser.equalsIgnoreCase("chrome"))
		{
		driver=new ChromeDriver();
		}
		else {
			driver=new FirefoxDriver();
		}
		Reporter.log("enter the url: "+url, true);
		driver.get(url);
		Reporter.log("Maximize the browser", true); 
		driver.manage().window().maximize();
		// int intTimeout = Integer.parseInt(timeout);  --> converting string to int value
		long intTimeout= Long.parseLong(timeout);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(intTimeout));
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
			
		
	}
	
	@AfterMethod
	public void closeApp()
	{
		Reporter.log("Close the browser", true);
		driver.quit();
	}

}
