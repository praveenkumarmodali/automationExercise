package testComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	protected WebDriver driver;
	
	public WebDriver InitialiseDriver() throws IOException {
		
		String path = "/Users/praveenkumar/eclipse-workspace7/Automation/src/test/java/resources/globalproperties.properties";
		Properties props = new Properties();
		FileInputStream fs = new FileInputStream(path);
		props.load(fs);
		
		String browserName = props.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		
		if(browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}
		
		if(browserName.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
		
	}
	
	@BeforeMethod
	public void launchApplication() throws IOException {
		driver = InitialiseDriver();
		driver.get("https://automationexercise.com/");
	}
	
	
	@AfterMethod
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}

}
