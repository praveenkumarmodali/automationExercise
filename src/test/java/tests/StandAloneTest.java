package tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.SignUpPage;
import testComponents.BaseTest;

public class StandAloneTest extends BaseTest {
	
	@Test(dataProvider="signUpDataProvider") // test case 1 
	public void registerUser(HashMap<String,String> input) {

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
		signupPage.select_news_letter_and_special_offers();
		
//		fill additional details
		signupPage.fill_additional_details(input.get("fname"), input.get("lname"),
				input.get("company"), input.get("add1")
				, input.get("add2"));

		//fill country , state , city
		signupPage.select_country_state_city(input.get("country"), 
				input.get("state"), input.get("city"), input.get("pincode"), input.get("mNumber"));
		
		
//		click on create account
		signupPage.click_createAccount();
		
		//verify account created
		signupPage.verify_account_creation();
		
		//click on continue 
		signupPage.click_continueBtn();
		
//		verify the logged in user
		signupPage.verify_logged_in_user();
		
//		click on delete account
		signupPage.click_delete_account_btn();
		
//		verify account delete text
		signupPage.verify_account_deletion();
	
//		click on continue button
		signupPage.click_continueBtn();
		
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
		map1.put("fname", "praveen");
		map1.put("lname", "kumar");
		map1.put("company", "mecitlabs");
		map1.put("add1", "hyd");
		map1.put("add2", "Gudimalkapur");
		map1.put("country", "India");
		map1.put("state", "Telangana");
		map1.put("city", "Hyderabad");
		map1.put("pincode", "500028");
		map1.put("mNumber", "12345677889");
		
		return new Object[] {map1};
	}


}
