package proj.steps;

import proj.Pages.BaseTests;
import proj.Pages.TripsPage;

public class TripsPageSteps extends BaseTests {
    public TripsCreationPageSteps goToCreateTrip() {
        TripsPage tripsPage = new TripsPage();
        tripsPage.goToTripCreation();
        return new TripsCreationPageSteps();
    }
}
