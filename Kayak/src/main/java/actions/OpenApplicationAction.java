package actions;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;
import static utils.GetCurrentDriver.*;

public class OpenApplicationAction {

    public static void inThePageWithChrome(String url){
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    public static void inThePageWithFirefox(String url){
        System.setProperty("webdriver.gecko.driver","geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }
}
