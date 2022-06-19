import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;
    private By _selfLocator = By.xpath("//h1[text()='Панель быстрого запуска']");
    private By _expencesDropDownButton = By.xpath("//div[@id='main-menu']/ul/li/a/span[text()='Расходы']");
    private By _tripsDropDownOption = By.xpath("//span[text()='Командировки']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public TripsPage NavigateToTrips() {
        driver.findElement(_expencesDropDownButton).click();
        driver.findElement(_tripsDropDownOption).click();
        return new TripsPage(driver);
    }
}
