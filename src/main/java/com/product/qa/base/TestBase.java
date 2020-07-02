 package com.product.qa.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;





public class TestBase 
{
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {

		try {
			// create an object reference for properties class.
			prop = new Properties();
			// By using fileInputStream we have to give Path of config.properties file
			// fileInputStream making a Streaming between your java code and
			// config.properties file.
			FileInputStream ip = new FileInputStream("src\\main\\java\\com\\product\\qa\\config\\config.properties");
			try {
				// Load all the properties which are available in config.properties file.
				prop.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	public String getScreenshotPath(String TestCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destPath=System.getProperty("User.dir")+"\\reports\\"+TestCaseName+".png";
		File file= new File(destPath);
		FileUtils.copyFile(source, file);
		return destPath;
		
	}
    
	public static void initialization() throws InterruptedException, AWTException {
		// by using getProperty we are using the value of 'browser' from
		// config.properties file.
		// and saving into String Variable 'browserName'.
		// we have to use exact name('browser') to pass which are mentioned in the
		// config file.

		String browserName = prop.getProperty("Browser");

		if (browserName.equalsIgnoreCase("chrome")) {
		
			
            //Headless testing 
			
			
			
			/*
			 * ChromeOptions options = new ChromeOptions();
			 * options.addArguments("headless").setHeadless(true);
			 * options.addArguments("window-size=1920x1080","--disable-gpu",
			 * "--ignore-certificate-errors", "--silent");
			 * options.addArguments("--disable-features=VizDisplayCompositor");
			 * 
			 * options.addArguments("--disable-dev-shm-usage");
			 * options.addArguments("--no-sandbox");
			 */
			
			
			System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
			// Create object for ChromeDriver

			driver = new ChromeDriver();

		} else if (browserName.equals("edge")) {
			// Set the path for EdgeDriver
			System.setProperty("webdriver.edge.driver",
					"C:\\Project\\Crm\\PortfolioCRMTest\\driver\\MicrosoftWebDriver.exe");
			// Create Object for EdgeDriver
			driver = new EdgeDriver();
		}

		

		// Maximize the window
		driver.manage().window().maximize();
		// Delete all Cookies
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	

}

}
