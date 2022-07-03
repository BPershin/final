package proj.Pages;

import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class TripCreationPage extends BaseTests {


    @FindBy(xpath = "//h1[text()='Создать командировку']")
    WebElement selfLocator;
    @FindBy(xpath = "//div[contains(@id, '_businessUnit')]/select")
    WebElement subdivisionExpandButton;

    @FindBy(xpath = "//a[@id='company-selector-show']")
    WebElement companySelectorLink;

    @FindBy(xpath = "//span[@class='select2-chosen']")
    WebElement companySelectorDropDown;

    @FindBy(xpath = "//div[@class='select2-result-label']")
    WebElement dropDownResults;

    @FindBy(xpath = "//div[@class='controls']")
    WebElement tasksArea;

    @FindBy(xpath = "//input[@data-name='field__departure-city']")
    WebElement depCityInput;

    @FindBy(xpath = "//input[@data-name='field__arrival-city']")
    WebElement arrCityInput;

    @FindBy(xpath = "//input[contains(@name, 'departureDatePlan-uid')]")
    WebElement departureDateInput;

    @FindBy(xpath = "//input[contains(@name, 'returnDatePlan-uid')]")
    WebElement arrivalDateInput;

    @FindBy(xpath = "//button[contains(text(),'Сохранить и закрыть')]")
    WebElement saveAndCloseButton;

    @FindBy(xpath = "//span[@class = 'validation-failed']")
    WebElement validationFailedAlert;

    @FindBy(css = "span[class='select2-chosen']")
    WebElement chosenCompany;

    @FindBy(xpath = "//div[contains(@id, '_businessUnit')]/span")
    WebElement selectedSubDiv;

    @FindBy(xpath = "//div[@id='ui-datepicker-div']")
    WebElement calendar;

    @FindBy(css = "ui-state-default ui-state-active ui-state-hover ui-state-highlight")
    WebElement selectedCell;

    @Description("Открывает drop down выбора Подразделений")

    public void clickSubdivisionExpandButton() {
        waitElement(selfLocator);
        subdivisionExpandButton.click();
    }

    @Description("Выбирает конкретное подразделение из списка")
    public void selectSubdivision(String subdivisionName) {
        subdivisionExpandButton.findElement(By.xpath(".//option[text() ='" + subdivisionName + "']")).click();
        isFieldSetUpCorrectly(selectedSubDiv.getText(), subdivisionName);
    }

    @Description("Нажимает на Открыть список")
    public void clickToHostOrganisationList() {

        waitUtilElementToBeClickable(companySelectorLink);
        companySelectorLink.click();
    }

    @Description("Открывает drop-down список Организаций")
    public void expandHostOrganisationList() {

        waitUtilElementToBeClickable(companySelectorDropDown);
        companySelectorDropDown.click();
    }

    @Description("Выбирает конкретную организацию из списка")
    public void selectHostOrganisationFromList(String hostOrganisation) {
        waitElement(dropDownResults);
        var currentHostOrg = dropDownResults.findElement(By.xpath("//div[text()='" + hostOrganisation + "']"));
        waitUtilElementToBeClickable(currentHostOrg);
        currentHostOrg.click();
        isFieldSetUpCorrectly(companySelectorDropDown.getText(), hostOrganisation);
    }

    @Description("Проставляет чек-бокс на конкретной задаче")
    public void selectTasksCheckBox(String taskName) {
        var currentTask = tasksArea.findElement(By.xpath("//label[text()='" + taskName + "']//preceding-sibling::input"));
        currentTask.click();
        isCheckBoxSelected(currentTask);
    }

    @Description("Устанавливает значение в поле Город выбытия")
    public void setDepartureCity(String depCityName) {
        waitUtilElementToBeClickable(depCityInput);
        depCityInput.click();
        depCityInput.clear();
        depCityInput.sendKeys(depCityName);
        isFieldSetUpCorrectly(depCityInput.getAttribute("value"), depCityName);
    }

    @Description("Устанавливает значение в поле Город прибытия")
    public void setArrivalCity(String arrCityName) {
        waitUtilElementToBeClickable(arrCityInput);
        arrCityInput.click();
        arrCityInput.clear();
        arrCityInput.sendKeys(arrCityName);
        isFieldSetUpCorrectly(arrCityInput.getAttribute("value"), arrCityName);
    }

    @Description("Устанавливает значение в поле Дата выезда")
    public void setDepartureDate(String departureDate) {
        waitUtilElementToBeClickable(departureDateInput);
        departureDateInput.click();
        departureDateInput.clear();
        departureDateInput.sendKeys(departureDate);
        clickEmptySpace();
        isFieldSetUpCorrectly(departureDateInput.getAttribute("value"), departureDate);
    }

    @Description("Устанавливает значение в поле Дата приезда")
    public void setArrivalDate(String arrivalDate) {
        arrivalDateInput.click();
        arrivalDateInput.clear();
        arrivalDateInput.sendKeys(arrivalDate);
        clickEmptySpace();
        isFieldSetUpCorrectly(arrivalDateInput.getAttribute("value"), arrivalDate);
    }

    @Description("Нажатие на кнопку Сохранить и закрыть")
    public void saveAndClose() {
        saveAndCloseButton.click();
    }
}

