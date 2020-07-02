package com.product.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.product.qa.base.TestBase;

public class TestUtil extends TestBase {


	public static long PAGE_LOAD_TIMEOUT = 40;
	public static long IMPICIT_WAIT = 15; 
	static String test_Data="src\\main\\java\\com\\product\\qa\\testdata\\TestData2.xlsx";
	static Workbook book;
	static Sheet sheet;
	//static Workbook book1;
	//static Sheet sheet1;
		
	public void windowHandle(WebDriver driver) {

        String subWindowHandler = null;
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()) {
            subWindowHandler = iterator.next();
            driver.switchTo().window(subWindowHandler);
        }
        }
        
       public static Object[][] getTestData(String sheetName)  {
    		FileInputStream file = null;
    		try {
    			file = new FileInputStream(test_Data);
    		} catch (FileNotFoundException e) {
    			e.printStackTrace();
    		}
    		try {
    			book = WorkbookFactory.create(file);
    		} catch (InvalidFormatException e) {
    			e.printStackTrace();
    		} catch (IOException e) {
    			e.printStackTrace();
    		} 
    		sheet = book.getSheet(sheetName);
    		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
    		// System.out.println(sheet.getLastRowNum() + "--------" +
    		 //sheet.getRow(0).getLastCellNum());
    		for (int i = 0; i < sheet.getLastRowNum(); i++) {
    			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
    				if(null == sheet.getRow(i + 1).getCell(k))
    				{
    					data[i][k]="";
    				}
    				else
    				{
    					data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
    					// System.out.println(data[i][k]);
    				}
    				
    			}
    			
    		}
    		
    		return data;
    	}

       
       public static Object[][] getTestData1(String sheetName)  {
   		FileInputStream file = null;
   		try {
   			file = new FileInputStream(test_Data);
   		} catch (FileNotFoundException e) {
   			e.printStackTrace();
   		}
   		try {
   			book = WorkbookFactory.create(file);
   		} catch (InvalidFormatException e) {
   			e.printStackTrace();
   		} catch (IOException e) {
   			e.printStackTrace();
   		} 
   		sheet = book.getSheet(sheetName);
   		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
   		// System.out.println(sheet.getLastRowNum() + "--------" +
   		 //sheet.getRow(0).getLastCellNum());
   		for (int i = 0; i < sheet.getLastRowNum(); i++) {
   			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
   				if(null == sheet.getRow(i + 1).getCell(k))
   				{
   					data[i][k]="";
   				}
   				else
   				{
   					data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
   					// System.out.println(data[i][k]);
   				}
   				
   			}
   			
   		}
   		
   		return data;
   	}
       
       /*public static Object[] getTestData1(String sheetName) {
    	   FileInputStream file = null;
   		try {
   			file = new FileInputStream(test_Data);
   		} catch (FileNotFoundException e){
   			e.printStackTrace();
   			
   		}
   		try {
   			book1 = WorkbookFactory.create(file);
   		} catch (InvalidFormatException e) {
   			e.printStackTrace();
   		} catch (IOException e) {
   			e.printStackTrace();
   		} 
   		sheet1 = book1.getSheet(sheetName);
   		Object[] data = new Object[sheet1.getLastRowNum()];//[sheet.getRow(0).getLastCellNum()];
   		// System.out.println(sheet.getLastRowNum() + "--------" +
   		 //sheet.getRow(0).getLastCellNum());
   		for (int i = 0; i < sheet1.getLastRowNum(); i++) {
   			//for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
   				if(null == sheet1.getRow(i + 1))//.getCell(k))
   				{
   					data[i]="";
   				}
   				else
   				{
   					data[i] = sheet1.getRow(i + 1).toString();
   					// System.out.println(data[i][k]);
   				}
   				
   			
   			
   		}
   		return data;
   	
       }*/
       
       
	public static void takeScreenshotAtEndOfTest()throws IOException {
		// TODO Auto-generated method stub
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	
	public void SendEmailWithAttachment() {
		// Create object of Property file
		//Properties props = new Properties();
 
		// this will set host of server- you can change based on your requirement 
		prop.put("mail.smtp.host", "smtp.gmail.com");
 
		// set the port of socket factory 
		prop.put("mail.smtp.socketFactory.port", "465");
 
		// set socket factory
		prop.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
 
		// set the authentication to true
		prop.put("mail.smtp.auth", "true");
 
		// set the port of SMTP server
		prop.put("mail.smtp.port", "465");
 
		// This will handle the complete authentication
		Session session = Session.getDefaultInstance(prop,
 
				new javax.mail.Authenticator() {
 
					protected PasswordAuthentication getPasswordAuthentication() {
 
					return new PasswordAuthentication("chauhan.rishi515@gmail.com", "renukarajesh");
 
					}
 
				});
 
		try {
 
			// Create object of MimeMessage class
			Message message = new MimeMessage(session);
 
			// Set the from address
			message.setFrom(new InternetAddress("chauhan.rishi515@gmail.com"));
 
			// Set the recipient address
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("rchauhan@mindzcloud.com"));
            
                        // Add the subject link
			message.setSubject("Extent Report for TestCases");
 
			// Create object to add multimedia type content
			BodyPart messageBodyPart1 = new MimeBodyPart();
 
			// Set the body of email
			messageBodyPart1.setText("Hi All,");
 
			// Create another object to add another content
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
 
			// Mention the file which you want to send
			String filename = "test-output/Extent.html";
 
			// Create data source and pass the filename
			DataSource source = new FileDataSource(filename);
 
			// set the handler
			messageBodyPart2.setDataHandler(new DataHandler(source));
 
			// set the file
			messageBodyPart2.setFileName(filename);
 
			// Create object of MimeMultipart class
			Multipart multipart = new MimeMultipart();
 
			// add body part 1
			multipart.addBodyPart(messageBodyPart2);
 
			// add body part 2
			multipart.addBodyPart(messageBodyPart1);
 
			// set the content
			message.setContent(multipart);
 
			// finally send the email
			Transport.send(message);
 
			System.out.println("=====Email Sent=====");
 
		} catch (MessagingException e) {
 
			throw new RuntimeException(e);
 
		}
 

	}
}
