package com.product.qa.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.product.qa.base.TestBase;

public class MyEvents extends TestBase{
	
	private static final Logger logger = LogManager.getLogger(MyEvents.class);
	
	
	@FindBy(xpath="//a[@class='nav-link'][contains(text(),'Events')]")
	WebElement EventsTab;
	
	@FindBy(xpath="//a[contains(text(),'React JS')]")
	WebElement ReactjsEvent;
	
	@FindBy(xpath="//div[@id='root']//div//div//div//div//section//div//div//div//div//p//a")
	WebElement subscribeUnsubscribeBtn;
	
	@FindBy(xpath="//div[@id='navbarText']//a[@id='userDropdown']/span")
	@CacheLookup
	WebElement Profile;
	
	@FindBy(xpath="//div[@id='navbarText']//ul//li//div//a[contains(text(),'My Events')]")
	WebElement Myevents;
	
	@FindBy(xpath="//button[contains(text(),'Yes')]")
	WebElement Yesbtn;
	
	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	WebElement NoBtn;
	
	@FindBy(xpath="//div[contains(@class,'_loading_overlay_wrapper css-79elbk')]//li[6]//a[1]")
	WebElement nextpage;
	
	@FindBy(xpath="//div[@class='h-100']//div[2]//div[1]//div[1]//div[2]//div[1]//h2[1]//a[1]")
	WebElement FirstEvent;
	
	@FindBy(xpath=" //h1[@class='mb-2']//a")
	WebElement EventTitle;
	
