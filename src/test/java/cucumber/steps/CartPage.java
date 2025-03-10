package cucumber.steps;


import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

import static cucumber.steps.Browser.driver;


public class CartPage {
    @Then("^I Validate \"([^\"]*)\" is in the cart$")
    public void validateProductInCart(String product) throws Throwable {
        String cartElement = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[2]/a")).getText();

        if (!cartElement.equals(product)) {
            throw new Error("Product " + product + " is not in the chart.");
        }

        Thread.sleep(5000);
    }

    @Then("^I Remove element from chart$")
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
}