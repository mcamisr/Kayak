package actions;


import java.util.Set;

import static utils.GetCurrentDriver.*;

public class ChangeWindow {

    private static String actualWindow;
    private static Set<String> nextsWindows;

    public static void toNext() {
        actualWindow = driver().getWindowHandle();
        nextsWindows = driver().getWindowHandles();
        nextsWindows.forEach(
                window -> {
                    if(!window.equals(actualWindow))
                        driver().switchTo().window(window);
                }
        );
    }
}
