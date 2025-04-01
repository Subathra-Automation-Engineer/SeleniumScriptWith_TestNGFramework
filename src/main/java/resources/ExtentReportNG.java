package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	static ExtentReports extentreport;
	
	public static ExtentReports getReportObject()
	
	{
		
		String path= System.getProperty("user.dir")+"\\reports\\index.html";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("EcommereceApp_RegressionTest_Results");
		reporter.config().setDocumentTitle("TestResults");
		
		extentreport = new ExtentReports();
		
		extentreport.attachReporter(reporter);
		extentreport.setSystemInfo("Tester","Subathra Selvaraj");
		
		return extentreport;
	}

}
