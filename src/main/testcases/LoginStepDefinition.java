package testcases;


import baseClass.TestBase;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class LoginStepDefinition extends TestBase {

	@Test(priority = 1, enabled = false)
	//@Given("^user is already on Login Page$")
	public void user_already_on_login_page() {
		webdriver.get("https://www.amazon.in");
	}

	@Test(priority = 1, enabled = false)
	//@Given("^user is already on Login Page$")
	public void alert_webBaseAlert() throws InterruptedException {
		webdriver.get("https://demo.automationtesting.in/Alerts.html");
		webdriver.findElement(By.xpath("//*[@class='btn btn-danger']")).click();
		Alert alert = webdriver.switchTo().alert();
		alert.accept();
		Thread.sleep(3000);
		webdriver.findElement(By.xpath("//a[@href='#CancelTab']")).click();
		webdriver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
		Thread.sleep(5000);
		alert.dismiss();
		Thread.sleep(5000);
		webdriver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
		alert.accept();
		Thread.sleep(5000);
		webdriver.findElement(By.xpath("//a[@href='#Textbox']")).click();
		webdriver.findElement(By.xpath("//*[@class='btn btn-info']")).click();
		alert.sendKeys("this is aditya");
		Thread.sleep(5000);
		alert.accept();

	}

	@Test(priority = 1, enabled = false)
	//@Given("^user is already on Login Page$")
	public void Windows_Switching() throws InterruptedException {

		webdriver.get("https://demo.automationtesting.in/Windows.html");
// Get parent window handle
		String parentWindowHandle = webdriver.getWindowHandle();
// Click the link/button to open a new window or tab
		webdriver.findElement(By.xpath("//button[@class='btn btn-info']")).click();

// Switch to child window
		Set<String> allWindowHandles = webdriver.getWindowHandles();
		for (String handle : allWindowHandles) {
			if (!handle.equals(parentWindowHandle)) {
				webdriver.switchTo().window(handle);
				break;
			}
		}
// Perform actions in child window
		webdriver.findElement(By.xpath("//div[@class='collapse navbar-collapse justify-content-end']/ul/li[4]")).click();
		Thread.sleep(10000);
		// Switch back to parent window
		webdriver.switchTo().window(parentWindowHandle);
		Thread.sleep(10000);


	}

	@Test(priority = 1, enabled = true)
	//@Given("^user is already on Login Page$")
	public void Frames_Switching() throws InterruptedException {

		webdriver.get("https://demo.automationtesting.in/Frames.html");
		webdriver.findElement(By.xpath("//div[@class='tabpane']/ul/li[2]")).click();
		Thread.sleep(10000);

		String s = "iframe-container";

		webdriver.switchTo().frame(1);
		Thread.sleep(10000);
		webdriver.findElement(By.xpath("//div[@class=\"col-xs-6 col-xs-offset-5\"]//input")).sendKeys("aditya");

	}
}