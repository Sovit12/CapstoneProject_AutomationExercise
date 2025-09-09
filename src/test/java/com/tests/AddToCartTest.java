package com.tests;

import com.base.TestNGBase;
import com.pages.AddToCartPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddToCartTest extends TestNGBase {

    private AddToCartPage addToCartPage;

    @BeforeClass(alwaysRun = true)
    public void initPageObjects() {
        addToCartPage = new AddToCartPage(driver);
    }

    @Test(priority = 1)
    public void verifyHomePageIsVisible() {
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Automation Exercise"),
                " Home page is not visible successfully!");
    }

    @Test(priority = 2)
    public void verifyAddToCartFlow() throws InterruptedException {
        
        addToCartPage.clickonProducts();

        Thread.sleep(3000);
        
        addToCartPage.clickHoverProduct1();

        
        addToCartPage.clickContinue();

        
        addToCartPage.clickHoverProduct2();

        
        addToCartPage.clickViewCart();

       
        Assert.assertEquals(addToCartPage.getFirstProductName(), "Blue Top", " First product mismatch!");
        Assert.assertEquals(addToCartPage.getSecondProductName(), "Men Tshirt", " Second product mismatch!");

       
        Assert.assertEquals(addToCartPage.getFirstProductPrice(), "Rs. 500");
        Assert.assertEquals(addToCartPage.getSecondProductPrice(), "Rs. 400");

        Assert.assertEquals(addToCartPage.getFirstProductQuantity(), "1");
        Assert.assertEquals(addToCartPage.getSecondProductQuantity(), "1");

        Assert.assertEquals(addToCartPage.getFirstProductTotal(), "Rs. 500");
        Assert.assertEquals(addToCartPage.getSecondProductTotal(), "Rs. 400");
    }
}
