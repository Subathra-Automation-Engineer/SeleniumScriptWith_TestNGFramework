package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubmitOrder {
	
	WebDriver driver;
	
	public SubmitOrder(WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy (css="input[placeholder=\'Select Country\']")
	WebElement CountryField;
	
	@FindBy (css=".ta-item .ng-star-inserted")
	List <WebElement> dropdownOptions;
	
	public void SelectCountry(String CountryName)
	
	{
		CountryField.sendKeys("India");
					
		// Select the required value from list
		WebElement SelectedOption = dropdownOptions.stream().filter(s->s.getText().equalsIgnoreCase(CountryName)).findFirst().orElse(null);
				
		SelectedOption.click();
		
	}
	
	@FindBy (className="action__submit")
	WebElement SubmitButton;
	
	public ConfirmationPage Submit()
	
	{
		SubmitButton.click();
		
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
	
		return confirmationPage;
	}

}
