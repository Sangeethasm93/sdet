package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_1 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net");
		String title = driver.getTitle();
		System.out.println("The title of the page is " + title);

		WebElement xpathlocator = driver.findElement(By.xpath("//a[@id='about-link']"));
		xpathlocator.click();

		System.out.println("The title of the About Us page is " + driver.getTitle());

		driver.close();

	}

}
