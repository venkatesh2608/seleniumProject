package bizLib;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import pageObjects.HomePageObjects;

public class HomePage {
	private static HomePage instance = null;

	private HomePage() {
		// Constructor
	}

	public static HomePage getInstatnce() {
		if (instance == null) {
			instance = new HomePage();
		}
		return instance;
	}


	public HomePage selectRoundTripRadioButton() {
		
		HomePageObjects.getInstatnce().roundTrip.click();
		Reporter.log("Select Round Trip Radio Button");
		return instance;
	}

	public HomePage selectOnewayTripRadioButton() {

		HomePageObjects.getInstatnce().oneWay.click();
		Reporter.log("Select OneWay Trip Radio Button");
		return instance;
	}
	
	public HomePage selectRadioButton(String value) {
		List<WebElement> list = (List<WebElement>) HomePageObjects.getInstatnce().radioButton;
		for(int i=0; i<list.size(); i++) {
			WebElement ele = list.get(i);
			if(ele.getAttribute("value").equalsIgnoreCase(value)) {
				ele.click();
			}
		}
		Reporter.log("Toggle radio "+value);
		return instance;
	}
	
	public HomePage selectPassengersDropdown(String value) {
		Select select = new Select(HomePageObjects.getInstatnce().passengers);
		select.selectByVisibleText(value);
		return instance;
	}
	
	public HomePage selectDepartingFromDropdown(String value) {
		Select select = new Select(HomePageObjects.getInstatnce().departingFrom);
		select.selectByVisibleText(value);
		return instance;
	}
	
	public HomePage selectOnDropdown(String monthValue, String dayValue) {
		Select select = new Select(HomePageObjects.getInstatnce().onMonth);
		select.selectByVisibleText(monthValue);
		select = new Select(HomePageObjects.getInstatnce().onDay);
		select.selectByVisibleText(dayValue);
		return instance;
	}

	public HomePage selectArrivingInDropdown(String value) {
		Select select = new Select(HomePageObjects.getInstatnce().arrivingIn);
		select.selectByVisibleText(value);
		return instance;
	}
	
	public HomePage selectReturningDropdown(String monthValue, String dayValue) {
		Select select = new Select(HomePageObjects.getInstatnce().returningMonth);
		select.selectByVisibleText(monthValue);
		select = new Select(HomePageObjects.getInstatnce().returningDay);
		select.selectByVisibleText(dayValue);
		return instance;
	}
	
	public HomePage selectServiceClassRadioButton(String value) {
		List<WebElement> list = (List<WebElement>) HomePageObjects.getInstatnce().serviceClassRadio;
		for(int i=0; i<list.size(); i++) {
			WebElement ele = list.get(i);
			if(ele.getAttribute("value").equalsIgnoreCase(value)) {
				ele.click();
			}
		}
		return instance;
	}
	
	public HomePage selectAirlineDropdown(String value) {
		Select select = new Select(HomePageObjects.getInstatnce().airline);
		select.selectByVisibleText(value);
		return instance;
	}
	
	public HomePage clickContinue() {
		HomePageObjects.getInstatnce().continueButton.click();
		return instance;
	}
}
