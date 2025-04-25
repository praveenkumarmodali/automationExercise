package abstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class utils {
	
	WebDriver driver;
	
	public utils(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement waitUntilElementLocated(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	
	public WebElement waitUntilWebElementLocated(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	@FindBy(css="[href*='login']")
	WebElement signUpButton;
	
	@FindBy(xpath="//button[text()='Create Account']")
	WebElement createAccountBtn;
	
	@FindBy(xpath="//a[text()='Continue']")
	WebElement continueBtn;
	
	@FindBy(css="[href*='delete_account']")
	WebElement deleteAccBtn;
	
	public void goToSignUp() {
		signUpButton.click();
	}
	
	public void goToLogin() {
		signUpButton.click();
	}
	
	public void click_createAccount() {
		createAccountBtn.click();
	}
	
	public void click_continueBtn() {
		continueBtn.click();
	}
	
	public void click_delete_account_btn() {
		deleteAccBtn.click();
	}

}
