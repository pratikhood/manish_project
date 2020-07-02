package com.product.qa.testcases;

import java.awt.AWTException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.product.qa.base.TestBase;
import com.product.qa.pages.HomePage;
import com.product.qa.pages.LoginPage;
import com.product.qa.pages.MyEvents;

public class MyEventsTest extends TestBase {
	
	LoginPage login;
	MyEvents event;
	HomePage homepage;
	
	@BeforeMethod
	public void setUp() throws InterruptedException, AWTException {
	
		initialization();
		login=new LoginPage();	
		homepage= new HomePage();
		event= new MyEvents();
		homepage=login.login();
		Thread.sleep(9000);
	}
	
	
	@Test(priority=1,enabled=true)
	public void VerifyMyEvent() throws InterruptedException
	{
		event.VerfyEventSubscribe();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
