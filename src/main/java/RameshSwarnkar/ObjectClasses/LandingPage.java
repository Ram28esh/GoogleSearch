package RameshSwarnkar.ObjectClasses;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RameshSwarnkar.AbstractObjects.AbstractComponents;

public class LandingPage extends AbstractComponents{

	WebDriver driver;
	Actions a;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		a = new Actions(driver);
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
}