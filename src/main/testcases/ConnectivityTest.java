package testcases;

import androidpageobjectss.ConnectivityPageAndroid;
import androidpageobjectss.LandingPageAndroid;
import baseClass.TestBase;
import org.testng.annotations.Test;

public class ConnectivityTest extends TestBase {
    LandingPageAndroid LandingPage = new LandingPageAndroid();
    ConnectivityPageAndroid Connectivity = new ConnectivityPageAndroid();

    @Test(priority = 1, enabled = true)
    public void Verify_Add_button() throws InterruptedException {
        LandingPage.get_started_screen_AfterIlldoit_signup();
        Connectivity.hamburger_Account_Setting();
        Connectivity.Verify_Add_button();
    }
    @Test(priority = 2, enabled = true)
    public void Verify_Search_for_printer_popup() throws InterruptedException {
        LandingPage.get_started_screen_AfterIlldoit_signup();
        Connectivity.hamburger_Account_Setting();
        Connectivity.Verify_search_printer_popup();
    }
    @Test(priority = 3, enabled = true)
    public void Verify_Search_for_printer_list() throws InterruptedException {
        LandingPage.get_started_screen_AfterIlldoit_signup();
        Connectivity.hamburger_Account_Setting();
        Connectivity.Verify_search_printer_List();

    }

    // Turn of printer for this case
    @Test(priority = 4, enabled = true,description = "Turn off printer for this case")
    public void Verify_Search_for_printer_not_found() throws InterruptedException {
        LandingPage.get_started_screen_AfterIlldoit_signup();
        Connectivity.hamburger_Account_Setting();
        Connectivity.Verify_search_printer_not_found();

    }


    @Test(priority =5 , enabled = true)
    public void Verify_600_STA_printer_Cancel() throws InterruptedException {
        LandingPage.get_started_screen_AfterIlldoit_signup();
        Connectivity.hamburger_Account_Setting();
        Connectivity.This_printer_use_wifi_popup();
        Connectivity.Connect_Printer_to_WiFi_Cancel_button();
    }
    @Test(priority =6 , enabled = true)
    public void Verify_600_STA_printer_Close_button() throws InterruptedException {
        LandingPage.get_started_screen_AfterIlldoit_signup();
        Connectivity.hamburger_Account_Setting();
        Connectivity.This_printer_use_wifi_popup();
        Connectivity.Connect_Printer_to_WiFi_Close_button();
    }
    @Test(priority =7, enabled = true)
    public void Verify_600_STA_printer_Connection() throws InterruptedException {
        LandingPage.get_started_screen_AfterIlldoit_signup();
        Connectivity.hamburger_Account_Setting();
        Connectivity.This_printer_use_wifi_popup();
        Connectivity.Connect_Printer_to_WiFi();
        Connectivity.Connected_popup();
    }
    @Test(priority =8, enabled = true)
    public void Verify_600_STA_printer_Connection_loop_for_5() throws InterruptedException {

        LandingPage.get_started_screen_AfterIlldoit_signup();
        Connectivity.hamburger_Account_Setting();
        for (int i = 0; i <= 5; i++) {
            Connectivity.This_printer_use_wifi_popup();
            Connectivity.Connect_Printer_to_WiFi();
            Connectivity.Connected_popup();
            Connectivity.Connected_printer_listing_name_remove_600printer();
        }
        System.out.println("Tested connection for the 5 times");
    }

    @Test(priority =8, enabled = true)
    public void Verify_600_AP() throws InterruptedException {

        LandingPage.get_started_screen_AfterIlldoit_signup();
        Connectivity.hamburger_Account_Setting();
        Connectivity.This_printer_use_wifi_popup();
        Connectivity.Connect_Printer_to_WiFi_AP();

    }





    }
