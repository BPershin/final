package proj.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FiltersPage extends BaseTests {
    @FindBy(xpath = "//div[@data-filter-id='glprice']//div[@data-prefix='от']/input")
    WebElement loverBoundInput;

    @FindBy(xpath = "//div[@data-filter-id='glprice']//div[@data-prefix='до']/input")
    WebElement highBoundInput;

    @FindBy(xpath = "//a[contains(text(),'Показать')]")
    WebElement showButton;


    @FindBy(xpath = "//input[@type='checkbox']//following-sibling::div")
    List<WebElement> makerCheckBoxes;

    public enum Makers {
        BQ, Samsung, LG, JBL
    }

    @Step
    public FiltersPage setLoverBoundCost(String low) {
        loverBoundInput.click();
        loverBoundInput.clear();
        loverBoundInput.sendKeys(low);
        return this;
    }

    @Step
    public FiltersPage setHighBoundCost(String high) {
        highBoundInput.click();
        highBoundInput.clear();
        highBoundInput.sendKeys(high);
        return this;
    }

    @Step
    public FiltersPage setMaker(Makers maker) {
        JSScroll();
        for (var elem : makerCheckBoxes
        ) {
            if (elem.getText().equals(maker.toString())) {
                elem.click();
            }
        }
        return this;
    }

    @Step
    public BaseProductsSampleAfterFilter showMe() {
        showButton.click();
        return new BaseProductsSampleAfterFilter();
    }
}
