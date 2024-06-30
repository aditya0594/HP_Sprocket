package androidpageobjectss;

import baseClass.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class ConnectivityPageAndroid extends TestBase {
    static LandingPageAndroid LandingPage = new LandingPageAndroid();
    private static WebElement printerElement;
    SoftAssert softassert = new SoftAssert();
    GalleryPageAndroid GalleryPage = new GalleryPageAndroid();



    static By Hamburger_Menu = By.id("com.hp.impulse.sprocket:id/toolbar_icon");
    static By Manage_printer = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout[3]/android.widget.LinearLayout/android.widget.ListView[1]/android.widget.RelativeLayout[2]/android.widget.TextView");
    static By Add_New_printer = By.id("com.hp.impulse.sprocket:id/manage_printers_text");
    static By Search_for_printer_pop = By.id("com.hp.impulse.sprocket:id/dialog_title");
    static By Printer_name = By.id("com.hp.impulse.sprocket:id/printer_name");
    static By Close_button = By.id("com.hp.impulse.sprocket:id/dialog_close");
    static By Cant_find_printer = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView");
    static By Loader_find_printer = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ProgressBar");
    static By This_printer_use_wifi = By.id("com.hp.impulse.sprocket:id/dialog_title");
    static By This_printer_use_wifi_Content_verify= By.id("com.hp.impulse.sprocket:id/dialog_wifi_text");
    static By This_printer_use_wifi_NEXT_Btn = By.id("com.hp.impulse.sprocket:id/mEnableWifiNextButton");
    public void hamburger_Account_Setting() {
        waitForElement(Hamburger_Menu);
        driver.findElement(Hamburger_Menu).click();
        waitForElement(Manage_printer);
        driver.findElement(Manage_printer).click();
    }

    public static void Verify_Add_button() throws InterruptedException {
        String Add_New_Printer = driver.findElement(Add_New_printer).getText();
        System.out.println("Button name: " + Add_New_Printer);
        Assert.assertEquals("Add New Printer", Add_New_Printer);
        driver.findElement(Add_New_printer).click();
    }

    public static void Verify_search_printer_popup() throws InterruptedException {
        waitForElement(Add_New_printer);
        driver.findElement(Add_New_printer).click();
        String Search_popup = driver.findElement(Search_for_printer_pop).getText();
        System.out.println("Search for printer title : " + Search_popup);
        Assert.assertEquals("Searching for Printer", Search_popup);
        driver.findElement(Search_for_printer_pop).click();

    }

    private static boolean waitForPrinterToBeFound(AndroidDriver driver, By locator, int timeoutSeconds) {
        long startTime = System.currentTimeMillis();
        long timeoutMillis = timeoutSeconds * 1000;
        boolean printerFound = false;

        while (System.currentTimeMillis() - startTime < 9000) {
            try {
                WebElement printerElement = driver.findElement(locator);
                if (printerElement.isDisplayed()) {
                    printerFound = true;
                    break;
                }
            } catch (Exception e) {
                // Printer element not found, continue waiting
            }
        }
        return printerFound;
    }


    // waitForPrinterToBeFound((AndroidDriver<MobileElement>) driver, Printer_name, 60);
    public static void Verify_search_printer_List() throws InterruptedException {
        waitForElement(Add_New_printer);
        driver.findElement(Add_New_printer).click();
        waitForElement(Search_for_printer_pop);
        driver.findElement(Search_for_printer_pop).click();

    }

    private static boolean isElementPresent(AppiumDriver driver, By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private static void waitForLoaderToDisappear(AppiumDriver driver, By loaderLocator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loaderLocator));
    }

    static By popup_Available_printer = By.id("com.hp.impulse.sprocket:id/dialog_title");
    static By popup_Available_printer_add = By.id("com.hp.impulse.sprocket:id/printer_add");
    public static boolean Verify_search_printer_not_found() throws InterruptedException {
        waitForElement(Add_New_printer);
        driver.findElement(Add_New_printer).click();
        waitForElement(Search_for_printer_pop);
        //  driver.findElement(Close_button).click();
        waitForElement(Cant_find_printer);
        boolean printername_Cant_find = driver.findElement(Cant_find_printer).isDisplayed();
        boolean printername_popup_list = driver.findElement(popup_Available_printer).isDisplayed();
        //  boolean popup_serach = driver.findElement(Search_for_printer_pop).isDisplayed();
        if (printername_Cant_find) {
            driver.findElement(Close_button).click();
            Assert.assertTrue(printername_Cant_find,"Printer not found");
        } else{
            System.out.println("Printer Found");
            driver.findElement(popup_Available_printer_add).click();
        }
        return printername_Cant_find;
    }

    public void This_printer_use_wifi_popup(){



        waitForElement(Add_New_printer);
        driver.findElement(Add_New_printer).click();
        String printe600_name = driver.findElement(Printer_name).getText();
        Assert.assertEquals(printe600_name,"HP Sprocket Studio Plus C2:F6");
        driver.findElement(Printer_name).click();
        waitForElement(This_printer_use_wifi);
        String Title_Of_wifi_popup  = driver.findElement(This_printer_use_wifi).getText();
        Assert.assertEquals(Title_Of_wifi_popup,printe600_name);
        String content_wifi_popup = driver.findElement(This_printer_use_wifi_Content_verify).getText();
        Assert.assertEquals(content_wifi_popup,"On the next screen, please follow instructions to set up your Wi-Fi connection.");
        String Wifi_popup_next_Btn  = driver.findElement(This_printer_use_wifi_NEXT_Btn).getText();
        Assert.assertEquals(Wifi_popup_next_Btn,"NEXT");
        driver.findElement(This_printer_use_wifi_NEXT_Btn).click();
    }

    static By Connect_printer_to_Wifi_Title = By.id("com.hp.impulse.sprocket:id/dialog_title");
    static By Connect_printer_to_Wifi_sub_title = By.id("com.hp.impulse.sprocket:id/dialog_sub_title");
    static By Connect_printer_to_Wifi_sub_title2 = By.id("com.hp.impulse.sprocket:id/dialog_sub_title2");
    static By Connect_printer_to_Wifi_DefaultWIFI_name = By.id("com.hp.impulse.sprocket:id/mEnterWifiNameEdit");
    static By Connect_printer_to_Wifi_Password_field = By.id("com.hp.impulse.sprocket:id/editTextPassword");
    static By Connect_printer_to_Wifi_Connect_Btn = By.id("com.hp.impulse.sprocket:id/mConnectButton");
    static By Toast_message_of_password_empty= By.id("com.hp.impulse.sprocket:id/mConnectButton");

    public void Connect_Printer_to_WiFi(){

        waitForElement(Connect_printer_to_Wifi_Title);
        String connect_printer_to_Wifi_Title = driver.findElement(Connect_printer_to_Wifi_Title).getText();
        Assert.assertEquals(connect_printer_to_Wifi_Title,"Connect Printer to Wi-Fi");
        String connect_printer_to_Wifi_sub_title = driver.findElement(Connect_printer_to_Wifi_sub_title).getText();
        Assert.assertEquals(connect_printer_to_Wifi_sub_title,"Make sure to use a 2.4 GHz network.");
        String connect_printer_to_Wifi_sub_title2 = driver.findElement(Connect_printer_to_Wifi_sub_title2).getText();
        Assert.assertEquals(connect_printer_to_Wifi_sub_title2,"5 GHz networks are not compatible.");
        String connect_printer_to_Wifi_DefaultWIFi_name = driver.findElement(Connect_printer_to_Wifi_DefaultWIFI_name).getText();
        Assert.assertEquals(connect_printer_to_Wifi_DefaultWIFi_name,"Adi");
        String connect_printer_to_Wifi_Password_field = driver.findElement(Connect_printer_to_Wifi_Password_field).getText();
        Assert.assertEquals(connect_printer_to_Wifi_Password_field,"Password");
        String connect_printer_to_Wifi_Connect_Btn = driver.findElement(Connect_printer_to_Wifi_Connect_Btn).getText();
        Assert.assertEquals(connect_printer_to_Wifi_Connect_Btn,"Connect");
        driver.findElement(Connect_printer_to_Wifi_Password_field).sendKeys("");
        driver.findElement(Connect_printer_to_Wifi_Connect_Btn).click();
        waitForElement(Toast_message_of_password_empty);
        boolean Toastmessage_display = driver.findElement(Toast_message_of_password_empty).isDisplayed();
        Assert.assertTrue(Toastmessage_display);
        driver.findElement(Connect_printer_to_Wifi_Password_field).sendKeys("adityaaa");
        driver.findElement(Connect_printer_to_Wifi_Connect_Btn).click();
    }

    static By Connect_Printer_to_WiFi_Cancel_button = By.id("com.hp.impulse.sprocket:id/mCancelButton");

    public void Connect_Printer_to_WiFi_Cancel_button (){

        waitForElement(Connect_Printer_to_WiFi_Cancel_button);
        String connect_Printer_to_WiFi_Cancel_button = driver.findElement(Connect_Printer_to_WiFi_Cancel_button).getText();
        Assert.assertEquals(connect_Printer_to_WiFi_Cancel_button,"Cancel");
        driver.findElement(Connect_Printer_to_WiFi_Cancel_button).click();
    }
    static By Connect_Printer_to_WiFi_Close_button = By.id("com.hp.impulse.sprocket:id/dialog_close");

    public void Connect_Printer_to_WiFi_Close_button (){

        waitForElement(Connect_Printer_to_WiFi_Close_button);
        boolean connect_Printer_to_WiFi_Close_button = driver.findElement(Connect_Printer_to_WiFi_Close_button).isDisplayed();
        Assert.assertTrue(connect_Printer_to_WiFi_Close_button);
        driver.findElement(Connect_Printer_to_WiFi_Close_button).click();
    }
    static By Connected_popup_title = By.id("com.hp.impulse.sprocket:id/dialog_title");
    static By Connected_popup_Content_Setup_Complete = By.id("com.hp.impulse.sprocket:id/update_your_firmware_text");

    public void Connected_popup(){
        waitForElement(Connected_popup_Content_Setup_Complete);
        String connected_popup_Content_Setup_Complete = driver.findElement(Connected_popup_Content_Setup_Complete).getText();
        Assert.assertEquals(connected_popup_Content_Setup_Complete,"Setup is Complete!");

    }

    static By Manage_priter_name_list_HP600 = By.id("com.hp.impulse.sprocket:id/device_list_name");
    public void Connected_printer_listing_name(){

        waitForElement(Manage_priter_name_list_HP600);
        String manage_priter_name_list_HP600 = driver.findElement(Manage_priter_name_list_HP600).getText();
        Assert.assertEquals(Manage_priter_name_list_HP600,"HP Sprocket Studio Plus D6:6C");

    }
    static By Manage_priter_to_be_HP600_remove = By.id("com.hp.impulse.sprocket:id/device_list_name");
    static By Manage_priter_afterRemove_printer_popup_OK_BTN = By.id("com.hp.impulse.sprocket:id/bt_ok");
    public void Connected_printer_listing_name_remove_600printer() throws InterruptedException {

        waitForElement(Manage_priter_to_be_HP600_remove);
       // Slide_touch(1065,509, 19, 498);
        driver.findElement(Manage_priter_afterRemove_printer_popup_OK_BTN).click();
    }


    static By Connect_printer_to_Wifi_Title_AP = By.id("com.hp.impulse.sprocket:id/dialog_title");
    static By Connect_printer_to_Wifi_sub_title_AP = By.id("com.hp.impulse.sprocket:id/dialog_sub_title");
    static By Connect_printer_to_Wifi_sub_title2_AP = By.id("com.hp.impulse.sprocket:id/dialog_sub_title2");
    static By Connect_printer_to_Wifi_DefaultWIFI_name_AP = By.id("com.hp.impulse.sprocket:id/mEnterWifiNameEdit");
    static By Connect_printer_to_Wifi_Password_field_AP = By.id("com.hp.impulse.sprocket:id/editTextPassword");
    static By Connect_printer_to_Wifi_Connect_Btn_AP = By.id("com.hp.impulse.sprocket:id/mConnectButton");
    static By Toast_message_of_password_empty_AP= By.id("com.hp.impulse.sprocket:id/mConnectButton");
    static By No_network_available_AP= By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.LinearLayout/android.widget.TextView");
    static By Hotspot_Mode_popup_title_AP= By.id("com.hp.impulse.sprocket:id/dialog_title");
    static By Hotspot_Mode_popup_title_1_AP= By.id("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]");
    static By Hotspot_Mode_popup_title_2_AP= By.id("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]");
    static By Hotspot_Mode_popup_title_3_AP= By.id("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[3]");
    static By Hotspot_Mode_popup_title_4_AP= By.id("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[4]");
    static By Hotspot_Mode_popup_title_5_AP= By.id("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[5]");
    static By Hoptspot_Mode_Open_setting_btn = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.Button");
    static By Native_Wifi_List = By.className("android.widget.RelativeLayout");
    static By printer_sign = By.xpath("\t\n" +
            "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
            "/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout" +
            "/android.view.ViewGroup/android.widget.LinearLayout[3]/android.widget.FrameLayout" +
            "/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
            "/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ScrollView" +
            "/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView[2]" +
            "/android.widget.LinearLayout[4]/android.widget.LinearLayout" +
            "/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.TextView");
    public void Connect_Printer_to_WiFi_AP(){


        waitForElement(Connect_printer_to_Wifi_Title);
        String connect_printer_to_Wifi_Title = driver.findElement(Connect_printer_to_Wifi_Title_AP).getText();
        Assert.assertEquals(connect_printer_to_Wifi_Title,"Connect Printer to Wi-Fi");
        String connect_printer_to_Wifi_sub_title = driver.findElement(Connect_printer_to_Wifi_sub_title_AP).getText();
        Assert.assertEquals(connect_printer_to_Wifi_sub_title,"Make sure to use a 2.4 GHz network.");
        String connect_printer_to_Wifi_sub_title2 = driver.findElement(Connect_printer_to_Wifi_sub_title2_AP).getText();
        Assert.assertEquals(connect_printer_to_Wifi_sub_title2,"5 GHz networks are not compatible.");
        String connect_printer_to_Wifi_Connect_Btn = driver.findElement(Connect_printer_to_Wifi_Connect_Btn_AP).getText();
        Assert.assertEquals(connect_printer_to_Wifi_Connect_Btn,"Connect");


        //String no_network_available_AP = driver.findElement(No_network_available_AP).getText();
       // Assert.assertEquals(no_network_available_AP,"Other connection options");

        driver.findElement(No_network_available_AP).click();

        //String hotspot_Mode_AP = driver.findElement(Hotspot_Mode_popup_title_AP).getText();
        //Assert.assertEquals(hotspot_Mode_AP,"Hotspot Mode");

       /* String hotspot_Mode_popup_title_1_AP = driver.findElement(Hotspot_Mode_popup_title_1_AP).getText();
        Assert.assertEquals(hotspot_Mode_popup_title_1_AP,"1. Open your phone’s Wi-Fi settings");

        String hotspot_Mode_popup_title_2_AP = driver.findElement(Hotspot_Mode_popup_title_2_AP).getText();
        Assert.assertEquals(hotspot_Mode_popup_title_2_AP,"2. Connect to HP Sprocket Studio Plus xx:xx.");

        String hotspot_Mode_popup_title_3_AP = driver.findElement(Hotspot_Mode_popup_title_3_AP).getText();
        Assert.assertEquals(hotspot_Mode_popup_title_3_AP,"3. Enter password 12345678 and connect.");

        String hotspot_Mode_popup_title_4_AP = driver.findElement(Hotspot_Mode_popup_title_4_AP).getText();
        Assert.assertEquals(hotspot_Mode_popup_title_4_AP,"4. Return to the HP Sprocket App once connected.");

        String hotspot_Mode_popup_title_5_AP = driver.findElement(Hotspot_Mode_popup_title_5_AP).getText();
        Assert.assertEquals(hotspot_Mode_popup_title_5_AP,"5. Warning: Do not close app until connection completes.");
        System.out.println(hotspot_Mode_popup_title_5_AP);*/

        waitForElement(Hoptspot_Mode_Open_setting_btn);
        driver.findElement(Hoptspot_Mode_Open_setting_btn).click();

        waitForElement(printer_sign);
        // Locate the container element that holds the list of Wi-Fi networks
        WebElement wifiListContainer =  driver.findElement(By.className("android.widget.LinearLayout"));
        // Find all the Wi-Fi network elements within the container
        List<WebElement> wifiNetworks = wifiListContainer.findElements(By.className("android.widget.LinearLayout"));

        for (WebElement wifiNetwork : wifiNetworks) {
            // Get the network name of each Wi-Fi network
            String networkName = wifiNetwork.getText();
            System.out.println("this is the output : " + networkName);
        }

    }


}



