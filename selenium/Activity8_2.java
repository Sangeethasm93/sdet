package SeleniumActivities;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity8_2 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://training-support.net/selenium/tables");

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr"));
		List<WebElement> cols = driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr[1]/td"));

		System.out.println("The number of rows are : " + rows.size());
		System.out.println("The number of cols are : " + cols.size());

		WebElement cellvalue = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));

		System.out.println("The value in 2nd row and 2nd column before sorting is " + cellvalue.getText());

		driver.findElement(By.xpath("//table[@id='sortableTable']/thead//th[1]")).click();

		System.out.println("The value in 2nd row and 2nd column after sorting is " + cellvalue.getText());
		
		WebElement footer = driver.findElement(By.xpath("//table[@id='sortableTable']/tfoot/tr"));
        System.out.println("Footer value is: " + footer.getText());

		driver.close();

	}

}
