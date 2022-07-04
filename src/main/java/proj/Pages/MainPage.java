package proj.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MainPage extends BaseTests {

    @FindBy(xpath = "//h1[text()='Панель быстрого запуска']")
    WebElement selfLocator;

    @FindBy(xpath = "//div[@id='main-menu']/ul/li/a/span[text()='Расходы']")
    WebElement expencesDropDownButton;

    @FindBy(xpath = "//span[text()='Командировки']")
    WebElement tripsOption;


    public void expencesDropDownClick() {
        expencesDropDownButton.click();
    }


    public void tripsButtonClick() {
        tripsOption.click();

    }

}
