package cucumber.steps;


import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.Map;

import static cucumber.steps.Browser.driver;


public class MainPage {
    //public static Map<String, String> mainPageElementsID =
    //        Map.of("searchBar", "search");
//
    //@Then("^I search element \"([^\"]*)\"$ by \"([^\"]*)\"$")
    //public void iSearchElementBy(String element, String locator) throws Throwable {
    //    if (locator.equalsIgnoreCase("id")) {
    //        driver.findElement(By.id(element)).clear();
    //        driver.findElement(By.id(element)).sendKeys();
    //        driver.findElement(By.id(element)).clear();
    //    } else if (locator.equalsIgnoreCase("xpath")) {
    //        driver.findElement(By.xpath(element));
    //    } else if (locator.equalsIgnoreCase("name")) {
    //        driver.findElement(By.name(element));
    //    } else if (locator.equalsIgnoreCase("class")) {
    //        driver.findElement(By.className(element));
    //    } else if (locator.equalsIgnoreCase("css_selector")) {
    //        driver.findElement(By.cssSelector(element));
    //    } else if (locator.equalsIgnoreCase("link_text")) {
    //        driver.findElement(By.linkText(element));
    //    } else if (locator.equalsIgnoreCase("partial_link_text")) {
    //        driver.findElement(By.partialLinkText(element));
    //    } else if (locator.equalsIgnoreCase("tag_name")) {
    //        driver.findElement(By.tagName(element));
    //    }
    //}

    @Then("^I search by \"([^\"]*)\"$")
    public void iSearchBy(String product) throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"search\"]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"search\"]/input")).sendKeys(product);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"search\"]/input")).sendKeys(Keys.ENTER);
        Thread.sleep(5000);
    }

}