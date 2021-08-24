package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.GetCurrentDriver;

import java.util.concurrent.TimeUnit;

public class WaitNow {
    public static final String LOADING = "//div[@class='Common-Results-ProgressBar theme-dark']";
    private int time;

    public WaitNow(int time) {
        this.time = time;
    }

    public static WaitNow inThePage(int time){
        return new WaitNow(time);
    }

    public static void thisTime(int seconds){
        WebDriver driver = GetCurrentDriver.driver();
       driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public static WebDriverWait theseSecond(int seconds){
        WebDriver driver = GetCurrentDriver.driver();
        return new WebDriverWait(driver, seconds);
    }

    public static void untilTheElement(WebElement element, int seconds){
        WebDriver driver = GetCurrentDriver.driver();
        new WebDriverWait(driver, seconds).until(ExpectedConditions.invisibilityOf(element));
    }

    public static void untilTheLoading(int seconds){
        WebDriver driver = GetCurrentDriver.driver();
        new WebDriverWait(driver, seconds).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(LOADING)));
    }

    public static void TheElement(WebElement element, int seconds){
        WebDriver driver = GetCurrentDriver.driver();
        new WebDriverWait(driver, seconds).until(ExpectedConditions.visibilityOf(element));
    }

}
