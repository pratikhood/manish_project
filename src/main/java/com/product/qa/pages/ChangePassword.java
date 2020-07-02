package com.product.qa.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.product.qa.base.TestBase;

public class ChangePassword extends TestBase{
	
	private static final Logger logger = LogManager.getLogger(ChangePassword.class);
	
	
	@FindBy(xpath="//div[@id='navbarText']//ul//li//div//a[contains(text(),'Change Password')]")
	WebElement changePwdOption;
	
	@FindBy(xpath="//input[@id='oldPassword']")
	WebElement currentPwd;
	
	@FindBy(xpath="//input[@id='newPassword']")
	WebElement NewPwd;
	
	@FindBy(xpath="//input[@id='confirmPassword']")
	WebElement ConfirmPwd;
	
	@FindBy(xpath=" //span[contains(text(),'Update')]")
	WebElement updateBtn;
	
	@FindBy(xpath="//h2[contains(text(),'Change Password')]")
	WebElement changePasswordLabel;
	
	@FindBy(xpath="//body//div[@id='root']//div//div//div//div//div//div//div//div[1]//div[1]//div[1]")
	WebElement PleaseEnterPasswordMessage;
	
	@FindBy(xpath="//div[contains(text(),'Please enter a valid password')]")
	WebElement PleaseEnterValidPasswordMessage;
	
	@FindBy(xpath="//div[contains(text(),'Password mismatch')]")
	WebElement PasswordMissMatchMessage;
	
	@FindBy(xpath="//div[contains(text(),'Please re-enter password')]")
	WebElement PleaseReEnterPassword;
	
	//Create Constructor for Initialize the webElements
	public ChangePassword() {
		//Initializing WebElements
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnChangePassword()
	{
		//changePwdOption.click();
		 WebElement element = driver.findElement(By.xpath("//div[@id='navbarText']//ul//li//div//a[contains(text(),'Change Password')]"));
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",element);
		logger.info("-----------Click on change password-------------");
	}
	
	public boolean changePasswordLabel()
	{
		return changePasswordLabel.isDisplayed();
	}
	
	public void verifyPleaseEnterPasswordText()
	{
		updateBtn.click();
		logger.info("-----------Click on the update button-------------");
		String s=PleaseEnterPasswordMessage.getText();
		Assert.assertEquals(s,"Please enter a password");
		logger.info("-----------Please enter a password text display -------------");
	}
	
	public void verifyPleaseEnterValidPasswordText()
	{
		currentPwd.sendKeys("12345");
		logger.info("-----------Current password send -------------");
		NewPwd.sendKeys("123");
		logger.info("-----------New password send -------------");
		ConfirmPwd.click();
		logger.info("-----------click on conferm password-------------");
		String s1=PleaseEnterValidPasswordMessage.getText();
		Assert.assertEquals(s1,"Please enter a valid password");
		logger.info("-----------Please enter a valid password message display-------------");
	}
	
	public void verifyPleaseReEnterPasswordText()
	{
		currentPwd.sendKeys("12345");
		logger.info("-----------Enter current password-------------");
		NewPwd.sendKeys("Ma@123456789");
		logger.info("-----------Enter New password-------------");
		updateBtn.click();
		logger.info("-----------Click on  the update button-------------");
		String s2=PleaseReEnterPassword.getText();
		Assert.assertEquals(s2,"Please re-enter password");
		logger.info("-----------Please re-enter password test is display-------------");
		
	}
	
	public void verifyPasswordMisMatchTextTest()
	{
		currentPwd.sendKeys("12345");
		logger.info("-----------Enter current password-------------");
		NewPwd.sendKeys("Ma@123456789");
		logger.info("-----------Enter New password-------------");
		ConfirmPwd.sendKeys("123");
		logger.info("-----------Enter confirm password-------------");

		updateBtn.click();
		logger.info("-----------Click on the Update button-------------");
		String s2=PasswordMissMatchMessage.getText();
		Assert.assertEquals(s2,"Password mismatch");
		logger.info("-----------Password Missmatched message display-------------");
	}
	
	public void verifyChangePassword()
	{
		currentPwd.sendKeys("12345");
		logger.info("-----------Enter current password-------------");
		NewPwd.sendKeys("123456");
		logger.info("-----------Enter New Password-------------");
		ConfirmPwd.sendKeys("123456");
		logger.info("-----------Enter confirm password-------------");
		//updateBtn.click();
		logger.info("-----------Update button click-------------");
		System.out.println("password updation successfull");
	}
	
	
	
	
}