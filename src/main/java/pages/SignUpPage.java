package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import abstractComponents.utils;

public class SignUpPage extends utils {
	
	WebDriver driver;
	
	public SignUpPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//	assert hope page is loaded
	By logo = By.cssSelector("[src*='logo']");
	
	@FindBy(css="[src*='logo']")
	WebElement hopePageLogo;
	
	@FindBy(css=".signup-form h2")
	WebElement signupForm;
	
	@FindBy(css="[name='name']")
	WebElement nameInput;
	
	@FindBy(xpath="//div[@class='signup-form']//input[@name='email']")
	WebElement emailInput;
	
	@FindBy(xpath="//button[text()='Signup']")
	WebElement signUpBtn;
	
	public void verifyHomePageLoaded() {
		waitUntilElementLocated(logo);
		Assert.assertTrue(hopePageLogo.isDisplayed());
	}
	
	public void verifyNewUserFormVisible() {
		waitUntilWebElementLocated(signupForm);
		Assert.assertTrue(signupForm.isDisplayed());
	}
	
	public void enter_Name_and_Email(String name, String email) {
		nameInput.sendKeys(name);
		emailInput.sendKeys(email);
		signUpBtn.click();
	}

}
