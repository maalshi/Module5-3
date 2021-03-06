package cucumber_steps;

import businessobjects.Constants;
import businessobjects.Origin;
import config.WebDriverSingleton;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import businessobjects.Route;
import ui.aerlpages.FlightResultsPage;
import ui.aerlpages.Homepage;

/**
 * Created by Maryia_Shynkarenka on 7/24/2017.
 */
public class StepDefinitions {

    WebDriver driver;
    Homepage homepage;

    Route route;

    @When("^I open Aerlingus Homepage$")
    public void i_open_aerlingus_homepage(){
        driver = WebDriverSingleton.getWebDriverInstance();
        driver.get("https://www.aerlingus.com/html/en-US/home.html");
    }

    /* @When ("^I enter origin$")
     public void i_enter_origin()throws Throwable{
         Homepage homepage = new Homepage(driver);
         homepage.waitElementByLocator(By.xpath("//input[@id='origin']"));
         homepage.clickOrigin();
         homepage.sendKeysOrigin("dublin");
         homepage.clickOriginSuggestion();
         throw new PendingException();
     }

         @And("^I enter desination$")
    public void i_enter_destination()throws Throwable{
        homepage.sendKeysDestination("paris");
        homepage.clickDestinationSuggestion();
        throw new PendingException();
    }*/

    @When ("^I enter origin$")
    public void i_enter_origin(String origin)throws Throwable{
        Homepage homepage = new Homepage(driver);
        homepage.waitElementByLocator(By.xpath("//input[@id='origin']"));
        homepage.sendKeysOrigin((Constants.ORIGIN()));
        homepage.clickOriginSuggestion();
        throw new PendingException();
    }

    @And("^I enter desination$")
    public void i_enter_destination(String destination)throws Throwable{
        route.setDestination(Constants.DESTINATION());
        homepage.clickDestinationSuggestion();
        throw new PendingException();
    }

    @And("^I press Find Flights button")
    public void press_find_flights_button(){
        homepage.clickFindFlightButton();
    }

    @Then ("^I see Flight Results page")
    public void i_see_flight_results_page() {
        FlightResultsPage flightresults = new FlightResultsPage(driver);
        Assert.assertEquals("Dublin to Paris", driver.findElement(By.xpath("//div[contains(@data-test-id,'first')]//div[contains(@class,'flight-results')]//span")).getText());
    }
}
