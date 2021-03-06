package SeleniumActivities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity11_1 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		// WebDriverWait wait = new WebDriverWait(driver, 15);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.training-support.net/selenium/javascript-alerts");
		String title = driver.getTitle();
		System.out.println("The title of the page is " + title);

		WebElement simplealert = driver.findElement(By.id("simple"));
		simplealert.click();

		Alert alert = driver.switchTo().alert();

		System.out.println(alert.getText());

		alert.accept();

		driver.close();

	}

}
