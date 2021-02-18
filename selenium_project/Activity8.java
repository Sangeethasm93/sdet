package Seleniumproject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity8 {

	WebDriver driver;
	WebDriverWait wait;
	Properties prop;
	FileInputStream ip;

	@BeforeMethod
	public void setup() throws IOException {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 10);
		driver.get(
				"https://alchemy.hguy.co/jobs/wp-login.php?redirect_to=https%3A%2F%2Falchemy.hguy.co%2Fjobs%2Fwp-admin%2F&reauth=1");
		/*prop = new Properties();
		ip = new FileInputStream("//NewProject//src//Seleniumproject//Staticvalues.properties");
		prop.load(ip);*/

	}

	@Test(description = "Actvity 8 - ​Visit the site’s backend and login. ")
	@Parameters({ "username", "password" })
	public void backendlogin(String username, String password) throws InterruptedException {
		
		WebElement Username = driver.findElement(By.id("user_login"));
		WebElement Password = driver.findElement(By.id("user_pass"));
		Username.sendKeys(username);
		Password.sendKeys(password);
		WebElement loginbutton = driver.findElement(By.xpath("//input[@value='Log In']"));
		loginbutton.click();
		Thread.sleep(5000);
		WebElement loggedin = driver.findElement(By.xpath("//div[contains(text(),'Dashboard')]"));
		Assert.assertTrue(loggedin.isDisplayed());
	}
	
	/*@Test(description = "Actvity 8 - ​Visit the site’s backend and login. ")
	public void backendlogin2() {

		String Uname = prop.getProperty("username");
		String Pwd = prop.getProperty("password");
		WebElement Username = driver.findElement(By.id("user_login"));
		WebElement Password = driver.findElement(By.id("user_pass"));
		Username.sendKeys(Uname);
		Password.sendKeys(Pwd);
		WebElement loginbutton = driver.findElement(By.xpath("//input[@value='Log In']"));
		loginbutton.click();
		Thread.sleep(5000);
		WebElement loggedin = driver.findElement(By.xpath("//div[contains(text(),'Dashboard')]"));
		Assert.assertTrue(loggedin.isDisplayed());

	}*/

	
	
	@AfterMethod

	public void TearDown() {
		driver.quit();
	}
}
