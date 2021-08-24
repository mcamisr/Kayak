package utils;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class GetCurrentDriver {
    public static WebDriver driver;

    public static WebDriver driver(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }

}
