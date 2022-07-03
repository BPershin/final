package proj.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static proj.DriverManager.getWebdriver;

public class BaseTests {

    protected static WebDriver driver = getWebdriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 10, 2000);

    private final By validationFailedAllert = By.xpath("//span[@class = 'validation-failed']");

    public BaseTests() {
        PageFactory.initElements(driver, this);
    }

    protected void waitUtilElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void clickEmptySpace() {
        driver.findElement(By.xpath("//html")).click();
    }

    protected void waitSomeInterval(int interval) {
        new WebDriverWait(driver, interval);
    }

    protected boolean isCheckBoxSelected(WebElement checkBox) {
        return checkBox.getAttribute("selected").equals("true");
    }

    public static boolean isElementExist(WebDriver driver, By locator, int waitTime) {
        try {
            new WebDriverWait(driver, waitTime).until(d -> (long) d.findElements(locator).size() != 0);
            return true;
        } catch (WebDriverException ex) {
            throw new WebDriverException("Element " + locator + " not exist");
        }
    }

    public boolean isFieldSetUpCorrectly(String fieldText, String expected) {

        return fieldText.equals(expected);
    }

    public boolean isValidationFailed() {
        return isElementExist(driver, validationFailedAllert, 5);
    }

    public String getAlertOfValidation() {
        if (isValidationFailed()) {
            try {

                return driver.findElement(validationFailedAllert).getText();

            } catch (NotFoundException ex) {
                return ex.getLocalizedMessage();
            }
        }
        return null;
    }

}
