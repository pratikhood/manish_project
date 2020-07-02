package com.product.qa.testcases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.product.qa.base.TestBase;
import com.product.qa.pages.ForgotPasswordPage;
import com.product.qa.pages.HomePage;
import com.product.qa.pages.LoginPage;

public class LoginTest extends TestBase{
	LoginPage login;
	ForgotPasswordPage forgotPasswordPage;
	HomePage homepage;
	
	 public LoginTest() {
		super();
	}
	@BeforeMethod
	public void setUp() throws InterruptedException, AWTException {
	
		initialization();
		login=new LoginPage();
		forgotPasswordPage=new ForgotPasswordPage();
		homepage= new HomePage();
	}
	
	 @Test(priority=1,enabled= true)
	 public void LoginPageTitletest() throws InterruptedException {
		String title=login.ValidateLoginpageTitle();
		Assert.assertEquals(title,"MZ Training Portal - Login");
	 }
	 
	 @Test(priority=2, enabled=true)
	 public void MzLogoImagetest() throws InterruptedException {
		boolean logo= login.ValidateMzLogo();
	  Assert.assertTrue(logo);
	 }
	
	 	
	@Test(priority=3,enabled=true)
	public void ValidateLogin() throws InterruptedException, AWTException {
		homepage=login.login();
	}
	
	@Test(priority=4,enabled=false) 
	  public void ValidateForgotPassword() throws InterruptedException 
	  {
	  forgotPasswordPage.VerifyForgotPassword();
	  
	  }
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
}
}
