package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlightConfirmation {
	WebDriver driver;
	
	
	
	public boolean CheckConfirmationMessage() {
		 String pageText = driver.findElement(By.xpath("/html/body")).getText();
		   	if (pageText.contains("Your itinerary has been booked!")) {
		    	return true;
		    }
		    else
		    {
		    	return false;
		    }
	
	}
	
	public String getTotalPrice() {
	    WebElement confirmationTable = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[4]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[5]/td[1]/table[1]"));
	    
	  //To locate rows of table.
	    List < WebElement > rows_table = confirmationTable.findElements(By.tagName("tr"));
	    //To calculate no of rows In table.
	    int rows_count = rows_table.size();
	 //   System.out.println("Rows = " + rows_count);
	    
	    // since total is near bottom of table, going to walk up it row by row
	    // start at rows_count-1
	    String totalValue = "";
	    boolean rowFound = false; // going to identify the total cell by it's neighbor, so once the row is found we want to exit the outer loop
	    for(int row=rows_count-1; row >= 0; row--)
	    {
	    	if (rowFound) {break;}  // exit once we've identified the row
	    	List <WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
	    	// get number of columns
	    	int columns_count = Columns_row.size();
	    //	System.out.println("Number of cells In Row " + row + " are " + columns_count);
	    	
	    	 //Loop will execute till the last cell of that specific row.
	    	   for (int column = 0; column < columns_count; column++) {
	    	    //To retrieve text from the cells.
	    	    String celltext = Columns_row.get(column).getText();
	    //	    System.out.println("Cell Value Of row number " + row + " and column number " + column + " Is " + celltext);

	    	    // looking for "Total Price (including taxes):"
	    	    if (celltext.contains("Total Price (including taxes):"))
	    	    {
	    	    	// once we've found this cell, the actual total should be in next column, so want to exit outer for loop after this
	    	    	rowFound=true;
	    	    }
	    	    // once row is found, if we identify cell containing USD, we capture and exit inner loop
	    	    if ((rowFound) && (celltext.contains("USD"))) 
	    	    {
	    	    	totalValue=celltext;  // copy value to outer existing variable
	    	    	break;
	    	    }
	    	    	
	    	   }
	    	
	    }
	    
	 //   System.out.println("Total Price is: " + totalValue);
	    return totalValue;
	}
	
	public void SignOff() {
	    driver.findElement(By.linkText("SIGN-OFF")).click();
	    
	}
	
	
	
	public FlightConfirmation(WebDriver driver) {
		this.driver = driver;
	}
}
