package com.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import com.base.TestNGBase;
import com.pages.RegistrationWhileCheckoutPage;

public class RegistrationBeforeCheckoutTest extends TestNGBase {

	RegistrationWhileCheckoutPage checkoutPage;

    @BeforeClass(alwaysRun = true)
    public void initPageObjects() {
        checkoutPage = new RegistrationWhileCheckoutPage(driver);
    }

    @Test
    public void verifyPlaceOrderAfterSignup() throws InterruptedException {
        
        Assert.assertTrue(driver.getTitle().contains("Automation Exercise"), "Home page not visible");

        
        checkoutPage.clickSignupLoginHeader();

        
        checkoutPage.setUsername("Rony");
        checkoutPage.setEmail("rony" + System.currentTimeMillis() + "@test.com");
        checkoutPage.clickSignin();

        checkoutPage.setGender();
        checkoutPage.setPassword("Test@123");
        checkoutPage.setDate("1");
        checkoutPage.setMonths("January");
        checkoutPage.setYears("2000");
        checkoutPage.clickNewsletter();
        checkoutPage.clickSpecial();
        checkoutPage.setFirstname("Rony");
        checkoutPage.setLastname("Mehta");
        checkoutPage.setCompany("TestCompany");
        checkoutPage.setAddress1("123 Main Street");
        checkoutPage.setAddress2("Near Temple");
        checkoutPage.setState("Odisha");
        checkoutPage.setCity("Bhubaneswar");
        checkoutPage.setZipcode("751001");
        checkoutPage.setMobileNumber("9876543210");
        checkoutPage.clickCreate();

        
        Assert.assertEquals(checkoutPage.getAccountCreatedMsg(), "ACCOUNT CREATED!");
        checkoutPage.clickContinue1();

      
        Assert.assertTrue(checkoutPage.getLoggedInAsText().contains("Rony"), "Not logged in properly");

        
        checkoutPage.clickHoverProduct1();

        
        checkoutPage.clickViewCart();

        
        Assert.assertTrue(driver.getCurrentUrl().contains("view_cart"), "Cart page not displayed");

        
        checkoutPage.clickProceedToCheckout();

        
        Assert.assertTrue(checkoutPage.isAddressDetailsVisible(), "Address details missing");
        Assert.assertTrue(checkoutPage.isReviewOrderVisible(), "Review order missing");

        
        checkoutPage.setDescription("Please deliver quickly");
        checkoutPage.clickplaceorder();

        
        checkoutPage.setCardName("Rony M");
        checkoutPage.setCardNumber("4111111111111111");
        checkoutPage.setCardNumberCVC("123");
        checkoutPage.setExpireMonth("12");
        checkoutPage.setExpireYear("2028");

        
        checkoutPage.onClickPayConfirm();

        
        Assert.assertTrue(
            checkoutPage.getSuccessOrderMsg().contains("Your order has been confirmed!"),
            "Order success message not found"
        );

        
        checkoutPage.clickDelete();

        Assert.assertEquals(checkoutPage.getAccountDeletedMsg(), "ACCOUNT DELETED!");
        checkoutPage.clickContinue1();
    }
}
