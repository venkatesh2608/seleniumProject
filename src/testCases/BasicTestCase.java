package testCases;

import org.testng.annotations.Test;

import bizLib.HomePage;
import bizLib.WelcomePage;
import managers.WebDriverManager;
import utilities.Util;

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
		Reporter.log("Test Method Exectuion" + "\n");
		WelcomePage.getInstatnce().enterUserName("venky2608");
		WelcomePage.getInstatnce().enterPassword("venky2608");

		WelcomePage.getInstatnce().clickSignIn();
		HomePage.getInstatnce().selectOnewayTripRadioButton();
		
		Assert.assertEquals("test", "test");
		
		HomePage.getInstatnce().selectRadioButton("roundtrip");
		HomePage.getInstatnce().selectRadioButton("OneWay");

	}

	@Test
	public void f1() {
		Reporter.log("Test Method Exectuion" + "\n");
		WelcomePage.getInstatnce().enterUserName(Util.getInstatnce().stringGen());
		WelcomePage.getInstatnce().enterPassword(Util.getInstatnce().stringGen(5));
		WelcomePage.getInstatnce().clickSignIn();

	}

	@Test
	public void f2() {
		Reporter.log("Test Method Exectuion" + "\n");
		WelcomePage.getInstatnce().enterUserName("venky2608");
		WelcomePage.getInstatnce().enterPassword("venky2608");

	}

	
	@AfterMethod
	public void afterMethod() {
		WebDriverManager.getInstance().cleanUp();
	}
}
