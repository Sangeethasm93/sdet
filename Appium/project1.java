package Appium_Project;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class project1 {

	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;

	@BeforeTest
	public void setUp() {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceId", "emulator-5554");
		caps.setCapability("deviceName", "Oneplus 7");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.google.android.apps.tasks");
		caps.setCapability("appActivity", ".ui.TaskListsActivity");
		caps.setCapability("noReset", true);

		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
			System.out.println("Google task is open");
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
		wait = new WebDriverWait(driver, 5);
	}

	@Test
	public void googleTask() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Clicking on add task
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(MobileBy.id("tasks_fab")))).click();
		// Adding 1st task
		driver.findElement(MobileBy.id("add_task_title")).sendKeys("Complete Activity with Google Tasks");

		driver.findElement(MobileBy.id("add_task_done")).click();

		// Clicking on add task
		driver.findElement(MobileBy.id("tasks_fab")).click();
		// Adding 2nd task
		driver.findElement(MobileBy.id("add_task_title")).sendKeys("Complete Activity with Google Keep");

		driver.findElement(MobileBy.id("add_task_done")).click();

		// Clicking on add task
		driver.findElement(MobileBy.id("tasks_fab")).click();
		// Adding 3rd task
		driver.findElement(MobileBy.id("add_task_title")).sendKeys("Complete the second Activity Google Keep");

		driver.findElement(MobileBy.id("add_task_done")).click();

		System.out.println("Tasks added");

		// Asserting
		String task1 = driver
				.findElementByXPath("//android.widget.TextView[@text='Complete Activity with Google Tasks']").getText();
		Assert.assertEquals(task1, "Complete Activity with Google Tasks");
		System.out.println("task1 is displaying");

		String task2 = driver
				.findElementByXPath("//android.widget.TextView[@text='Complete Activity with Google Keep']").getText();
		Assert.assertEquals(task2, "Complete Activity with Google Keep");
		System.out.println("task2 is displaying");

		String task3 = driver
				.findElementByXPath("//android.widget.TextView[@text='Complete the second Activity Google Keep']")
				.getText();
		Assert.assertEquals(task3, "Complete the second Activity Google Keep");
		System.out.println("task3 is displaying");

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
