package cucumber.steps;


import cucumber.util.ScreenshotUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Browser {
    ChromeDriverService service = new ChromeDriverService.Builder().build();
    public static WebDriver driver;


    @Before
    public void browserSetup() {
        driver = new ChromeDriver(service);
        driver.manage().window().maximize();
    }

    @Given("^I Go To \"([^\"]*)\" Page$")
    public void iGoToPage(String page) throws Throwable {
        driver.get(page);
        Thread.sleep(5000);
    }

    public static void waitForElementXpath(String elementXPath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXPath)));
    }

    @After
    public void takeScreenShotsOnStepFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ScreenshotUtil.captureScreenshot(driver);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        driver.close();
    }
}