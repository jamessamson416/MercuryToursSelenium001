package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {

	WebDriver driver;
	// Define Web Elements
	@FindBy(name="userName")
	WebElement userNameEdit;
	
	@FindBy(name="password")
	WebElement passwordEdit;
	
	@FindBy(name="login")
	WebElement loginButton;
	
	// steps
	public void setUserName(String username) {
		userNameEdit.sendKeys(username);
	}
	
	public void setPassword(String password) {
		passwordEdit.sendKeys(password);
	}
	
	public void clickLogin() {
		loginButton.click();
	}
	
	//actions
	public void login(String username, String password) {
		System.out.println("running page factory login method");
		setUserName(username);
		setPassword(password);
		clickLogin();
	}
	
	// constructor
	public LoginPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	
	
}
