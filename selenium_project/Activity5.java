package Seleniumproject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity5 {

	WebDriver driver;
	WebDriverWait wait;
	
	
	@BeforeMethod
	public void setup() throws IOException {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 10);
		driver.get("https://alchemy.hguy.co/jobs/");

	}
	
	@Test(description = "Actvity 5 - Navigate to the “Jobs” page on the site.")
	public void jobpage() {
		List<WebElement> menuoptions = driver.findElements(By.xpath("//ul[@id='primary-menu']//a"));
		System.out.println("The menu options are :");
		for (WebElement menu : menuoptions) {
			System.out.println(menu.getText());
		}
		menuoptions.get(0).click();
		wait.until(ExpectedConditions.urlToBe("https://alchemy.hguy.co/jobs/jobs/"));
		System.out.println("The title of new jobs page is : " + driver.getTitle());

	}
	
	@AfterMethod

	public void TearDown() {
		driver.quit();
	}
}
