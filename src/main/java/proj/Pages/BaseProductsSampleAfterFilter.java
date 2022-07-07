package proj.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BaseProductsSampleAfterFilter extends BaseTests {
    List<WebElement> productList = driver.findElements(By.xpath("//main[@id='main']//article//h3/a"));

    @Step
    public String getFirstProdName() {
        return productList.stream().findFirst().get().getText();
    }
}