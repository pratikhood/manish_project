package com.product.qa.extentReportListener;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.product.qa.base.TestBase;

public class Listeners extends TestBase implements ITestListener {
	
	ExtentReports extent=ExtentReportNG.extentReportGenrator();
	ExtentTest test;
	private static ThreadLocal<ExtentTest> extentTest= new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		 test=extent.createTest(result.getMethod().getMethodName());
		 extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.PASS, "Successful");
		
	}

	public void onTestFailure(ITestResult result) {
		WebDriver driver = null;
		// TODO Auto-generated method stub
		//screenshot attached to report
		extentTest.get().fail(result.getThrowable());
		/*Object testObject=result.getInstance();
		Class clazz=result.getTestClass().getRealClass();
		try {
			driver=(WebDriver)clazz.getDeclaredField("driver").get(testObject);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try
		{
			extentTest.get().addScreenCaptureFromPath(getScreenshotPath(result.getMethod().getMethodName(),driver), result.getMethod().getMethodName());
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
		
	}

}
