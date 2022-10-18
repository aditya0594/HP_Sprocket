package androidpageobjects;


import org.openqa.selenium.By;
import org.testng.Assert;

import base.ScreenBase;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.PointOption;

import static base.TestBase.driver;

public class GalleryPageAndroid extends ScreenBase {
    String Settings;
    
    By Ill_Btn = By.className("android.widget.RelativeLayout");
    By action_bar_burger_icon = By.id("in.amazon.mShop.android.shopping:id/action_bar_burger_icon");
    By setting_bar_burger = By.xpath("//*[@resource-id='in.amazon.mShop.android.shopping:id/drawer_icon']");
    By sign_out_setting_burger = By.xpath(
            "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[5]/android.widget.LinearLayout");
    By sign_out_popup = By.id("android:id/button2");
    By usrname_display_burger = By.id("in.amazon.mShop.android.shopping:id/gno_greeting_text_view");
    By Shop_by_Category = By.xpath("//*[contains(@text,'Shop by Category')]");
    By TV_Appliances_Electronics = By.xpath("//*[contains(@text,'TV, Appliances, Electronics')]");
    By Headphones = By.xpath("//*[contains(@text,'Headphones')]");
    By deals_idp_first_headphone = By.xpath("//*[contains(@text,'Bose SoundSport, Wireless Earbuds, (Sweatproof Bluetooth Headphones for Running and Sports), Aqua')]");
    By Bose = By.xpath("//*[contains(@text,'Bose SoundSport, Wireless Earbuds, (Sweatproof Bluetooth Headphones for Running and Sports), Aqua')]");
    By add_to_cart_button = By.xpath("//*[contains(@text,'Add to Cart')]");
    By gallery_popup = By.id("com.polaroid.universalapp:id/in_app_message_close");
    By gallery_tap = By.id("com.polaroid.universalapp:id/ivItemGridImage");
    By galleryText = By.id("com.polaroid.universalapp:id/textViewMyGallery");
    By cameraBtn = By.id("com.polaroid.universalapp:id/img_capture_camera");
    By cameraFlash = By.id("com.polaroid.universalapp:id/img_flash");
    By touchGallery = By.id("com.polaroid.universalapp:id/ivItemGridImage");
    //com.polaroid.universalapp:id/ivItemGridImage
    

    public void gallery_main_popupClose() {
    
    		if(driver.findElement(gallery_popup).isDisplayed()) {
        		driver.findElement(gallery_popup).click();
        	}
        	else {
        		System.out.println("Popup not display");
        	}
    	
    }
    public void Gallery_Tap() {
    	driver.findElement(gallery_tap).click();
    }
    public void gallery_Verify() {
    	
    	 String Gallery_Veri = driver.findElement(galleryText).getText();
    	 Assert.assertEquals(Gallery_Veri,"MY GALLERY");
    	
    }
  
    
    public void gallery_SwipeCamera() {
    	 org.openqa.selenium.Dimension dim =driver.manage().window().getSize();
    
    	 
    	 int startx = 943;
    	 int starty = 1769 ;
    	 int endx = 126;
    	 int endy = 1871;
    	 
    	 TouchAction action = new  TouchAction(driver);
    	 action.press(PointOption.point(startx, starty))
    	 .moveTo(PointOption.point(endx, endy))
    	 .release()
    	 .perform();
    }
    public void CameraBtn() {
	   
    	driver.findElement(cameraBtn);
    	
   }
    public boolean Verify_Camera() {
 	    return driver.findElement(cameraBtn).isDisplayed();
  }
  
	public void Camera_Flashbutton() {
		driver.findElement(cameraFlash);
		
	}
	public void Gallery_touch1() {
		
		driver.findElement(touchGallery);
	}
    
   
    
}