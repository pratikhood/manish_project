package com.product.qa.pages;

import java.awt.AWTException;
//import java.awt.Robot;
//import java.awt.event.KeyEvent;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

//import com.google.apphosting.utils.config.ApplicationXml.Modules.Web;
import com.product.qa.base.TestBase;


public class BlogPage extends TestBase{
	
	private static final Logger logger = LogManager.getLogger(BlogPage.class);
	
	
	@FindBy(xpath="//a[contains(text(),'Blog')]")
	WebElement BlogsLink;
	
	@FindBy(xpath="//h2[contains(text(),'Blogs')]")
	WebElement BlogsLabel;
	
	@FindBy(xpath="//a[contains(text(),'Future Opportunities in Android App Development')]")
	WebElement AndroidAppDevelopmentBlogs;
	
	@FindBy(xpath="//div[@class='blog-info']//div[@class='blog-info']//a[@class='blue-btn']")
	WebElement ReadMorebtn;
	
	@FindBy(xpath="//p[contains(text(),'Android Development')]")
	WebElement AndroidRelatedCourse;
	
	@FindBy(xpath = "//p[contains(text(),'Javascript')]")
	WebElement JavaScriptRelaterEvent;
	
	@FindBy(xpath="//a[contains(text(),'Android Development')]")
	WebElement AndroidDevelopmentTags;
	
	@FindBy(xpath="//textarea[@id='message']")
	WebElement Textbox;
	
	@FindBy(xpath="//button[@class='mt-4 btn btn-primary']")
	WebElement SubmitBtn;
	
	@FindBy(xpath="//a[contains(text(),'Read more comments')]")
	WebElement ReadMoreLink;
	
	@FindBy(xpath="//button[1][@id='edit']")
	WebElement EditBtn;
	
	@FindBy(xpath = "//p[text()='Please Edit Your Comment:']/following::textarea")
	WebElement commentTextBox;
	
	@FindBy(xpath = "//button[text()='Submit' and @class='btn btn-primary btn-space-right']")
	WebElement EditBoxSubmitBtn;
	
	@FindBy(xpath="//button[text()='Yes']")
    WebElement YesBtnDoyouWantToEdit;
	
	@FindBy(xpath="//button[text()='No']")
    WebElement NoBtnDoyouWantToEdit;
   
	@FindBy(xpath="//div[@class='_loading_overlay_wrapper css-79elbk']//button[2]")
	WebElement DeleteComment;
	@FindBy(xpath="//button[@class='btn-danger btn btn-secondary' and text()='Delete']")
	WebElement DoyouWantToDeleteYesBtn;
	
	@FindBy(xpath="//p[@class='comment-error']")
	WebElement AbuseWordsError;
	
	
	//Create Constructor for Initialize the webElements
			public BlogPage() {
				//Initializing WebElements
				PageFactory.initElements(driver,this);
			}
			
						
			public boolean verifyBlogsLabel() throws InterruptedException
			{
				//BlogsLink.click();
				WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Blog')]"));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();",element);
				Thread.sleep(2000);
				return BlogsLabel.isDisplayed();
			}
			
			public void verifyBlogOpenByLink() throws InterruptedException
			{
				//BlogsLink.click();
				WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Blog')]"));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();",element);
				logger.info("-----------Click on Blogs link-------------");
				
				Thread.sleep(4000);
				//AndroidAppDevelopmentBlogs.click();
				WebElement elementB = driver.findElement(By.xpath("//a[contains(text(),'Future Opportunities in Android App Development')]"));
				JavascriptExecutor executorB = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();",elementB);
				
				
				logger.info("-----------Android appdevelopment blog open-------------");
				Thread.sleep(3000);
				System.out.println("Blog open by link");
			}
			
