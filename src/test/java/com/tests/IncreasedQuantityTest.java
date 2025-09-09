package com.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.TestNGBase;
import com.pages.IncreasedQuantityPage;

public class IncreasedQuantityTest extends TestNGBase{

    IncreasedQuantityPage page;

    @BeforeClass(alwaysRun = true)
    public void initPageObjects() {
        page = new IncreasedQuantityPage(driver);
    }
 

    @Test
    public void verifyIncreaseQuantityFlow() throws InterruptedException {
        
        Assert.assertTrue(driver.getTitle().contains("Automation Exercise"), "Home page not loaded!");

        
        page.clickViewProduct();
        Assert.assertTrue(driver.getCurrentUrl().contains("product_details"), "Product details not opened!");

        
        page.setQuantity("4");

        
        page.clickAddToCart();
        Thread.sleep(5000);

      
        page.clickViewCart();

        
        String actualQty = page.getCartQuantity();
        Assert.assertEquals(actualQty, "4", "Cart quantity mismatch!");
    }

}
