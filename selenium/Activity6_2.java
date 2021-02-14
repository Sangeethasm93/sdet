package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity6_2 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		driver.get("https://training-support.net/selenium/ajax");
		String title = driver.getTitle();
		System.out.println("The title of the page is " + title);

		driver.findElement(By.xpath("//button[contains(text(), 'Change Content')]")).click();

		WebElement placeholder = driver.findElement(By.id("ajax-content"));

		wait.until(ExpectedConditions.textToBePresentInElement(placeholder, "HELLO!"));

		System.out.println(placeholder.getText());

		wait.until(ExpectedConditions.textToBePresentInElement(placeholder, "I'm late!"));

		System.out.println(placeholder.getText());

		driver.close();
	}

}
