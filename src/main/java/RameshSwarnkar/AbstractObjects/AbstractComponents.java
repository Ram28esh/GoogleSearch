package RameshSwarnkar.AbstractObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AbstractComponents {

	WebDriver driver;
	public AbstractComponents(WebDriver driver) {
		this.driver=driver;
		
		
	}
	
	
	public void scrollToElement(WebElement locator) {
		
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true);", locator);
		
	}
	
	public void checkIfElementIsVisible(WebElement locator) {
		
		if(locator.isDisplayed()) {
			System.out.println("Element : " + locator+ " is visible");
		//	System.out.println("i am scrolling while checking for element");
		} else 
		//System.out.println("needed to scroll");
			scrollToElement(locator);
		
	}
	
}
