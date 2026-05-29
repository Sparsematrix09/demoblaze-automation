package listeners;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import base.BaseClass;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        if (testClass instanceof BaseClass) {
            WebDriver driver = ((BaseClass) testClass).driver;
            if (driver != null) {
                try {
                    String testName = result.getName();
                    ((BaseClass) testClass).captureScreen(driver, testName);
                    System.out.println(">>> AUTOMATED CAPTURE: Screenshot captured successfully for failed test: " + testName);
                } catch (IOException e) {
                    System.err.println("Exception while taking failure screenshot: " + e.getMessage());
                }
            }
        }
    }
}
