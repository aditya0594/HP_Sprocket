package testcases;


import baseClass.TestBase;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Array;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class LoginStepDefinition extends TestBase {

	@Test(priority = 1, enabled = true)
	//@Given("^user is already on Login Page$")
	public void user_already_on_login_page() {
		webdriver.navigate().to("https://www.amazon.in");
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

	@Test(priority = 1, enabled = false)
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

	@Test(priority = 1, enabled = false)
	public void Scroll_using_javascript() throws InterruptedException {
		webdriver.get("https://demo.automationtesting.in/Register.html");
		webdriver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(webdriver,Duration.ofSeconds(3));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='secondpassword']")));
		Thread.sleep(10000);
		//WebElement elementtoscroll = webdriver.findElement(By.xpath("//input[@id='secondpassword']"));


		// scroll to the element on the page
		JavascriptExecutor js = (JavascriptExecutor)webdriver;
		//js.executeScript("arguments[0].scrollIntoView();",element );

		// scroll to the bottom of the page
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

		// scroll by the specific pixels
		js.executeScript("window.scrollBy(0,500);");
	}

	@Test(priority = 1, enabled = false)
	public void Action_class () throws InterruptedException {

		webdriver.get("https://demo.automationtesting.in/Register.html");
		//webdriver.navigate().to();
				WebDriverWait wait = new WebDriverWait(webdriver,Duration.ofSeconds(5));
				WebElement movetoElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='First Name']")));
	//	WebElement movetoElement = webdriver.findElement(By.xpath("//input[@class='form-control ng-pristine ng-invalid ng-invalid-required ng-touched']"));
		webdriver.manage().window().maximize();
		Actions action = new Actions(webdriver);
		Thread.sleep(3000);    
		action.moveToElement(movetoElement).build().perform();
	}
		@Test(priority = 1, enabled = false)
		public void Headleass_browser() throws InterruptedException {
		WebDriver headdriver = new HtmlUnitDriver();
			headdriver.get("https://demo.automationtesting.in/Alerts.html");
			headdriver.findElement(By.xpath("//*[@class='btn btn-danger']")).click();
			Alert alert = headdriver.switchTo().alert();
			alert.accept();
			Thread.sleep(3000);
			headdriver.findElement(By.xpath("//a[@href='#CancelTab']")).click();
			headdriver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
			Thread.sleep(5000);
			alert.dismiss();
			Thread.sleep(5000);
			headdriver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
			alert.accept();
			Thread.sleep(5000);
			headdriver.findElement(By.xpath("//a[@href='#Textbox']")).click();
			headdriver.findElement(By.xpath("//*[@class='btn btn-info']")).click();
			alert.sendKeys("this is aditya");
			Thread.sleep(5000);
			alert.accept();

		}
		@Test(priority = 1, enabled = false)
		public void Findelements_List() throws InterruptedException {
			webdriver.get("https://demo.automationtesting.in/Register.html");
			WebDriverWait wait = new WebDriverWait(webdriver,Duration.ofSeconds(5));
			//	WebElement movetoElement = webdriver.findElement(By.xpath("//input[@class='form-control ng-pristine ng-invalid ng-invalid-required ng-touched']"));
			List<WebElement> list =webdriver.findElements(By.xpath("//div[@class='col-md-4 col-xs-4 col-sm-4']//input"));
			System.out.println("this is the list of elements" + list.size());
		}

	@Test(priority = 1, enabled = true)
	public void tooltip() throws InterruptedException {
		webdriver.get("https://demo.automationtesting.in/Register.html");
		WebDriverWait wait = new WebDriverWait(webdriver, Duration.ofSeconds(2) );
		WebElement movetoElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='First Name']")));
		//	WebElement movetoElement = webdriver.findElement(By.xpath("//input[@class='form-control ng-pristine ng-invalid ng-invalid-required ng-touched']"));
		webdriver.manage().window().maximize();
		Actions action = new Actions(webdriver);
		action.moveToElement(movetoElement).build().perform();
		Thread.sleep(3000);
		String tooltip_text = movetoElement.getText();
		System.out.println("text : "+ tooltip_text);
	}
	@DataProvider(name = "data-provider")
	public Object[][] dataprovidermethod() {
		return new Object[][]{{"data1"},{"data2"}};
	}
	@Test(priority = 1, enabled = false, dataProvider = "data-provider")
	public void data_provider_exam(String data) throws InterruptedException {
		Reporter.log("this is data showing");
		System.out.println("Data is: " + data);
	}

	@Test(priority = 0, enabled = false)
	public void ConvertArray_in_ArrayList(String data) throws InterruptedException {

		String[] aditya = {"aditya","Pawar"};
		// conver array into array list using the AsList

		ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(aditya));
		System.out.println(arrayList);

	}

	/*public static void main(String[] args){
		String[] aditya = {"aditya","Pawar"};
		// conver array into array list using the AsList

		ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(aditya));
		System.out.println(arrayList);

		// by usage of map and the hashmap

		Map<String , String > hashmap = new HashMap<String, String>();
		hashmap.put("aditya", "2");
		hashmap.put("pawar", "3");
		hashmap.put("","");
		hashmap.put("geeta","subhash");

		System.out.println("hashmapp example all keyset: "+ hashmap.keySet());
		System.out.println("hashmapp example all values: "+ hashmap.values());

		for(Map.Entry<String, String> en : hashmap.entrySet()){
			System.out.println(en.getKey()+" = "+ en.getValue() );
		}

		System.out.println("get the value : "+ hashmap.get("subhash"));

	}*/
}