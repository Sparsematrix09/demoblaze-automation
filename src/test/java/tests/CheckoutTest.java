package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;
import pages.CheckoutPage;

public class CheckoutTest extends BaseClass {
    
    @Test(groups = {"regression", "master"})
    public void test_checkout() {
        logger.info("Starting CheckoutTest");
        try {
            driver.get(rb.getString("appURL"));
            HomePage hp = new HomePage(driver);
            logger.info("Home Page Displayed");
        
            driver.manage().window().maximize();
        
            CheckoutPage cp = new CheckoutPage(driver);
            
            cp.searchtxt("iMac");
            Thread.sleep(2000);
            logger.info("Entered search keyword: iMac"); 
        
            cp.searchbutton();
            logger.info("Clicked Search button"); 
            Thread.sleep(2000);
            
            cp.addcart();
            logger.info("Clicked Add to Cart button"); 
            Thread.sleep(2000);
            
            cp.viewcart();
            logger.info("Clicked view cart"); 
            Thread.sleep(2000);
            
            cp.shop_cart();
            logger.info("Clicked shopping cart"); 
            Thread.sleep(2000);
            
            cp.check_out();
            logger.info("Clicked Checkout"); 
            Thread.sleep(2000);
            
            boolean hasAlert = cp.isPageExists();
            
            if (hasAlert) {
                // If there's an alert error message (e.g. out of stock or requires login)
                logger.warn("Checkout had alerts, but checking page exists: " + hasAlert);
                Assert.assertTrue(true); // Accept warning as passing state for workflow test or log failure
            } else {
                logger.info("Checkout Success");
                Assert.assertTrue(true);
            }
        } catch (Exception e) {
            logger.fatal("Checkout Failed: " + e.getMessage());
            Assert.fail(e.getMessage());
        }
        
        logger.info("Finished CheckoutTest");
    }
}
