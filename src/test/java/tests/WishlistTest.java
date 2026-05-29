package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;

public class WishlistTest extends BaseClass {
    
    @Test(groups = {"regression", "master"})
    public void test_wishlist() {
        logger.info("Starting WishlistTest");
        try {
            driver.get(rb.getString("appURL"));
            HomePage hp = new HomePage(driver);
            logger.info("Home Page Displayed");
        
            driver.manage().window().maximize();
            
            ProductPage pp = new ProductPage(driver);
            
            pp.search_txt("iMac");
            Thread.sleep(2000);
            logger.info("Entered search keyword: iMac"); 
        
            pp.search_button();
            Thread.sleep(2000);
            
            pp.clickAddToWishlist();
            logger.info("Clicked Add to Wishlist");
            Thread.sleep(2000);
            
            pp.clickWishlistHeaderLink();
            logger.info("Clicked Wishlist header link");
            Thread.sleep(2000);
            
            LoginPage lp = new LoginPage(driver);
            
            lp.setEmail(rb.getString("email"));
            logger.info("Provided Login Email");
            
            lp.setPassword(rb.getString("password"));
            logger.info("Provided Login Password");
            
            lp.clickLogin();
            logger.info("Submitted Login Form");
            Thread.sleep(3000);
            
            boolean notFound = pp.isNotFoundMsgDisplayed();
            
            if (notFound) {
                logger.error("WishList Failed ");
                captureScreen(driver, "test_wishlist_failed");
                Assert.fail("Wishlist displayed search empty error message");
            } else {
                logger.info("Wishlist Test Success");
                Assert.assertTrue(true);
            }
        } catch (Exception e) {
            logger.fatal("WishList Failed: " + e.getMessage());
            Assert.fail(e.getMessage());
        }
        
        logger.info("Finished WishlistTest");
    }
}
