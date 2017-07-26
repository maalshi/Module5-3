import businessobjects.CarHireDetails;
import businessobjects.Constants;
import org.testng.annotations.Test;
import ui.CarHirePages.CarHireResults;
import ui.CarHirePages.CarHireSearch;
import ui.aerlpages.Homepage;
import utils.AssertUtil;

/**
 * Created by Maryia_Shynkarenka on 6/19/2017.
 */
public class CarHireTest extends BaseTest {

    @Test
    public void findCarHire() {
        driver.get("http://www.aerlinguscars.com/en/?clientId=567309#/searchcars");
        /*Homepage homepage = new Homepage(driver);
        homepage.clickTabCarHire();
        String winHandleBefore = driver.getWindowHandle();
        homepage.clickButtonMoreInfo();
        for (String winHandle : driver.getWindowHandles()) {
            if (!winHandle.equals(winHandleBefore)) {
                driver.switchTo().window(winHandle);
            }
        }
*/
        CarHireSearch search = new CarHireSearch(driver);
        CarHireDetails carHireDetails = new CarHireDetails(Constants.CITY());
        carHireDetails.setPickUpDate(Constants.OUTBOUNDDATE());
        carHireDetails.setDropOffDate(Constants.INBOUNDDATE());
        search.sendKeysPickUpLocation(carHireDetails);
        String winHandleBefore = driver.getWindowHandle();
        search.clickSuggestion();
        search.clickStartDate();
        //search.clickOutboundDate(carHireDetails);
        search.clickFixedOutboundDate();
        //search.clickEndDate();
        //search.clickInboundDate(carHireDetails);
        search.clickFixedInboundDate();
        search.clickSearchButton();
        CarHireResults results = new CarHireResults(driver);
        //AssertUtil util = new AssertUtil();
        AssertUtil.assertEquals(results.getOutboundAirportText(),"Dublin - Airport");
        AssertUtil.assertEquals(results.getInboundAirportText(),"Dublin - Airport");
    }
}


