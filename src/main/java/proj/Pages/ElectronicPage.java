package proj.Pages;


import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ElectronicPage extends BaseTests {
    public enum subCategory {
        Телевизоры, Наушники
    }

    @FindBy(xpath = "//ul[@data-autotest-id='subItems']//a")
    List<WebElement> subCat;

    @Step
    public Object goToSubCategory(subCategory subCategory) {
        switch (subCategory) {
            case Телевизоры:
                for (var elem : subCat
                ) {
                    if (elem.getText().equals(subCategory.toString())) {
                        elem.click();
                        return new ElectronicPage();
                    }
                }
                break;
            case Наушники:
                for (var elem : subCat
                ) {
                    var a = elem.getText();
                    if (elem.getText().contains(subCategory.toString())) {
                        elem.click();
                        return new ElectronicPage();
                    }
                }
                break;
        }
        return this;
    }
}
