package com.product.qa.pages;

import java.util.List;

import javax.xml.xpath.XPath;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.product.qa.base.TestBase;

public class CoursesPage extends TestBase {
	
	private static final Logger logger = LogManager.getLogger(CoursesPage.class);

	@FindBy(xpath = "//a[contains(text(),'Courses')]")
	@CacheLookup
	WebElement CoursesLink;
	
	@FindBy(xpath = "//div[@class='section-title']//h2[text()='Courses']")
	@CacheLookup
	WebElement Courseslabel;
	
	@FindBy(xpath = "//div[@class='section-title']/following::h2[text()='Filters'][2]")
	@CacheLookup
	WebElement FiltersTitle;
	
	@FindBy(xpath="(//div[@id='accordion']//li//a[text()='Business'])[2]")
	@CacheLookup
	WebElement BussinessLink;
	
	@FindBy(xpath="(//div[@id='accordion']//li//a[text()='Design'])[2]")
	@CacheLookup
	WebElement DesignLink;
	
	@FindBy(xpath = "//div[@class='section-title']//h2[text()='Blogs']")
	@CacheLookup
	WebElement BlogsTitle;
	
	@FindBy(xpath = "//div//p[text()='No Courses Found']")
	WebElement LinkDetails;
	
	@FindBy(xpath = "//div[@class='blog-info']//a[text()='View']")
	WebElement ViewLink;
	
	@FindBy(xpath = "//div[@class='chapter-unlock']//p/following::a[text()='Access Course']")
	WebElement AccessCourse;
	
	public CoursesPage() {
		//initializing WebElement
		PageFactory.initElements(driver ,this);
	}
	
	
	public boolean VerifyCoursesLabel() {
		return Courseslabel.isDisplayed();
	}
	
	
	
	public CoursesPage ValidateFilterLinks() throws InterruptedException {
		  List<WebElement>  FilterLinks = driver.findElements(By.xpath("//div[@class='section-title']/following::h2[text()='Filters'][2]"));  
		  System.out.println(FilterLinks.size());
		
		  for(int i=8; i<FilterLinks.size();i++) {
		         FilterLinks.get(i).click();
		         Thread.sleep(5000);
		         //System.out.println(i+"--" + LinkDetails);
		         //System.out.println(i+"--" + LinkDetails.toString().contains("Proxy"));
				
		         if(!LinkDetails.toString().contains("Proxy") && LinkDetails.getText().equalsIgnoreCase("No Courses Found") ) {
		        	 //Thread.sleep(5000);
		        	 Assert.assertTrue(LinkDetails.isDisplayed(),"Courses Found");
		        	 System.out.println("Course Not Found");
		         }
		         else{
			
		        	 //List<WebElement> ListViewlink= driver.findElements(By.xpath("//div[@class='blog-info']//a[text()='View']"));
		        	 //Thread.sleep(5000);
			
		        	 Assert.assertTrue(ViewLink.isDisplayed(),"No Courses Found");
		        	 System.out.println("Courses Found");
			
		         }	
		  }
		return new CoursesPage();
		
		}
	
	
		public CoursesPage VerifyCoursesSession(String session) throws InterruptedException {
			WebElement ListViewlink = driver.findElement(By.xpath("//div[@class='blog-info']//a[text()='View']"));
				//for(int j=0; j<ListViewlink.size();j++) {
			boolean ismatch=false;		
			Thread.sleep(5000);
			
			ListViewlink.click();
			Thread.sleep(5000);
			List<WebElement> SessionList=driver.findElements(By.xpath("//div[@class='card-header collapsed']//a[@class=\"card-title font-weight-bold\"]"));
					for(int k=0; k<SessionList.size();k++) {
							//System.out.println(SessionList.get(k).getText());
						//	System.out.println(session);
							if(session.equalsIgnoreCase(SessionList.get(k).getText())) {
								System.out.println("Courses are Matched");
								ismatch=true;
								break;
								}
						}
							if(!ismatch) {
								Assert.fail();
								}
						
							return new CoursesPage();
				}

	}

