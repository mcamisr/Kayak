package actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import static utils.GetCurrentDriver.*;

public class JavaScriptClick {

    public static void on(WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor) driver();
        executor.executeScript("arguments[0].click();", element);
    }
}
