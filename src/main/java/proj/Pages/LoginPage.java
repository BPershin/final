package proj.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BaseTests {
    @FindBy(xpath = "//input[@name='_username']")
    private WebElement loginInput;

    @FindBy(xpath = "//input[@name='_password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@id='_submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//form[@id = 'login-form']")
    private WebElement formSigning;


    public void enterLoginAndPassword(String login, String password) {
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);

    }


    public void clickSubmit() {
        waitUtilElementToBeClickable(submitButton);
        submitButton.click();

    }

}
