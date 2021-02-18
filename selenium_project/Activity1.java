package Seleniumproject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void setup() throws IOException {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 10);
		driver.get("https://alchemy.hguy.co/jobs/");

	}
	
	
	@Test(description = "Activity 1 - Verify the Webpage title")
	public void verifytitle() {
		String title = driver.getTitle();
		System.out.println("The title of the page is :" + title);
		String ExpectedTitle = "Alchemy Jobs – Job Board Application";
		Assert.assertEquals(title, ExpectedTitle, "The title is not matching");

	}
	
	@AfterMethod

	public void TearDown() {
		driver.quit();
	}

}
