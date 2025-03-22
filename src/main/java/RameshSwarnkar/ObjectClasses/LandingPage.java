package RameshSwarnkar.ObjectClasses;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RameshSwarnkar.AbstractObjects.AbstractComponents;

public class LandingPage extends AbstractComponents{

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[contains(@class,'compTable')]")
	WebElement table;

	@FindBy(xpath = "//*[contains(@class,'compTable')]/tbody/tr/td/a")
	List<WebElement> searchTable;

	@FindBy(id = "yschsp")
	WebElement searchBox;

	public void enterSearchText(String searchText) {

		searchBox.sendKeys(searchText, Keys.ENTER);
	}

	public void printLinks() {

		checkIfElementIsVisible(table);
		
		System.out.println(searchTable.size());
		
		for (WebElement searchItem : searchTable) {

			String linkText = searchItem.getText();
			System.out.println(linkText);
		}
	}
	
	public void clickOnLinks() {
		
		for(WebElement searchItem : searchTable) {
			searchItem.sendKeys(Keys.chord(Keys.COMMAND, Keys.ENTER));
			}
		
	}
	
	public void getTitles() {
		
		String currentWindow = driver.getWindowHandle();
		
		Set<String> windows = driver.getWindowHandles();
		
		System.out.println(windows.size());
		
		for (String window : windows) {
		String title	= driver.switchTo().window(window).getTitle();
		
		System.out.println(title);	
		
		
		}
		
	}
}