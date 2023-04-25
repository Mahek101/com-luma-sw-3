package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

import java.util.ArrayList;
import java.util.List;

public class WomenTest extends Utility {
    @Before
    public void setUp() {
        openBrowser("https://magento.softwaretestingboard.com/");
    }

    @Test
    public void verifyTheSortByProductNameFilter()throws InterruptedException {
        //Mouse Hover on Women Menu
        //Mouse Hover on Tops
        mouseHoverToElement(By.xpath("//span[normalize-space()='Women']"), By.cssSelector("a[id='ui-id-9'] span:nth-child(2)"));
        //Click on Jackets
        clickOnElement(By.cssSelector("a[id='ui-id-11'] span"));
        // Storing jackets names in list for Sorting
        List<WebElement> beforeSortValue = driver.findElements(By.xpath("//strong[@class='product name product-item-name']//a"));
        List<String> beforeSortJacketsValue = new ArrayList<>();
        for (WebElement value : beforeSortValue) {
            beforeSortJacketsValue.add(value.getText());
            //Select Sort By filter “Product Name”
            WebElement dropdown = driver.findElement(By.id("sorter"));
            Select select = new Select(dropdown);
            select.selectByVisibleText("Product Name");
            Thread.sleep(1000);
            // After Sorting value
            List<WebElement> afterSortValue = driver.findElements(By.xpath("//strong[@class='product name product-item-name']//a"));
            List<String> afterSortJacketsValue1 = new ArrayList<>();
            Thread.sleep(1000);
            for (WebElement value1 : afterSortValue) {
                afterSortJacketsValue1.add(value1.getText());
            }
            // Sort value for comparison
            beforeSortJacketsValue.sort(String.CASE_INSENSITIVE_ORDER);// Ascending order
            // Verify the products name display in alphabetical order
            Assert.assertEquals(beforeSortJacketsValue, afterSortJacketsValue1);

        }
    }

    @Test
    public void verifyTheSortByPriceFilter()throws InterruptedException{
        //Mouse Hover on Women Menu
        //Mouse Hover on Tops
        mouseHoverToElement(By.xpath("//span[normalize-space()='Women']"), By.cssSelector("a[id='ui-id-9'] span:nth-child(2)"));
        //Click on Jackets
        clickOnElement(By.cssSelector("a[id='ui-id-11'] span"));
        Thread.sleep(1000);
        // Storing jackets names in list for Sorting
        List<WebElement> beforeSortValue = driver.findElements(By.xpath("//strong[@class='product name product-item-name']//a"));
        List<String> beforeSortJacketsValue = new ArrayList<>();
        for (WebElement value : beforeSortValue) {
            beforeSortJacketsValue.add(value.getText());
        }
        //Select Sort By filter “Price”
        WebElement dropdown1 = driver.findElement(By.id("sorter"));
        Select select1 = new Select(dropdown1);
        select1.selectByVisibleText("Price");
        // After Sorting value
        List<WebElement> afterSortValue = driver.findElements(By.xpath("//strong[@class='product name product-item-name']//a"));
        List<String> afterSortJacketsValue1 = new ArrayList<>();
        Thread.sleep(1000);
        for (WebElement value1 : afterSortValue) {
            afterSortJacketsValue1.add(value1.getText());
        }
        // Sort value for comparison
        beforeSortJacketsValue.sort(String.CASE_INSENSITIVE_ORDER);// Ascending order
        // Verify the products name display in alphabetical order
        Assert.assertEquals(beforeSortJacketsValue, afterSortJacketsValue1);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}

