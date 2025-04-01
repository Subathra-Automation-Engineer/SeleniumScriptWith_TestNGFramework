This Selenium Script is written using JAVA language.In this script, I have automated the Login Functionality and Order Placing functionality of an Ecommerce Application.
If UserID , Password and Product name is given, It will login to the Ecommerce application, place order for the given product and check the order history to confirm the placed order. 

I have used maven Project to manage all dependencies.
Also used testNg as framework for easy maintanance of the script and Page Object Model for beter redability of the script.
Along with testNg framework,I have used Data Driven Approach - TestNg @DataProvider annotation,
so that the Test Datas are fetched from a JSON file and we can run our tests multiple times with different Data set.

Framework Explanation

*Folder 1 (src/test/java)

👉 In this folder where we have one package named "Testcases" and we are maintaining all our test case files (java files). Ex : ErrorValidationTest.java We are using @Test Annotation for tests.

*Folder 2 (src/main/java)

👉 In this folder we have three packages, 
          1) The default package contains the Standaloe script to place order(Without framework implementation).
          2) The package **"Pageobjects"** contains all our locators for each webpage of the application.
             In this package, we also have a class named "BaseTest.java" from where we invoke our browsers.
             we are using @BeforeSuite (for launching browsers ) and @AfterSuite (for closing browser).
             we are extending this base class in every tests. 
          3) The package **resources** contains the Listeners class, which we are using to generate extent report.

*Folder 3 (src/test/resources)          

👉 In this folder,we have a folder named TestData which containd the TestData_ToPlaceOrder.json file.
