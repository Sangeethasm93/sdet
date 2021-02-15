package SeleniumActivities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10_2 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.training-support.net/selenium/input-events");
		String title = driver.getTitle();
		System.out.println("The title of the page is " + title);

		Actions action = new Actions(driver);
		action.sendKeys("S").build().perform();
		String keypressed = driver.findElement(By.id("keyPressed")).getText();
		System.out.println("The key pressed is " + keypressed);

		action.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).build().perform();
		keypressed = driver.findElement(By.id("keyPressed")).getText();
		System.out.println("The key pressed is " + keypressed);

		driver.close();

	}

}
