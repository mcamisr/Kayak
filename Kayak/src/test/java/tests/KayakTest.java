package tests;

import actions.OpenApplicationAction;
import assertions.ValidatePriceLowFlight;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import models.BookFlight;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import steps.BookANewFlightStep;
import steps.SelectLowPriceOfFlight;
import steps.UpdateCurrentFlightStep;
import utils.ExtentReportBase;
import utils.GetCurrentDriver;

import java.io.File;
import java.io.IOException;

import static utils.GetCurrentDriver.*;

public class KayakTest {
    private final String URL = "https://kayak.com.co/";
    private static ExtentReportBase extentReportBase = new ExtentReportBase();
    private BookFlight flightResevation =
            new BookFlight("Medellín", "San Francisco", "2 - Adultos - 1 - Niño",
            "10/10/2021","20/10/2021");

    private BookFlight updateFlightResevation =
            new BookFlight("Medellín", "San Francisco", "2 - Adultos - 1 - Niño",
                    "12/12/2021","10/01/2022");
    private String screenShot = System.getProperty("user.dir")+"\\artifacts\\goodTest.png";

    @Before
    public void beforeClass(){
        extentReportBase.createReport();
    }

    @Test
    public void newFlightInKayak() throws IOException {
       OpenApplicationAction.inThePageWithChrome(URL);
       ExtentTest parentTest = extentReportBase.createFeature("Search new flight in kayak");
       ExtentTest child = parentTest.createNode("Test 1");
       child.createNode("Select a new flight from medellin to san francisco on the dates " + flightResevation.getGoDate() + " - " + flightResevation.getReturnDate());
       BookANewFlightStep.toCityYouWant(flightResevation);
       child.createNode("Update the dates of the selected flight to "+ updateFlightResevation.getGoDate() + " - " + updateFlightResevation.getReturnDate());
       UpdateCurrentFlightStep.date(updateFlightResevation);
       child.createNode("Select the lowest price of the flight ");
       SelectLowPriceOfFlight.inKayak();
       child.createNode("Validate that the flight with the lowest price has been selected");
       ValidatePriceLowFlight.inKayak();
       parentTest.assignAuthor("Camila Salas");
       WebDriver driver = GetCurrentDriver.driver();
       File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
       FileUtils.copyFile(file, new File(screenShot));
       child.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(screenShot).build());
       extentReportBase.flushReport();
    }

    @After
    public void quit(){
        driver().quit();
    }

}
