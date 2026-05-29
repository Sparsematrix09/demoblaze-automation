package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseClass {

    @Test(groups = {"sanity", "master"})
    public void test_Login() {
        logger.info("Starting LoginTest");
        
        try {
            driver.get(rb.getString("appURL"));
            logger.info("Home Page Displayed");
            
            driver.manage().window().maximize();
            
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            logger.info("Clicked on My Account");
            hp.clickLogin();
            logger.info("Clicked on Login link");
            
            LoginPage lp = new LoginPage(driver);
            
            lp.setEmail(rb.getString("email"));
            logger.info("Provided Email");
            
            lp.setPassword(rb.getString("password"));
            logger.info("Provided Password");
            
            lp.clickLogin();
            logger.info("Clicked on Login Button");
            Thread.sleep(3000);
            
            boolean targetpage = lp.isMyAccountPageExists();
            
            if (targetpage) {
                logger.info("Login Success");
                Assert.assertTrue(true);
            } else {
                logger.error("Login Failed");
                captureScreen(driver, "test_Login");
                Assert.assertTrue(false, "My Account page did not exist after login attempt");
            }
        } catch (Exception e) {
            logger.fatal("Login Failed: " + e.getMessage());
            Assert.fail(e.getMessage());
        }
        
        logger.info("Finished LoginTest");
    }
}
