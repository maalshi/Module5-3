package ui.CarHirePages;


import businessobjects.CarHireDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.AbstractPage;

/**
 * Created by Maryia_Shynkarenka on 6/19/2017.
 */
public class CarHireSearch extends AbstractPage {

    @FindBy(id = "pickupLocation")
    WebElement pickUpField;

    @FindBy(id = "item-0-0")
    WebElement suggestion;

    @FindBy(id = "pickupDate")
    WebElement startDate;

    @FindBy(xpath = "//td[@data-enabled=\"true\"][2]")
    WebElement outboundDate;

    @FindBy(id = "returnDate")
    WebElement endDate;

    @FindBy(xpath = "//td[@data-enabled=\"true\"][3]")
    WebElement inboundDate;

    @FindBy(id = "searchCarsFormBtn-searchcars")
    WebElement searchButton;

    @FindBy(xpath = "//i[@data-comp-id='ct-calendar-nav-next']")
    WebElement nextMonth;

    public CarHireSearch(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }

    public void sendKeysPickUpLocation(CarHireDetails carHireDetails){
        waitElement(pickUpField);
        pickUpField.sendKeys(carHireDetails.getCity());
    }

    public void clickSuggestion(){
        waitElement(suggestion);
        suggestion.click();
    }

    public void clickStartDate(){
        waitElement(startDate);
        startDate.click();
    }

    public void clickOutboundDate(CarHireDetails carHireDetails){
        String date=carHireDetails.getPickUpDate();
        while(driver.findElements(By.xpath("//*[@id='day-" + date + "']")).size() == 0){
            clickNextMonth();
        }
        driver.findElement(By.xpath("//*[@id='" + date + "']")).click();
    }

    public void clickEndDate(){
        waitElement(endDate);
        endDate.click();
    }

    public void clickNextMonth(){
        waitElement(nextMonth);
        nextMonth.click();
    }

    public void clickInboundDate(CarHireDetails carHireDetails){
        String date=carHireDetails.getDropOffDate();
        while(driver.findElements(By.xpath("//*[@id='day-" + date + "']")).size() == 0){
            clickNextMonth();
        }
        driver.findElement(By.xpath("//*[@id='" + date + "']")).click();
    }

    public void clickSearchButton(){
        waitElement(searchButton);
        searchButton.click();
    }
}
