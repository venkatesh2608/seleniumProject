package bizLib;

import org.testng.Reporter;

import pageObjects.HomePageObjects;

public class HomePage {
	private static HomePage instance = null;
	
	private HomePage() {
		//Constructor
	}
	
	public static HomePage getInstatnce() {
		if(instance == null) {
			instance = new HomePage();
		}
		return instance;
	}
	
	public HomePage enterUserName(String user_name) {
		Reporter.log("Entering User Name");
		HomePageObjects.getInstatnce().userName.sendKeys(user_name);
		
		return instance;
	}
	
}
