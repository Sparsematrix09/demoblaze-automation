package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;
import pages.SearchPage;

public class SearchTest extends BaseClass {
     
    @Test(groups = {"master"})
    public void test_search() {
        logger.info("Starting SearchTest");
        
        try {
            driver.get(rb.getString("appURL"));
            HomePage hp = new HomePage(driver);
            logger.info("Home Page Displayed");
        
            driver.manage().window().maximize();
        
            SearchPage sp = new SearchPage(driver);
        
            sp.searchtxt("iMac");
            Thread.sleep(2000);
            logger.info("Entered Product name: iMac"); 
        
            sp.searchbutton();
            Thread.sleep(2000);
            
            boolean notFound = sp.isPageExists();
            
            if (notFound) {
                logger.error("Search failed: product not found");
                captureScreen(driver, "test_search_failed");
                Assert.fail("Product search iMac returned no results");
            } else {
                logger.info("Search Success: product found");
                Assert.assertTrue(true);
            }
        } catch (Exception e) {
            logger.fatal("Search Failed: " + e.getMessage());
            Assert.fail(e.getMessage());
        }
        
        logger.info("Finished SearchTest");
    }
}
