package cucumber.steps;


import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static cucumber.steps.Browser.driver;


public class ProductPage {
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
}