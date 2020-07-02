package com.product.qa.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.product.qa.base.TestBase;

public class HomePage extends TestBase {
	
	private static final Logger logger = LogManager.getLogger(HomePage.class);
	
	

	
	   @FindBy(xpath = "//a[@class=\"navbar-brand active\"]//img")
	   WebElement MzLogo;
	   
	   @FindBy(xpath = "//a[text()=\"Dashboard\"]")
	   WebElement DashboardLink;
	   
	   @FindBy(xpath = "//a[text()=\"Courses\"]")
	   WebElement CoursesLink;
	   
	   @FindBy(xpath = "//a[text()=\"Events\"]")
	   WebElement EventsLink;
	   
	   @FindBy(xpath="//div[@id='navbarText']//a[@id='userDropdown']/span")
		@CacheLookup
		WebElement Profile;
	   
	   public HomePage() {
		   PageFactory.initElements(driver, this);
	   }
	   
	   public String VerifyHomepageTitle()  {
		   
		   return driver.getTitle();
	   }
	   
	   public boolean VerifyMzLogo() {
		 return MzLogo.isDisplayed();
	   }
	   public DashboardPage ClickOnDashboardLink() {
		   DashboardLink.click();
		   logger.info("-----------click on dashboard link-------------");
		   return new DashboardPage();
	   }
	   
	   public CoursesPage ClickOnCoursesLink() {
		   //CoursesLink.click();
		   WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Courses')]"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();",element);
			  logger.info("-----------click on Courses link-------------");
		   return new CoursesPage();
	   }
	   
	   public void clickOnProfile()
	   {
		   //Profile.click();
		   WebElement element = driver.findElement(By.xpath("//li[@class='nav-item dropdown desktop-search']//a[@id='userDropdown'][1][@role='button']"));//li[@class='nav-item dropdown desktop-search']/a[@id=\"userDropdown\"]/span[text()='SA']"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();",element);
			 logger.info("-----------click on Profile-------------");
	   }
	   

}
