package PageObjects;



import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderHistory extends ReusableComponents{
	
	WebDriver driver;
	
	public OrderHistory(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}	
	
	@FindBy (css="button[routerlink*=\"myorders\"]")
	WebElement OrdersLink;
	
	
	
	public void GoToOrdersPage() 
	
	{
		WaitForVisibilityOfElement(OrdersLink);
		
		OrdersLink.click();
		
		}
	
	@FindBy(xpath="//tr/td[2]")
	List<WebElement> RecentOrder;	
	
	
	public String CheckforProduct()
	
	{
		String RecentlyOrderedProduct = RecentOrder.get(0).getText();
		
		return RecentlyOrderedProduct;
	}
	
	
}
