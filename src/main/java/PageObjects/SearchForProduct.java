package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchForProduct extends ReusableComponents{
	
	WebDriver driver;
	
	public SearchForProduct(WebDriver driver)
	{
		super(driver); 
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(css=".col-lg-4")	
	List <WebElement> AvailableProducts;
	
	@FindBy(css="img.card-img-top") 
	WebElement ProductCatalogue ;
	
	By TostMessage = By.id("toast-container");
	
	public CheckOut SearchNSelect(String ProductName)
	
	{
		WaitForVisibilityOfElement(ProductCatalogue);	
		
		WebElement selectedProduct = AvailableProducts.stream().filter(s->s.findElement(By.xpath("//div/h5/b"))
				.getText().equals(ProductName)).findFirst().orElse(null);
		
		selectedProduct.findElement(By.xpath("//button[2]")).click();
		
		WaitForPresenceOfElement(TostMessage);
		
		CheckOut checkout  = new CheckOut(driver);
		
		return checkout;
	}
	

}
