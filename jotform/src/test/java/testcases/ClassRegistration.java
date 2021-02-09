package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.ClassRegistrationPage;
import pageObjects.SubmissionConfirmationPage;

public class ClassRegistration {
	
   	public WebDriver driver;
    ClassRegistrationPage cr;
    SubmissionConfirmationPage sc;
   	Properties prop;
	
	@BeforeMethod
	public void setupTest() throws IOException {
		
		
		FileInputStream fis = new FileInputStream("C:/Abdul/New Workspace2/jotform/config.properties");
		prop = new Properties();
		prop.load(fis);
		System.setProperty("webdriver.chrome.driver", prop.getProperty("driverpath"));
		driver=new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		cr = new ClassRegistrationPage(driver);
		sc = new SubmissionConfirmationPage(driver);
	}
	
	
	
	@Test(priority =1)
	public void classRegistration() throws IOException {
		
		
		cr.selectGender(prop.getProperty("gender"));
		Assert.assertTrue(cr.verifyFristNameElementPresent(), "First Name field is found");
		if (cr.verifyFristNameElementPresent()==true)
		{
			Assert.assertTrue(true);
			System.out.println("First Name field  found");
		}
		
		
		if (cr.verifyMiddleNameElementPresent()==true)
		{
			Assert.assertTrue(true);
			System.out.println("Middle Name field  found");
		}
		
		
		if (cr.verifyLastNameElementPresent()==true)
		{
			
			Assert.assertTrue(true);
			System.out.println("Last Name field  found");
		}
		
		cr.enterFirstName(prop.getProperty("firstname"));
		cr.enterMiddleName(prop.getProperty("middlename"));
		cr.enterLastName(prop.getProperty("lastname"));
		
		if (cr.verifyStudentEmailPresent()==true)
		{
			
			Assert.assertTrue(true);
			System.out.println("Student Email field  found");
		}
		
		
		cr.enterStudentEmailid(prop.getProperty("studentemail"));
		cr.enterStudentid(prop.getProperty("studentid"));
				
		if(cr.verifyListOfClassavailable()==true)
		{
			Assert.assertTrue(true);
			System.out.println("Drop down has value Math 101");
		}
		
		 
		cr.selectListOfClassavailable();
		cr.clickRegisterClassBtn();
		
	   if(sc.verifyThankYouMsg()==true)
	   {
		   Assert.assertTrue(true);
			System.out.println("Thank You message is displayed");
		}
		
	   
	}
	
	
	@AfterMethod
	public void teardown() {
			
		driver.quit();
	}

}
