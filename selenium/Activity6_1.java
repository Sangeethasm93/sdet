package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity6_1 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		driver.get("https://training-support.net/selenium/dynamic-controls");
		String title = driver.getTitle();
		System.out.println("The title of the page is " + title);

		WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
		WebElement button = driver.findElement(By.xpath("//button[@id='toggleCheckbox']"));

		button.click();

		wait.until(ExpectedConditions.invisibilityOf(checkbox));

		button.click();

		wait.until(ExpectedConditions.visibilityOf(checkbox));

		checkbox.click();

		driver.close();

	}

}
