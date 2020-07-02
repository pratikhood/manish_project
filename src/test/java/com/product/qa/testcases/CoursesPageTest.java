	
package com.product.qa.testcases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.product.qa.base.TestBase;
import com.product.qa.pages.CoursesPage;
import com.product.qa.pages.HomePage;
import com.product.qa.pages.LoginPage;
import com.product.qa.util.TestUtil;

public class CoursesPageTest extends TestBase {

	CoursesPage coursespage;
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	String sheetName2="Courses";
	public CoursesPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException, AWTException{
		initialization();
		coursespage=new CoursesPage();
		loginpage=new LoginPage();
		homepage=loginpage.login();
		testutil=new TestUtil();
		coursespage=homepage.ClickOnCoursesLink();
	}
	
	@Test(priority=2,enabled=false)
	public void VerifyCoursesPageLabelTest() {
		Assert.assertTrue(coursespage.VerifyCoursesLabel());
	}
	
	@Test(priority=1, enabled=false)
	public void VerifyCoursesPageFilterLinksTest() throws InterruptedException {
		coursespage.ValidateFilterLinks();
	}	
	
	
	@DataProvider
	public Object[][] getTestData2() {
		Object data[][]=TestUtil.getTestData(sheetName2);
		return data;
	}
	
	@Test(priority=3,enabled=true, dataProvider="getTestData2")
	public void VerifyCoursesSessionTest(String session) throws InterruptedException {
		coursespage.VerifyCoursesSession(session);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
}
}
