package tests;

import actions.OpenApplicationAction;
import assertions.ValidatePriceLowFlight;
import models.BookFlight;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import steps.BookANewFlightStep;
import steps.SelectLowPriceOfFlight;
import steps.UpdateCurrentFlightStep;
import utils.ExtentReportBase;

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

    @Before
    public void beforeClass(){
        extentReportBase.createReport();
        extentReportBase.createFeature("Nuevo vuelo desde Medellin a San Francisco");
    }

    @Test
    public void newFlightInKayak(){
       OpenApplicationAction.inThePageWithChrome(URL);
       BookANewFlightStep.toCityYouWant(flightResevation);
       UpdateCurrentFlightStep.date(updateFlightResevation);
       SelectLowPriceOfFlight.inKayak();
       ValidatePriceLowFlight.inKayak();
       extentReportBase.flushReport();
    }

    @After
    public void quit(){
        driver().quit();
    }

}