			public void verifyReadMoreBtn() throws InterruptedException
			{
				//BlogsLink.click();
				WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Blog')]"));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();",element);
				logger.info("-----------Click on Blogs link-------------");
				
				Thread.sleep(2000);
				ReadMorebtn.click();
				logger.info("-----------Click on Read More button-------------");
				Thread.sleep(3000);
				System.out.println("Blogs open by read more button");
			}
			public void verifyRelatedCourseOpen() throws InterruptedException, AWTException
			{
				
				//BlogsLink.click();
				WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Blog')]"));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();",element);
				logger.info("-----------Click on Blogs link-------------");
				Thread.sleep(10000);
				AndroidAppDevelopmentBlogs.click();
				logger.info("-----------Open the blog button-------------");
				Thread.sleep(10000);
				AndroidRelatedCourse.click();
				logger.info("-----------Click on Android related course-------------");
				Thread.sleep(10000);
				System.out.println("Related course open");
				
			}
			public void verifyRelatedEventsOpen() throws InterruptedException
			{
				//BlogsLink.click();
				WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Blog')]"));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();",element);
				logger.info("-----------Click on Blogs link-------------");
				Thread.sleep(10000);
				AndroidAppDevelopmentBlogs.click();
				logger.info("-----------open the Blog button-------------");
				Thread.sleep(10000);
				JavascriptExecutor js= (JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();", JavaScriptRelaterEvent);
				logger.info("-----------Related Event open-------------");
				Thread.sleep(10000);
				System.out.println("Related Event open");
				
			}
			public void verifyTagsOpen() throws InterruptedException
			{
				//BlogsLink.click();
				WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Blog')]"));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();",element);
				logger.info("-----------Click on Blogs link-------------");
				Thread.sleep(10000);
				//AndroidAppDevelopmentBlogs.click();
				WebElement elementB = driver.findElement(By.xpath("//a[contains(text(),'Future Opportunities in Android App Development')]"));
				JavascriptExecutor executorB = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();",elementB);
				//AndroidAppDevelopmentBlogs.click();
				logger.info("-----------Click on Read More-------------");
				Thread.sleep(10000);
				JavascriptExecutor js= (JavascriptExecutor)driver;
				js.executeScript("arguments[0].scrollIntoView();", AndroidDevelopmentTags);
				Thread.sleep(4000);
				//AndroidDevelopmentTags.click();
				WebElement element1 = driver.findElement(By.xpath("//a[contains(text(),'Android Development')]"));
				JavascriptExecutor executor1= (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();",element1);
				logger.info("-----------Click on Android development tag-------------");
				Thread.sleep(10000);
				System.out.println(" Android appdevelopment tag open");
			}
			
			public void verifyAddingComment() throws InterruptedException
			{
				//BlogsLink.click();
				WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Blog')]"));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();",element);
				logger.info("-----------Click on the Blogs link-------------");
				Thread.sleep(5000);
				//AndroidAppDevelopmentBlogs.click();
				WebElement elementB = driver.findElement(By.xpath("//a[contains(text(),'Future Opportunities in Android App Development')]"));
				JavascriptExecutor executorB = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();",elementB);
				//AndroidAppDevelopmentBlogs.click();
				logger.info("-----------open the blog -------------");
				Thread.sleep(3000);
				Textbox.sendKeys("Test11");
				logger.info("-----------Enter Text in comment box-------------");
				Thread.sleep(2000);
				SubmitBtn.click();
				logger.info("-----------Click on the subit button-------------");
				Thread.sleep(2000);
				System.out.println("New Comment added");
			}
			public void verifyEditComment() throws InterruptedException
			{
				//BlogsLink.click();
				WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Blog')]"));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();",element);
				logger.info("-----------Click on the Blogs link-------------");
				
				Thread.sleep(5000);
				//AndroidAppDevelopmentBlogs.click();
				WebElement elementB = driver.findElement(By.xpath("//a[contains(text(),'Future Opportunities in Android App Development')]"));
				JavascriptExecutor executorB = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();",elementB);
				//AndroidAppDevelopmentBlogs.click();
				logger.info("-----------Open the blog-------------");
				Thread.sleep(5000);
				JavascriptExecutor js= (JavascriptExecutor)driver;
				//js.executeScript("window.scrollBy(0,1000)");
				js.executeScript("arguments[0].click();", EditBtn);
				logger.info("-----------Click on Edit comment button-------------");
				
				//WebElement element = driver.findElement(By.xpath("//button[@id='edit'][1]")); 
				//Actions actions = new Actions(driver);
				//actions.moveToElement(element).click().perform();
	            //EditBtn.click();
				Thread.sleep(5000);
				commentTextBox.sendKeys("Edited Text");
				logger.info("-----------Enter Edited text-------------");
				Thread.sleep(5000);
				EditBoxSubmitBtn.click();
				logger.info("-----------Enter Edited text-------------");
				Thread.sleep(5000);
				YesBtnDoyouWantToEdit.click();
				System.out.println("Comment Edited");
			}
			
			public void verifyDeletComment() throws InterruptedException
			{
				//BlogsLink.click();
				WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Blog')]"));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();",element);
				logger.info("-----------Click on Blogs link-------------");
				
				Thread.sleep(5000);
				ReadMorebtn.click();
				logger.info("-----------Click on Read more button-------------");
				Thread.sleep(5000);
				JavascriptExecutor js= (JavascriptExecutor)driver;
				//js.executeScript("window.scrollBy(0,1000)");
				js.executeScript("arguments[0].click();", DeleteComment);
				logger.info("-----------Click on delete comment-------------");
				
				//WebElement element = driver.findElement(By.xpath("//button[@id='edit'][1]")); 
				//Actions actions = new Actions(driver);
				//actions.moveToElement(element).click().perform();
	            //EditBtn.click();
				
				Thread.sleep(5000);
				DoyouWantToDeleteYesBtn.click();
				logger.info("-----------Click on yes button-------------");
				System.out.println("Comment Deleted");

				
			}
			
			public void verifyAbuseWords() throws InterruptedException
			{
				
				//BlogsLink.click();
				WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Blog')]"));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();",element);
				logger.info("-----------Click on Blogs link-------------");
				Thread.sleep(5000);
				//AndroidAppDevelopmentBlogs.click();
				WebElement elementB = driver.findElement(By.xpath("//a[contains(text(),'Future Opportunities in Android App Development')]"));
				JavascriptExecutor executorB = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();",elementB);
				//AndroidAppDevelopmentBlogs.click();
				logger.info("-----------Open the Blog-------------");
				Thread.sleep(3000);
				Textbox.sendKeys("Fuck");
				logger.info("-----------send abusing words in text box-------------");
				Thread.sleep(2000);
				SubmitBtn.click();
				logger.info("-----------click on the submit button-------------");
				Thread.sleep(2000);
				String s1=AbuseWordsError.getText();
				Assert.assertEquals(s1,"Your comment contains abusive words please remove them to proceed");
				logger.info("-----------compare the warning message-------------");
				Thread.sleep(2000);
				System.out.println("Waring message displayed");
				
			}
			

}
