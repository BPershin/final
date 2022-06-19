import Helpers.TestSettings;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass {
    WebDriver driver;

    @Before
    public void doBefore() {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        options.setCapability("acceptInsecureCerts", true);
        driver = new ChromeDriver(options);
        driver.get(TestSettings.HostPrefix);
        driver.manage().window().maximize();
    }
    @After
    public void doAfter() {
        driver.quit();
    }
}
