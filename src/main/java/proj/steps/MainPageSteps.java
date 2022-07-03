package proj.steps;

import proj.Pages.MainPage;

public class MainPageSteps {
    public TripsPageSteps navigateToTrips() {
        MainPage mainPage = new MainPage();
        mainPage.expencesDropDownClick();
        mainPage.tripsButtonClick();
        return new TripsPageSteps();
    }
}
