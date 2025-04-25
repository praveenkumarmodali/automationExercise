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
	By newsLetter = By.id("newsletter");
	By specialOffer = By.id("optin");
	By firstName = By.id("first_name");
	By lastName = By.id("last_name");
	By company = By.id("company");
	By add1= By.id("address1");
	By add2 = By.id("address2");
	
	
	
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
	
	@FindBy(id="country")
	WebElement counrtyDropdown;
	
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
	
	public void select_news_letter_and_special_offers() {
		driver.findElement(newsLetter).click();
		driver.findElement(specialOffer).click();
	}
	
	public void fill_additional_details(String fName , String lName, String comName, String address1,String address2) {
		driver.findElement(firstName).sendKeys(fName);
		driver.findElement(lastName).sendKeys(lName);
		driver.findElement(company).sendKeys(comName);
		driver.findElement(add1).sendKeys(address1);
		driver.findElement(add2).sendKeys(address2);
		
	}
	
	public void select_country_state_city(String country, String state, String city, String pincode,String mNumber) {
		Select countrySelect = new Select(counrtyDropdown);
		countrySelect.selectByValue(country);
		driver.findElement(By.id("state")).sendKeys(state);
		driver.findElement(By.id("city")).sendKeys(city);
		driver.findElement(By.id("zipcode")).sendKeys(pincode);
		driver.findElement(By.id("mobile_number")).sendKeys(mNumber);
	}
	
	public void verify_account_creation() {
		String accountCreatedText = driver.findElement(By.xpath("//b[text()='Account Created!']")).getText();
		Assert.assertEquals(accountCreatedText, "ACCOUNT CREATED!");
	}
	
	public void verify_logged_in_user() {
		WebElement loggedInUserText = driver.findElement(By.xpath("//a[text()=' Logged in as ']"));
		waitUntilWebElementLocated(loggedInUserText);
		Assert.assertTrue(loggedInUserText.isDisplayed());
	}
	
	public void verify_account_deletion() {
		WebElement deleteAccountText = driver.findElement(By.xpath("//b[text()='Account Deleted!']"));
		waitUntilWebElementLocated(deleteAccountText);
		Assert.assertTrue(deleteAccountText.isDisplayed());
	}

}
