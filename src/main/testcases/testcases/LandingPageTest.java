
package testcases;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.TestBase;
import androidpageobjects.LandingPageAndroid;


public class LandingPageTest extends TestBase {
	
	public LandingPageAndroid LandingPage = new LandingPageAndroid();


    @Test(priority = 1, enabled = false)
    public void Sign_up() throws InterruptedException {
       LandingPage.Sign_up();
       LandingPage.verify_signup_disble_firstname();
       LandingPage.verify_signup_disble_email();
       LandingPage.verify_signup_disble_password();
       LandingPage.password_validation();
       LandingPage.password_eye_btn();
       LandingPage.Already_have_acct();
    }
    @Test(priority = 2, enabled = false)
    public void Ill_Do_it(){
        LandingPage.ill_do_later();
    }

    @Test(priority = 3, enabled = false)
    public void login() throws InterruptedException {

        LandingPage.login_invalid_email();
        LandingPage.login_invalid_password();
        LandingPage.login();

    }
    @Test (priority = 4,enabled = true)
    public void Get_Started_onboarding() throws InterruptedException {
        LandingPage.get_started_screen();
    }

}
