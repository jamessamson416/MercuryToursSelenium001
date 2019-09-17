package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GeneralUtilities {

	//Get the title of Page
    public static String getPageTitle(WebDriver driver){
        return driver.getTitle();
    }
	
    
	public static void fnHighlightMe(WebDriver driver,WebElement element) throws InterruptedException{
		 //Creating JavaScriptExecuter Interface
		JavascriptExecutor js = (JavascriptExecutor)driver;
		for (int iCnt = 0; iCnt < 5; iCnt++) {
		  //Execute javascript
			js.executeScript("arguments[0].style.border='4px outset red'", element);
			Thread.sleep(1000);
			js.executeScript("arguments[0].style.border=''", element);
			Thread.sleep(500);
		}
		}




	public static double getRandomDoubleBetweenRange(double min, double max){
	   double x = (Math.random()*((max-min)+1))+min;
	   return x;
	}

    
}