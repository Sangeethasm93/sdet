package Appium_Testing.Appium_Testing;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class calculator {
	AppiumDriver<MobileElement> driver = null;

	@BeforeClass
	public void calc() throws InterruptedException, IOException {
		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceId", "emulator-5554");
		caps.setCapability("deviceName", "Oneplus 7");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.android.calculator2");
		caps.setCapability("appActivity", "com.android.calculator2.Calculator");

		// Instantiate Appium Driver

		try {
			URL remoteurl = new URL("http://0.0.0.0:4723/wd/hub");
			// Initialize driver
			driver = new AndroidDriver<MobileElement>(remoteurl, caps);
			System.out.println("Calculator is open");
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void multiply() {
		driver.findElementById("digit_7").click();
		driver.findElementById("op_mul").click();
		driver.findElementById("digit_5").click();
		driver.findElementById("eq").click();

		String output = driver.findElementById("result").getText();
		System.out.println(output);
		Assert.assertEquals(output, "35");

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
