package RameshSwarnkar.AbstractObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AbstractComponents {

	WebDriver driver;
	

	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
	}

	public void scrollToElement(WebElement locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", locator);

	}
	
	public boolean isElementInView(WebElement element) {
        // Get the location and size of the element
        int elementTop = element.getLocation().getY();
        int elementBottom = elementTop + element.getSize().getHeight();

        // Get the visible area of the browser viewport
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long viewportHeight = (long) js.executeScript("return window.innerHeight;");

        // Check if the element is within the vertical visible area of the viewport
        return (elementTop >= 0 && elementBottom <= viewportHeight);
    }

	public void checkIfElementIsVisible(WebElement locator) {

		if (isElementInView(locator)) {
			System.out.println("Element : " + locator + " is visible");
		} else
			scrollToElement(locator);
	}
}