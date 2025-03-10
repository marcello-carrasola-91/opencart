package cucumber.util;

import org.openqa.selenium.*;

public class ScreenshotUtil {

    public static byte[] captureScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}