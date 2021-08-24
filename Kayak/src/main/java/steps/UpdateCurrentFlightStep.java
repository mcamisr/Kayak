package steps;

import actions.JavaScriptClick;
import actions.SearchElement;
import actions.WaitNow;
import models.BookFlight;
import org.openqa.selenium.By;
import pages.KayakHomePage;
import pages.LowPriceFlightPage;
import utils.FormatDate;

public class UpdateCurrentFlightStep {
    private final static String FORMAT_XPATH_SELECT_CALENDAR =
            "(//div[contains(@id,'%s')]//div[@class='weeks ']//div[contains(text(),'%s')])[1]";

    public static void date(BookFlight bookFlight){
        String monthGo = FormatDate.monthAndYear(bookFlight.getGoDate());
        String dayGo = FormatDate.day(bookFlight.getGoDate());
        String monthReturn = FormatDate.monthAndYear(bookFlight.getReturnDate());
        String dayReturn = FormatDate.day(bookFlight.getReturnDate());
        By selectDateGo = By.xpath(String.format(FORMAT_XPATH_SELECT_CALENDAR, monthGo, dayGo));
        By selectDateReturn = By.xpath(String.format(FORMAT_XPATH_SELECT_CALENDAR, monthReturn, dayReturn));
        WaitNow.TheElement(KayakHomePage.updateDate(), 10);
        JavaScriptClick.on(KayakHomePage.updateDate());
        SearchElement.dateInCalendar(selectDateGo);
        JavaScriptClick.on(KayakHomePage.selectDayFlight(monthGo, dayGo));
        SearchElement.dateInCalendar(selectDateReturn);
        JavaScriptClick.on(KayakHomePage.selectDayFlight(monthReturn, dayReturn));
        JavaScriptClick.on(KayakHomePage.searchFlight());
        WaitNow.untilTheLoading(60);
    }
}