	public MyEvents()
	{
		//Initializing WebElements
		PageFactory.initElements(driver,this);
	}
	public void VerfyEventSubscribe() throws InterruptedException
	{
		//EventsTab.click();
		 WebElement element = driver.findElement(By.xpath("//a[@class='nav-link'][contains(text(),'Events')]"));
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",element);
		logger.info("-----------Click on the 'Event Tab'-------------");
		
		Thread.sleep(5000);
		
		 WebElement elementa1 = driver.findElement(By.xpath("//a[contains(text(),'React JS')]"));
		 JavascriptExecutor executora1 = (JavascriptExecutor)driver;
		 executor.executeScript("arguments[0].click();",elementa1);
		 
		
		
		//FirstEvent.click();
		Thread.sleep(5000);
		logger.info("-----------Open the Event-------------");
		//String eventTxt=EventTitle.getText();
		Thread.sleep(7000);
		
		String  Btntext=subscribeUnsubscribeBtn.getText();
		if(Btntext.equals("Subscribe"))
		{
	// Subscribing the event
			subscribeUnsubscribeBtn.click();
			logger.info("-----------Click on subscribe button-------------");
			Thread.sleep(5000);
			Yesbtn.click();
			logger.info("-----------Click on yes button-------------");
			System.out.println("Event Subscribed");
			Thread.sleep(5000);
			logger.info("-----------Event Subscribed-------------");
			
   //Checking subscribed event in MYEvent
			//Profile.click();
			WebElement element1 = driver.findElement(By.xpath("//div[@id='navbarText']//a[@id='userDropdown']/span"));
			JavascriptExecutor executor1 = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();",element1);
			logger.info("-----------Click on the profile-------------");
			
			Thread.sleep(5000);
			Myevents.click();
			logger.info("-----------Click on the My Events-------------");
			Thread.sleep(5000);
			
			ReactjsEvent.isDisplayed();
			logger.info("-----------Event is display in my events-------------");
			System.out.println("Subscribed event is displayed in MyEvent");
			
	//Unsubscribing the subscribe event 
			//EventsTab.click();
			 WebElement element2 = driver.findElement(By.xpath("//a[@class='nav-link'][contains(text(),'Events')]"));
			 JavascriptExecutor executor2 = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();",element2);
			logger.info("-----------Click on the My Event-------------");
			
			Thread.sleep(3000);
			
			 WebElement elementa2 = driver.findElement(By.xpath("//a[contains(text(),'React JS')]"));
			 JavascriptExecutor executora2 = (JavascriptExecutor)driver;
			 executor.executeScript("arguments[0].click();",elementa2);
			logger.info("-----------Open the Event -------------");
			Thread.sleep(5000);
			subscribeUnsubscribeBtn.click();
			logger.info("-----------Click on the unsubscribe button-------------");
			Yesbtn.click();
			logger.info("-----------Click on the yes button-------------");
			Thread.sleep(5000);
			System.out.println("Event is unsubscribed successful");
			logger.info("-----------Event is Unsubscribed-------------");
			
	//Check Unsubscribe event is removed from myEvent
			
			
			//Profile.click();
			
			WebElement element3 = driver.findElement(By.xpath("//div[@id='navbarText']//a[@id='userDropdown']/span"));
			JavascriptExecutor executor3= (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();",element3);
			logger.info("-----------Click on the Profile-------------");
			
			Thread.sleep(5000);
			Myevents.click();
			logger.info("-----------Click on the My Events-------------");
			Thread.sleep(5000);
		   // String m1=ReactjsEvent.getText();
			if(driver.getPageSource().contains("React JSS"))
			{
				System.out.println("Event is not removed from my event. Please check ");
				logger.info("-----------Event is not removed from my event-------------");
			}
			else
			{
				System.out.println("Event is successfully removed from MyEvent");
				logger.info("-----------Event is removed from My Events-------------");
			}
			
			
		}
  else
		{
	//Checking subscribed event in MyEvents
			//Profile.click();
	    WebElement element4 = driver.findElement(By.xpath("//div[@id='navbarText']//a[@id='userDropdown']/span"));
		JavascriptExecutor executor4= (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",element4);
		logger.info("-----------Click on the Profile-------------");
			Thread.sleep(5000);
			Myevents.click();
			logger.info("-----------Click on the My Events-------------");
			Thread.sleep(5000);
			ReactjsEvent.isDisplayed();
			logger.info("-----------Subscribed event is displayed in My event-------------");
			System.out.println("Subscribed event is displayed in MyEvent");
			
	//Unsubscribe the subscribed event
			//EventsTab.click();
			 WebElement element5 = driver.findElement(By.xpath("//a[@class='nav-link'][contains(text(),'Events')]"));
			 JavascriptExecutor executor5 = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();",element5);
			logger.info("-----------Click on the Event Tab-------------");
			Thread.sleep(5000);
		
			 WebElement elementa3 = driver.findElement(By.xpath("//a[contains(text(),'React JS')]"));
			 JavascriptExecutor executora3 = (JavascriptExecutor)driver;
			 executor.executeScript("arguments[0].click();",elementa3);
			logger.info("-----------Open ReactJS event-------------");
			Thread.sleep(5000);
			subscribeUnsubscribeBtn.click();
			logger.info("-----------Click on the Unsubscribe button-------------");
			Yesbtn.click();
			logger.info("-----------Click on the Yes button-------------");
			Thread.sleep(5000);
			System.out.println("Event is unsubscribed successful");
			logger.info("-----------Event is unsubscribed-------------");
			
	//Checking unsubscribe event is removed from MyEvents
			//Profile.click();
			WebElement element6 = driver.findElement(By.xpath("//div[@id='navbarText']//a[@id='userDropdown']/span"));
			JavascriptExecutor executor6= (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();",element6);
			logger.info("-----------Click on the Profile-------------");
			
			Thread.sleep(5000);
			Myevents.click();
			logger.info("-----------Click on the My Events-------------");
			Thread.sleep(5000);
		   // String m1=ReactjsEvent.getText();
			if(driver.getPageSource().contains("React JSS"))
			{
				System.out.println("Event is not removed from my event. Please check ");
				logger.info("-----------ReactJS event is not removed from My Event-------------");
			}
			else
			{
				System.out.println("Event is successfully removed from MyEvent");
				logger.info("-----------ReactJS event is removed from My Event-------------");
			}
			
	 //Subscribe the event
			//EventsTab.click();
			 WebElement element7 = driver.findElement(By.xpath("//a[@class='nav-link'][contains(text(),'Events')]"));
			 JavascriptExecutor executor7 = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();",element7);
			logger.info("-----------Click on the My Events-------------");
			Thread.sleep(3000);
			Thread.sleep(3000);
			 WebElement elementa4 = driver.findElement(By.xpath("//a[contains(text(),'React JS')]"));
			 JavascriptExecutor executora4 = (JavascriptExecutor)driver;
			 executor.executeScript("arguments[0].click();",elementa4);
			logger.info("-----------Open the ReactJS event-------------");
			Thread.sleep(3000);
			String  Btntext1=subscribeUnsubscribeBtn.getText();
			if(Btntext1.equals("Subscribe"))
			{
				subscribeUnsubscribeBtn.click();
				logger.info("-----------Click on the Subscribe button-------------");
				Thread.sleep(3000);
				Yesbtn.click();
				logger.info("-----------Click on the Yes Button-------------");
				System.out.println("Event Subscribed");
				Thread.sleep(2000);
				logger.info("-----------Event is subscribed-------------");
			}
			else
			{
				System.out.println("Event is not subscribed Please check");
				logger.info("-----------Event is not subscribed-------------");
			}
	
		
	}

}
	}
