package listeners;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {
    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;
    
    String repName;
    
    public void onStart(ITestContext testContext) {        
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        repName = "Test-Report-" + timeStamp + ".html";
        
        System.out.println("Generating extent report: " + repName);
                
        // Ensure reports directory exists or ExtentSparkReporter will create it
        sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);
                
        sparkReporter.config().setDocumentTitle("demoblaze Automation Report");
        sparkReporter.config().setReportName("demoblaze Functional Testing");
        sparkReporter.config().setTheme(Theme.DARK);
                
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Application", "demoblaze");
        extent.setSystemInfo("Module", "Customer Portal");
        extent.setSystemInfo("Operating System", System.getProperty("os.name"));
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("Environment", "QA");
    }
    
    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.PASS, "Test Passed");
    }
    
    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getName()); 
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.FAIL, "Test Failed");
        test.log(Status.FAIL, result.getThrowable().getMessage());
        
        try {
            String screenshotPath = System.getProperty("user.dir") + "\\screenshots\\" + result.getName() + ".png";
            test.addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.SKIP, "Test Skipped");
        test.log(Status.SKIP, result.getThrowable().getMessage());
    }
    
    public void onFinish(ITestContext testContext) {
        extent.flush();
    }
}
