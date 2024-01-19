package baseClass;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import io.appium.java_client.AppiumDriver;
import utils.CommonUtils;
import utils.AppConfigTags;
import utils.Constants;


public class TestBase {

    public static AppiumDriver driver;
    public static WebDriver webdriver;
    String drivertype = "chrome";
    //public LandingPageAndroid LandingPage;


    @Parameters("chrome")
    @BeforeMethod
    public void setUp() throws IOException, InterruptedException {
        switch(drivertype){
            case("appium"):
                CommonUtils.startServer();
                System.out.println("Setup TestCase");
                CommonUtils utils = new CommonUtils();
                utils.setup(AppConfigTags.ANDROID, AppConfigTags.MOTOROLA, Constants.ANDROID_URI);
                driver = utils.driver;
                break;
            case("chrome"):
                System.setProperty("webdriver.chrome.driver", "Chrome Latest Version/chromedriver_win.exe");
                ChromeOptions options = new ChromeOptions();
                webdriver = new ChromeDriver(options);
                webdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
    	 //configuration items to change the look and feel
         //add content, manage tests etc


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
        if(drivertype == "Chrome")
        {
           // driver.closeApp();
        }
        else
        {
            webdriver.quit();
        }
	}
	@AfterSuite
	public void tearDown() {
       // driver.quit();
	}
    @AfterTest
    public void closeApp(){
        if(drivertype == "appium")
        {
            //driver.closeApp();
        }
        else
        {
            webdriver.quit();
        }
    }
 /*   @AfterClass
    public void appiumEnd() throws IOException, InterruptedException {
        if(drivertype == "appium")
        {
            CommonUtils.killServer();
        }
    }*/
    public static void waitForElement(By element) {
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(3));
        w.until(ExpectedConditions.presenceOfElementLocated ((By) element));
    }

    public void scrollDown() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)");
    }
    public void scrollDown(String pixel) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0," + pixel + ")", "");
    }
//    public static void Tap_screen (int startx, int starty) throws InterruptedException {
//       // int startx = 568;
//       // int starty = 2140 ;
//        TouchAction action = new  TouchAction(driver);
//        action.tap(PointOption.point(startx, starty))
//                .release()
//                .perform();
//    }
//    public static void Slide_touch (int startx, int starty, int endX, int endY ) throws InterruptedException {
//        // int startx = 568;
//        // int starty = 2140 ;
//        TouchAction action = new  TouchAction(driver);
//        action.press(PointOption.point(startx, starty))
//                .waitAction()
//                .moveTo(PointOption.point(endX, endY))
//                .release()
//                .perform();
//    }

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
        FileUtils.copyFile(f, new File(folder_name + "/" + file_name));
    }
}
