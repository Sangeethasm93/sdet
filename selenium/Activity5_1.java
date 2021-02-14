package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_1 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/dynamic-controls");
		String title = driver.getTitle();
		System.out.println("The title of the page is " + title);

		WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
		System.out.println(checkbox.isDisplayed());

		driver.findElement(By.xpath("//button[contains(text(), 'Remove checkbox')]")).click();
		System.out.println(checkbox.isDisplayed());

		driver.close();

	}

}
