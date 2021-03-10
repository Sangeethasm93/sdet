package Appium_Project;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class project4 {
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;

	@BeforeClass
	public void calc() throws InterruptedException, IOException {
		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceId", "emulator-5554");
		caps.setCapability("deviceName", "Oneplus 7");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.android.chrome");
		caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		caps.setCapability("noReset", true);

		// Instantiate Appium Driver

		try {
			URL remoteurl = new URL("http://0.0.0.0:4723/wd/hub");
			// Initialize driver
			driver = new AndroidDriver<MobileElement>(remoteurl, caps);
			System.out.println("Chrome is open");
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
		wait = new WebDriverWait(driver, 5);
		driver.get("https://www.training-support.net/selenium");
	}

	@Test
	public void chromeAction() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("android.view.View")));
		//driver.findElement(MobileBy.AndroidUIAutomator(
			//	"UiScrollable(UiSelector().scrollable(true)).getChildByText(UiSelector().className(\"android.view.View\"),\"To-Do List\")"))
			//	.click();
		driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollIntoView(text(\"To-Do List\"))")).click();
		String[] array = { "Add tasks to list", "Get number of tasks", "Clear the list" };
		for (String str : array) {
			driver.findElement(MobileBy.id("taskInput")).sendKeys(str);
			driver.findElement(MobileBy.xpath("//android.widget.Button[@text='Add Task']")).click();
		}
		for (String str : array) {
			driver.findElement(MobileBy.xpath("//android.view.View[@text='" + str + "']")).click();
		}
		driver.findElement(MobileBy.xpath("//android.view.View[@text='Clear List']")).click();

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
