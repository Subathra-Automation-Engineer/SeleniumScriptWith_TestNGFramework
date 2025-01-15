package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.Advice.Return;

public class LandingPage {
	
	 WebDriver driver;
		
		public LandingPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver,this);
			
		}
		
		
		public void goTo()	
		{
					//Open the Amazon URL
			
					driver.get("https://rahulshettyacademy.com/client");
					
										
		}
		
		@FindBy(id="userEmail") 
		WebElement Email;
		
		@FindBy(id="userPassword")
		WebElement PasswordField;
		
		@FindBy(id="login")
		WebElement LoginButton;
		
		////div[@class='top-tab']
		//.top-tab // Id=toast-container
		

		@FindBy(id="toast-container")
		WebElement ToastContainer;
		
		public SearchForProduct login(String EmailId,String Password)
		
		{
			Email.sendKeys(EmailId);
			
			PasswordField.sendKeys(Password);
			
			LoginButton.click();
			
			SearchForProduct Search  = new SearchForProduct(driver);
			
			return Search;
		}
		
		public String GetErrorMessage()
		
		{
			String ErrorMessage = ToastContainer.getText();
			
			System.out.println(ErrorMessage);
			
			return ErrorMessage ;
			
		}
		

}
