package bizLib;

import java.util.List;

import org.openqa.selenium.WebElement;


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
		return instance;
	}

	public HomePage selectOnewayTripRadioButton() {

		HomePageObjects.getInstatnce().oneWay.click();
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
		return instance;
	}

}
