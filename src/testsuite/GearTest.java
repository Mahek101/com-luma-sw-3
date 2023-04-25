package testsuite;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class GearTest extends Utility {
    @Before
    public void setUp(){
        openBrowser("https://magento.softwaretestingboard.com/");
    }
    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart(){
        //Mouse Hover on Gear Menu
        mouseHoverToSingleElement(By.xpath("//span[normalize-space()='Gear']"));
        //Click on Bags
        clickOnElement(By.xpath("//span[normalize-space()='Bags']"));
        //Click on Product Name ‘Overnight Duffle’
        clickOnElement(By.xpath("//a[normalize-space()='Overnight Duffle']"));
        //Verify the text ‘Overnight Duffle’
        isTextDisplayed(By.xpath("//span[contains(text(),'Overnight Duffle')]"),"Overnight Duffle");
        //Change Qty 3
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.id("qty"));
        actions.doubleClick(element).sendKeys("3").build().perform();
        //Click on ‘Add to Cart’ Button.
        clickOnElement(By.xpath("product-addtocart-button"));
        //Verify the text ‘You added Overnight Duffle to your shopping cart.’
        isTextDisplayed(By.xpath("//body/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]"),"You added Overnight Duffle to your shopping cart.");
        //Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        //Verify the product name ‘Overnight Duffle’
        isTextDisplayed(By.xpath("//td[@class='col item']//a[normalize-space()='Overnight Duffle']"),"Overnight Duffle");
        //Verify the Qty is ‘3’
        isTextDisplayed(By.id("cart-104275-qty"),"3");
        //Verify the product price ‘$135.00’
        isTextDisplayed(By.xpath("//span[contains(text(),'$135.00')]"),"$135.00");
        //Change Qty to ‘5’
        Actions actions1 = new Actions(driver);
        WebElement element1 = driver.findElement(By.id("cart-104275-qty"));
        actions1.doubleClick(element1).sendKeys("5").build().perform();
        //Click on ‘Update Shopping Cart’ button
        clickOnElement(By.xpath("//span[normalize-space()='Update Shopping Cart']"));
        //Verify the product price ‘$225.00’
        isTextDisplayed(By.xpath("//span[contains(text(),'$225.00')]"),"$225.00");
    }
}
