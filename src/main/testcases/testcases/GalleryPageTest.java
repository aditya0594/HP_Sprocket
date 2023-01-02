package testcases;

import androidpageobjects.DeletePageAndroid;
import androidpageobjects.GalleryPageAndroid;
import androidpageobjects.LandingPageAndroid;
import base.TestBase;
import org.testng.annotations.Test;

public class GalleryPageTest extends TestBase {
    LandingPageAndroid LandingPage= new  LandingPageAndroid();
    DeletePageAndroid DeletePage = new DeletePageAndroid();

    @Test(priority = 1, enabled = true)
    public void Gallery_verify() throws InterruptedException {
        LandingPage.Normal_login();
        LandingPage.get_started_screen();
        Thread.sleep(2000);
        GalleryPageAndroid.gallery_images();
    }

}
