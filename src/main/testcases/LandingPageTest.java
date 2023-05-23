
package testcases;
import org.testng.annotations.Test;
import baseClass.TestBase;
import androidpageobjectss.LandingPageAndroid;


public class LandingPageTest extends TestBase {
	
	public LandingPageAndroid LandingPage = new LandingPageAndroid();
    @Test(priority = 1, enabled = true)
    public void Sign_up() throws InterruptedException {
      // LandingPage.verify_signup_disble_firstname();
       LandingPage.verify_signup_disble_email();
       LandingPage.verify_signup_disble_password();
       LandingPage.password_validation();
       LandingPage.password_eye_btn();
       LandingPage.Sign_up();
       LandingPage.get_started_screen_After_signup();
       LandingPage.hamburger_Account_Setting();
       LandingPage.verify_account_name();


    }
    @Test(priority = 2, enabled = true)
    public void login() throws InterruptedException {
        LandingPage.login();
        LandingPage.get_started_screen();
        LandingPage.hamburger_Account_Setting();
        LandingPage.verify_account_name();
    }

    @Test(priority = 3, enabled = false)
    public void Ill_Do_it() throws InterruptedException {
        LandingPage.ill_do_later();
    }
    @Test (priority = 4,enabled = true)
    public void Get_Started_onboarding() throws InterruptedException {
       // LandingPage.ill_do_later();
        LandingPage.get_started_screen_AfterIlldoit_signup();
    }

}
