package com.product.qa.pages;


//import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.product.qa.base.TestBase;



 public class DashboardPage extends TestBase
 {
	 
	 private static final Logger logger = LogManager.getLogger(DashboardPage.class);

	@FindBy(xpath="//a[@class='nav-link active active']")
	@CacheLookup
	WebElement DashboardLink;
	
	@FindBy(xpath="//div[@class='row']//div[2]//div[1]//div[2]//div[1]//a[1]")
	WebElement ResumeBtn;
	
	@FindBy(xpath= "//h2[contains(text(),'Learning Paths')]")
	WebElement LearningPathLabel;
	
	@FindBy(xpath="//h2[contains(text(),'Upcoming Events')]")
	WebElement upcomingEventsLabels;
	
	
	@FindBy(xpath="//a[contains(text(),'Javascript')]")
	WebElement JavaScripteventsName;
	
	@FindBy(xpath="//section[4]//div[1]//div[3]//div[1]//a[1]")
	WebElement EventsViewAllBtn;
	
	@FindBy(xpath="//h2[contains(text(),'Latest Blogs')]")
	WebElement LatestblogsLabel;
	
	@FindBy(xpath="//a[contains(text(),'Future Opportunities in Android App De...')]")
	WebElement AndroidAppBlogs;
	
	@FindBy(xpath="//section[@class='latest-blogs']//a[@class='blue-btn w-100']")
	WebElement BlogsViewAllBtn;
	
	@FindBy(xpath="//a[@class='latst-add-block latest-courses']//h2")
	WebElement coursesCount;
	
	@FindBy(xpath="//a[@class='latst-add-block new-blogs animated']//h2")
	WebElement BlogsCount;
	
	@FindBy(xpath="//a[@class='latst-add-block new-events animated']//h2")
	WebElement eventCount;
	
	@FindBy(xpath = "//li[@class='nav-item linkmenu']//a[text()='Courses']")
	@CacheLookup
	WebElement CoursesLink;
	
	@FindBy(xpath="//a[@class='nav-link'][contains(text(),'Events')]")
	WebElement EventsTab;
	
	@FindBy(xpath="//a[contains(text(),'Blog')]")
	WebElement BlogsLink;
	
	
	//Create Constructor for Initialize the webElements
	public DashboardPage() {
		//Initializing WebElements 
		PageFactory.initElements(driver,this);
	}
	
	
	public void verifyCoursesCount() throws InterruptedException
	{
		
	int totalCourseCount = 0;
	// Counting course on dashboard
		Thread.sleep(3000);
		WebElement DashboardCourse= driver.findElement(By.xpath("//a[@class='latst-add-block latest-courses']//h2"));
		String actual=DashboardCourse.getText();
		int DashboardCourseCount= Integer.parseInt(actual);
		System.out.println("Courses count on dashboard=" + DashboardCourseCount);
		logger.info("---------Count the course on dashboard-------------");
		
	//Counting course on courses page
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Courses')]"));        //li[@class='nav-item linkmenu']//a[text()='Courses']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",element);
		logger.info("---------click on Courses Page-------------");
		
		
		while(totalCourseCount < DashboardCourseCount)
		{
			if(totalCourseCount != 0)
			{
				// fetch for first page
				WebElement element1 = driver.findElement(By.xpath("//a[@class='prev  page-link']/i[@class='fas fa-angle-right']"));
				JavascriptExecutor executor1 = (JavascriptExecutor)driver;
				executor1.executeScript("arguments[0].click();",element1);
			//	driver.findElement(By.xpath("//a[@class='prev  page-link']/i[@class='fas fa-angle-right']")).click();
								
			}
			Thread.sleep(3000);
			List<WebElement> CourseCount1= driver.findElements(By.xpath("//a[@class='blue-btn']"));
			// System.out.println(CourseCount1.size());
						
			totalCourseCount=totalCourseCount+ CourseCount1.size();
			logger.info("---------Count the total courses on courses Page-------------");
		}
		System.out.println("Courses available on course page =" + totalCourseCount);
		Assert.assertEquals(DashboardCourseCount,totalCourseCount);
		logger.info("---------Match the courses cout with the dashboard count-------------");
		
	}	
		
		
	public void verifyBlogsCount() throws InterruptedException
	{
		int totalBlogCount=0;
	// Counting blogs on dashboard
		Thread.sleep(3000);
		WebElement DashboardCount= driver.findElement(By.xpath("//a[@class='latst-add-block new-blogs animated']//h2"));
		String actual1=DashboardCount.getText();
		int DashboardBlogCount= Integer.parseInt(actual1);
		System.out.println("Blogs count on dashboard=" + DashboardBlogCount);
		logger.info("---------Count the Blogs Count on the Dashboard page-------------");
		
	//Counting blogs on blogs page
		//BlogsLink.click();
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Blog')]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",element);
		logger.info("---------click on the Blogs Page-------------");
		while(totalBlogCount < DashboardBlogCount)
		{
			if(totalBlogCount != 0)
			{
				// fetch for first page
				WebElement element1 = driver.findElement(By.xpath("//a[@class='prev  page-link']/i[@class='fas fa-angle-right']"));
				JavascriptExecutor executor1 = (JavascriptExecutor)driver;
				executor1.executeScript("arguments[0].click();",element1);
			//	driver.findElement(By.xpath("//a[@class='prev  page-link']/i[@class='fas fa-angle-right']")).click();
								
			}
			Thread.sleep(3000);
			List<WebElement> BlogCount1= driver.findElements(By.xpath("//a[@class='blue-btn']"));
			// System.out.println(BlogCount1.size());
						
			totalBlogCount=totalBlogCount+ BlogCount1.size();
			logger.info("---------Count the blogs on the Blogs Page-------------");
		}
		System.out.println("Courses available on course page =" + totalBlogCount);
		Assert.assertEquals(DashboardBlogCount,totalBlogCount);
		logger.info("---------Match the blogs count with dashboard count-------------");
		
	}
	
	public void verifyEventsCount() throws InterruptedException
	{
		int totalEventCount=0;
	// Counting events on dashboard
		Thread.sleep(3000);
		WebElement Dashboardcount= driver.findElement(By.xpath("//a[@class='latst-add-block new-events animated']//h2"));
		String actual=Dashboardcount.getText();
		int DashboardEventCount= Integer.parseInt(actual);
		System.out.println("Events count on dashboard=" + DashboardEventCount);
		logger.info("---------Count the events on the dashboard-------------");
		
	//Counting events on events page
		//EventsTab.click();
		WebElement element = driver.findElement(By.xpath("//a[@class='nav-link'][contains(text(),'Events')]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",element);
		logger.info("---------click on the Events page-------------");
		while(totalEventCount < DashboardEventCount)
		{
			if(totalEventCount != 0)
			{
				// fetch for first page
				WebElement element1 = driver.findElement(By.xpath("//a[@class='prev  page-link']/i[@class='fas fa-angle-right']"));
				JavascriptExecutor executor1 = (JavascriptExecutor)driver;
				executor1.executeScript("arguments[0].click();",element1);
			//	driver.findElement(By.xpath("//a[@class='prev  page-link']/i[@class='fas fa-angle-right']")).click();
								
			}
			Thread.sleep(3000);
			List<WebElement> EventCount1= driver.findElements(By.xpath("//a[@class='blue-btn']"));
			// System.out.println(EventCount1.size());
						
			totalEventCount=totalEventCount+ EventCount1.size();
			logger.info("---------Count the events on the events page-------------");
		}
		System.out.println("Courses available on course page =" + totalEventCount);
		Assert.assertEquals(DashboardEventCount,totalEventCount);
		logger.info("---------Match the count of events with the dashboard count-------------");
	}
	
	public boolean verifyLearningPathLabel()
	{
		return LearningPathLabel.isDisplayed();
		
	
	}

//Verifying the resume button
	
	public void verifyResumeCourse() throws InterruptedException
	{
		ResumeBtn.click();
		logger.info("-----------Click on the resume button-------------");
		Thread.sleep(3000);
		driver.getPageSource().contains("Course Content");
		logger.info("-----------Resume button work properly-------------");
		System.out.println("Resume button work properly");
	}

	public boolean verifyUpcomingEventlabel()
	{
		return upcomingEventsLabels.isDisplayed();
		
	}
	
//Verify single javascript event open	
	public void verifyEventOpen() throws InterruptedException
	{
		
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Javascript')]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",element);
		logger.info("---------click on java script event-------------");
		Thread.sleep(9000);
		
		System.out.println("Event is open");
		
	}
	
//verify all events open through view all button
	public void verifyEventViewAllBtn() throws InterruptedException
	{
		WebElement element = driver.findElement(By.xpath("//section[4]//div[1]//div[3]//div[1]//a[1]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",element);
		logger.info("---------click on Event View All button-------------");
		Thread.sleep(9000);
		System.out.println("View All events button working fine");
	}
	
	public boolean verifyLettestBlogsLabel()
	{
		return LatestblogsLabel.isDisplayed();
	}
	
// verify a single blog open
	public void verifyBlogOpen() throws InterruptedException
	{
		Thread.sleep(6000);
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Future Opportunities in Android App De...')]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",element);
		logger.info("---------click on Android app developenemt blog -------------");
		Thread.sleep(9000);
		System.out.println("Blogs is open");
	}
	
//verify all blogs open through view all button
	public void verifyBlogsViewAllBtn() throws InterruptedException
	{
		WebElement element = driver.findElement(By.xpath("//section[@class='latest-blogs']//a[@class='blue-btn w-100']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",element);
		logger.info("---------click on Blogs View all button -------------");
		Thread.sleep(9000);
		System.out.println("View All blogs button working fine");
	}
	
	
	
}
