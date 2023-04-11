package testcases;

import androidpageobjects.DeletePageAndroid;
import androidpageobjects.GalleryPageAndroid;
import androidpageobjects.LandingPageAndroid;
import base.TestBase;
import org.testng.annotations.Test;

public class GalleryPageTest extends TestBase {
    LandingPageAndroid LandingPage = new LandingPageAndroid();
    DeletePageAndroid DeletePage = new DeletePageAndroid();


    @Test(priority = 1, enabled = true)
    public void Gallery_verify_album() throws InterruptedException {
        LandingPage.get_started_screen_signup();
        GalleryPageAndroid.gallery_album();
    }

    @Test(priority = 2, enabled = true)
    public void Gallery_verify_image() throws InterruptedException {
        LandingPage.get_started_screen_signup();
        GalleryPageAndroid.gallery_images();

    }
    @Test(priority = 3, enabled = true)
    public void Verify_Select_Functionality() throws InterruptedException {
        LandingPage.get_started_screen_signup();
        GalleryPageAndroid.Select_Func();
    }
    @Test(priority = 4, enabled = true)
    public void Verify_Select_Clear() throws InterruptedException {
        LandingPage.get_started_screen_signup();
        GalleryPageAndroid.Select_Clear_func();
    }
    @Test(priority = 5, enabled = true)
    public void Collage_Btn_functionality() throws InterruptedException {
        LandingPage.get_started_screen_signup();
        GalleryPageAndroid.Verify_Collage_btn();
    }
    @Test(priority = 6, enabled = true)
    public void Collage_Img_functionality() throws InterruptedException {
        LandingPage.get_started_screen_signup();
        GalleryPageAndroid.Verify_Collage_Image();
    }
    @Test(priority =7, enabled = true)
    public void Collage_multi_Img_functionality() throws InterruptedException {
        LandingPage.get_started_screen_signup();
        GalleryPageAndroid.Verify_Collage_Multi_Image();
    }

}
