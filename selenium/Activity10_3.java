package SeleniumActivities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity10_3 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		// driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://training-support.net/selenium/drag-drop");
		String title = driver.getTitle();
		System.out.println("The title of the page is " + title);

		WebElement ball = driver.findElement(By.id("draggable"));
		WebElement dropzone1 = driver.findElement(By.id("droppable"));
		WebElement dropzone2 = driver.findElement(By.id("dropzone2"));

		Actions action = new Actions(driver);
		action.dragAndDrop(ball, dropzone1).build().perform();
		wait.until(ExpectedConditions.attributeToBeNotEmpty(dropzone1, "background-color"));
		System.out.println("Ball is in dropzone1");

		action.dragAndDrop(ball, dropzone2).build().perform();
		wait.until(ExpectedConditions.attributeToBeNotEmpty(dropzone2, "background-color"));
		System.out.println("Ball is in dropzone2");

		driver.close();

	}

}
