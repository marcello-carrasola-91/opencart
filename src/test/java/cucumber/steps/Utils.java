package cucumber.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Utils {
    public static void waitForElementXpath(String elementXPath) {
        WebDriverWait wait = new WebDriverWait(Browser.driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXPath)));
    }

    public static void waitForElementID(String elementID) {
        WebDriverWait wait = new WebDriverWait(Browser.driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementID)));
    }
}