package proj.steps;

import org.openqa.selenium.WebDriver;
import proj.Pages.LoginPage;

import static proj.DriverManager.getWebdriver;

public class LoginSteps {
    WebDriver driver = getWebdriver();
    public MainPageSteps login(String login, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.enterLoginAndPassword(login,password);
        loginPage.clickSubmit();
        return new MainPageSteps();
    }
}
