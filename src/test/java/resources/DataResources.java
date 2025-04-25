package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.testng.annotations.DataProvider;

public class DataResources {
	
	@DataProvider
	public static Object[] signUpDataProvider() throws IOException {
		
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
