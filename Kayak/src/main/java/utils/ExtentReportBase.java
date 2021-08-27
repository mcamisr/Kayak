package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportBase {
    public ExtentReports extentReport;
    public ExtentTest extentTest;
    public ExtentTest extentStep;

    public void createReport(){
        extentReport = new ExtentReports();
        ExtentSparkReporter reporter = new ExtentSparkReporter("target/ExtentReport.html");
        reporter.config().setReportName("Kayak Extent Report");
        extentReport.setSystemInfo("Author", "Maria Camila Salas");
        extentReport.attachReporter(reporter);
    }

    public ExtentTest createFeature(String feature) {
        extentTest = extentReport.createTest(feature);
        return extentTest;
    }

    public ExtentTest createScenario(String screnario) {
        extentStep = extentReport.createTest(screnario);
        return extentStep;
    }

    public void flushReport() {
        extentReport.flush();
    }
}
