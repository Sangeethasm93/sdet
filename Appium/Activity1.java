package Appium_Testing.Appium_Testing;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity1 {

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
		wait = new WebDriverWait(driver, 10);
	}

	@Test
	public void test() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.training-support.net/");
		String title = driver.findElementByXPath("//android.view.View[@text ='Training Support']").getText();
		System.out.println("The title of the page is  " + title);
		Assert.assertEquals(title, "Training Support");

		wait = new WebDriverWait(driver, 10);
		driver.findElementByXPath("//android.view.View[@content-desc='About Us']").click();
		
		//driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).scrollIntoView(text(\"Tab Opener\"))")).click();
		String newtitle = driver.findElementByXPath("//android.view.View[@text ='About Us']").getText();
		System.out.println("The new page title is " + newtitle);
		Assert.assertEquals(title, "About Us");

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
