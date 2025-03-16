package RameshSwarnkar.Test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

import RameshSwarnkar.AbstractClasses.BaseTest;
import RameshSwarnkar.ObjectClasses.LandingPage;

public class googleSearchTest extends BaseTest {

	@Test
	public void searchResultsTest() throws IOException {

		LandingPage landingPage = launchApplication();
		landingPage.enterSearchText(prop.getProperty("searchText"));
		landingPage.printLinks();
	}
}