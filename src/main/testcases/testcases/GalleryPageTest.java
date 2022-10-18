package testcases;

import androidpageobjects.GalleryPageAndroid;
import androidpageobjects.LandingPageAndroid;
import org.testng.annotations.Test;
import base.TestBase;
import androidpageobjects.GalleryPageAndroid;
import androidpageobjects.LandingPageAndroid;

public class GalleryPageTest extends TestBase {

    public LandingPageAndroid LandingPage = new LandingPageAndroid();
    public GalleryPageAndroid galleryPage = new GalleryPageAndroid();

    @Test(priority = 1, enabled = true)
    public void verifyMainGallery() throws Exception {

        System.out.println("My Gallery Closing the Copilot popup");
     	LandingPage.tap_on_ill1();
       	LandingPage.accpt_term();
       	LandingPage.Quicktour();
      //  LandingPage.verify_StartBtn_isdisplay();
     	//LandingPage.verify_Startappbtn_text();
        LandingPage.Start_App_tour();
        //galleryPage.gallery_main_popupClose();
        LandingPage.exitapp();
    
        
//		AmazonHomePage.tapAction_bar_burger_icon();
//		System.out.println("tapAction_bar_burger_icon");
    }
    @Test(priority = 2, enabled = true)
    public void verify_MainGallery() throws Exception {

        System.out.println("My Gallery Verification");
        
        LandingPage.tap_on_ill1();
        wait(10000);
       	LandingPage.accpt_term();
       	LandingPage.Quicktour();
       	LandingPage.Start_App_tour();
       // galleryPage.gallery_main_popupClose();
        galleryPage.Gallery_Tap();
        galleryPage.gallery_Verify();
        LandingPage.exitapp();
        
//		AmazonHomePage.tapAction_bar_burger_icon();
//		System.out.println("tapAction_bar_burger_icon");
    }
    @Test(priority = 3, enabled = true)
    public void verify_MainGallery1() throws Exception {

        System.out.println("My Gallery open camera by sliding ");
        
        LandingPage.tap_on_ill1();
        wait(10000);
       	LandingPage.accpt_term();
       	LandingPage.Quicktour();
        LandingPage.verify_StartBtn_isdisplay();
     	//LandingPage.verify_Startappbtn_text();
        LandingPage.Start_App_tour();
        //galleryPage.gallery_main_popupClose();
        galleryPage.Gallery_touch1();
        //galleryPage.gallery_Verify();
        galleryPage.gallery_SwipeCamera();
        Thread.sleep(2000);
        galleryPage.CameraBtn();
        galleryPage.Verify_Camera();
    }
    
    
    @Test(priority = 3, enabled = false)
        public void verify_Camera_fLash() throws Exception {

        System.out.println("Camera Flash button ");
        
        LandingPage.tap_on_ill1();
        wait(10000);
       	LandingPage.accpt_term();
       	LandingPage.Quicktour();
        LandingPage.verify_StartBtn_isdisplay();
     	LandingPage.verify_Startappbtn_text();
        LandingPage.Start_App_tour();
      //  galleryPage.gallery_main_popupClose();
        galleryPage.Gallery_Tap();
        galleryPage.gallery_SwipeCamera();
        //thread.sleep(2000);
//        gallerypage.camera_flashbutton();
//        gallerypage.camerabtn();
      
        //galleryPage.Verify_Camera();
       
    }


}
