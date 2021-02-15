package SeleniumActivities;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity12_3 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.training-support.net/selenium/popups");
		String title = driver.getTitle();
		System.out.println("The title of the page is " + title);

		WebElement signin = driver.findElement(By.xpath("//button[@data-tooltip='Click to sign in']"));
		Actions action = new Actions(driver);
		action.moveToElement(signin).pause(Duration.ofSeconds(2)).build().perform();
		String tooltip = signin.getAttribute("data-tooltip");
		System.out.println("Tooltip txt is " + tooltip);

		signin.click();

		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();

		String message = driver.findElement(By.id("action-confirmation")).getText();
		System.out.println(message);

		driver.close();

	}

}
