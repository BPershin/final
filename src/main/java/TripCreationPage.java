import Helpers.TestSettings;
import Helpers.Helper;
import org.openqa.selenium.*;


public class TripCreationPage {

    private WebDriver driver;
    private By _selfLocator = By.xpath("//h1[text()='Создать командировку']");
    private By _subdivisionExpandButton = By.xpath("//select[@data-name='field__business-unit']");
    private By _companySelectorLink = By.xpath("//a[@id='company-selector-show']");
    private By _companySelectorDropDowm = By.xpath("//span[@class='select2-chosen']");
    private By _dropDownResults = By.xpath("//*[@class='select2-result-label' and contains(text(),'')]");
    private By _depCityInput = By.xpath("//input[@data-name='field__departure-city']");
    private By _arrCityInput = By.xpath("//input[@data-name='field__arrival-city']");
    private By _departureDateInputLocator = By.xpath("//input[contains(@name, 'departureDatePlan-uid')]");
    private By _returnDateInputLocator = By.xpath("//input[contains(@name, 'returnDatePlan-uid')]");
    private By _saveAndCloseButtoLocator = By.xpath("//button[contains(text(),'Сохранить и закрыть')]");
    private By _validationFailedAllert = By.xpath("//span[@class = 'validation-failed']");
    private By _chosenCompanyLocator = By.cssSelector("span[class='select2-chosen']");


    private By _baseTasksLocator(String taskName) {
        return By.xpath("//div[@data-name='field__tasks']//label[text()='" + taskName + "']//ancestor::div/input");
    }

    private By _baseSubdivisionLocator(String subdivision) {
        return By.xpath("//option[text() = '" + subdivision + "']");
    }

    private By _currentOrgLocator(String subdivisionName) {
        return By.xpath("//*[@class='select2-result-label' and contains(text(),'" + subdivisionName + "')]");
    }

    public TripCreationPage(WebDriver driver) {
        this.driver = driver;
        Helper.ShouldLocate(driver, TestSettings.HostPrefix + "business-trip/create/");
        Helper.IsElementExist(driver, _selfLocator, 5);

    }

    public TripCreationPage SetSubdivision(String subdivision) {
        driver.findElement(_baseSubdivisionLocator(subdivision)).click();
        IsFieldSetCorrectlyByText(_baseSubdivisionLocator(subdivision), subdivision);
        return this;
    }

    public TripCreationPage SelectHostOrganisationFromList(String subdivision) {
        driver.findElement(_companySelectorLink).click();
        driver.findElement(_companySelectorDropDowm).click();
        Helper.IsElementExist(driver, _dropDownResults, 5);
        driver.findElement(_currentOrgLocator(subdivision)).click();

        IsFieldSetCorrectlyByText(_chosenCompanyLocator, subdivision);

        return this;
    }

    public TripCreationPage SelectTask(String taskName) {
        driver.findElement(_baseTasksLocator(taskName)).click();
        return this;
    }

    public TripCreationPage SetOutInCities(String outCityName, String inCityName) {
        WebElement depInput = driver.findElement(_depCityInput);
        depInput.clear();
        depInput.sendKeys(outCityName);
        IsFieldSetCorrectlyByAttr(_depCityInput, outCityName);
        WebElement inInput = driver.findElement(_arrCityInput);
        inInput.sendKeys(inCityName);
        IsFieldSetCorrectlyByAttr(_arrCityInput, inCityName);
        Helper.IsElementNotExist(driver, _validationFailedAllert, 5);
        return this;
    }

    public TripCreationPage SetDates(String departureDate, String returningDate) {
        WebElement depDateInput = driver.findElement(_departureDateInputLocator);
        depDateInput.sendKeys(departureDate);
        WebElement retDateInput = driver.findElement(_returnDateInputLocator);
        retDateInput.sendKeys(returningDate);
        Helper.IsElementNotExist(driver, _validationFailedAllert, 5);
        return this;
    }

    public void SaveAndClose() {
        Helper.JSClickElement(driver, _saveAndCloseButtoLocator);
    }

    public boolean IsValidationFailed() {
        return Helper.IsElementExist(driver, _validationFailedAllert, 5);
    }

    public String GetAlertOfValidation() {
        if (IsValidationFailed()) {
            try {
                return driver.findElement(_validationFailedAllert).getText();
            } catch (NotFoundException ex) {
                return ex.getLocalizedMessage();
            }
        }
        return null;
    }

    public boolean IsFieldSetCorrectlyByText(By locator, String expectedText) {

        if (driver.findElement(locator).getText().equals(expectedText)) {
            return true;

        } else {
            throw new WebDriverException("Field set not correctly");
        }

    }

    public boolean IsFieldSetCorrectlyByAttr(By locator, String expectedValue) {

        if (driver.findElement(locator).getAttribute("value").equals(expectedValue)) {
            return true;

        } else {
            throw new WebDriverException("Field set not correctly");
        }
    }

}


