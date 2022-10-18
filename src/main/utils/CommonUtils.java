package utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class CommonUtils {


    DesiredCapabilities caps = new DesiredCapabilities();
    String path;
    public AppiumDriver<MobileElement> driver;

    public void setup(String platformName, String deviceName, String uri) throws MalformedURLException {
//        caps.setCapability("platformName", platformName);
//        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"ANDROID");
//        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"ANDROID");
//        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 4a");
       // caps.setCapability(MobileCapabilityType.UDID,"13311JEC205927");
      //  caps.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
        //caps.setCapability("deviceName", deviceName);
        //caps.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
       // caps.setCapability("app", "Chrome");
       // caps.setCapability("noReset", false);
        //caps.setCapability("appPackage", "com.android.chrome");
      //  caps.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
      //  caps.setCapability("deviceName", "Pixel 4a");
    	System.out.println("Session is creating");
		path = System.getProperty("user.dir");
    	caps.setCapability("platformName", "Android");
		caps.setCapability("deviceName", "Galaxy s22 FE");
		caps.setCapability("app", path+"//app//HP600AndMaintenanceRealeaseBuildDate.17.10.2022v2.82.7.apk");
		//caps.setCapability("fullRest", true);
		caps.setCapability("autoGrantPermissions", "true");
        caps.setCapability("udid","RZ8NA1P2S8D");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,AutomationName.ANDROID_UIAUTOMATOR2);

        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);

    }

    public static Properties read_properties() throws IOException {


        File file = new File("src/resources/config.properties");
        Properties prop = new Properties();


        InputStreamReader is = new InputStreamReader(new FileInputStream(file));
        prop.load(is);
        return prop;
    }

    public static void main(String... args) throws IOException {
        CommonUtils.read_properties();
    }

}