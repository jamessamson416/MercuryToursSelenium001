package tests_junit;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import pages.BookAFlight;
import pages.FlightConfirmation;
import pages.FlightFinder;
import pages.LoginPageFactory;
import pages.SelectFlight;
import pages.SignOnPage;

public class TestUsingPageFactory {
	public static WebDriver driver;
	
	@BeforeEach
	void setUp() throws Exception {
		// initiate driver
		driver = utilities.DriverFactory.open("chrome");
		driver.get("http://localhost:8082/servlets/com.mercurytours.servlet.WelcomeServlet");
		
	}

	@AfterEach
	void tearDown() throws Exception {
		
		driver.quit();
		
	}
	
	@DisplayName("Create Flight Reservation PF Version")
	@Test
	public void createFlightReservation() throws InterruptedException {
		
		// Login Page using PageFactory
		LoginPageFactory loginPage = new LoginPageFactory(driver);
		loginPage.login("jojo", "bean");
		
		// Remaining pages using POM	
		// Flight Finder Page
			FlightFinder flightFinder = new FlightFinder(driver);
			flightFinder.setTripType("return");
			flightFinder.setPassCount("2");
			flightFinder.selectDepartCity("Frankfurt");
			flightFinder.selectArriveCity("random");
			flightFinder.setTripType("first");
			flightFinder.continueButtonClick();
			
			// Select Flight Page
			SelectFlight selectFlight = new SelectFlight(driver);
			selectFlight.selectDepart();
			selectFlight.selectReturn();
			selectFlight.clickContinueButton();
			
			// Book a Flight Page
			BookAFlight bookAFlight = new BookAFlight(driver);
			bookAFlight.setPassFirst("George");
			bookAFlight.setPassLast("Jetson");
			bookAFlight.setPassFirst("Jane", "1");
			bookAFlight.setPassLast("Jetson","1");
			
			bookAFlight.setCCNum("1234567890");
			bookAFlight.clickSecurePurchaseButton();
			
			// Flight Confirmation Page
			FlightConfirmation flightConfirmation = new FlightConfirmation(driver);
			Assertions.assertTrue(flightConfirmation.CheckConfirmationMessage());
			System.out.println("Total price is: " + flightConfirmation.getTotalPrice());
			flightConfirmation.SignOff();
			
			// SignOn Page
			SignOnPage signOnPage = new SignOnPage(driver);
			signOnPage.clickHome();

		
	}
	
	

}
