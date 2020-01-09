package managers;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;

import enums.DriverType;
import enums.EnvironmentType;
import pageObjects.HomePageObjects;
import pageObjects.WelcomePageObjects;

public class WebDriverManager {
	private static WebDriver driver = null;
	private static WebDriverManager instance = null;
	private static DriverType driverType;
	private static EnvironmentType environmentType;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";


	private WebDriverManager() {
		driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
		environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
	}
	
	
	/**
     * getInstance method to retrieve active WebDriverManager instance
     *
     * @return WebDriverManager
     */
    public static WebDriverManager getInstance() {
        if ( instance == null ) {
            instance = new WebDriverManager();
        }
        return instance;
    }

    /**
     * getDriver method to retrieve active driver if exists or create driver if not exists 
     * 
     * @return WebDriver
     */
	public WebDriver getDriver() {
		if(driver == null) {
			driver = createDriver();
		}
		return driver;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public WebDriver createDriver() {
		Reporter.log("Opening Browser");
		   switch (environmentType) {	    
	        case LOCAL : driver = createLocalDriver();
	        	break;
	        case REMOTE : driver = createRemoteDriver();
	        	break;
		   }
		   return driver;
	}

	private WebDriver createRemoteDriver() {
		throw new RuntimeException("RemoteWebDriver is not yet implemented");
	}

	private WebDriver createLocalDriver() {
        switch (driverType) {	    
        case FIREFOX : 
        	driver = new FirefoxDriver();
	    	break;
        case CHROME : 
        	System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getDriverPath());
        	driver = new ChromeDriver();
    		break;
        case INTERNETEXPLORER : 
        	driver = new InternetExplorerDriver();
    		break;
        }

        if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
		return driver;
	}	

	/**
	 * launchApplicationUrl method will navigate driver to desired URL
	 */
	public void launchApplicationUrl() {
		
		getDriver().navigate().to(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	}
	
	/**
	 * closeDriver will close and quit existing driver
	 */
	private void closeDriver() {
		Reporter.log("Closing Browser");
		getDriver().close();		
	}
	
	private void destroyDmObject() {
		WebDriverManager.instance=null;
	}
	
	private void clearPageBojects() {
		WelcomePageObjects.instance = null;
		HomePageObjects.instance = null;
	}
	
	public void cleanUp() {
		closeDriver();
		destroyDmObject();
		clearPageBojects();
		
	}
	

}