package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utilities.GeneralUtilities;


public class FlightFinder {
	WebDriver driver;
	
	
	
	public void setTripType(String tripType) {
		if (tripType.equalsIgnoreCase("oneway")) {
			driver.findElement(By.cssSelector("input[name='tripType'][value='oneway']")).click();
		}
		else
		{
			// round trip is default anyway, so could probably leave this out
			driver.findElement(By.cssSelector("input[name='tripType'][value='roundtrip']")).click();
		}
	}
	
	public void setPassCount(String passCount) {
		Select passCountField = new Select(driver.findElement(By.name("passCount")));
		passCountField.selectByValue(passCount);
	}
	
	public void selectDepartCity(String departCity) {
		Select departFrom = new Select(driver.findElement(By.name("fromPort")));
		List<WebElement> dfl = departFrom.getOptions();
		// setup case to allow passing the word random in, and have it randomly select an item.
		if (!departCity.equalsIgnoreCase("random")) {
			departFrom.selectByVisibleText(departCity);
		}
		else
		{
			int dflSize = dfl.size();
			//	System.out.println(dflSize);
			// select random item
			departFrom.selectByIndex((int) GeneralUtilities.getRandomDoubleBetweenRange(0, dflSize-1));
		}
	}
	
	public void selectArriveCity(String arriveCity) {
		Select arriveFrom = new Select(driver.findElement(By.name("toPort")));
		List<WebElement> dfl = arriveFrom.getOptions();
		// setup case to allow passing the word random in, and have it randomly select an item.
		if (!arriveCity.equalsIgnoreCase("random")) {
			arriveFrom.selectByVisibleText(arriveCity);
		}
		else
		{
			int dflSize = dfl.size();
			//	System.out.println(dflSize);
			// select random item
			arriveFrom.selectByIndex((int) GeneralUtilities.getRandomDoubleBetweenRange(0, dflSize-1));
		}
	}
	
	public void selectFlightClass(String flightClass) {
		String flightClassToSelect = "";
		
		if (flightClass.equalsIgnoreCase("first")) {
			flightClassToSelect="First";
		}
		else if (flightClass.equalsIgnoreCase("business")) {
			flightClassToSelect="Business";
		}
		else
		{
			flightClassToSelect="Coach";
		}
		
		driver.findElement(By.cssSelector("input[name='servClass'][value='" + flightClassToSelect + "']")).click(); 
	}
	
	public void continueButtonClick() {
		driver.findElement(By.name("findFlights")).click();
	}
	//Get the title of Page
    public String getPageTitle(){
        return driver.getTitle();
    }

	
	public FlightFinder(WebDriver driver) {
		this.driver = driver;
	}
}
