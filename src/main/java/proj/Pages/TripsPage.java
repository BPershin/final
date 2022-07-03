package proj.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class TripsPage extends BaseTests {

    @FindBy(xpath = "//div[@class='btn-group']//a[@href='/business-trip/create/']")
    private WebElement createTripButton;

    @FindBy(xpath = "//h1[contains(text(),'Командировки')]")
    private WebElement selfLocator;

    public void goToTripCreation() {
        waitUtilElementToBeClickable(createTripButton);
        createTripButton.click();
    }

}
