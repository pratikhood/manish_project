package com.product.qa.testcases;

import java.awt.AWTException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.product.qa.base.TestBase;
import com.product.qa.pages.BlogPage;
import com.product.qa.pages.HomePage;
import com.product.qa.pages.LoginPage;
import com.product.qa.pages.MyEvents;

public class BlogsPageTest extends TestBase 
{
	
	LoginPage login;
	BlogPage blog;
	HomePage homepage;
	
	@BeforeMethod
	public void setUp() throws InterruptedException, AWTException {
	
		initialization();
		login=new LoginPage();
		homepage= new HomePage();
		blog= new BlogPage();
		homepage=login.login();
		Thread.sleep(14000);
	}
	
	
	@Test(priority = 1,enabled = true)
    public void verifyBlogLabelTest() throws InterruptedException
    {
     blog.verifyBlogsLabel();	
    }
	
	@Test(priority = 2,enabled = true)
    public void verifyBlogopenByLinkTest() throws InterruptedException
    {
     blog.verifyBlogOpenByLink();	
    }
	@Test(priority = 3,enabled = true)
    public void verifyReadMoreBtnTest() throws InterruptedException
    {
    	blog.verifyReadMoreBtn();
    }
	@Test(priority = 4,enabled = false)//related course removed from demo website
    public void relatedCourseOpenTest() throws InterruptedException, AWTException
    {
    	blog.verifyRelatedCourseOpen();
    }
	@Test(priority = 5,enabled = false)//related course event from demo website
    public void relatedEventsOpenTest() throws InterruptedException
    {
    	blog.verifyRelatedEventsOpen();
    }
	@Test(priority = 6,enabled = true)
    public void relatedTagsOpenTest() throws InterruptedException
    {
    	blog.verifyTagsOpen();
    }
	@Test(priority = 7,enabled = true)
	public void addingCommentTest() throws InterruptedException
	{
		blog.verifyAddingComment();
	}
	@Test(priority = 8,enabled = true)
	public void EditCommentTest() throws InterruptedException
	{
		blog.verifyEditComment();
	}
	@Test(priority = 9,enabled = true)
	public void deleteCommentTest() throws InterruptedException
	{
	  blog.verifyDeletComment();
		
	}
	
	@Test(priority = 10,enabled = true)
	public void AbusingWordTest() throws InterruptedException
	{
		blog.verifyAbuseWords();	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
}
	
}
