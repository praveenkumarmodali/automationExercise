package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import abstractComponents.utils;
import testComponents.BaseTest;

public class StandAloneTest extends BaseTest {
	
	@Test
	public void registerUser() {
		utils utils = new utils(driver);
		
		
		// Assert that the Home page is Loaded
		utils.waitUntilElementLocated(By.cssSelector("[src*='logo']"));
		WebElement homePageLogo = driver.findElement(By.cssSelector("[src*='logo']"));
		Assert.assertTrue(homePageLogo.isDisplayed());
		
		//click on sign up/login button
		driver.findElement(By.cssSelector("[href*='login']")).click();
		
		//verify new user form is visible 
		WebElement signupForm = driver.findElement(By.cssSelector(".signup-form h2"));
		utils.waitUntilWebElementLocated(signupForm);
		Assert.assertTrue(signupForm.isDisplayed());
		
		//give name and email address
		WebElement name = driver.findElement(By.cssSelector("[name='name']"));
		WebElement email = driver.findElement(By.xpath("//div[@class='signup-form']//input[@name='email']"));
		WebElement signupBtn = driver.findElement(By.xpath("//button[text()='Signup']"));
		
		name.sendKeys("praveen");
		email.sendKeys("modalipraveen@gmail.com");
		signupBtn.click();
		
		
//		verify that Enter account information is visible 
		WebElement accountInformationText = driver.findElement(By.xpath("//b[text()='Enter Account Information']"));
		utils.waitUntilWebElementLocated(accountInformationText);
		Assert.assertTrue(accountInformationText.isDisplayed());
		
		//fill details
		By maleCheckbox = By.id("id_gender1");
		driver.findElement(maleCheckbox).click();
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("modalipraveen");
		
		WebElement daysDropdown = driver.findElement(By.id("days"));
		WebElement monthDropdown = driver.findElement(By.id("months"));
		WebElement yearDropdown = driver.findElement(By.id("years"));
		
		Select dayselect = new Select(daysDropdown);
		dayselect.selectByValue("28");
		
		Select monthselect = new Select(monthDropdown);
		monthselect.selectByValue("11");
		
		Select yearselect = new Select(yearDropdown);
		yearselect.selectByValue("2000");
		
//		select news letter and special offers
		driver.findElement(By.id("newsletter")).click();
		driver.findElement(By.id("optin")).click();
		
		System.out.println("quit");
		
		
	}


}
