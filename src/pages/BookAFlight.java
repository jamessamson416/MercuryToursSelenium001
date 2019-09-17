package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class BookAFlight {

	WebDriver driver;
	
	public void setPassFirst(String firstName) {
	    driver.findElement(By.name("passFirst0")).sendKeys(firstName);
	}

	public void setPassFirst(String firstName, String index) {
		 driver.findElement(By.name("passFirst" + index)).sendKeys(firstName);
	}
	
	public void setPassLast(String lastName) {
	    driver.findElement(By.name("passLast0")).sendKeys(lastName);
	}
	public void setPassLast(String lastName, String index) {
	    driver.findElement(By.name("passLast" + index)).sendKeys(lastName);
	}
	
	

	public void setCCNum(String ccNum) {
	    driver.findElement(By.name("creditnumber")).sendKeys(ccNum);
	}
	
	
	public void clickSecurePurchaseButton() {
	    driver.findElement(By.name("buyFlights")).click();		
	}


	public BookAFlight(WebDriver driver) {
		this.driver = driver;
	}
	
}
