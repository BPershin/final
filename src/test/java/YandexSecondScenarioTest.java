import extension.DriverExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import proj.Pages.BaseTests;
import proj.Pages.ElectronicPage;
import proj.Pages.FiltersPage;
import proj.Pages.MainMarketPage;
import proj.properties.TestProperties;

import java.util.Properties;

import static proj.DriverManager.getWebdriver;
import static proj.Pages.ElectronicPage.subCategory;
import static proj.Pages.FiltersPage.Makers;
import static proj.Pages.MainMarketPage.category;

@ExtendWith(DriverExtension.class)
class YandexSecondScenarioTest extends BaseTests {

    private final Properties properties = TestProperties.getProperties();
    MainMarketPage mainMarketPage = new MainMarketPage();
    ElectronicPage electronicPage = new ElectronicPage();
    FiltersPage filtersPage = new FiltersPage();

    @Test
    void yandexSecondTest() throws InterruptedException {
            getWebdriver();
        var expectedCountOfProduct = 48; // К сожалению я не нашел настройку отображения кол - ва карточек элементов на странице, пока оставил 48
        Thread.sleep(20000); //Яндекс кидает капчу, добавлено что бы ввести вручную :(

        mainMarketPage.
                goToCategory(category.Электроника);
        electronicPage.
                goToSubCategory(subCategory.Наушники);

        goToFilterPage()
                .setLoverBoundCost("5000")
                .setMaker(Makers.JBL);

        var results = filtersPage.showMe();
        Assertions.assertEquals(expectedCountOfProduct, getCountOfProd(), "Count of displayed products is wrong");
        var dataForSearch = results.getFirstProdName();
        doBaseSearch(dataForSearch);

        Assertions.assertTrue(isSearchResultsContainsSearchData(dataForSearch), "Product with name: " + dataForSearch + "Is not found");
    }
}
