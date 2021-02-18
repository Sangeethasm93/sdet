package Seleniumproject;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity2 {

	WebDriver driver;
	WebDriverWait wait;
	
	
	@BeforeMethod
	public void setup() throws IOException {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 10);
		driver.get("https://alchemy.hguy.co/jobs/");

	}
	
	@Test(description = "Activity 2 - Verify the first heading of the page")
	public void verifyheading1() {
		WebElement heading = driver.findElement(By.xpath("//h1[@class='entry-title']"));
		String Headingtext = heading.getText();
		System.out.println("The Actual Heading is " + Headingtext);
		String ExpectedHeading = "Welcome to Alchemy Jobs";
		Assert.assertEquals(Headingtext, ExpectedHeading, "The heading is not matching");

	}
	
	@AfterMethod

	public void TearDown() {
		driver.quit();
	}
}
