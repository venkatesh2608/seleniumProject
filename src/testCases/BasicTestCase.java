package testCases;

import org.testng.annotations.Test;

import bizLib.HomePage;
import bizLib.WelcomePage;
import managers.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class BasicTestCase {

	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.getInstance().createDriver();
		WebDriverManager.getInstance().launchApplicationUrl();
	}

	@Test
	public void f() {
		Reporter.log("Test Method f Execution", 1);
		
		WelcomePage.getInstatnce().enterUserName("venky2608");
		WelcomePage.getInstatnce().enterPassword("venky2608");
		WelcomePage.getInstatnce().clickSignIn();
		
		Assert.assertEquals("string", "string");
		HomePage.getInstatnce().selectRadioButton("roundtrip");
		HomePage.getInstatnce().selectPassengersDropdown("2");
		HomePage.getInstatnce().selectDepartingFromDropdown("Frankfurt");
		HomePage.getInstatnce().selectOnDropdown("March", "3");
		HomePage.getInstatnce().selectArrivingInDropdown("London");
		HomePage.getInstatnce().selectReturningDropdown("March", "10");
		HomePage.getInstatnce().selectServiceClassRadioButton("First");
		HomePage.getInstatnce().selectAirlineDropdown("Unified Airlines");
		HomePage.getInstatnce().clickContinue();
		

	}

//	@Test
//	public void f1() {
//		Reporter.log("Test Method f1 Execution");
//		WelcomePage.getInstatnce().enterUserName(Util.getInstatnce().stringGen());
//		WelcomePage.getInstatnce().enterPassword(Util.getInstatnce().stringGen(5));
//		WelcomePage.getInstatnce().clickSignIn();
//
//	}
//
//	@Test
//	public void f2() {
//		Reporter.log("Test Method f2 Execution");
//		WelcomePage.getInstatnce().enterUserName("venky2608");
//		WelcomePage.getInstatnce().enterPassword("venky2608");
//
//	}

	
	@AfterMethod
	public void afterMethod() {
		WebDriverManager.getInstance().cleanUp();
	}
}
