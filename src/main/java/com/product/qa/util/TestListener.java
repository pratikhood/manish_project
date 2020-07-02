package com.product.qa.util;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListener implements ITestListener {
	
	//@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	
	//onTestSuccess
	//@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test is Passed");
	}
	
	//on Test Failure
	//@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test is Failed");
	}
	
	//onTestSkipped
	//@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test is Skipped");
	}
	
	//@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	
	//@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
	//onTestFinish
	//@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//TestLogin.driver.quit();
	}
	
}

    
