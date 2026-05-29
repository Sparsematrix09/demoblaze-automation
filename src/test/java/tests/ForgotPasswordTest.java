package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;
import pages.LoginPage;

public class ForgotPasswordTest extends BaseClass {

    @Test(groups = {"regression", "master"})
    public void test_forgotpassword() {
        logger.info("Starting ForgotPasswordTest");
        try {
            driver.get(rb.getString("appURL"));
            HomePage hp = new HomePage(driver);
            logger.info("Home Page Displayed");
        
            driver.manage().window().maximize();
            
            hp.clickMyAccount();
            logger.info("Clicked on My Account");
            hp.clickLogin();
            logger.info("Clicked on Login link");
            Thread.sleep(2000);
                      
            LoginPage lp = new LoginPage(driver);
            lp.clickForgotPassword();
            logger.info("Clicked Forgotten Password link");
            Thread.sleep(2000);
            
            lp.setEmail("srivenfamily@gmail.com");
            logger.info("Entered Recovery Email");
            Thread.sleep(2000);
            
            lp.clickContinueReset();
            logger.info("Clicked continue to trigger reset");
            Thread.sleep(3000);
            
            Assert.assertTrue(true);
        } catch (Exception e) {
            logger.fatal("Forgot Password Failed: " + e.getMessage());
            Assert.fail(e.getMessage());
        }
        logger.info("Finished ForgotPasswordTest");
    }
}
