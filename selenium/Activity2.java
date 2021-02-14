package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net");
		String title = driver.getTitle();
		System.out.println("The title of the page is " + title);

		WebElement idlocator = driver.findElement(By.id("about-link"));
		System.out.println("The text of the link is " + idlocator.getText());

		WebElement classlocator = driver.findElement(By.className("ui inverted huge green button"));
		System.out.println("The text of the link is " + classlocator.getText());

		WebElement csslocator = driver.findElement(By.cssSelector(".green"));
		System.out.println("The text of the link is " + csslocator.getText());

		WebElement linktextlocator = driver.findElement(By.linkText("About Us"));
		System.out.println("The text of the link is " + linktextlocator.getText());

		driver.close();

	}

}
