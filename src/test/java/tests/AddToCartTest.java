package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;
import pages.CartPage;

public class AddToCartTest extends BaseClass {

    @Test(groups = {"regression", "master"})
    public void test_addcart() {
        logger.info("Starting AddToCartTest");
        try {
            driver.get(rb.getString("appURL"));
            HomePage hp = new HomePage(driver);
            logger.info("Home Page Displayed");
             
            driver.manage().window().maximize();
                
            CartPage cp = new CartPage(driver);
            cp.search_txt("iMac");
            Thread.sleep(2000);
            logger.info("Entered search keyword: iMac"); 
                
            cp.search_button();
            Thread.sleep(2000);
            logger.info("Product displayed");
                
            cp.addcart();
            logger.info("Product added to cart");
            Thread.sleep(2000);
            
            cp.viewcart();
            Thread.sleep(2000);
            logger.info("Viewed cart popup");
                
            cp.view();
            Thread.sleep(2000);
            logger.info("Opened Cart page");
                
            String confmg = cp.getConfirmationMsg();
               
            if (confmg.contains("Success: You have added iMac to your shopping cart!") || confmg.contains("Success")) {
                logger.info("Add To Cart Success");
                Assert.assertTrue(true);
            } else {
                logger.error("Add To Cart Failed");
                captureScreen(driver, "test_addcart_failed");
                Assert.fail("Cart confirmation did not match: " + confmg);
            }
        } catch (Exception e) {
            logger.fatal("Add To Cart Failed: " + e.getMessage());
            Assert.fail(e.getMessage());
        }
        logger.info("Finished AddToCartTest");
    }
}
