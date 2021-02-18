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

public class Activity4 {
	WebDriver driver;
	WebDriverWait wait;
	
	
	@BeforeMethod
	public void setup() throws IOException {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 10);
		driver.get("https://alchemy.hguy.co/jobs/");

	}
	
	@Test(description = "Actvity 4 - Verify the second heading of the page")
	public void verifyheading2() {
		WebElement heading2 = driver.findElement(By.xpath("//div[@class='entry-content clear']/h2"));
		String Headingtext2 = heading2.getText();
		System.out.println("The Actual Heading is " + Headingtext2);
		String ExpectedHeading2 = "Quia quis non";
		Assert.assertEquals(Headingtext2, ExpectedHeading2, "The heading is not matching");

	}
	
	@AfterMethod

	public void TearDown() {
		driver.quit();
	}
	
}
