package SeleniumActivities;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity11_4 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		// driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.training-support.net/selenium/tab-opener");
		String title = driver.getTitle();
		System.out.println("The title of the page is " + title);

		// Get parent window handle
		String parentwindow = driver.getWindowHandle();
		System.out.println("parent window is " + parentwindow);

		// open the link in new tab
		driver.findElement(By.id("launcher")).click();

		// get all windows
		Set<String> allwindows = driver.getWindowHandles();
		System.out.println("All window handles: " + allwindows);

		// Loop through each handle
		for (String handle : allwindows) {
			driver.switchTo().window(handle);
		}

		// Print the handle of the current window
		System.out.println("All windows :" + driver.getWindowHandle());

		// Wait for page to load completely
		wait.until(ExpectedConditions.titleIs("Newtab"));

		// Print New Tab Title
		System.out.println("New Tab Title is: " + driver.getTitle());

		// Get heading on new page
		String newtabheading = driver.findElement(By.xpath("//div[@class='content']")).getText();
		System.out.println("New tab heading is: " + newtabheading);

		// click another link to open in new tab
		driver.findElement(By.id("actionButton")).click();

		// get all windows
		allwindows = driver.getWindowHandles();
		System.out.println("All window handles: " + allwindows);

		// Loop through each handle
		for (String handle : allwindows) {
			driver.switchTo().window(handle);
		}

		// Print the handle of the current window
		System.out.println("All windows :" + driver.getWindowHandle());

		// Wait for page to load completely
		wait.until(ExpectedConditions.titleIs("Newtab2"));

		// Print New Tab Title
		System.out.println("New Tab Title is: " + driver.getTitle());

		// Get heading on new page
		newtabheading = driver.findElement(By.xpath("//div[@class='content']")).getText();
		System.out.println("New tab heading is: " + newtabheading);

		driver.close();

	}

}
