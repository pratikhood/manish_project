package com.product.qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.google.appengine.tools.util.Action;
import com.product.qa.base.TestBase;

public class MyProfile extends TestBase{
	
	private static final Logger logger = LogManager.getLogger(MyProfile.class);
	
	@FindBy(xpath="//div[@id='navbarText']//ul//li//div//a[contains(text(),'My Profile')]")
	WebElement MyProfileOption;
	
	@FindBy(xpath="//div[contains(text(),'Super Admin')]")
	WebElement FullName;
	
	@FindBy(xpath="//div[contains(text(),'8833445533')]")
	WebElement Phone;
	
	@FindBy(xpath="//div[@class='col-lg-8'][contains(text(),'admin@mindzcloud.com')]")
	WebElement email;
	
	@FindBy(xpath="//div[@id='pills-tabContent']//div[2]//div[2]//div[2]")
	WebElement location;
	
	@FindBy(xpath="//div[contains(text(),'MindZcloud Technologies')]")
	WebElement college;
	
	@FindBy(xpath="//div[contains(text(),'Information Technology')]")
	WebElement Department;
	
	@FindBy(xpath="//div[text()='admin@mindzcloud.com']")
	WebElement ContactEmail;
	
	@FindBy(xpath="//div[3]//div[2]//div[1]")
	WebElement contactLocation;
	
	@FindBy(xpath="//div[@class='main-profile-contact-list']//div[1]//div[2]//div[1]")
	WebElement ContactMobile;
	
	@FindBy(xpath="//button[contains(text(),'Choose image')]")
	WebElement chooseimageBtn;
	
	@FindBy(xpath="//a[contains(text(),'Edit Profile')]")
	WebElement Editbwt;
	
	@FindBy(xpath="//*[@id=\"country\"]")
	WebElement state;
	
	@FindBy(xpath="//*[@id='city']")
	WebElement city;
	
	@FindBy(xpath="//span[contains(text(),'Update Profile')]")  
	WebElement UptBwn;
	
	@FindBy(xpath = "//button[contains(text(),'Choose image')]")
	WebElement UploadImage;
	
	@FindBy(xpath="//button[contains(text(),'Remove Image')]")
	WebElement RemoveImage;
	
	//Create Constructor for Initialize the webElements
			public MyProfile() {
				//Initializing WebElements
				PageFactory.initElements(driver,this);
			}
			
			public void ClickOnMyProfileOption() {
				//MyProfileOption.click();
				WebElement element = driver.findElement(By.xpath("//div[@id='navbarText']//ul//li//div//a[contains(text(),'My Profile')]"));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();",element);
				logger.info("-----------Click on the My Profile Option-------------");
			}
			
			public boolean verifyFirstName()
			{
				return FullName.isDisplayed();
			}
			public boolean verifyPhoneNumber()
			{
				return Phone.isDisplayed();
			}
			public boolean verifyEmail()
			{
				return email.isDisplayed();
			}
			public boolean verifyLocation()
			{
				return location.isDisplayed();
			}
			public boolean verifyCollege()
			{
				return college.isDisplayed();
			}
			public boolean verifyDept()
			{
				return Department.isDisplayed();
			}
			public boolean verifyContactMobile()
			{
				return ContactMobile.isDisplayed();
			}
			public boolean verifyContactEmail()
			{
				return ContactEmail.isDisplayed();
			}
			public boolean verifyContactLocation()
			{
				return contactLocation.isDisplayed();
			}
			
			
			
			public void UpdateProfile() throws InterruptedException, AWTException, IOException
			{
				Editbwt.click();
				logger.info("-----------Click on Edit button-------------");
				Thread.sleep(5000);
				
				
			//Selecting states
				state.click();
				logger.info("-----------Click on the state-------------");
				
	List<WebElement> states= driver.findElements(By.cssSelector("#country>option"));
				for (WebElement stateList: states) {
					 if(stateList.getText().equals("Maharashtra"))
					 {
						 stateList.click();
						 Actions sl= new Actions(driver);
						 sl.sendKeys(Keys.ENTER);
						 logger.info("-----------State is selected-------------");
						 break;
					 }
					
				}
		  //Selecting city
				city.click();
				logger.info("-----------Click on the city-------------");
				List<WebElement> cities= driver.findElements(By.cssSelector("#city>option"));
				for (WebElement cityList: cities) {
					 if(cityList.getText().equals("Nagpur"))
					 {
						 cityList.click(); 
						 logger.info("-----------City is selected-------------");
						 break;
						 
					 }
					
				}  
				
				chooseimageBtn.click();
				logger.info("-----------Click on the choose image button -------------");
				Thread.sleep(5000);
				
			//Uploading image
				
				Runtime.getRuntime().exec("driver/UploadFile.exe");
				System.out.println("Profile Image Selected");
				Thread.sleep(5000);
				
				
				//UptBwn.click();
				WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Update Profile')]"));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();",element);
				Thread.sleep(10000);
				System.out.println("Profile Updated Successfuly");
				
					
			}
			
			public void VerifyRemoveImage() throws InterruptedException
			{
				Editbwt.click();
				logger.info("-----------Click On the Edit button-------------");
				Thread.sleep(5000);
				RemoveImage.click();
				logger.info("-----------Click on the removed image button-------------");
				Thread.sleep(5000);
				
			}
	
			
	

}
