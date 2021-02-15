package SeleniumActivities;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity8_1 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://training-support.net/selenium/tables");

		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='ui celled striped table']/tbody/tr"));
		List<WebElement> cols = driver
				.findElements(By.xpath("//table[@class='ui celled striped table']/tbody/tr[1]/td"));

		System.out.println("The number of rows are : " + rows.size());
		System.out.println("The number of cols are : " + cols.size());

		List<WebElement> thirdrowvalues = driver
				.findElements(By.xpath("//table[@class='ui celled striped table']/tbody/tr[3]/td"));
		for (WebElement values : thirdrowvalues) {
			System.out.println("The values in third row " + values.getText());

		}

		WebElement cellvalue = driver
				.findElement(By.xpath("//table[@class='ui celled striped table']/tbody/tr[2]/td[2]"));
		System.out.println("The value in 2nd row and 2nd column is " + cellvalue.getText());

		driver.close();
	}

}
