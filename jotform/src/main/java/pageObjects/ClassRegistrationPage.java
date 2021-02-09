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


public class ClassRegistrationPage
{
	//Properties prop;
	public WebDriver driver;

	public ClassRegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}



	@FindBy(xpath = "//select[@name='q3_gender']")
	WebElement genderDropDown;

	@FindBy(xpath = "//input[@id='first_4']")
	WebElement firstName;

	@FindBy(xpath = "//input[@id='middle_4']")
	WebElement middleName;

	@FindBy(xpath = "//input[@id='last_4']")
	WebElement lastName;

	@FindBy(xpath = "//*[@name='q6_studentEmail']")
	WebElement studentEmail;

	@FindBy(xpath = "//*[@name='q5_studentId']")
	WebElement studentID;

	@FindBy(xpath = "//select[@name='q7_listOf7']")
	WebElement listOfClass;

	@FindBy(xpath = "//button[@id='input_2']")
	WebElement registerClassBtn;



	public void selectGender(String gender) {

		Select drop = new Select(genderDropDown);
		drop.selectByVisibleText(gender);
	}


	public void enterFirstName(String fname) {


		firstName.sendKeys(fname);
	}

	public void enterMiddleName(String mname) {


		middleName.sendKeys(mname);
	}

	public void enterLastName(String lname) {


		lastName.sendKeys(lname);
	}


	public boolean verifyFristNameElementPresent()
	{
		return firstName.isDisplayed();

	}

	public boolean verifyLastNameElementPresent()
	{
		return lastName.isDisplayed();

	}

	public boolean verifyMiddleNameElementPresent()
	{
		return middleName.isDisplayed();

	}

	public boolean verifyStudentEmailPresent()
	{
		return studentEmail.isDisplayed();

	}

	public void enterStudentEmailid(String Emailid) {


		studentEmail.sendKeys(Emailid);
	}

	public void enterStudentid(String studntID) {


		studentID.sendKeys(studntID);
	}

	public boolean verifyListOfClassavailable() {

		Select drop = new Select(listOfClass);
		List<WebElement> options = drop.getOptions();
		boolean a = false;
		for(WebElement we:options)  
		{ 
			if(we.getText( ).contains("Math 101"))
			{
				a = true;
				break;

			}
			else
			{
				a= false;
			}
		}

		return a;
	}


	public void selectListOfClassavailable() {

		Select drop = new Select(listOfClass);
		drop.selectByVisibleText("Math 101");

	}
	
	public void clickRegisterClassBtn() {

		registerClassBtn.click();

	}


}
