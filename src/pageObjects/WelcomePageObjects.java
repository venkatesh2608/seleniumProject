package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import managers.WebDriverManager;

public class WelcomePageObjects  {
	private static WelcomePageObjects instance = null;
	private static WebDriver driver = WebDriverManager.getInstance().getDriver();
	
	/*
	 * This Class is a singleton
	 * 
	 */
	private WelcomePageObjects(WebDriver driver) {
		WelcomePageObjects.driver = driver;
		 PageFactory.initElements(driver, this);
	}
	
	public static WelcomePageObjects getInstatnce() {
		if(instance == null) {
			instance = new WelcomePageObjects(driver);
		}
		return instance;
	}
	
	@FindBy(xpath="//input[@name='userName']")
	public WebElement userName;
	
	@FindBy(xpath="//input[@name='password']")
	public WebElement password;
	
	@FindBy(xpath="//input[@name='login']")
	public WebElement signIn;
}
