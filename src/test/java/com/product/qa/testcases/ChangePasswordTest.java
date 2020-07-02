package com.product.qa.testcases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.product.qa.base.TestBase;
import com.product.qa.pages.ChangePassword;
import com.product.qa.pages.HomePage;
import com.product.qa.pages.LoginPage;

public class ChangePasswordTest extends TestBase  {
	ChangePassword changepassword;
	HomePage homepage;
	LoginPage loginpage;
	
	public ChangePasswordTest()
	{
		super();
	}
	@BeforeMethod
	public void setUp() throws InterruptedException, AWTException {
	
		initialization();
		changepassword=new ChangePassword();
		homepage= new HomePage();
		loginpage=new LoginPage();
		homepage=loginpage.login();
		homepage.clickOnProfile();
		changepassword.clickOnChangePassword();
		Thread.sleep(5000);
		
		}
	
	@Test(priority=1,enabled = true)
	public void verifyPasswordLabelTest(){
		
		Assert.assertTrue(changepassword.changePasswordLabel());
		
	 }
	
	
	@Test(priority=2,enabled = true)
	public void verifyChangePasswordTest()
	{
		changepassword.verifyChangePassword();
		
	}
	@Test(priority=3, enabled=true)
	public void VerifyChangePasswordTextTest()
	{
		changepassword.verifyPleaseEnterPasswordText();
		
	}
	@Test(priority=4, enabled= true)
	public void verifyPleaseEnterValidPasswordtextTest()
	{
		changepassword.verifyPleaseEnterValidPasswordText();
	}
	@Test(priority=5,enabled=true)
	public void verifyPleaseReEnterPasswordTextTest()
	{
		changepassword.verifyPleaseReEnterPasswordText();
	}
	@Test(priority=6,enabled=true)
	public void verifyPasswordMisMatchTextTest()
	{
		changepassword.verifyPasswordMisMatchTextTest();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
    }
	
	
}
