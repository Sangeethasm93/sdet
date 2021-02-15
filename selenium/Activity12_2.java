package SeleniumActivities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity12_2 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.training-support.net/selenium/nested-iframes");
		String title = driver.getTitle();
		System.out.println("The title of the page is " + title);

		// Switch to first iFrame on the page
		driver.switchTo().frame(0);

		// Switch to first iFrame in that frame
		driver.switchTo().frame(0);

		// Get heading text in iFrame
		WebElement frameHeading1 = driver.findElement(By.xpath("//div[@class='content']"));
		System.out.println(frameHeading1.getText());

		// Switch back to parent page
		driver.switchTo().defaultContent();

		// Switch to first iFrame on the page
		driver.switchTo().frame(0);

		// Switch to second iFrame in that frame
		driver.switchTo().frame(1);

		// Get heading text in iFrame
		WebElement frameHeading2 = driver.findElement(By.xpath("//div[@class='content']"));
		System.out.println(frameHeading2.getText());

		// Close browser
		driver.close();

	}

}
