package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MenTest extends Utility {
    @Before
    public void setUp(){
        openBrowser("https://magento.softwaretestingboard.com/");
    }
    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart(){
         //Mouse Hover on Men Menu
        //Mouse Hover on Bottoms
        mouseHoverToElement(By.xpath("//span[normalize-space()='Men']"),By.id("ui-id-18"));
        //Click on Pants
        clickOnElement(By.cssSelector("a[id='ui-id-23'] span"));
        //Mouse Hover on product name ‘Cronus Yoga Pant’ and click on size 32
        mouseHoverToSingleElement(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
        clickOnElement(By.id("option-label-size-143-item-175"));
        //Mouse Hover on product name ‘Cronus Yoga Pant’
        mouseHoverToSingleElement(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
        //click on colour Black.
        clickOnElement(By.id("option-label-color-93-item-49"));
        //Mouse Hover on product name ‘Cronus Yoga Pant’
        mouseHoverToSingleElement(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
        //click on ‘Add To Cart’ Button.
        clickOnElement(By.xpath("//li[1]//div[1]//div[1]//div[3]//div[1]//div[1]//form[1]//button[1]//span[1]"));
        //Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        isTextDisplayed(By.xpath("//div[@class='message-success success message']//div[1]"),"You added Cronus Yoga Pant to your shopping cart.");
        //Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        //Verify the text ‘Shopping Cart.’
        isTextDisplayed(By.xpath("//span[@class='base']"),"Shopping Cart");
        //Verify the product name ‘Cronus Yoga Pant’
        isTextDisplayed(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"),"Cronus Yoga Pant");
        //Verify the product size ‘32’
        isTextDisplayed(By.xpath("//dd[contains(text(),'32')]"),"32");
        //Verify the product colour ‘Black’
        isTextDisplayed(By.xpath("//dd[contains(text(),'Black')]"),"Black");
    }
    @After
    public void tearDown(){
        closeBrowser();
    }

}
