package steps;


import pages.ProductPage;
import io.qameta.allure.Step;

public class ProductStep {
    ProductPage productPage = new ProductPage();

    @Step("Click the button add to cart")
    public void clickTheButtonAddToCart(){
        productPage.getButtonAddToCart().click();
    }

    @Step("Click the button items in cart")
    public void clickTheButtonItemsInCart (){
        productPage.getButtonItemsInCart().click();
    }
}
