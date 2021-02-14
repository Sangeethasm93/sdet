package SeleniumActivities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_2 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/simple-form");
		String title = driver.getTitle();
		System.out.println("The title of the page is " + title);

		WebElement firstname = driver.findElement(By.xpath("//input[@id='firstName']"));
		WebElement lastname = driver.findElement(By.xpath("//input[@id='lastName']"));

		firstname.sendKeys("Sample firstname");
		lastname.sendKeys("Sample lastname");

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("sampleemail@gmail.com");
		driver.findElement(By.xpath("//input[@id='number']")).sendKeys("9234567898");

		driver.findElement(By.xpath("//input[@type='submit']")).click();

		Alert alert = driver.switchTo().alert();
		alert.accept();

		driver.close();

	}

}
