package assertions;

import com.aventstack.extentreports.util.Assert;
import utils.GetCurrentDriver;

public class ValidatePriceLowFlight {

    public static void inKayak(){
        String url = GetCurrentDriver.driver().getCurrentUrl();
        Assert.notEmpty(url, "Good Url");
    }
}
