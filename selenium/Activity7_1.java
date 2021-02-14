package SeleniumActivities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity7_1 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://training-support.net/selenium/dynamic-attributes");
		String title = driver.getTitle();
		System.out.println("The title of the page is " + title);

		driver.findElement(By.xpath("//input[starts-with(@class, 'username')]")).sendKeys("admin");
		driver.findElement(By.xpath("//input[starts-with(@class, 'password')]")).sendKeys("password");

		driver.findElement(By.xpath("//button[contains(text(), 'Log in')]")).click();

		String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
		System.out.println("The login message is " + loginMessage);

		driver.close();

	}

}
