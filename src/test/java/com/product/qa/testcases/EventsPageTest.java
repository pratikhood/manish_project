package com.product.qa.testcases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.product.qa.base.TestBase;
import com.product.qa.pages.EventsPage;
import com.product.qa.pages.HomePage;
import com.product.qa.pages.LoginPage;
import com.product.qa.util.TestUtil;


public class EventsPageTest extends TestBase{
	LoginPage login;
	EventsPage event;
	HomePage homepage;
	TestUtil testutil;
	String sheetName2="Courses";
	
	@BeforeMethod
	public void setUp() throws InterruptedException, AWTException {
	
		initialization();
		login=new LoginPage();	
		homepage= new HomePage();
		event= new EventsPage();
		homepage=login.login();
		Thread.sleep(9000);
	}
	
	@Test(priority=1,enabled=true)
	public void VerifyEventTest() throws InterruptedException
	{
		event.VerfyEventSubscribe();
	}
	
	
	
	@Test(priority=3, enabled=true)
	public void VerifyEventPageFilterLinksTest() throws InterruptedException {
		event.ValidateFilterLinks();
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}


}
