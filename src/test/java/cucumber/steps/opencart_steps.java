package cucumber.steps;


import cucumber.util.ScreenshotUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;


public class opencart_steps {
    ChromeDriverService service = new ChromeDriverService.Builder().build();
    WebDriver driver;


    @Before
    public void browserSetup() {
        driver = new ChromeDriver(service);
        driver.manage().window().maximize();
    }

    @Given("^I Go To opencart Page$")
    public void iGoToOpencartPage() throws Throwable {
        driver.get("http://opencart.abstracta.us/");
        Thread.sleep(5000);
    }

    @Then("^I search by \"([^\"]*)\"$")
    public void iSearchBy(String product) throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"search\"]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"search\"]/input")).sendKeys(product);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"search\"]/input")).sendKeys(Keys.ENTER);
        Thread.sleep(5000);
    }

    @Then("^I click on element \"([^\"]*)\"$")
    public void iClickOnElement(String position) throws Throwable {
        if (position.equals("1")) {
            driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[1]/a")).click();
        } else {
            driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[" + position + "]/div/div[1]/a")).click();
        }
        Thread.sleep(5000);
    }

    @Then("^I click on Add to Cart$")
    public void iClickOnAddToCart() throws Throwable {
        driver.findElement(By.id("button-cart")).click();

        Thread.sleep(5000);
    }

    @Then("^I click on Shopping Cart$")
    public void iClickOnShoppingCart() throws Throwable {
        driver.findElement(By.id("cart-total")).click();

        Thread.sleep(5000);
    }

    @Then("^I click on View Cart$")
    public void iClickOnViewCart() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"cart\"]/ul/li[2]/div/p/a[1]")).click();

        Thread.sleep(5000);
    }

    @Then("^I Validate \"([^\"]*)\" is in the cart$")
    public void validateProductInCart(String product) throws Throwable {
        String cartElement = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[2]/a")).getText();

        if (!cartElement.equals(product)) {
            throw new Error("Product " + product + " is not in the chart.");
        }

        Thread.sleep(5000);
    }

    @Then("^Remove element from chart$")
    public void removeElementFromChart() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/span/button[2]")).click();

        Thread.sleep(5000);
    }

    @Then("^Validate chart is empty$")
    public void validateChartIsEmpty() throws Throwable {
        String emptyChartMessage = driver.findElement(By.xpath("//*[@id=\"cart\"]/ul/li/p")).getText();

        if (!emptyChartMessage.equals("Your shopping cart is empty!")) {
            throw new Error("Chart is not empty.");
        }

        Thread.sleep(5000);
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