package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class ExtReport {
 private ExtReport(){
 }
    public static ExtentReports generateExtReport(){


        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyy HH/mm/ss");
        Date date = new Date();
        String ssDate = format.format(date);


        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("index.html");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(sparkReporter);


        extent.setSystemInfo("Hostname", "RHEL8");
        extent.setSystemInfo("Username", "root");
        extent.setSystemInfo("Executed By User: ", System.getProperty("user.name"));

        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setDocumentTitle("API Framework Report");
        sparkReporter.config().setReportName("API Framework Test results");


        return extent;
    }
}
