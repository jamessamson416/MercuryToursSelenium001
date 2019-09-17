package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.GeneralUtilities;

public class SelectFlight {
	WebDriver driver;
	
	public void selectDepart() {
		// doing count of items using findelements, then selecting random one
		List<WebElement> elements = driver.findElements(By.cssSelector("input[name='outFlight']"));
	    System.out.println("Number of outFlight elements:" +elements.size());
	    int randomSelection = (int) GeneralUtilities.getRandomDoubleBetweenRange(0, elements.size()-1);
	    System.out.println("Random selection for flight radio's is: " + randomSelection);
	    elements.get(randomSelection).click();
	}
	
	public void selectReturn() {
		// doing count of items using findelements, then selecting random one
		List<WebElement> elements = driver.findElements(By.cssSelector("input[name='inFlight']"));
	    System.out.println("Number of outFlight elements:" +elements.size());
	    int randomSelection = (int) GeneralUtilities.getRandomDoubleBetweenRange(0, elements.size()-1);
	    System.out.println("Random selection for flight radio's is: " + randomSelection);
	    elements.get(randomSelection).click();
	}

	
	public void clickContinueButton() {
	    driver.findElement(By.name("reserveFlights")).click();		
	}


	
	
	
	public SelectFlight(WebDriver driver) {
		this.driver = driver;
	}
}
