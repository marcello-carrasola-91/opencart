package cucumber.steps;


import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

import static cucumber.steps.Browser.driver;


public class SearchPage {
    @Then("^I click on element \"([^\"]*)\"$")
    public void iClickOnElement(String position) throws Throwable {
        if (position.equals("1")) {
            driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[1]/a")).click();
        } else {
            driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[" + position + "]/div/div[1]/a")).click();
        }
        Thread.sleep(5000);
    }
}