package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;
import pages.RegistrationPage;

public class RegistrationTest extends BaseClass {
    
    @Test(groups = {"regression", "master"})
    public void test_account_Registration() {
        logger.info("Starting RegistrationTest");
        try {
            driver.get(rb.getString("appURL"));
            logger.info("Home Page Displayed");
         
            driver.manage().window().maximize();
            
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            logger.info("Clicked on My Account");
            hp.clickRegister();
            logger.info("Clicked on Register");
            
            RegistrationPage regpage = new RegistrationPage(driver);
            
            regpage.setFirstName("kween");
            logger.info("Provided First Name");
             
            regpage.setLastName("krakue");
            logger.info("Provided Last Name");
             
            regpage.setEmail(randomestring() + "@gmail.com");
            logger.info("Provided Email");
             
            regpage.setTelephone("5105551212");
            logger.info("Provided Telephone");
             
            regpage.setPassword("kween");
            logger.info("Provided Password");
            
            regpage.setConfirmPassword("kween");
            logger.info("Provided Confirmed Password");
            
            regpage.setPrivacyPolicy();
            logger.info("Set Privacy Policy");
             
            regpage.clickContinue();
            logger.info("Clicked on Continue");
         
            Thread.sleep(3000);
         
            String confmsg = regpage.getConfirmationMsg();
            
            if (confmsg.equals("Your Account Has Been Created!")) {
                logger.info("Account Registration Success");
                Assert.assertTrue(true);
            } else {
                logger.error("Account Registration Failed");
                captureScreen(driver, "test_account_Registration");
                Assert.fail("Confirmation message did not match: " + confmsg);
            }
            
        } catch (Exception e) {
            logger.fatal("Account Registration Failed: " + e.getMessage());
            Assert.fail(e.getMessage());
        }
  
        logger.info("Finished RegistrationTest");
    } 
}
