package testCases;

import org.testng.annotations.Test;

import bizLib.WelcomePage;
import managers.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class BasicTestCase {
	public WebDriver driver = null;
	WelcomePage welcomePage = null;

	@BeforeMethod
	  public void beforeMethod() {
		
		driver = WebDriverManager.getInstance().getDriver();
		WebDriverManager.getInstance().launchApplicationUrl();
		welcomePage = new WelcomePage(driver);
	  }
	
	@Test
	  public void f() {
		Reporter.log("Test Method Exectuion"+"\n");
		welcomePage.enterUserName("Venkatesh");
		welcomePage.enterPassword("PASS");
		welcomePage.clickSignIn();
		
		
	  }
	
	@AfterMethod
	  public void afterMethod() {
		WebDriverManager.getInstance().closeDriver();
	  }  
}
