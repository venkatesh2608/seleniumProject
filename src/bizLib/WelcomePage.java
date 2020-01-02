package bizLib;

import org.testng.Reporter;
import pageObjects.WelcomePageObjects;

public class WelcomePage {
private static WelcomePage instance = null;
	
	private WelcomePage() {
		
	}
	
	public static WelcomePage getInstatnce() {
		if(instance == null) {
			instance = new WelcomePage();
		}
		return instance;
	}
	
	public WelcomePage enterUserName(String user_name) {
		WelcomePageObjects.getInstatnce().userName.sendKeys(user_name);
		Reporter.log("Entering User Name");
		
		return instance;
	}
	
	public WelcomePage enterPassword(String password) {
		Reporter.log("Entering Password");
		WelcomePageObjects.getInstatnce().password.sendKeys(password);
		
		return instance;
	}
	
	public HomePage clickSignIn() {
		Reporter.log("Clicking on Sign In");
		WelcomePageObjects.getInstatnce().signIn.click();
		return HomePage.getInstatnce();
	}
}
