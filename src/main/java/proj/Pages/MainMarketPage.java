package proj.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class MainMarketPage extends BaseTests {
    @FindBy(xpath = "//div[@data-zone-name='category-link']/div/a/span")
    List<WebElement> allCategory;

    public enum category {
        Экспресс, Универмаг, Продукты, Аптека, Дача, Спорт, Одежда, Электроника, Детям
    }

    @Step
    public Object goToCategory(category category) {
        ;
        switch (category) {
            case Электроника:
                for (var elem : allCategory
                ) {
                    if (elem.getText().equals(category.toString())) {
                        elem.click();
                        return new ElectronicPage();
                    }
                }
                break;
        }
        return true;
    }
}
