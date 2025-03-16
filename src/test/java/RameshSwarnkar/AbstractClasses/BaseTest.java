package RameshSwarnkar.AbstractClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import RameshSwarnkar.ObjectClasses.LandingPage;

public class BaseTest {

	public WebDriver driver;
	public Properties prop;

	public void getData() throws IOException {
		prop = new Properties();

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//resources//GlobalData.Properties");

		prop.load(fis);
	}

	public String getScreenshot(String testcaseName, WebDriver driver) throws IOException {
		
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String screenshotFileInWorkspace = System.getProperty("user.dir") + "//test-output//Screenshots//"
				+ testcaseName + LocalDateTime.now() + ".png";

		FileUtils.copyFile(src, new File(screenshotFileInWorkspace));
		
		return screenshotFileInWorkspace;

	}
	

	
	@BeforeMethod
	public WebDriver initializeDriver() throws IOException {
		getData();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
	//	driver.get(prop.getProperty("URL"));

		return driver;
	}
	
	public LandingPage launchApplication() throws IOException {
		
		driver.get(prop.getProperty("URL"));
		
		LandingPage landingPage = new LandingPage(driver);
		return landingPage;
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
