import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By _formSigningLocator = By.xpath("//form[@id = 'login-form']");
    private By _loginInputLocator = By.xpath("//input[@name='_username']");
    private By _passwordInputLocator = By.xpath("//input[@name='_password']");
    private By _submitButtonLocator = By.xpath("//button[@id='_submit']");

    public MainPage Login(String login, String password) {

        driver.findElement(_loginInputLocator).sendKeys("Taraskina Valeriya");
        driver.findElement(_passwordInputLocator).sendKeys("testing");
        driver.findElement(_submitButtonLocator).click();
        return new MainPage(driver);
    }
}
