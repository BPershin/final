package proj.steps;

import io.qameta.allure.Step;
import proj.Pages.TripCreationPage;

public class TripsCreationPageSteps {
    private static final TripCreationPage tripCreationPage = new TripCreationPage();

    @Step("Заполняем Подразделение")
    public TripsCreationPageSteps selectSubdivision(String subdivisionName) {
        tripCreationPage.clickSubdivisionExpandButton();
        tripCreationPage.selectSubdivision(subdivisionName);
        return this;
    }

    @Step("Выбираем принимающую организацию")
    public TripsCreationPageSteps selectHostOrganisation(String hostOrgName) {
        tripCreationPage.clickToHostOrganisationList();
        tripCreationPage.expandHostOrganisationList();
        tripCreationPage.selectHostOrganisationFromList(hostOrgName);
        return this;
    }

    @Step("Проставляем задачу")
    public TripsCreationPageSteps setTask(String taskName) {
        tripCreationPage.selectTasksCheckBox(taskName);
        return this;
    }

    @Step("Проставляем города отъезда и приезда")
    public TripsCreationPageSteps setOutAndInCities(String departureCity, String arivalCity) {
        tripCreationPage.setDepartureCity(departureCity);
        tripCreationPage.setArrivalCity(arivalCity);
        return this;
    }

    @Step("Проставляем даты отъезда и приезда")
    public TripsCreationPageSteps setOutAndInDates(String departureDate, String arivalDate) {
        tripCreationPage.setDepartureDate(departureDate);
        tripCreationPage.setArrivalDate(arivalDate);
        return this;
    }

    @Step("Жмем Сохранить и закрыть")
    public TripsCreationPageSteps saveAndClose() {
        tripCreationPage.saveAndClose();
        return this;
    }
}
