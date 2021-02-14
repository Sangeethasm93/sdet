package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_3 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/dynamic-controls");
		String title = driver.getTitle();
		System.out.println("The title of the page is " + title);

		WebElement input = driver.findElement(By.id("input-text"));
		System.out.println(input.isEnabled());

		driver.findElement(By.xpath("//button[contains(text(), 'Enable Input')]")).click();
		System.out.println(input.isEnabled());

		driver.close();
	}

}
