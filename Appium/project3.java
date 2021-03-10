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

public class project3 {
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;

	@BeforeTest
	public void setUp() {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceId", "emulator-5554");
		caps.setCapability("deviceName", "Oneplus 7");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.google.android.keep");
		caps.setCapability("appActivity", ".activities.BrowseActivity");
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
	public void googleKeep() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Clicking on add task
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(MobileBy.id("new_note_button")))).click();

		driver.findElement(MobileBy.id("editable_title")).sendKeys("title");
		driver.findElement(MobileBy.id("edit_note_text")).sendKeys("Description");
		Thread.sleep(5000);
		driver.findElement(MobileBy.id("com.google.android.keep:id/menu_reminder")).click();
		driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Pick a date & time']")).click();
		driver.findElement(MobileBy.id("com.google.android.keep:id/time_spinner")).click();
		driver.findElement(MobileBy.id("com.google.android.keep:id/reminder_time_afternoon")).click();
		String time = driver.findElement(MobileBy.xpath(
				"//android.widget.LinearLayout[@content-desc=\"Time - Currently selected - 1:00 PM\"]/android.widget.Spinner/android.widget.TextView"))
				.getText();
		System.out.println("Time selected is " +time);
		driver.findElement(MobileBy.id("save")).click();
		driver.findElement(MobileBy.xpath("//android.widget.ImageButton[@content-desc='Open navigation drawer']"))
				.click();
		String keep = driver.findElement(MobileBy.id("reminder_chip_text")).getText();
		if(keep.contains(time))
		{
			System.out.println("Afternoon time is selected");
		}
		else
			System.out.println("Afternoon is not selected");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
