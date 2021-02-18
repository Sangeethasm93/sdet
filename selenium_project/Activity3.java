package Seleniumproject;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity3 {

	WebDriver driver;
	WebDriverWait wait;
	
	
	@BeforeMethod
	public void setup() throws IOException {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 10);
		driver.get("https://alchemy.hguy.co/jobs/");

	}
	
	@Test(description = "Activity 3 - Verify the image url")
	public void imageurl() {
		String url = driver.findElement(By.tagName("img")).getAttribute("src");
		System.out.println("The url of the header image is : " + url);
	}
	
	@AfterMethod

	public void TearDown() {
		driver.quit();
	}
}
