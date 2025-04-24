package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
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
	By maleCheckbox = By.id("id_gender1");
	
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
	
	@FindBy(xpath="//b[text()='Enter Account Information']")
	WebElement accountInformationText;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="days")
	WebElement daysDropdown;
	
	@FindBy(id="months")
	WebElement monthDropdown;
	
	@FindBy(id="years")
	WebElement yearDropdown;
	
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
	
	public void verifyAccountInformation() {
		waitUntilWebElementLocated(accountInformationText);
		Assert.assertTrue(accountInformationText.isDisplayed());
	}
	
	public void fillAccountDetails(String passwordvalue , String day, String month, String year) {
		driver.findElement(maleCheckbox).click();
		
		password.sendKeys(passwordvalue);

		Select dayselect = new Select(daysDropdown);
		dayselect.selectByValue(day);
		
		Select monthselect = new Select(monthDropdown);
		monthselect.selectByValue(month);
		
		Select yearselect = new Select(yearDropdown);
		yearselect.selectByValue(year);
	}

}
