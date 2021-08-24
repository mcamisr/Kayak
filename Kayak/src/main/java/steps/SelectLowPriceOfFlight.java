package steps;

import actions.ChangeWindow;
import actions.JavaScriptClick;
import actions.WaitNow;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.GetCurrentDriver;

import static pages.LowPriceFlightPage.*;

public class SelectLowPriceOfFlight {
    private static WebElement element;
    public static void inKayak(){
        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            e.printStackTrace(); }
        String lowPrice = getLowPrice().getText();
        WaitNow.untilTheLoading(60);
        JavaScriptClick.on(lowPrice());
        WaitNow.TheElement(getLowPrice(lowPrice),10);
        JavaScriptClick.on(getLowPrice(lowPrice));
        try {
            element = ExpectedConditions.visibilityOf(getOffer(lowPrice)).apply(GetCurrentDriver.driver());
        } catch (NoSuchElementException e) {
            element = null;
        }
        if(element != null)
            JavaScriptClick.on(getOffer(lowPrice));
        ChangeWindow.toNext();
    }
}
