package testCases;

import org.testng.annotations.Test;

import managers.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class BasicTestCase {
	public WebDriver driver = null;
	WebDriverManager wdm = null;

	@BeforeMethod
	  public void beforeMethod() {
		wdm = new WebDriverManager();
		driver = wdm.getDriver();
		wdm.launchApplicationUrl();
	  }
	
	@Test
	  public void f() {
		driver.navigate().to("https://www.google.com");
		
		
	  }
	
	@AfterMethod
	  public void afterMethod() {
		wdm.closeDriver();
	  }  
}
