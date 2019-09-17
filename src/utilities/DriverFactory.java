package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class DriverFactory {

	public static WebDriver open(String browserType) {
		if(browserType.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\SeleniumFiles\\geckodriver.exe");
			return new FirefoxDriver();
		}
		else if (browserType.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\chromedriver.exe");
			return new ChromeDriver();
		} 
		else { 
			System.setProperty("webdriver.ie.driver", "C:\\SeleniumFiles\\IEDriverServer32.exe");
			InternetExplorerOptions options = new InternetExplorerOptions();
			options.setCapability(
			InternetExplorerDriver.INITIAL_BROWSER_URL, "about:blank");
			options.setCapability("nativeEvents", false);
			options.setCapability("requireWindowFocus", true);
			System.out.println("Running Test with IE");

			return new InternetExplorerDriver(options);
			
		}
			
			
	
	}
	
	
	
}
