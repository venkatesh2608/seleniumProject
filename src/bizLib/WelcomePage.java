package bizLib;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class WelcomePage extends pageObjects.WelcomePageObjects {
	private WebDriver driver;
	public WelcomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public WelcomePage enterUserName(String user_name) {
		Reporter.log("Entering User Name");
		this.userName.sendKeys(user_name);
		return this;
	}
	
	public WelcomePage enterPassword(String password) {
		Reporter.log("Entering Password");
		this.password.sendKeys(password);
		return this;
	}
	
	public HomePage clickSignIn() {
		Reporter.log("Clicking on Sign In");
		this.signIn.click();
		return HomePage.getInstatnce();
	}
}
