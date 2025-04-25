package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import abstractComponents.utils;

public class LoginPage extends utils {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	By logo = By.cssSelector("[src*='logo']");
	
	@FindBy(css="[src*='logo']")
	WebElement hopePageLogo;
	
	public void verifyHomePageLoaded() {
		waitUntilElementLocated(logo);
		Assert.assertTrue(hopePageLogo.isDisplayed());
	}

}
