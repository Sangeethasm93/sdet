package SeleniumActivities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10_1 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.training-support.net/selenium/input-events");
		String title = driver.getTitle();
		System.out.println("The title of the page is " + title);

		WebElement cube = driver.findElement(By.id("wrapD3Cube"));

		Actions action = new Actions(driver);

		// Left Click
		action.click(cube);
		WebElement valueofcube = driver.findElement(By.xpath("//div[@class='active']"));
		System.out.println("Left Click: " + valueofcube.getText());

		// Double click
		action.doubleClick(cube).perform();
		valueofcube = driver.findElement(By.xpath("//div[@class='active']"));
		System.out.println("Double Click: " + valueofcube.getText());

		// Right click
		action.contextClick(cube).perform();
		valueofcube = driver.findElement(By.xpath("//div[@class='active']"));
		System.out.println("Right Click: " + valueofcube.getText());

		driver.close();

	}

}
