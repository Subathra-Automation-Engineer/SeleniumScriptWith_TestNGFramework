package TestCases;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import PageObjects.BaseTest;

public class ErrorValidationTest extends BaseTest{
	
	public String ErrorMessage;
	@Test
	public void ErrorValidationEmail() throws InterruptedException 
	
	{
	
	landingPage.login("subathra.tt@gmail.com", "Testpassword*3");
	
	ErrorMessage = landingPage.GetErrorMessage();
	
	Assert.assertEquals(ErrorMessage,"Incorrect email or password1.");

	}
	
	@Test
	public void ErrorValidationPassword() throws InterruptedException 
	
	{
	
	landingPage.login("subathra.test@gmail.com", "Testpaword*3");
	
	ErrorMessage = landingPage.GetErrorMessage();
	
	Assert.assertEquals("Incorrect email or password.", ErrorMessage);

	}

	
	
	
	/*@Test 	
	public void ValidatetheString() throws IOException
	
	{
		// File myObj = new File(System.getProperty("user.dir")+"//src//main//java//TestData//TestData_ToPlaceOrder.json");
	    //  Scanner JsonFile = new Scanner(myObj);
	      
		Path path = Paths.get(System.getProperty("user.dir")+"//src//main//java//TestData//TestData_ToPlaceOrder.json");
	      String JsonContent = Files.readString(path);
			//String JsonContent = JsonFile.next();
			
			 System.out.println("JSON STRING: " + JsonContent);
			//to convert String to Hashmap we must use Jack Data binding dependency

			ObjectMapper Mapper = new ObjectMapper();
			
			List<HashMap<String,String>> data = Mapper.readValue(JsonContent,new TypeReference<List<HashMap<String,String>>>(){});
	
			for (HashMap<String, String> map : data) {
			    map.forEach((key, value) -> System.out.println(key + " -> " + value));
			}
	}
	
	
	@DataProvider
	public Object[][] getDataUsingJson() throws IOException
	
	{
		
		List<HashMap<String,String>> data =  GetjsontoHashmap(System.getProperty("user.dir")+"//src//main//java//TestData//TestData_ToPlaceOrder.json");
		
		return new Object [][]  {{data.get(0)},{data.get(1)}};
	}*/

}
