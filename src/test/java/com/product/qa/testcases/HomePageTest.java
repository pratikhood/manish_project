package com.product.qa.testcases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.product.qa.base.TestBase;
import com.product.qa.pages.CoursesPage;
import com.product.qa.pages.ForgotPasswordPage;
import com.product.qa.pages.HomePage;
import com.product.qa.pages.LoginPage;

public class HomePageTest extends TestBase{

	 LoginPage login;
	 HomePage homepage;
	 CoursesPage coursespage;
	
	 public HomePageTest() {
		 super();
	 }
	 
	 @BeforeMethod
		public void setUp() throws InterruptedException, AWTException {
		
			initialization();
			login=new LoginPage();
			homepage=login.login();
			coursespage= new CoursesPage();
		}
	 
	 
	 @Test(priority=1,enabled = true)
	 public void VerifyHomePageTitleTest() throws InterruptedException {
		 Thread.sleep(7000);
		 String homepagetitle=homepage.VerifyHomepageTitle();
		 Assert.assertEquals(homepagetitle,"MZ Training Portal - Dashboard", "Home Page Title is not Matched");
	 }
	 
	 @Test(priority=2,enabled=true)
	 public void VerifyMzLogotest() throws InterruptedException {
		 Thread.sleep(5000);
		 Assert.assertTrue(homepage.VerifyMzLogo());
	 }
	 
	 @Test(priority=3,enabled=true)
	 public void VerifyCoursesLinkTest() {
		 coursespage=homepage.ClickOnCoursesLink();
	 }
	 @AfterMethod
		public void tearDown() {
			driver.quit();
	}
}
