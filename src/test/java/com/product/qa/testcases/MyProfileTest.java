package com.product.qa.testcases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.product.qa.base.TestBase;
import com.product.qa.pages.ChangePassword;
import com.product.qa.pages.HomePage;
import com.product.qa.pages.LoginPage;
import com.product.qa.pages.MyProfile;

public class MyProfileTest extends TestBase {
	HomePage homepage;
	LoginPage loginpage;
	MyProfile profile;
	
	 public MyProfileTest() {
			super();
			
			
		}
	 
	 @BeforeMethod
		public void setUp() throws InterruptedException, AWTException {
		 
		    initialization();
			profile=new MyProfile();
			homepage= new HomePage();
			loginpage=new LoginPage();
			homepage=loginpage.login();
			homepage.clickOnProfile();
			Thread.sleep(7000);
			profile.ClickOnMyProfileOption();
			Thread.sleep(9000);
			
		 }
	 
	 @Test(priority = 1, enabled=true)
	 public void verifyBesicDetailTest()
		{
		profile.verifyFirstName();
		System.out.println("First Name is displayed");
		profile.verifyEmail();
		System.out.println("Email is displayed");
		profile.verifyPhoneNumber();
		System.out.println("Phone Number is displayed");
		profile.verifyLocation();
		System.out.println("Location is displayed");
		profile.verifyCollege();
		System.out.println("College is Displayed");
		profile.verifyDept();
		System.out.println("Dept is displayed");
		}
	 
	 @Test(priority = 2, enabled = true)
	 public void verifyContactInformationTest()
	 {
		 profile.verifyContactMobile();
		 System.out.println("COntact Mobile number is displayed");
		 profile.verifyContactEmail();
		 System.out.println("Contact email is displayed");
		 profile.verifyContactLocation();
		 System.out.println("Contact Location is display");
	 }
	
	 
	 
	@Test(priority = 3,enabled=false)
	 public void ValidateUpdateProfileTest() throws InterruptedException, AWTException, IOException
	 {
		 profile.UpdateProfile();
	 }
	
	@Test(priority=4,enabled=false)
	public void ValidateRemoveImageTest() throws InterruptedException
	{
		profile.VerifyRemoveImage();
		
	}
	 
		@AfterMethod
		public void tearDown() {
			driver.quit();
	}
}
