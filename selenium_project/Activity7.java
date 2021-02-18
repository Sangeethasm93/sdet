package Seleniumproject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity7 {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void setup() throws IOException {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 10);
		driver.get("https://alchemy.hguy.co/jobs/");

	}

	@DataProvider(name = "postdetails")
	public static Object[][] jobpostdetails() {
		return new Object[][] { { "sample9@email.com", "sample9jobtitle", "sample description", "https://sampleurl.com",
				"sample company name" } };

	}

	@Test(dataProvider = "postdetails", description = "Actvity 7 - ​Create a new job listing. ")
	public void postajob(String Email, String Jobtitle, String Description, String Url, String Companyname)
			throws InterruptedException {
		// Click on post a job option in menu
		WebElement postajoboption = driver
				.findElement(By.xpath("//ul[@id='primary-menu']//a[contains(text(),'Post a Job')]"));
		postajoboption.click();
		Thread.sleep(5000);
		// Getting webelement location
		WebElement email = driver.findElement(By.id("create_account_email"));
		email.sendKeys(Email);
		WebElement jobtitle = driver.findElement(By.id("job_title"));
		jobtitle.sendKeys(Jobtitle);
		WebElement description = driver.findElement(By.xpath("//iframe[@id='job_description_ifr']"));
		Thread.sleep(3000);
		description.sendKeys(Description);
		WebElement url = driver.findElement(By.id("application"));
		url.sendKeys(Url);
		WebElement companyname = driver.findElement(By.id("company_name"));
		companyname.sendKeys(Companyname);

		WebElement preview = driver.findElement(By.xpath("//input[@value='Preview']"));
		preview.click();
		WebElement submitlisting = driver.findElement(By.xpath("//input[@value='Submit Listing']"));
		submitlisting.click();

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
		if (newpost.contains(Jobtitle)) {
			System.out.println("The posted job is displaying in the list");
		}

	}

	@AfterMethod

	public void TearDown() {
		driver.quit();
	}
}
