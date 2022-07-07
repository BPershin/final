package proj.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static proj.DriverManager.getWebdriver;

public class BaseTests {

    protected static WebDriver driver = getWebdriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 10, 2000);

    private final By validationFailedAllert = By.xpath("//span[@class = 'validation-failed']");
    @FindBy(css = "[data-auto='allFiltersButton']")
    WebElement allFilters;
    @FindBy(xpath = "//main[@id='main']//article")
    List<WebElement> productList;
    @FindBy(css = "[placeholder='Искать товары']")
    WebElement searchInput;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;


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

    public static boolean isElementExist(WebDriver driver, By locator, int waitTime) {
        try {
            new WebDriverWait(driver, waitTime).until(d -> (long) d.findElements(locator).size() != 0);
            return true;
        } catch (WebDriverException ex) {
            throw new WebDriverException("Element " + locator + " not exist");
        }
    }

    public void JSScroll() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)");
    }

    public void JSScrollTilEnd() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void scrollSmooth() {
        for (int i = 0; i < 500; i++) {
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,60)", "");
        }
    }

    public boolean isFieldSetUpCorrectly(String fieldText, String expected) {

        return fieldText.equals(expected);
    }

    public FiltersPage goToFilterPage() {
        waitElement(allFilters);
        allFilters.click();
        return new FiltersPage();
    }

    public int getCountOfProd() {
        scrollSmooth();
        return productList.size();
    }

    public String getFirstProdName() {
        return productList.stream().findFirst().get().getText();
    }

    public boolean isSearchResultsContainsSearchData(String searchData) {
        waitSomeInterval(5);
        for (var elem: productList)
              {
            if (elem.getText().contains(searchData)) {
                return true;
            }
            else return false;
        }
        return false;
    }

    public void doBaseSearch(String data) {
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(data);
        submitButton.click();
        waitSomeInterval(5);
    }

}
