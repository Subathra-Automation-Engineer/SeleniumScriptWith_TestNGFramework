
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StandaloneScript {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/client");
		
		driver.manage().window().maximize();
		
		
		//Enter Email, Password and Click SUbmit
		
		driver.findElement(By.id("userEmail")).sendKeys("subathra.test@gmail.com");
				
		driver.findElement(By.id("userPassword")).sendKeys("Testpassword*3");
			
		driver.findElement(By.id("login")).click();
		
		// Wait to load all the products
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
				
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("img.card-img-top"))));
				
				// Collect the webelements of all the products 
				
				List <WebElement> products = driver.findElements(By.cssSelector(".col-lg-4"));
				
				//Select the webelement of required product from list
				
				WebElement selectedProduct = products.stream().filter(s->s.findElement(By.xpath("//div/h5/b"))
						.getText().equals("ADIDAS ORIGINAL")).findFirst().orElse(null);
				
						
				//Click Add to cart
				
				selectedProduct.findElement(By.xpath("//button[2]")).click();
				
				// Wait for the toast container
				
				WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(20));
				
				wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("toast-container")));
				
				System.out.println(driver.findElement(By.id("toast-container")).getText());
				
				//Assert.assertEquals(driver.findElement(By.id("toast-container")).getText(),"Product Added To Cart");
				
				Thread.sleep(3000);
				
				//Wait for the cart link to get enabled
				
				WebDriverWait wait4 = new WebDriverWait(driver,Duration.ofSeconds(20));
				
				wait4.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[routerlink='/dashboard/cart'")));
				
				//Click Cart
				driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart'")).click();
				
				//Get the products list in cart
				
				//List <WebElement>	cartProducts = driver.findElements(By.tagName("h3"));
				
				// Check whether the added product is available in cart
			
				//boolean match = cartProducts.stream().anyMatch(s->s.getText().equalsIgnoreCase("ZARA COAT 3"));
			
				//Assert.assertEquals(match, true);
			
				// Click Checkout
				driver.findElement(By.cssSelector(".totalRow .btn")).click();
			
			
				// Select the Country //placeholder="Select Country"
			
				driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("India");
			
				// ta-item list-group-item ng-star-inserted		
		        // Wait for the dropdown options to get load
				
				WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(10));
			
				wait2.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("ta-item"))));
				
				// Collect the list of dropdown values
				List <WebElement>	dropdownOptions = driver.findElements(By.cssSelector(".ta-item .ng-star-inserted"));
				
				// Select the required value from list
				WebElement SelectedOption = dropdownOptions.stream().filter(s->s.getText().equalsIgnoreCase("India")).findFirst().orElse(null);
				
				SelectedOption.click();
			
				//Submit the order //action__submit
			
				driver.findElement(By.className("action__submit")).click();

		
	}

}
