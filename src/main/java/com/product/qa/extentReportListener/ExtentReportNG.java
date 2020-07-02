package com.product.qa.extentReportListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	static ExtentReports extent;
	
	public static ExtentReports extentReportGenrator()
	{
		
		//ExtentReport, ExtentSparxReporter
		//String path=System.getProperty("User.dir")+"\\reports\\index.html";
		 String path=System.getProperty("User.dir")+"\\reports\\index.html";
		 ExtentSparkReporter report=new ExtentSparkReporter(path);
		 report.config().setReportName("MZ Product Results");
		 report.config().setDocumentTitle("Test Results");
		 
		 extent= new ExtentReports();
		 extent.attachReporter(report);
		 extent.setSystemInfo("Tester Name", "Manish Patil");
		 return extent;
		 
		
		
    }

	
	

}
