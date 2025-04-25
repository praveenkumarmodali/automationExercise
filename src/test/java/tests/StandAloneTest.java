package tests;


import java.util.HashMap;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.SignUpPage;
import testComponents.BaseTest;

public class StandAloneTest extends BaseTest {
	
	@Test(dataProvider="signUpDataProvider" ,
			dataProviderClass = resources.DataResources.class) // test case 1 
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
	
	@Test // test case 2 
	public void successfulLoginUser() {
		
		LoginPage loginPage = new LoginPage(driver);
		
//		verify that the home page is loaded
		loginPage.verifyHomePageLoaded();
		
//		go to login 
		loginPage.goToLogin();
		
	}

}
