package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePageObjects extends PageBase {
	private WebDriver driver;
	
	public WelcomePageObjects(WebDriver driver) {
		 super(driver);
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='userName']")
	WebElement userName;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@name='login']")
	WebElement signIn;
}
