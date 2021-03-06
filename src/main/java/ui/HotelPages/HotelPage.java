package ui.HotelPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ui.AbstractPage;

/**
 * Created by Maryia_Shynkarenka on 6/14/2017.
 */
public class HotelPage extends AbstractPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "green-search-dates-flights_IE-EUR")
    WebElement buttonSearchFlights;

    @FindBy(xpath = "//img/preceding-sibling::div//h1//strong")
    WebElement hotelText;

    @FindBy(xpath = "//img/preceding-sibling::div//p[@ng-if='!latestOffersPath']")
    WebElement wereChangingText;

    @FindBy(xpath = "//*[@ng-if='header']//p")
    WebElement newHotelPatnersText;

    @FindBy(xpath = "//*[@on='isGreen']//p/p")
    WebElement werePatneringText;

    public HotelPage (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    public String verifyHotelsText(){
        //waitElement(buttonSearchFlights);
        return hotelText.getText();
    }

    public String verifyWereChangingText(){
       // waitElement(wereChangingText);
        return wereChangingText.getText();
    }

    public String verifyNewHotelsPartnerText(){
        //waitElement(newHotelPatnersText);
       return newHotelPatnersText.getText();
    }

    public String verifyWerePartneringText(){
       // waitElement(werePatneringText);
        return werePatneringText.getText();
    }

    public void clickButtonSearchFlights(){
       // waitElement(wereChangingText);
        buttonSearchFlights.click();
    }
}
