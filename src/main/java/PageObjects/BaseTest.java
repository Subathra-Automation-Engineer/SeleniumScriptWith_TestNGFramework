package PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage landingPage;
	
	
	public WebDriver InitializeBrowser()
	
	{
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		return driver;
		
	}
	
	
	@BeforeMethod
	public LandingPage LaunchApplication()
	
	{
		
		driver =  InitializeBrowser();
		landingPage = new LandingPage(driver);
		
		landingPage.goTo();
		
		return landingPage	;	
	}
	
	@AfterMethod
	public void CloseBrowser()
	
	{		
		driver.close();
	}

}
