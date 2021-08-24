package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import pages.KayakHomePage;
import utils.GetCurrentDriver;

public class SearchElement {
    private static final int MINIMUM_WAITING_TIME = 60;
    private static final int MAXIMUM_INTERVAL = 10;

    public static void dateInCalendar(By element){
        for (int i= 0; i<= MAXIMUM_INTERVAL; i++) {
            WebElement elementInPage = selectMonth(element);
            System.out.println(elementInPage);
            if(elementInPage == null)
                nextMonth();
            break;
        }
    }

    protected static WebElement selectMonth(By element){
        try {
            return GetCurrentDriver.driver().findElement(element);
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public static void nextMonth(){
        JavaScriptClick.on(KayakHomePage.nextMonth());
    }
}
