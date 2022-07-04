package proj.steps;

import io.qameta.allure.Step;
import proj.Pages.MainPage;

public class MainPageSteps {
    @Step("Переходим в Командировки")
    public TripsPageSteps navigateToTrips() {
        MainPage mainPage = new MainPage();
        mainPage.expencesDropDownClick();
        mainPage.tripsButtonClick();
        return new TripsPageSteps();
    }
}
