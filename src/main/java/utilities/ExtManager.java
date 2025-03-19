package utilities;

import com.aventstack.extentreports.ExtentReports;
import org.testng.annotations.Test;

public final class ExtManager {

    @Test
    public static void passMessage(){
       ExtentReports extReport =  ExtReport.generateExtReport();


       extReport.flush();
    }
}
