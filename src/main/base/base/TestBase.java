package base;
import java.net.MalformedURLException;

import androidpageobjects.LandingPageAndroid;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import io.appium.java_client.AppiumDriver;
import utils.CommonUtils;
import utils.AppConfigTags;
import utils.Constants;


public class TestBase {

    public static AppiumDriver driver;
    //public LandingPageAndroid LandingPage;


    @BeforeMethod
    public void setUp() throws MalformedURLException {

    	 //configuration items to change the look and feel
         //add content, manage tests etc
        System.out.println("Setup TestCase");
        CommonUtils utils = new CommonUtils();
        utils.setup(AppConfigTags.ANDROID, AppConfigTags.MOTOROLA, Constants.ANDROID_URI);
        driver = utils.driver;
        
    }

//    @BeforeTest
//    public void startapp() throws IOException {
//    	pageObjectConfig();
//        System.out.println("Setup TestCase");
//
//        CommonUtils utils = new CommonUtils();
//
//        utils.setup(AppConfigTags.ANDROID, AppConfigTags.MOTOROLA, Constants.ANDROID_URI);
//        driver = utils.driver;
//    }
	@AfterMethod
	public void Aftertest() {
        driver.resetApp();
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
		
	}
    public By waitForElement(By element) {
        WebDriverWait w = new WebDriverWait(driver,3);
        w.until(ExpectedConditions.presenceOfElementLocated ((By) element));
        return element;
    }
    /*
     * Scroll page down 250 pixel
     */
    public void scrollDown() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)");
    }

    /*
     * Scroll page down pixel
     *
     * @Param pixel pixel to scroll down
     */
    public void scrollDown(String pixel) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0," + pixel + ")", "");
    }

}
