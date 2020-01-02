package testCases;

import org.testng.annotations.Test;

import bizLib.WelcomePage;
import managers.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class BasicTestCase {
	
	@BeforeMethod
	  public void beforeMethod() {
		WebDriverManager.getInstance().getDriver();
		WebDriverManager.getInstance().launchApplicationUrl();
	  }
	
	@Test
	  public void f() {
		Reporter.log("Test Method Exectuion"+"\n");
		WelcomePage.getInstatnce().enterUserName("Venkatesh");
		WelcomePage.getInstatnce().enterPassword("Pass");
		WelcomePage.getInstatnce().clickSignIn();
		
	  }
	
	@AfterMethod
	  public void afterMethod() {
		WebDriverManager.getInstance().closeDriver();
	  }  
}
