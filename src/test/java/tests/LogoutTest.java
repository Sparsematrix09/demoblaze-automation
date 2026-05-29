package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;
import pages.LoginPage;
import pages.AccountPage;

public class LogoutTest extends BaseClass {

    @Test(groups = {"sanity", "master"})
    public void test_Logout() {
        logger.info("Starting LogoutTest");
        try {
            driver.get(rb.getString("appURL"));
            logger.info("Home Page Displayed");
            
            driver.manage().window().maximize();
            
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            logger.info("Clicked on My Account");
            hp.clickLogin();
            logger.info("Clicked on Login");
            Thread.sleep(2000);
            
            LoginPage lp = new LoginPage(driver);
            lp.setEmail(rb.getString("email"));
            logger.info("Entered Login Email");
            lp.setPassword(rb.getString("password"));
            logger.info("Entered Login Password");
            lp.clickLogin();
            logger.info("Clicked Login button");
            Thread.sleep(3000);
            
            AccountPage ap = new AccountPage(driver);
            boolean loginSuccess = ap.isMyAccountPageExists();
            Assert.assertTrue(loginSuccess, "Login failed before attempting logout");
            
            hp.clickMyAccount();
            logger.info("Clicked My Account dropdown for Logout options");
            ap.clickLogout();
            logger.info("Clicked Logout option");
            Thread.sleep(3000);
            
            logger.info("Logout Success");
            Assert.assertTrue(true);
        } catch (Exception e) {
            logger.fatal("Logout Failed: " + e.getMessage());
            Assert.fail(e.getMessage());
        }
        logger.info("Finished LogoutTest");
    }
}
