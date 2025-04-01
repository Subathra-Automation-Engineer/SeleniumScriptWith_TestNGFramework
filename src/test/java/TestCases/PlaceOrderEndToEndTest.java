package TestCases;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.BaseTest;
import PageObjects.CheckOut;
import PageObjects.ConfirmationPage;
import PageObjects.OrderHistory;
import PageObjects.SearchForProduct;
import PageObjects.SubmitOrder;

public class PlaceOrderEndToEndTest extends BaseTest{
	
	//String ProductName= "ADIDAS ORIGINAL";	
	@Test(dataProvider="getDataUsingJson")
	//@Test(dataProvider="getDataUsingJson", groups= {"DataProvider"})
	public void PlaceOrder(HashMap <String,String> input) throws InterruptedException 
	
	{
	
	SearchForProduct Search = landingPage.login(input.get("Email"), input.get("Password"));
	
	CheckOut checkout  = Search.SearchNSelect(input.get("ProductName"));
	
	checkout.GoToCart();	
	
	SubmitOrder submitorder  = checkout.ContinueCheckOut();
	
	submitorder.SelectCountry("India");
	
	ConfirmationPage confirmationPage = submitorder.Submit();
	
	String ConfirmationMessage = confirmationPage.GetMessage();
	
	Assert.assertTrue(ConfirmationMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	
	
	}
	
	@Test(dependsOnMethods="PlaceOrder",dataProvider="getDataUsingJson")
	public void OrderHistoryTest(HashMap <String,String> input)
	
	{
		landingPage.login(input.get("Email"), input.get("Password"));
		
		OrderHistory orderHistory = new OrderHistory(driver);
		
		orderHistory.GoToOrdersPage();		
		
		String RecentlyOrderedProduct = orderHistory.CheckforProduct();
		
		Assert.assertTrue(RecentlyOrderedProduct.equalsIgnoreCase(input.get("ProductName")));
	}
	
	/*@DataProvider	
	public Object[][] getData()
	
	{
		
		return new Object[][] {{"subathra.test@gmail.com", "Testpassword*3","ADIDAS ORIGINAL"},{"mithu.test@gmail.com", "Testpassword*3","ADIDAS ORIGINAL"}};
		
		
	} */
	
	/*@DataProvider	
	public Object[][] getDataUsingHashMap()
	
	{
		HashMap <String,String> map = new HashMap <String,String>() ;
		
		map.put("Email", "subathra.test@gmail.com");
		map.put("Password", "Testpassword*3");
		map.put("ProductName", "ZARA COAT 3");
		
		HashMap <String,String> map1 = new HashMap <String,String>() ;
		
		map1.put("Email", "mithu.test@gmail.com");
		map1.put("Password", "Testpassword*3");
		map1.put("ProductName", "ZARA COAT 3");
		
		return new Object[][] {{map},{map1}};
		
	}*/
	
	
	
	@DataProvider
	public Object[][] getDataUsingJson() throws IOException
	
	{
		
		//List<HashMap<String,String>> data =  GetjsontoHashmap(System.getProperty("user.dir")+"//src//main//java//TestData//TestData_ToPlaceOrder.json");
		
		List<HashMap<String,String>> data =  GetjsontoHashmap(System.getProperty("user.dir")+"//src//test//resources//TestData//TestData_ToPlaceOrder.json");
		return new Object [][]  {{data.get(0)},{data.get(1)}};
	}
	


}