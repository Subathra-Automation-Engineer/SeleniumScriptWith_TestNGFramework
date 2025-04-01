package PageObjects;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

//import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v126.page.model.Screenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	
	public String GetScreenshot(String testCaseName,WebDriver driver) throws IOException
	
	{
		System.out.println("Test");
	
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File file= new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
		FileHandler.copy(source, file);
		return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
		
	}
	
	
public  List <HashMap <String,String>> GetjsontoHashmap(String FilePath) throws IOException
	
	{		
			//to convert Json to String

				Path path = Paths.get(FilePath);
				String JsonContent = Files.readString(path);
	
				
				//to convert String to Hashmap we must use Jack Data binding dependency

				ObjectMapper Mapper = new ObjectMapper();
				
				List<HashMap<String,String>> data = Mapper.readValue(JsonContent, new TypeReference<ArrayList<HashMap<String,String>>>(){

				});

				return data;
			

			}

	


}
