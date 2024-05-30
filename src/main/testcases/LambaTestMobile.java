package testcases;


import baseClass.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static baseClass.TestBase.driver;

public class LambaTestMobile extends TestBase {

    // TO install the appiu




   @Test
           public void AndroidTest() throws MalformedURLException, InterruptedException {
       // Android Test Scenario
       executeAndroidScenario();
   }

    private static void executeAndroidScenario() throws MalformedURLException, InterruptedException {

            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(By.id("com.android.permissioncontroller:id/continue_button")).click();
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]")).click();
        driver.findElement(By.id("android:id/button1")).click();


            // 1. Validate if the app is launched
          /*  System.out.println("App launched successfully: " + driver.isAppInstalled("com.lambdatest.proverbial"));
            //APP_PACKAGE_NAME
            String expectedText = "Hello! Welcome to lambdatest Sample App called Proverbial";
            AndroidElement textView = (AndroidElement) driver.findElement(By.id("com.lambdatest.proverbial:id/Textbox"));
            String actualText = textView.getText();
            if (actualText.equals(expectedText)) {
                System.out.println("App launched successfully.");
            } else {
                 System.out.println("App launch failed.");
            }
            // 2. Print welcome message
            System.out.println("Welcome message: " + driver.findElement(By.id("com.lambdatest.proverbial:id/Textbox")).getText());

            // 3. Click the "Color" button
            driver.findElement(By.id("com.lambdatest.proverbial:id/color")).click();
            Thread.sleep(500);

            // 4. Click the "Color" button again to revert the color
            driver.findElement(By.id("com.lambdatest.proverbial:id/color")).click();
            Thread.sleep(500);

            // 5. Click the "Text" button
            driver.findElement(By.id("com.lambdatest.proverbial:id/Text")).click();
            Thread.sleep(500); // Wait for text update
            System.out.println("Updated text: " + driver.findElement(By.id("com.lambdatest.proverbial:id/Textbox")).getText());

            // 6. Click the "Toast" button
            driver.findElement(By.id("com.lambdatest.proverbial:id/toast")).click();
            Thread.sleep(500);

            // 7. Click the "Notification" button
            driver.findElement(By.id("com.lambdatest.proverbial:id/notification")).click();
            // Wait for notification

            // 8. Click the "GeoLocation" button
            driver.findElement(By.id("com.lambdatest.proverbial:id/geoLocation")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Home\"]")).click();
            // 9. Click the "Browser" button
            driver.findElement(By.id("com.lambdatest.proverbial:id/webview")).click();
            Thread.sleep(500);

            // Enter URL
            driver.findElement(By.className("android.widget.EditText")).sendKeys("www.lambdatest.com");
            driver.findElement(By.id("com.lambdatest.proverbial:id/find")).click();*/
            Thread.sleep(5000); // Wait for page load

    }

   /* private static void executeIOSScenario() throws MalformedURLException, InterruptedException {


        // Perform test steps for iOS
        // 1. Verify if the app is launched
        try {
            // 1. Verify if the app is successfully launched
            System.out.println("App launched successfully: " + driver.isAppInstalled("APP_BUNDLE_ID"));

            // 2. Capture text from XCUIElementTypeTextView named "Textbox"
            String textBoxText = driver.findElement(By.xpath("//*[@name='Textbox']")).getText();
            System.out.println("Text captured from Textbox: " + textBoxText);

            // 3. Click the "Colour" button to change the color and confirm that the color change is
            //reflected by clicking the "Colour" button again to return to black.
            driver.findElement(By.name("Colour")).click();
            Thread.sleep(500);
            // Color revert
            driver.findElement(By.name("Colour")).click();
            Thread.sleep(500);


            // 4. Click on the "Text" button and print the text value from the
            //XCUIElementTypeTextView with the name "Textbox" after clicking the "Text"
            //button.
            driver.findElement(By.xpath("//*[@value='Text']")).click();
            Thread.sleep(5000); // Wait for text update
            textBoxText = driver.findElement(By.name("Textbox")).getText();
            System.out.println("Updated text from Textbox: " + textBoxText);

            // 5. Click the "Toast" button
            driver.findElement(By.name("toast")).click();
            Thread.sleep(500); // Wait for toast

            // 6. Click the "Notification" button
            driver.findElement(By.name("Notification")).click();
            // Allow the notification by interacting with the popup

            // 7. Click the "GeoLocation" button to open the geolocation page
            driver.findElement(By.name("GeoLocation")).click();
            Thread.sleep(500); // Wait for geolocation page to load
            Thread.sleep(5000); // Wait for 5 seconds
            // Navigate back to previous page using the device's back button

            // 8. Navigate back to the previous page using the device's back button
            driver.findElement(By.xpath("//*[@name=\"iphone.homebutton.radiowaves.left.and.right\"]")).click();

            // 9. Click the "Browser" button to open the browser page
            driver.findElement(By.name("Browser")).click();
            Thread.sleep(5000); // Wait for browser page to load
            // Click the "Search" button, enter "LambdaTest" in the search bar, and submit the search
            driver.findElement(By.name("url")).click();
            driver.findElement(By.name("url")).sendKeys("LambdaTest");
            driver.findElement(By.name("Find")).click();
            Thread.sleep(5000); // Wait for search results

            // 10. Verify the status of the test, marking it as "passed."

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }*/
}

