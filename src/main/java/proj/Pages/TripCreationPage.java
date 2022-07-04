package proj.Pages;

import io.qameta.allure.Step;
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


    @Step("Открываем выпадашку 'Подразделения'")
    public void clickSubdivisionExpandButton() {
        waitElement(selfLocator);
        subdivisionExpandButton.click();
    }


    public void selectSubdivision(String subdivisionName) {
        subdivisionExpandButton.findElement(By.xpath(".//option[text() ='" + subdivisionName + "']")).click();
        isFieldSetUpCorrectly(selectedSubDiv.getText(), subdivisionName);
    }


    public void clickToHostOrganisationList() {

        waitUtilElementToBeClickable(companySelectorLink);
        companySelectorLink.click();
    }


    public void expandHostOrganisationList() {

        waitUtilElementToBeClickable(companySelectorDropDown);
        companySelectorDropDown.click();
    }


    public void selectHostOrganisationFromList(String hostOrganisation) {
        waitElement(dropDownResults);
        WebElement currentHostOrg = dropDownResults.findElement(By.xpath("//div[text()='" + hostOrganisation + "']"));
        waitUtilElementToBeClickable(currentHostOrg);
        currentHostOrg.click();
        isFieldSetUpCorrectly(companySelectorDropDown.getText(), hostOrganisation);
    }


    public void selectTasksCheckBox(String taskName) {
        WebElement currentTask = tasksArea.findElement(By.xpath("//label[text()='" + taskName + "']//preceding-sibling::input"));
        currentTask.click();
        isCheckBoxSelected(currentTask);
    }


    public void setDepartureCity(String depCityName) {
        waitUtilElementToBeClickable(depCityInput);
        depCityInput.click();
        depCityInput.clear();
        depCityInput.sendKeys(depCityName);
        isFieldSetUpCorrectly(depCityInput.getAttribute("value"), depCityName);
    }


    public void setArrivalCity(String arrCityName) {
        waitUtilElementToBeClickable(arrCityInput);
        arrCityInput.click();
        arrCityInput.clear();
        arrCityInput.sendKeys(arrCityName);
        isFieldSetUpCorrectly(arrCityInput.getAttribute("value"), arrCityName);
    }


    public void setDepartureDate(String departureDate) {
        waitUtilElementToBeClickable(departureDateInput);
        departureDateInput.click();
        departureDateInput.clear();
        departureDateInput.sendKeys(departureDate);
        clickEmptySpace();
        isFieldSetUpCorrectly(departureDateInput.getAttribute("value"), departureDate);
    }


    public void setArrivalDate(String arrivalDate) {
        arrivalDateInput.click();
        arrivalDateInput.clear();
        arrivalDateInput.sendKeys(arrivalDate);
        clickEmptySpace();
        isFieldSetUpCorrectly(arrivalDateInput.getAttribute("value"), arrivalDate);
    }


    public void saveAndClose() {
        saveAndCloseButton.click();
    }
}

