package TestCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.BaseTest;

public class ErrorValidationTest extends BaseTest{
	
	public String ErrorMessage;
	@Test
	public void ErrorValidationEmail() throws InterruptedException 
	
	{
	
	landingPage.login("subathra.tt@gmail.com", "Testpassword*3");
	
	ErrorMessage = landingPage.GetErrorMessage();
	
	Assert.assertEquals("Incorrect email or password.", ErrorMessage);

	}
	
	@Test
	public void ErrorValidationPassword() throws InterruptedException 
	
	{
	
	landingPage.login("subathra.test@gmail.com", "Testpaword*3");
	
	ErrorMessage = landingPage.GetErrorMessage();
	
	Assert.assertEquals("Incorrect email or password.", ErrorMessage);

	}



}
