package SeleniumActivities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity12_1 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.training-support.net/selenium/iframes");
		String title = driver.getTitle();
		System.out.println("The title of the page is " + title);

		// Switch to first iFrame on the page
		driver.switchTo().frame(0);

		// Perform operation on the first frame
		WebElement frame1heading = driver.findElement(By.xpath("//div[@class='content']"));
		System.out.println(frame1heading.getText());
		System.out.println(frame1heading.getCssValue("background-color"));

		WebElement button1 = driver.findElement(By.xpath("//button[@class='ui inverted red button']"));
		System.out.println(button1.getText());
		System.out.println(button1.getCssValue("background-color"));
		button1.click();
		System.out.println(button1.getText());
		System.out.println(button1.getCssValue("background-color"));

		// Switch back to parent page
		driver.switchTo().defaultContent();

		// Switch to second iFrame on the page
		driver.switchTo().frame(1);

		// Perform operation on the second frame
		WebElement frame2heading = driver.findElement(By.xpath("//div[@class='content']"));
				//div[@class='content']);
		System.out.println(frame2heading.getText());
		System.out.println(frame2heading.getCssValue("background-color"));

		WebElement button2 = driver.findElement(By.xpath("//button[@class='ui inverted green button']"));
		System.out.println(button2.getText());
		System.out.println(button2.getCssValue("background-color"));
		button2.click();
		System.out.println(button2.getText());
		System.out.println(button2.getCssValue("background-color"));

		// Switch back to parent page
		driver.switchTo().defaultContent();

		driver.close();

	}

}
