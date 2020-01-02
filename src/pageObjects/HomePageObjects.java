package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import managers.WebDriverManager;

public class HomePageObjects {
	private static HomePageObjects instance = null;
	private static WebDriver driver = WebDriverManager.getInstance().getDriver();
	
	/*
	 * This Class is a singleton
	 * 
	 */
	private HomePageObjects(WebDriver driver) {
		 HomePageObjects.driver = driver;
		 PageFactory.initElements(driver, this);
	}
	
	public static HomePageObjects getInstatnce() {
		if(instance == null) {
			instance = new HomePageObjects(driver);
		}
		return instance;
	}
	
	@FindBy(xpath="//input[@name='userName']")
	public WebElement userName;
	
	
}
