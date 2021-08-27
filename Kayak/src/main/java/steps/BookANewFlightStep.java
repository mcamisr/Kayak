package steps;

import actions.JavaScriptClick;
import actions.SearchElement;
import com.aventstack.extentreports.ExtentTest;
import models.BookFlight;
import org.openqa.selenium.By;
import utils.ExtentReportBase;
import utils.FormatDate;

import static pages.KayakHomePage.*;

public class BookANewFlightStep {
    private static String FORMAT_XPATH_SELECT_CALENDAR = "//div[@data-month='%s']//div[contains(@class,'days')]//div[contains(text(),'%s')]";

    public static void toCityYouWant(BookFlight bookFlight){
        if(closeItemOrigin().isDisplayed())
            JavaScriptClick.on(closeItemOrigin());
        originCity().sendKeys(bookFlight.getOriginCity());
        optionCity(bookFlight.getOriginCity()).click();
        destinationCity().click();
        destinyCity().sendKeys(bookFlight.getDestinationCity());
        optionCity(bookFlight.getDestinationCity()).click();
        reservationPerson().click();
        selectPassenger(bookFlight);
        selectDate().click();
        selectDateOfFlight(bookFlight);
        searchFlight().click();
    }

    public static void selectDateOfFlight(BookFlight bookFlight) {
        String monthGo = FormatDate.monthAndYear(bookFlight.getGoDate());
        String dayGo = FormatDate.day(bookFlight.getGoDate());
        String monthReturn = FormatDate.monthAndYear(bookFlight.getReturnDate());
        String dayReturn = FormatDate.day(bookFlight.getReturnDate());
        By selectDateGo = By.xpath(String.format(FORMAT_XPATH_SELECT_CALENDAR, monthGo, dayGo));
        By selectDateReturn = By.xpath(String.format(FORMAT_XPATH_SELECT_CALENDAR, monthReturn, dayReturn));
        SearchElement.dateInCalendar(selectDateGo);
        JavaScriptClick.on(selectDayFlight(monthGo, dayGo));
        SearchElement.dateInCalendar(selectDateReturn);
        JavaScriptClick.on(selectDayFlight(monthReturn, dayReturn));
    }

    private static void selectPassenger(BookFlight bookFlight) {
        String[] passenger = bookFlight.getPassengers().split("-");
        String passengerOne = passenger[1];
        String passengerTwo = passenger[3];
        selectMorePassengers(passengerOne).click();
        selectMorePassengers(passengerTwo).click();
    }
}
