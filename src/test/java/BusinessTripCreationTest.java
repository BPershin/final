
import Helpers.TestSettings;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BusinessTripCreationTest extends BaseClass {

    @Test
    public void Test() {

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String testDate = currentDate.format(formatter);
        var loginPage = new LoginPage(driver);
        var tripCreationPage = loginPage
                .Login(TestSettings.LOGIN, TestSettings.PASSWORD)
                .NavigateToTrips()
                .GoToTripCreation();
        tripCreationPage
                .SetSubdivision("Отдел внутренней разработки")
                .SelectHostOrganisationFromList("?????")
                .SelectTask("Заказ билетов")
                .SetOutInCities("Грозный", "Караганда")
                .SetDates(testDate, testDate)
                .SaveAndClose();
        Assert.assertEquals("Список командируемых сотрудников не может быть пустым",tripCreationPage.GetAlertOfValidation());
    }
}
