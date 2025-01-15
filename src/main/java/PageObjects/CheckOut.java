package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOut extends ReusableComponents{
	
WebDriver driver;
	
	public CheckOut(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}	
	
	By CartLink = By.cssSelector("button[routerlink='/dashboard/cart'");
	
	@FindBy(css="button[routerlink*='cart'") 
	WebElement CartLinkToClick;
	
	@FindBy(css=".totalRow .btn") 
	WebElement CheckoutButton;
	
	public void GoToCart() throws InterruptedException
	
	{		
		Thread.sleep(3000);
		WaitForPresenceOfElement(CartLink);
		
     	CartLinkToClick.click();
		
	}
	
	public SubmitOrder ContinueCheckOut()
	
	{
		
		// Click Checkout
		CheckoutButton.click();
		
		SubmitOrder submitorder  = new SubmitOrder(driver);	
		
		return submitorder;
		
	}

}
