package pageObjects;



import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import managers.WebDriverManager;

public class HomePageObjects {
	public static HomePageObjects instance = null;
	private static WebDriver driver = null;
	
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
			driver = WebDriverManager.getInstance().getDriver();
			instance = new HomePageObjects(driver);
		}
		return instance;
	}
	
	public void clearPageobj(){
		instance = null;
	}
	
	
	@FindBy(xpath="//input[@name='userName']")
	public WebElement userName;
	
	@FindBy(how = How.CSS, using = "[type='radio'][value='roundtrip']")
	public WebElement roundTrip;

	@FindBy(how = How.CSS, using = "[type='radio'][value='oneway']")
	public WebElement oneWay;
	
	@FindBy(xpath = "//input[@name='tripType']")
	public List<WebElement> radioButton;
	
	
}
