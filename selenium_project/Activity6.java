package Seleniumproject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity6 {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void setup() throws IOException {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 10);
		driver.get("https://alchemy.hguy.co/jobs/");

	}

	@Test(description = "Actvity 6 - Search for a job and apply for it. ")
	@Parameters("searchkeyword")
	public void jobsearch(String searchkeyword) throws InterruptedException {
		// Click on jobs in menu
		WebElement joboption = driver.findElement(By.xpath("//ul[@id='primary-menu']//a[contains(text(),'Jobs')]"));
		joboption.click();
		// Enter keyword in search box
		WebElement searchbox = driver.findElement(By.id("search_keywords"));
		searchbox.sendKeys(searchkeyword);
		// Click search button
		WebElement searchbutton = driver.findElement(By.xpath("//input[@type='submit']"));
		searchbutton.click();
		Thread.sleep(6000);
		// Get the list of results
		List<WebElement> results = driver.findElements(By.xpath("//ul[@class='job_listings']/li//a"));

		System.out.println("The list of results are : ");
		for (WebElement result : results) {
			System.out.println(result.getText());
		}
		results.get(0).click();
		// Click apply job button
		WebElement applyjob = driver.findElement(By.xpath("//input[@value='Apply for job']"));
		applyjob.click();
		// Get the email id and display in console

		WebElement emailid = driver.findElement(By.xpath("//div[@class='application_details']//a"));
		System.out.println("The email id is : " + emailid.getText());

	}

	@AfterMethod

	public void TearDown() {
		driver.quit();
	}

}
