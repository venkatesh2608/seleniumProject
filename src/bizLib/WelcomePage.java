package bizLib;

import org.openqa.selenium.WebDriver;

public class WelcomePage extends pageObjects.WelcomePageObjects {
	private WebDriver driver;
	public WelcomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void enterUserName(String user_name) {
		this.userName.sendKeys(user_name);
	}
	
	public void enterPassword(String password) {
		this.password.sendKeys(password);
	}
	
	public void clickSignIn() {
		this.signIn.click();
	}
}
