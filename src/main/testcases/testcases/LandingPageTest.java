
package testcases;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.TestBase;
import androidpageobjects.LandingPageAndroid;


public class LandingPageTest extends TestBase {
	
	public LandingPageAndroid LandingPage = new LandingPageAndroid();


    @Test(priority = 1, enabled = true)
    public void Sign_up() throws InterruptedException {
      //  LandingPage.Sign_up();
        LandingPage.verify_signup_disble_firstname();
      //  LandingPage.verify_signup_disble_email();
       // LandingPage.verify_signup_disble_password();
       // LandingPage.password_validation();
        LandingPage.password_eye_btn();

    }




    @Test(priority = 2,enabled = false )
    public void verifyILL() {
    	System.out.println("Verify the functionality of the ill do it later");
    	Assert.assertTrue(LandingPage.VerifyTapill());
    	LandingPage.tap_on_ill1();
        LandingPage.exitapp();
        
    }
    @Test(priority = 3, enabled = false)
    public void verify_Login_Btn() {
    	
        System.out.println("Verify the Sign in present button");
        Assert.assertTrue(LandingPage.VerifySignInButtonDash());
        //LandingPage.tapSignInOnLandingPage();
        LandingPage.exitapp();
    }
    

    
    @Test(priority = 4, enabled = false)
    public void verifyInvalidEmail() throws InterruptedException {
    	
        System.out.println("Verify the Invaild Email");
//        LandingPage.invalid_EnterNumberOrEmail();
        LandingPage.enterPassword();
        LandingPage.tapSignInSubmit();
        LandingPage.VerifyFieldvalidationEmail();
        LandingPage.exitapp();
       
    }
    @Test(priority = 4, enabled = false)
    public void verifyInvalidPassword(){
    	
        System.out.println("Verify the Invaild Email");
//        LandingPage.enterNumberOrEmail();
        LandingPage.invalidEnterPassword();
        LandingPage.tapSignInSubmit();
        LandingPage.VerifyFieldvalidationPass();
        LandingPage.exitapp();
       
    }
    
    @Test(priority = 5, enabled = false )
    public void verifyQuicktour_StartBTn() {

    	LandingPage.tap_on_ill1();
       	LandingPage.accpt_term();
       	LandingPage.Quicktour();
        LandingPage.verify_StartBtn_isdisplay();
     	LandingPage.verify_Startappbtn_text();
        LandingPage.Start_App_tour();
        LandingPage.exitapp();
    }
    @Test(priority = 6, enabled = false )
    public void verifySignupBt_Login(){

        System.out.println("Verify the Signup button on login page");
       // LandingPage.tapSignInOnLandingPage();
        LandingPage.VerfySignupBtnLogin();
        LandingPage.SignupBtnLogin();
        LandingPage.exitapp();

    }
    @Test(priority = 7, enabled = false )
    public void VerifyForgetPassword() throws InterruptedException {
        System.out.println("Verify Forget password email send on email");
        Thread.sleep(3000);
       // LandingPage.tapSignInOnLandingPage();
        Thread.sleep(3000);
        LandingPage.verify_forgetpasswordbtn();
        LandingPage.forget_password();
        LandingPage.forget_password_successful();
        LandingPage.exitapp();
    }
    @Test(priority = 8, enabled = false )
    public void VerifyForgetPassword_invalidEmail(){
        System.out.println("Verify Forget password with invalid Email id ");
      //  LandingPage.tapSignInOnLandingPage();
        LandingPage.forget_passwordInvaild();
        LandingPage.verify_Invalid_ForgetEmail();
        LandingPage.exitapp();
    }

    @Test(priority = 9, enabled = false)
    public void randomEmail()  {
        LandingPage.generateRandomString();
    }
    @Test(priority = 10, enabled = true)
    public void SignupForm() throws InterruptedException {
        LandingPage.Signup();
    }
}
