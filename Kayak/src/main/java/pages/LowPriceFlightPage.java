package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.GetCurrentDriver.*;

public class LowPriceFlightPage {

    public static WebElement lowPrice(){
        return driver().findElement(By.xpath("//a[contains(@aria-label,'Precio más bajo')]"));
    }

    public static WebElement getLowPrice(){
        return driver()
                .findElement(By.xpath("//a[contains(@aria-label,'Precio más bajo')]//span[contains(@class,'price')]"));
    }

    public static WebElement getLowPrice(String lowPrice){
        return driver()
                .findElement(By
                        .xpath("//div[@class='resultInner']//div[@class='booking']//span[contains(@class,'person-price')]//span[contains(text(),'"+lowPrice+"')]//following::div[@role='listbox']//a[contains(@aria-label,'"+lowPrice+"')]"));
    }
    public static WebElement getOffer(String lowPrice){
        return driver()
                .findElement(By
                        .xpath("(//div[contains(@class,'Flights-Results')]//section[contains(@class,'table-section')]//ul//a[contains(@aria-label,'"+lowPrice+"')]//ancestor::div[@role='button'])[2]"));
    }
    public static WebElement getReturnDate(){
        return driver()
                .findElement(By
                        .xpath("//div[@class='_iaf _iEU _iam _iai']//div[@class='date-input-inner-text _iVh' and @data-placeholder='Vuelta']"));
    }

    public static WebElement selectDayFlight(String month, String day){
        return driver().findElement(By
                .xpath("(//div[contains(@id,'"+month+"')]//div[@class='weeks ']//div[contains(text(),'"+day+"')])[1]"));
    }

    public static WebElement search(){
        return driver().findElement(By
                .xpath("//div[@aria-label='Buscar vuelos']"));
    }
}
