import extension.DriverExtension;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import proj.Pages.BaseTests;
import proj.steps.LoginSteps;
import proj.properties.TestProperties;
import proj.steps.MainPageSteps;
import proj.steps.TripsCreationPageSteps;
import proj.steps.TripsPageSteps;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import static io.qameta.allure.SeverityLevel.BLOCKER;
import static proj.DriverManager.getWebdriver;

@ExtendWith({DriverExtension.class,AllureExtension.class})
class BusinessTripCreationTest extends BaseTests {

    private final Properties properties = TestProperties.getProperties();
    private final LoginSteps loginSteps = new LoginSteps();
    private final MainPageSteps mainPageSteps = new MainPageSteps();
    private final TripsPageSteps tripsPageSteps = new TripsPageSteps();
    private final TripsCreationPageSteps tripsCreationPageSteps = new TripsCreationPageSteps();

    @Test
    @Severity(BLOCKER)
    @DisplayName("Создание командировки")
    void businessTripCreationTest() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String testDate = currentDate.format(formatter);

        loginSteps
                .login(properties.getProperty("LOGIN"), properties.getProperty("PASSWORD"))
                .navigateToTrips()
                .goToCreateTrip()
                .selectSubdivision("Отдел внутренней разработки")
                .selectHostOrganisation("?????")
                .setTask("Заказ билетов")
                .setOutAndInCities("Коломна", "Магадан")
                .setOutAndInDates(testDate, testDate)
                .saveAndClose();

        Assertions.assertEquals("Список выпроваживаемых сотрудников не может быть пустым",
                getAlertOfValidation(),"Ошибка в тексте аллерта");
    }
}
