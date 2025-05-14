package JsonServerTests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utilities.ExtManager;
import utilities.ExtReport;
import utilities.ThreadSafeExtLogger;

public class BaseTestC {
 private    ExtentReports extReport;
    @BeforeSuite
    public void startExtReports(){
         extReport =  ExtReport.generateExtReport();
    }

    @BeforeMethod
    public void addComments(ITestResult result){
       ExtentTest extTest= extReport.createTest(result.getMethod().getMethodName());
       ThreadSafeExtLogger.getInstance().setExtTest(extTest);
    }
    @AfterMethod
    public void afterMethod(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {
           ExtManager.logResponse(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test case failed", ExtentColor.RED));
            ExtManager.logResponse(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test case failed", ExtentColor.RED));
        } else if (result.getStatus() == ITestResult.SKIP) {
            ExtManager.logResponse(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test case Skipped", ExtentColor.ORANGE));
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            ExtManager.logResponse(Status.PASS, MarkupHelper.createLabel(result.getName() + " - Test case SUCCESS", ExtentColor.GREEN));
            //logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " - Test case SUCCESS", ExtentColor.GREEN));
        }


    }

    @AfterSuite
    public void endExtReports(){
        extReport.flush();
        ThreadSafeExtLogger.getInstance().removeExtentObject();
    }
}
