package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	
	public void setUserName(String username) {
		driver.findElement(By.name("userName")).sendKeys(username);
	}
	
	public void setPassword(String password) {
		driver.findElement(By.name("password")).sendKeys(password);
	}
	
	public void clickLogin() {
		driver.findElement(By.name("login")).click();
	}
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	

}
