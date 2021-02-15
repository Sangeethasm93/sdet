package SeleniumActivities;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity9_1 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://training-support.net/selenium/selects");

		Select dropdown = new Select(driver.findElement(By.id("single-select")));

		WebElement chosen = driver.findElement(By.id("single-value"));

		dropdown.selectByVisibleText("Option 2");
		System.out.println(chosen.getText());

		dropdown.selectByIndex(3);
		System.out.println(chosen.getText());

		dropdown.selectByValue("4");
		System.out.println(chosen.getText());

		List<WebElement> alloptions = dropdown.getOptions();
		for (WebElement options : alloptions) {
			System.out.println("The options are : " + options.getText());
		}

		driver.close();

	}

}
