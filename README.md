This Selenium Script is written using JAVA language.
If UserID , Password and Product name is given, It will login to the Ecommerce application and place order for the given product.

I have used maven Project to manage all dependencies and used testNg as framework. 
Along with testNg framework I have used Data Driven Approach - TestNg @DataProvider annotation so that we can run our tests multiple times with different Data.

**Framework Explanation**

**Folder 1 (src/test/java)*

👉 In this folder where we have one package named "Testcases" and we are maintaining all our test case files (java files). Ex : ErrorValidationTest.java
We are using @Test Annotation for tests.

**Folder 2 (src/main/java)*

👉 In this folder we have two packages, The default package contains the Standaloe script to place order(Without framework implementation) 
The package "Pageobjects" contains all our locators for each webpage of the application.

👉 In this folder we have also have a class named "BaseTest.java" from where we invoke our browsers,we are extending this base class in every tests.
Also we are using @BeforeSuite (for launching browsers ) and @AfterSuite (for closing browser)
