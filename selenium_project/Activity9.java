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

public class Activity9 {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void setup() throws IOException {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 10);
		driver.get(
				"https://alchemy.hguy.co/jobs/wp-login.php?redirect_to=https%3A%2F%2Falchemy.hguy.co%2Fjobs%2Fwp-admin%2F&reauth=1");

	}

	@Test(description = "Actvity 9 - ​ ​Visit the site’s backend and create a job listing. ")
	@Parameters({ "username", "password", "position" })
	public void backendjoblist(String username, String password, String position) throws InterruptedException {

		// Login
		WebElement Username = driver.findElement(By.id("user_login"));
		WebElement Password = driver.findElement(By.id("user_pass"));
		Username.sendKeys(username);
		Password.sendKeys(password);
		WebElement loginbutton = driver.findElement(By.xpath("//input[@value='Log In']"));
		loginbutton.click();
		Thread.sleep(5000);
		WebElement dashboard = driver.findElement(By.xpath("//div[contains(text(),'Job Listings')]"));
		dashboard.click();
		Thread.sleep(5000);
		WebElement addnewbtn = driver.findElement(By.xpath("//a[@class='page-title-action']"));
		addnewbtn.click();
		Thread.sleep(5000);
		WebElement Position = driver.findElement(By.xpath("//textarea[@placeholder='Position']"));
		Position.sendKeys(position);
		WebElement publish = driver.findElement(By.xpath("//button[contains(text(),'Publish…')]"));
		publish.click();
		Thread.sleep(3000);
		WebElement publishbtn = driver
				.findElement(By.xpath("//div[@class='editor-post-publish-panel__header-publish-button']/button"));
		publishbtn.click();
		Thread.sleep(6000);
		WebElement viewjob = driver.findElement(By.xpath("//a[contains(text(),'View Job')]"));
		viewjob.click();

		// Click on jobs in menu
		WebElement joboption = driver.findElement(By.xpath("//ul[@id='primary-menu']//a[contains(text(),'Jobs')]"));
		joboption.click();

		Thread.sleep(6000);
		// Get the list of results
		List<WebElement> results = driver.findElements(By.xpath("//ul[@class='job_listings']/li//a"));

		System.out.println("The list of results are : ");
		for (WebElement result : results) {
			System.out.println(result.getText());
		}
		String newpost = results.get(0).getText();
		if (newpost.contains(position)) {
			System.out.println("The posted job is displaying in the list");
		}

	}

	@AfterMethod

	public void TearDown() {
		driver.quit();
	}
}
