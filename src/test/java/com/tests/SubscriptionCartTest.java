package com.tests;

import com.base.TestNGBase;
import com.pages.SubscriptionCartPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SubscriptionCartTest extends TestNGBase {

    private SubscriptionCartPage subscriptionCartPage;

    @BeforeClass(alwaysRun = true)
    public void initPageObjects() {
        subscriptionCartPage = new SubscriptionCartPage(driver);
    }

    @Test(priority = 1)
    public void verifyHomePageIsVisible() {
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Automation Exercise"),
                "Home page is not visible successfully!");
    }

    @Test(priority = 2)
    public void verifySubscriptionFlow() throws InterruptedException {
        
        subscriptionCartPage.clickCart();

        
        subscriptionCartPage.scrollToFooter();

        Assert.assertTrue(subscriptionCartPage.isSubscriptionHeadingVisible(),
                "'SUBSCRIPTION' heading not visible!");

        
        subscriptionCartPage.setEmail("testemail" + System.currentTimeMillis() + "@gmail.com");
        subscriptionCartPage.clickArrow();

      
        String successMsg = subscriptionCartPage.getSuccessMessage();
        Assert.assertEquals(successMsg.trim(), "You have been successfully subscribed!",
                "Subscription success message not matched!");
    }
}
