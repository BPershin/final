import Helpers.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TripsPage {
    private WebDriver driver;
    private By _createTripButtonLocator = By.cssSelector("a.btn.back.icons-holder-text");
    private By _selfLocator = By.xpath("//h1[contains(text(),'Командировки')]");

    public TripsPage(WebDriver driver) {
        this.driver = driver;
        Helper.IsElementExist(driver, _selfLocator, 5);
    }

    public TripCreationPage GoToTripCreation() {
        driver.findElement(_createTripButtonLocator).click();
        return new TripCreationPage(driver);
    }

}
