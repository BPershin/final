package proj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import proj.properties.TestProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class DriverManager {
    private static WebDriver driver;
    public static Properties properties = TestProperties.getInstance().getProperties();

    public static WebDriver getWebdriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    public static void initDriver() {

        if (properties.getProperty("BROWSER").equals("chrome")) {
            System.setProperty(properties.getProperty("CHROME_WEB_DRIVER"), properties.getProperty("CHROME_WEB_DRIVER_PATH"));
            driver = new ChromeDriver();
            ChromeOptions options = new ChromeOptions();
            options.setCapability("acceptInsecureCerts", true);
            driver.get(properties.getProperty("HOSTNAME"));
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }

        if (properties.getProperty("BROWSER").equals("firefox")) {
            System.setProperty(properties.getProperty("FIREFOX_WEB_DRIVER"), properties.getProperty("GECKO_WEB_DRIVER_PATH"));
            driver = new FirefoxDriver();
            FirefoxOptions options = new FirefoxOptions();
            options.setCapability("acceptInsecureCerts", true);
            driver.get(properties.getProperty("HOSTNAME"));
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
    }

    public static void closeDriver() {
        driver.quit();
    }
}
