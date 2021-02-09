package pageObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SubmissionConfirmationPage
{
	//Properties prop;
	public WebDriver driver;
	
	public SubmissionConfirmationPage(WebDriver driver) {
		this.driver = driver;
		 PageFactory.initElements(driver, this);
		 }
	
	
		
	
	@FindBy(xpath = "//*[contains(text(),'Thank You!')]")
	 WebElement thankYouMsg;
	
	public boolean verifyThankYouMsg() 
	{
		return thankYouMsg.isDisplayed();
	}
 

}
