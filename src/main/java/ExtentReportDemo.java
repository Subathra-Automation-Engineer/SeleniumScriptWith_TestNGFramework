import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {
	
	
	ExtentReports extentreport;
	
	@BeforeTest
	public void config()
	
	{
		String path= System.getProperty("user.dir")+"\\reports\\index.html";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("EcommereceApp_Standalone_Results");
		reporter.config().setDocumentTitle("TestResults");
		
		extentreport = new ExtentReports();
		
		extentreport.attachReporter(reporter);
		extentreport.setSystemInfo("Tester","Subathra Selvaraj");
	}
	
	@Test
	public void DemoTest()
	
	{
		extentreport.createTest("StandaloneTestResult");
		
WebDriver driver= new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/client");
		
		driver.manage().window().maximize();
		
		
		//Enter Email, Password and Click SUbmit
		
		driver.findElement(By.id("userEmail")).sendKeys("subathra.test@gmail.com");
				
		driver.findElement(By.id("userPassword")).sendKeys("Testpassword*3");
			
		driver.findElement(By.id("login")).click();
		
		extentreport.flush();
		
	}

}
