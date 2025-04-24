package tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import abstractComponents.utils;
import pages.SignUpPage;
import testComponents.BaseTest;

public class StandAloneTest extends BaseTest {
	
	@Test(dataProvider="signUpDataProvider")
	public void registerUser(HashMap<String,String> input) {
		utils utils = new utils(driver);
		
		// Assert that the Home page is Loaded
		SignUpPage signupPage = new SignUpPage(driver);
		signupPage.verifyHomePageLoaded();

		//click on sign up/login button
		signupPage.goToSignUp();
		
		//verify new user form is visible 
		signupPage.verifyNewUserFormVisible();
		
		//give name and email address
		
		signupPage.enter_Name_and_Email(input.get("name"), input.get("email"));
		
//		verify that Enter account information is visible 
		signupPage.verifyAccountInformation();
		
		//fill details
		signupPage.fillAccountDetails(input.get("password"), 
				input.get("date"), input.get("month"), input.get("year")); //password, date, month , year
		
		
//		select news letter and special offers
		driver.findElement(By.id("newsletter")).click();
		driver.findElement(By.id("optin")).click();
		
//		fill additional details 
		driver.findElement(By.id("first_name")).sendKeys("Praveen");
		driver.findElement(By.id("last_name")).sendKeys("kumar");
		driver.findElement(By.id("company")).sendKeys("mecitlabs");
		driver.findElement(By.id("address1")).sendKeys("Hyd");
		driver.findElement(By.id("address2")).sendKeys("Gudimalkapur");
		WebElement countryDropdown = driver.findElement(By.id("country"));
		Select countrySelect = new Select(countryDropdown);
		countrySelect.selectByValue("India");
		driver.findElement(By.id("state")).sendKeys("Telangana");
		driver.findElement(By.id("city")).sendKeys("Hyderabad");
		driver.findElement(By.id("zipcode")).sendKeys("500028");
		driver.findElement(By.id("mobile_number")).sendKeys("12345678");
		
//		click on create account
		driver.findElement(By.xpath("//button[text()='Create Account']")).click();
		
		//verify account created
		String accountCreatedText = driver.findElement(By.xpath("//b[text()='Account Created!']")).getText();
		Assert.assertEquals(accountCreatedText, "ACCOUNT CREATED!");
		
		//click on continue 
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
		
//		verify the logged in user
		WebElement loggedInUserText = driver.findElement(By.xpath("//a[text()=' Logged in as ']"));
		utils.waitUntilWebElementLocated(loggedInUserText);
		Assert.assertTrue(loggedInUserText.isDisplayed());
		
//		click on delete account
		driver.findElement(By.cssSelector("[href*='delete_account']")).click();
		
//		verify account delete text
		WebElement deleteAccountText = driver.findElement(By.xpath("//b[text()='Account Deleted!']"));
		utils.waitUntilWebElementLocated(deleteAccountText);
		Assert.assertTrue(deleteAccountText.isDisplayed());
		
//		click on continue button
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
		
	}
	
	@DataProvider
	public Object[] signUpDataProvider() throws IOException {
		String path = "/Users/praveenkumar/eclipse-workspace7/"
				+ "Automation/src/test/java/resources/globalproperties.properties";
		Properties props = new Properties();
		FileInputStream fs = new FileInputStream(path);
		props.load(fs);
		
		String email = "modalikumar" + System.currentTimeMillis()+ "@gmail.com";
		
		HashMap<String, String> map1 = new HashMap<>();
		map1.put("name", "praveen");
		map1.put("email", email);
		map1.put("password", props.getProperty("password"));
		map1.put("date", "28");
		map1.put("month", "11");
		map1.put("year", "2000");
		
		return new Object[] {map1};
	}


}
