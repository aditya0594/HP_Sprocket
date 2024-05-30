package baseClass;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import io.appium.java_client.AppiumDriver;
import utils.CommonUtils;
import utils.AppConfigTags;
import utils.Constants;


public class TestBase {

    public static AndroidDriver<MobileElement> driver;
    public AppiumDriverLocalService service;
    //public LandingPageAndroid LandingPage;


    @BeforeMethod
    public void setUp() throws MalformedURLException {
       /* service = new AppiumServiceBuilder()
                        .withIPAddress("127.0.0.1") // Set IP address to 127.0.0.1
                        .usingPort(4723).build();// Set port to 4723

        service.start();
        if (service.isRunning()) {
            System.out.println("Appium server started successfully.");
        } else {
            System.err.println("Failed to start Appium server.");
        }*/
    	 //configuration items to change the look and feel
         //add content, manage tests etc
        System.out.println("Setup TestCase");
        CommonUtils utils = new CommonUtils();
        utils.setup(AppConfigTags.ANDROID, AppConfigTags.MOTOROLA, Constants.ANDROID_URI);
        driver = (AndroidDriver<MobileElement>) utils.driver;

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
	public void Aftertest() throws InterruptedException {
        driver.quit();
	}
	@AfterSuite
	public void tearDown() {
       // driver.quit();
	}
    @AfterTest
    public void closeApp(){
        //driver.closeApp();
    }
    public static By waitForElement(By element) {
        WebDriverWait w = new WebDriverWait(driver, 3);
        w.until(ExpectedConditions.presenceOfElementLocated ((By) element));
        return element;
    }

    public void scroll_UIautomator(){
        String scrollableList = "new UiScrollable(new UiSelector().scrollable(true))";
        String scrollToText = ".scrollIntoView(new UiSelector().text(\"Your Element Text\"))";
        String scrollToEnd = ".scrollToEnd(1)";
        String command = scrollableList + scrollToText;
        //driver.findElement(AppiumBy.androidUIAutomator(command));

    }

   public static void Tap_screen (int startx, int starty)throws InterruptedException {
        TouchAction action = new  TouchAction(driver);
        action.tap(PointOption.point(startx, starty))
                .release()
                .perform();
    }
  /*  public static void Slide_touch (int startx, int starty, int endX, int endY ) throws InterruptedException {
        // int startx = 568;
        // int starty = 2140 ;
        TouchAction action = new  TouchAction(driver);
        action.press(PointOption.point(startx, starty))
                .waitAction()
                .moveTo(PointOption.point(endX, endY))
                .release()
                .perform();
    }*/



    public static void swipe(int startX, int startY,int endX,int endY) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Object> scrollObject = new HashMap<>();
        scrollObject.put("direction", "down"); // Optionally you can still provide a direction
        scrollObject.put("startX", startX);
        scrollObject.put("startY", startY);
        scrollObject.put("endX", endX);
        scrollObject.put("endY", endY);
        js.executeScript("mobile: dragGesture", scrollObject);
        // Slide_touch_mobile(531, 51, 463, 1094);

    }
    public static void swipeUp(int startX, int startY,int endX,int endY) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Object> scrollObject = new HashMap<>();
        scrollObject.put("direction", "up"); // Optionally you can still provide a direction
        scrollObject.put("startX", startX);
        scrollObject.put("startY", startY);
        scrollObject.put("endX", endX);
        scrollObject.put("endY", endY);
        js.executeScript("mobile: dragGesture", scrollObject);
        // Slide_touch_mobile(531, 51, 463, 1094);

    }

    public static void moveTo(int startX, int startY) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Object> swipeObject = new HashMap<>();
        swipeObject.put("action", "moveTo");
        swipeObject.put("x", startX); // ending x-coordinate
        swipeObject.put("y", startY); // ending y-coordinate
        js.executeScript("mobile: touchAction", swipeObject);
    }
    public static void release(int startX, int startY) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Object> releaseObject = new HashMap<>();
        releaseObject.put("action", "release");
        js.executeScript("mobile: touchAction", releaseObject);
    }
    public static void captureScreenShots(String Feature_name)throws IOException {
        String folder_name = "screenshot";
        File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //Date format fot screenshot file name
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
        //create dir with given folder name
        new File(folder_name).mkdir();
        //Setting file name
        String file_name= Feature_name + df.format(new Date())+".png";
        //coppy screenshot file into screenshot folder.
        //FileUtils.copyFile(f, new File(folder_name + "/" + file_name));
    }
}
