🛒**E-commerce Website Testing Project**

📜**Project Description**

This Selenium Script is written using JAVA language.In this script, I have automated the Login Functionality and Order Placing functionality of an Ecommerce Application.
If UserID , Password and Product name is given, It will login to the Ecommerce application, place order for the given product and check the order history to confirm the placed order. 

🚀 **Key Highlights**

**Framework Design:**

Integrated Maven for build management and dependency handling.

Followed the Page Object Model (POM) design pattern for modularity and maintainability.

Also used testNG as framework for easy maintanance of the script.

**Testing Approach:**

Implemented Data-Driven Testing using Excel files for dynamic and reusable test data.

**Reporting and Logging:**

Generated detailed test execution reports using TestNG Listeners and Extent Reports.

**🛠️ Tools and Technologies**

Programming Language: Java

Automation Tool: Selenium WebDriver

Test Framework: TestNG

Build Management: Maven

Reporting: Extent Reports, TestNG Listeners

Data Handling: Data Provider (JSON File)

Source Control: GitHub

**Framework Explanation**

***Folder 1 (src/test/java)**

👉 In this folder where we have one package named "Testcases" and we are maintaining all our test case files (java files). Ex : ErrorValidationTest.java We are using @Test Annotation for tests.

***Folder 2 (src/main/java)**

👉 In this folder we have three packages, 
          1) The default package contains the Standaloe script to place order(Without framework implementation).
          2) The package **"Pageobjects"** contains all our locators for each webpage of the application.
             In this package, we also have a class named "BaseTest.java" from where we invoke our browsers.
             we are using @BeforeSuite (for launching browsers ) and @AfterSuite (for closing browser).
             we are extending this base class in every tests. 
          3) The package **resources** contains the Listeners class, which we are using to generate extent report.

***Folder 3 (src/test/resources)**          

👉 In this folder,we have a folder named TestData which containd the TestData_ToPlaceOrder.json file.
