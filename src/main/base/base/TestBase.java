package base;
import java.net.MalformedURLException;

import androidpageobjects.LandingPageAndroid;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import androidpageobjects.LandingPageAndroid;
import utils.CommonUtils;
import utils.AppConfigTags;
import utils.Constants;


public class TestBase {

    public static AppiumDriver driver;
    public LandingPageAndroid LandingPage;

    
    @BeforeMethod
    public void setUp() throws MalformedURLException {

    	 //configuration items to change the look and feel
         //add content, manage tests etc

        pageObjectConfig();
        System.out.println("Setup TestCase");

        CommonUtils utils = new CommonUtils();

        utils.setup(AppConfigTags.ANDROID, AppConfigTags.MOTOROLA, Constants.ANDROID_URI);
        driver = utils.driver;
       
        
    }

    private void pageObjectConfig() {

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
		
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
		
	}
	

	

}
