package Helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Helper {
    private WebDriver driver;

    public static boolean IsElementExist(WebDriver driver, By locator, int waitTime) {
        try {
            new WebDriverWait(driver, waitTime).until(d -> d.findElements(locator).stream().count() != 0);
            return true;
        } catch (WebDriverException ex) {
            throw new WebDriverException("Element " + locator + " not exist");
        }
    }

    public static boolean IsElementNotExist(WebDriver driver, By locator, int waitTime) {
        try {
            new WebDriverWait(driver, waitTime).until(d -> d.findElements(locator).stream().count() == 0);
            return true;
        } catch (WebDriverException ex) {
            throw new WebDriverException("Element " + locator + "exist");
        }
    }

    public static void ShouldLocate(WebDriver driver, String location) {
        try {
            new WebDriverWait(driver, 10).until(ExpectedConditions.urlContains(location));
        } catch (NotFoundException ex) {
            throw new NotFoundException("Cannot find location");
        }
    }

    public static void JSClickElement(WebDriver driver, By element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement elem = driver.findElement(element);
        js.executeScript("arguments[0].click()", elem);
    }
}