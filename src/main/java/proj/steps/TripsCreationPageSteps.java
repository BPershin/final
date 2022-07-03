package proj.steps;

import proj.Pages.TripCreationPage;

public class TripsCreationPageSteps {
    private static final TripCreationPage tripCreationPage = new TripCreationPage();

    public TripsCreationPageSteps selectSubdivision(String subdivisionName) {
        tripCreationPage.clickSubdivisionExpandButton();
        tripCreationPage.selectSubdivision(subdivisionName);
        return this;
    }

    public TripsCreationPageSteps selectHostOrganisation(String hostOrgName) {
        tripCreationPage.clickToHostOrganisationList();
        tripCreationPage.expandHostOrganisationList();
        tripCreationPage.selectHostOrganisationFromList(hostOrgName);
        return this;
    }

    public TripsCreationPageSteps setTask(String taskName) {
        tripCreationPage.selectTasksCheckBox(taskName);
        return this;
    }

    public TripsCreationPageSteps setOutAndInCities(String departureCity, String arivalCity) {
        tripCreationPage.setDepartureCity(departureCity);
        tripCreationPage.setArrivalCity(arivalCity);
        return this;
    }

    public TripsCreationPageSteps setOutAndInDates(String departureDate, String arivalDate) {
        tripCreationPage.setDepartureDate(departureDate);
        tripCreationPage.setArrivalDate(arivalDate);
        return this;
    }

    public TripsCreationPageSteps saveAndClose () {
        tripCreationPage.saveAndClose();
        return this;
    }
}
