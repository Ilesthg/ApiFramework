package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.annotations.Test;



public final class ExtManager {


   /* public static void passResponse(String response) {
        ExtentTest  logger = ThreadSafeExtLogger.getInstance().getExtTest();//remove public and create Manager
        logger.pass(response);
    }*/
    public static void passResponse(String response) {
        ExtentTest  logger = ThreadSafeExtLogger.getInstance().getExtTest();//remove public and create Manager
        logger.pass(MarkupHelper.createCodeBlock(response, CodeLanguage.JSON));
    }
    public static void logResponse(Status status, Markup markup) { //remove public and create Manager
        ExtentTest  logger = ThreadSafeExtLogger.getInstance().getExtTest();
        logger.log(status, markup);
    }
}
