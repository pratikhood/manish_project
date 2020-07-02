package com.product.qa.testcases;

import java.awt.AWTException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.product.qa.base.TestBase;
import com.product.qa.pages.DashboardPage;
import com.product.qa.pages.HomePage;
import com.product.qa.pages.LoginPage;


public class DashboardPageTest extends TestBase {
	LoginPage login;
	DashboardPage dashboard;
	HomePage homepage;
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException, AWTException {
	
		initialization();
		login=new LoginPage();	
		homepage= new HomePage();
		dashboard= new DashboardPage();
		homepage=login.login();
		Thread.sleep(9000);
	}
	@Test(priority = 1,enabled = true)
	public void courseCountTest() throws InterruptedException 
	{
		dashboard.verifyCoursesCount();
			
	}
	@Test(priority = 2,enabled = true)	
	
	public void BlogsCountTest() throws InterruptedException 
	{
		dashboard.verifyBlogsCount();
	}
	@Test(priority = 3,enabled = true)
	public void EventsCountTest() throws InterruptedException 
	{
		dashboard.verifyEventsCount();
	}
	@Test(priority=4,enabled=true)
	public void resumeButtonTest() throws InterruptedException
	{
	   dashboard.verifyResumeCourse();
	}
	
	@Test(priority=5,enabled=true)
	public void LearnigPathLabelTest()
	{
		dashboard.verifyLearningPathLabel();
	}
	

	@Test(priority=6, enabled = false)//Events are not availabe in website
	public void upcomingEventLabelTest() 
	{
      dashboard.verifyUpcomingEventlabel();
	}
	
	@Test(priority=7,enabled= false)//Event are not available in website
	public void verifyEventOpenTest() throws InterruptedException
	{
		dashboard.verifyEventOpen();
	}
	@Test(priority=8,enabled = false)//Event are not avalable in website.
	public void EventViewAllBtnTest() throws InterruptedException
	{
		dashboard.verifyEventViewAllBtn();
	}
	
	@Test(priority = 9,enabled = true)
	public void BlogsLabelTest()
	{
		dashboard.verifyLettestBlogsLabel();
	}
	@Test(priority = 10,enabled = true)
	public void BlogsOpenTest() throws InterruptedException
	{
		dashboard.verifyBlogOpen();
	}
	@Test(priority = 11,enabled = true)
	public void BlogsViewAllBtnTest() throws InterruptedException
	{
		dashboard.verifyBlogsViewAllBtn();
		Thread.sleep(4000);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	
}
}


