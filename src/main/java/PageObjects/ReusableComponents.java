package PageObjects;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableComponents{
	
	WebDriver driver;
	
	public ReusableComponents(WebDriver driver)
	{
	
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	
	
	// Wait for product Catalogue to get Load
	
	public void WaitForVisibilityOfElement(WebElement ElementName)
	
	{
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.visibilityOf(ElementName));
		
	}
	
	// Wait for Toast Message to displayed
	
	
	
	public void WaitForPresenceOfElement(By ElementName)
	
	{
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(ElementName));

	}
	
	
	
	

}
