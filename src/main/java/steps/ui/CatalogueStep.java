package steps.ui;
import com.codeborne.selenide.Condition;
import pages.CataloguePage;
import pages.MainPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
public class CatalogueStep {
    private CataloguePage cataloguePage = new CataloguePage();

    @Step("Click on product name")
    public void clickOnProductName(){
        cataloguePage.getLinkToProductPage().click();
    }
}
