package androidpageobjects;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;

public class GalleryPageAndroid extends TestBase {

    static By Gallery_each_image = By.id("Gallery_each_image");
    //By Gallery_each_image = By.id("com.hp.impulse.sprocket:id/thumbnail");
    //
    ///hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.ScrollView/android.widget.RelativeLayout/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]
    public static void gallery_images(){



        List<WebElement> allLinks = driver.findElements(By.id("com.hp.impulse.sprocket:id/item_list_view"));

        Iterator<WebElement> itr = allLinks.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next().getSize());
        }

       // List<Boolean> image_count = driver.findElements(Gallery_each_image);
       // int totalimages = image_count.size();
       // for(int i=1;i<=totalimages;i++) {
       //         image_count.add(driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.ScrollView/android.widget.RelativeLayout/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout["+i+"]")).isDisplayed());
       //         System.out.println(totalimages);


    }
}

// List<WebElement> PMPageCMList = driver.findElements(By.xpath("//*[@id='collapseCM']/div[2]/div[2]"));
//int totalcms = PMPageCMList.size();
//for(int i=1;i<=totalcms;i++){
//    CaseManagersreceivingreminders.add(driver.findElement(By.xpath("//*[@id='collapseCM']/div[2]/div[2]/div"+"["+i+"]"+"/span")).getText());
//  System.out.println(CaseManagersreceivingreminders);