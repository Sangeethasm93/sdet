package SeleniumActivities;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity9_2 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://training-support.net/selenium/selects");

		WebElement multiselect = driver.findElement(By.id("multi-select"));

		WebElement chosen = driver.findElement(By.id("multi-value"));

		Select select = new Select(multiselect);
		System.out.println(select.isMultiple());

		if (select.isMultiple()) {
			// Select the 'JavaScript' option by visible text
			select.selectByVisibleText("Javascript");
			System.out.println(chosen.getText());

			// Select the 'NodeJS' option by value
			select.selectByValue("node");
			System.out.println(chosen.getText());

			// Select the 4th, 5th, and the 6th options by index
			for (int i = 4; i <= 6; i++) {
				select.selectByIndex(i);
			}
			System.out.println(chosen.getText());

			// Deselect the 'NodeJS' option by value attribute
			select.deselectByValue("node");
			System.out.println(chosen.getText());

			// Deselect the 7th option by index
			select.deselectByIndex(7);
			System.out.println(chosen.getText());

			// Print the first selected option
			System.out.println(select.getFirstSelectedOption().getText());

			// Print all selected options one by one
			List<WebElement> allselectedoptions = select.getAllSelectedOptions();
			for (WebElement optionsselected : allselectedoptions) {
				System.out.println("Options seleted are " + optionsselected.getText());
			}

			// deselect all options

			select.deselectAll();
			System.out.println(chosen.getText());

			driver.close();

		}

	}

}
